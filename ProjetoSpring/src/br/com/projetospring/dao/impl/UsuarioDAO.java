/**
 * 
 */
package br.com.projetospring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetospring.dao.IUsuarioDAO;
import br.com.projetospring.entity.Usuario;

/**
 * @author Joelson
 *
 */
@Repository("usuarioDao")
public class UsuarioDAO implements IUsuarioDAO{

	@PersistenceContext
	protected EntityManager em;
	
	@Transactional(readOnly = true)
	public List<Usuario> buscarTodos(){
		
		String jpql = "select u from usuario u order by u.nome";
		Query query = em.createQuery(jpql);
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();
		return usuarios;
		
	}
	
	@Transactional(readOnly = true)
	public List<Usuario> buscaPorNome(String nome){
		
		String jpql = "select u from usuario u where nome like :nome order by u.nome";
		Query query = em.createQuery(jpql);
		query.setParameter("nome", nome + "%" );
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();
		return usuarios;
		
	}
	
	@Transactional
	public Usuario create(Usuario usuario){
		em.persist(usuario);
		return usuario;
	}
	
	@Transactional
	public void update(Usuario usuario){
		em.merge(usuario);
	}
	
	@Transactional
	public void delete(Usuario usuario){
		em.remove(usuario);
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}	
		
}
