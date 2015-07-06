package session;

import entity.Articles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ArticlesFacade extends AbstractFacade<Articles> {
	@PersistenceContext(unitName = "myblogPU")
	private EntityManager em;

	public ArticlesFacade(Class<Articles> entityClass) {
		super(entityClass);
	}

	public ArticlesFacade() {
		super(Articles.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return this.em;
	}

}
