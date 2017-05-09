package practica.jasper.backend.dao.interfaces;

import java.util.List;
import java.util.Set;

public interface AbstractDAO<T> {
	public T findById(Class<T> typeParameterClass, Integer id);
	
	public List<T> findAll(Class<T> typeParameterClass);
	
	public void save(T entity);
	
	public T merge(T entity);
	
	public void delete(T entity);
	
	void deleteAll(Set<T> entities);

	public List<T> findAllActivos(Class<T> typeParameterClass); // activo = true && fechaBaja != null
	

	

}
