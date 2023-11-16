package hcmute.dao;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import JPAConfig.JPAConfig;

public abstract class AbstractDAO_21110559<T> {
	protected EntityManager entitymanager = JPAConfig.getEntityManager();
	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractDAO_21110559() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	@SuppressWarnings("removal")
	@Override
	protected void finalize() throws Throwable {
		entitymanager.close();
		super.finalize();
	}

    public T insert(T entity) {
        try {
            entitymanager.getTransaction().begin();
            entitymanager.persist(entity);
            entitymanager.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            entitymanager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public T update(T entity) {
        try {
            entitymanager.getTransaction().begin();
            entitymanager.merge(entity);
            entitymanager.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            entitymanager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public T delete(int i) {
        try {
            entitymanager.getTransaction().begin();
            T entity = this.findById(i);
            entitymanager.remove(entity);
            entitymanager.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            entitymanager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
    public T findById(int id) {
		T entity = entitymanager.find(entityClass, id);
		return entity;
	}

	public List<T> findAll() {
		String jsql = "FROM " + entityClass.getSimpleName();
		TypedQuery<T> query = entitymanager.createQuery(jsql, entityClass);
		List<T> list = query.getResultList();
		return list;
	}

}