package br.com.codepampa.service;


import br.com.codepampa.model.BaseModel;
import com.google.common.base.Strings;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

public abstract class GenericService<T extends BaseModel<PK>, PK extends Serializable> extends ServiceFactory implements Serializable {


    protected EntityManager entityManager = factoryEntityManagerCode();

/*
    private final Class<T> type = (Class)(new TypeToken(this.getClass()) {
    }).getType();
*/

    protected GenericService() {
    }

    protected Class<T> getType() {
        return this.getTypeClass();
    }

    public T findById(PK id) {
        return (T)this.entityManager.find(this.getTypeClass(), id);
    }

    public T findById(PK id, LockModeType lock) {
        return (T)this.entityManager.find(this.getTypeClass(), id, lock);
    }

    private void persist(T obj) {
        entityManager.persist(obj);

        //
    }

    private T merge(T obj) {
        return (T)this.entityManager.merge(obj);
    }

    public T save(T obj) {
        entityManager.getTransaction().begin();
        if(obj.getId() == null) {
            this.persist(obj);
        } else {
            obj = this.merge(obj);
        }
        entityManager.flush();
        entityManager.getTransaction().commit();
        return obj;
    }

    public void remove(PK id) {
        BaseModel t = (T)this.entityManager.getReference(this.getTypeClass(), id);
        this.entityManager.remove(t);
    }

    public void remove(T obj) {
        this.remove(obj.getId());
    }

    protected void flush() {
        this.entityManager.flush();
    }

    protected void clear() {
        this.entityManager.clear();
    }

    public Collection<T> findAll() {
        return entityManager.createQuery("FROM " + getTypeClass().getName())
                .getResultList();
    }

    public List<T> findAllCriteria() {
        final Criteria criteria = getCriteria(getType().getSimpleName() + ".findAll");

        @SuppressWarnings("unchecked")
        List<T> list = criteria.list();
        return list;
    }

    protected Query createQuery(String query, Object... parameters) {
        Query q = entityManager.createQuery(query);
        for (int i = 1; i <= parameters.length; i++) {
            q.setParameter(i, parameters[i]);
        }
        return q;
    }

    protected Criteria getCriteria(String cacheRegion) {
        @SuppressWarnings("deprecation")
        Criteria criteria = getSession().createCriteria(getType());
        if (!Strings.isNullOrEmpty(cacheRegion)) {
            criteria.setCacheable(true);
            criteria.setCacheRegion(cacheRegion);
        }
        return criteria;
    }

    //verificar qual metodo é melhor, esse ou o do guava.
    private Class<T> getTypeClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private Session getSession() {
        return ((Session) entityManager.getDelegate());
    }

    public List<T> listByCriteriaDistinct() {
        Criteria criteria = getCriteria(getType().getSimpleName() + ".findAll");
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        @SuppressWarnings("unchecked")
        final List<T> ret = criteria.list();
        return ret;
    }
}
