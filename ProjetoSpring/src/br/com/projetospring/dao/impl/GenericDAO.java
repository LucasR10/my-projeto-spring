/**
 * 
 */
package br.com.projetospring.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetospring.dao.IGenericDAO;

/**
 * @author Joelson
 *
 */
@Repository("genericDAO")
public abstract class GenericDAO<T> extends HibernateDaoSupport implements IGenericDAO<T> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> classe;

	public GenericDAO(Class<T> classe) {
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

	@Override
	@Transactional
	public void deletar(T t) throws Exception {
		getHibernateTemplate().delete(t);
		getHibernateTemplate().flush();
	}

	@Override
	@Transactional
	public T buscaPeloID(int id) throws Exception {
		return (T) getHibernateTemplate().get(getClasse(), id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> buscaTodos() throws Exception {
		return getHibernateTemplate().loadAll(classe);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public T salva(T t) throws Exception {
		getHibernateTemplate().save(t);
		getHibernateTemplate().flush();
		return t;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public T merge(T t) throws Exception {
		getHibernateTemplate().merge(t);
		getHibernateTemplate().flush();
		return t;
	}

	@Override
	@Transactional
	public T salvarOuAtualizar(T t) throws Exception {
		getHibernateTemplate().saveOrUpdate(t);
		getHibernateTemplate().flush();
		return t;
	}

	@Override
	@Transactional
	public T atualiza(T t) throws Exception {
		getHibernateTemplate().update(t);
		getHibernateTemplate().flush();
		return t;
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> buscaListaPeloCriterio(Criterion... criterion) throws Exception {
		Session session = getSession();
		Criteria crit = session.createCriteria(getClasse());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> buscaListaPeloCriterio(Order order, Criterion... criterion) throws Exception {
		Session session = getSession();
		Criteria crit = session.createCriteria(getClasse());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		crit.addOrder(order);
		return crit.list();
	}

	@Override
	@Transactional
	public T buscaUmPeloCriterio(Criterion... criterion) throws Exception {
		Session session = getSession();
		Criteria crit = session.createCriteria(getClasse());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return (T) crit.uniqueResult();
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

}
