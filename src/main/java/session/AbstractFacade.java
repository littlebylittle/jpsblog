package session;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractFacade<TYPE> {
	private final Class<TYPE> entityClass;

	public AbstractFacade(Class<TYPE> entityClass) {
		this.entityClass = entityClass;
	}

	public abstract EntityManager getEntityManager();
	public void create(TYPE entity) {
		getEntityManager().persist(entity);
	}

	public void edit(TYPE entity) {
		getEntityManager().merge(entity);
	}

	public void remove(TYPE entity) {
		this.getEntityManager().remove(this.getEntityManager().merge(entity));
	}

	public TYPE find(Object id) {
		return this.getEntityManager().find(entityClass, id);
	}

	public List<TYPE> findAll() {
		CriteriaQuery<TYPE> cq = this.getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
	}

	public List<TYPE> findAll(int[] range) {
		CriteriaQuery<TYPE> cq = this.getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		Query q  = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
	}

	public int count() {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<TYPE> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        Query q = getEntityManager().createQuery(cq);
		Integer res = (Integer) q.getSingleResult();
        return res;
	}
}