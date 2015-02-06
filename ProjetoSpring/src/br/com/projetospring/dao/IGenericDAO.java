/**
 * 
 */
package br.com.projetospring.dao;

import java.util.List;

/**
 * @author Joelson
 *
 */

public interface IGenericDAO<T> {

	void adicionar(T t);

	void remove(T t);

	void atualizar(T t);

	List<T> listaTodos();

	T buscaPorId(Long id);

}
