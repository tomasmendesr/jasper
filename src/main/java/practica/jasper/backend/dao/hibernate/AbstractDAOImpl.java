package practica.jasper.backend.dao.hibernate;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import practica.jasper.backend.dao.interfaces.AbstractDAO;


public abstract class AbstractDAOImpl<T> implements AbstractDAO<T>{
	@PersistenceContext(type=PersistenceContextType.TRANSACTION, unitName="jasper")
	protected EntityManager entityManager;

	@Override
	public T findById(Class<T> typeParameterClass, Integer id){
		T instance = entityManager.find(typeParameterClass, id);
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> typeParameterClass){
		Criteria c = entityManager.unwrap(Session.class).createCriteria(typeParameterClass);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllActivos(Class<T> typeParameterClass){
		Criteria c = entityManager.unwrap(Session.class).createCriteria(typeParameterClass);
		c.add(Restrictions.isNull("fechaBaja"));
		c.add(Restrictions.eq("activo", true));
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return c.list();
	}
	
	
	@Override
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	public T merge(T entity) {
		return entityManager.merge(entity);
	}
	
	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}
	
	
	@Override
	public void deleteAll(Set<T> entities) {
		entities.forEach(entity -> {
			entityManager.remove(entity);
		});
	}
}
