<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <body>
        <header>
            <a href="/"><img alt="Логотип" id="top-image" src="#"/></a>
            <div id="user-panel">
                <a href="#"><img alt="Иконка юзера" scr=""/></a>
                <a href="javascript:void(0);">[Панель для юзера]</a>
            </div>
        </header>
         <div id="main">
            <aside class="leftAside">
                <h2>Темы статей</h2>
                <ul>
                    <li><a href="#">Тема 1</a></li>
                    <li><a href="#">Тема 2</a></li>
                    <li><a href="#">Тема 3</a></li>
                    <li><a href="#">Тема 3</a></li>

                </ul>
            </aside>
			${param.name}
            <section>
                <article>
                    <h1>${article.title}</h1>
                    <div class="text-article">
                        ${article.text}
                    </div>
                    <div class="fotter-article>
                        <span class="date-article">Дата статьи: ${article.date}</span>
                    </div>
                </article>
			</section>
        </div>