package ru.vist.loader.sbean;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        EntityManager em = getEntityManager();
        T find = em.find(entityClass, id);
        return find;
        
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    public String newId() {
        String ret = UUID.randomUUID().toString();
        return ret;
    }
//    public long curId() {
//        Query qwr = getEntityManager().createNativeQuery("select max(r.id) from ap_stat.reference r");
//        BigDecimal id = (BigDecimal) qwr.getResultList().get(0);
//        if (id == null) {
//            id = new BigDecimal(0);
//        }
//        return id.longValue();
//    }    
}
//        EntityManager em = getEntityManager();
//        Query qwr = em.createNamedQuery("Reference.findById");
//        qwr.setParameter("id", id);
//        List resultList = qwr.getResultList();
//        return (T) resultList.get(0);
