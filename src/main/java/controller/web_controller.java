/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Articles;
import java.io.IOException;
import java.util.Enumeration;
import javax.ejb.EJB;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import session.ArticlesFacade;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "web_controller", urlPatterns = {"/article", "/registration"}, loadOnStartup = 1)
public class web_controller extends HttpServlet {
	@EJB
	private ArticlesFacade articlesFacade;

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute("articles", articlesFacade.findAll());
	}

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userPath = request.getServletPath();
        if (null != userPath) switch (userPath) {
			case "/article":
				String id = null;
				Enumeration<String> params = request.getParameterNames();
				while(params.hasMoreElements()) {
					String param = params.nextElement();
					id = "id".equals(param) ? request.getParameter(param) : id;
				}
				try{
					Articles article = articlesFacade.find(Integer.parseInt(id));
					request.setAttribute("article", article);
				 }catch(Exception e){
					e.printStackTrace();
				 }

				break;
			case "/registration":
				break;
		}
        request.getRequestDispatcher("/WEB-INF/views" + userPath +".jsp").forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}