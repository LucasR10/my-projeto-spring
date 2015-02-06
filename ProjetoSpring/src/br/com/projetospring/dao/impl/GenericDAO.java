/**
 * 
 */
package br.com.projetospring.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.projetospring.dao.IGenericDAO;
/**
 * @author Joelson
 *
 */
@Repository("genericDAO")
public class GenericDAO<T> implements IGenericDAO<T> {

	@PersistenceContext
	protected EntityManager em;	
	
	private Class<T> classe;
	
	public GenericDAO() {
		
	}


	public GenericDAO(Class<T> classe) {
		super();
		this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.classe = classe;
	}

	@Transactional
	public void adicionar(T t) {

		em.persist(t);
	}

	@Transactional
	public void remove(T t) {

		em.remove(em.merge(t));
	}

	@Transactional
	public void atualizar(T t) {

		em.merge(t);
	}

	@Transactional(readOnly = true)
	public List<T> listaTodos() {

		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).getResultList();
		return lista;
	}

	@Transactional
	public T buscaPorId(Long id) {
		return (T) em.find(classe, id);
	}
	

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Class<T> getClasse() {
		return classe;
	}

	public void setClasse(Class<T> classe) {
		this.classe = classe;
	}
}
