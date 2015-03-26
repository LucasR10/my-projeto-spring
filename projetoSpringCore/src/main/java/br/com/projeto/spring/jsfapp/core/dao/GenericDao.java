package br.com.projeto.spring.jsfapp.core.dao;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Lucas Rocha
 * @since 20/03/20015
 * 
 * */

@Component("GenericDao")
public interface GenericDao <T , K extends Number>  {

	public T salve(T entity);

	public T update(T entity);

	public T remove(T entity);

	public T findById(K key);

	public List<T> findAll();
	
	public T loadByUserEmailAndPassword(String email ,String password);
	
	public List<T> loadPagination (int first, int pageSize) ;

}
