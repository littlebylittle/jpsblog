package session;

import entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsersFacade extends AbstractFacade<Users> {
	@PersistenceContext(unitName = "myblogPU")
	private EntityManager em;

	public UsersFacade() {
		super(Users.class);
	}
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}