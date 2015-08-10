package session;

import entity.Contacts;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ContactsFacade extends AbstractFacade<Contacts> {
	@PersistenceContext(unitName = "myblogPU")
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
	public ContactsFacade() {
		super(Contacts.class);
	}
}
