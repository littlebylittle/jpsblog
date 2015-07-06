package session;

import entity.Messages;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MessagesFacade extends AbstractFacade<Messages>{
	@PersistenceContext(unitName = "myblogPU")
	private EntityManager em;

	public MessagesFacade() {
		super(Messages.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

}
