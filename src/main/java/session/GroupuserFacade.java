package session;

import entity.Groupuser;
import javax.persistence.EntityManager;

public class GroupuserFacade extends AbstractFacade<Groupuser> {
	private EntityManager em;

	public GroupuserFacade() {
		super(Groupuser.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
