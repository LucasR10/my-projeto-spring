package br.com.projeto.spring.jsfapp.core.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.spring.jsfapp.core.dao.GenericDao;


/**
 * @author Lucas Rocha
 * @since 20/03/20015
 * 
 * */

@Transactional
@Repository
public abstract class GenericDaoImpl <T> implements GenericDao<T, Long> {

	
	@SuppressWarnings("rawtypes")
	private Class icClass;
	
	@PersistenceContext
	protected EntityManager emManager;
	
	@SuppressWarnings("rawtypes")
	public GenericDaoImpl(Class icClass) {
		super();
		this.icClass = icClass;
	}

	public T salve(T entity) {
		emManager.persist(entity);
		return entity;
	}


	public T update(T entity) {
		emManager.merge(entity);
		return entity;
	}

	public T remove(T entity) {
		 emManager.remove(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public T findById(Long key) {
		return (T) emManager.find(icClass, key);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<T> findAll() {
		return emManager.createQuery(" SELECT obj FROM  "+icClass.getSimpleName()+ " obj ").getResultList();
	}
	@Transactional(readOnly=true)
	public T loadByUserEmailAndPassword(String email, String password) {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<T> loadPagination(int first, int pageSize) {
		return  emManager.createQuery(" SELECT obj FROM  "+icClass.getSimpleName()+ " obj ").setFirstResult(first).setMaxResults(pageSize).getResultList();
	}

}
