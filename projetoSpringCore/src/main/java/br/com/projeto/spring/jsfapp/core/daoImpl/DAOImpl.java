package br.com.projeto.spring.jsfapp.core.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.spring.jsfapp.core.dao.DAO;
import br.com.projeto.spring.jsfapp.core.model.Usuario;


/**
 * @author Lucas Rocha
 * @since 20/03/20015
 * 
 * */

@Transactional
@Repository
public class DAOImpl implements DAO {

	
	@PersistenceContext
	protected EntityManager emManager;
	
	

	public Usuario salve(Usuario entity) {
		emManager.persist(entity);
		return entity;
	}


	public Usuario update(Usuario entity) {
		emManager.merge(entity);
		return entity;
	}

	public Usuario remove(Usuario entity) {
		 emManager.remove(entity);
		return entity;
	}

	
	@Transactional(readOnly=true)
	public Usuario findById(Long key) {
		return (Usuario) emManager.find(Usuario.class, key);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return emManager.createQuery(" SELECT obj FROM Usuario obj ").getResultList();
	}
	@Transactional(readOnly=true)
	public Usuario loadByUserEmailAndPassword(String email, String password) {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Usuario> loadPagination(int first, int pageSize) {
		return  emManager.createQuery(" SELECT obj FROM  USUARIO obj ").setFirstResult(first).setMaxResults(pageSize).getResultList();
	}

}
