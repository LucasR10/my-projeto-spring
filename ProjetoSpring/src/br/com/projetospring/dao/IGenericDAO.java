/**
 * 
 */
package br.com.projetospring.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;

/**
 * @author Joelson
 *
 */
@Component
public interface IGenericDAO<T> {

	void adicionar(T t);

	void remove(T t);

	void atualizar(T t);

	List<T> listaTodos();

	T buscaPorId(Long id);

	void deletar(T t) throws Exception;

	T buscaPeloID(int id) throws Exception;

	List<T> buscaTodos() throws Exception;

	T salva(T t) throws Exception;

	T merge(T t) throws Exception;

	T salvarOuAtualizar(T t) throws Exception;

	T atualiza(T t) throws Exception;

	List<T> buscaListaPeloCriterio(Criterion[] criterion) throws Exception;

	List<T> buscaListaPeloCriterio(Order order, Criterion[] criterion) throws Exception;

	T buscaUmPeloCriterio(Criterion[] criterion) throws Exception;

}
