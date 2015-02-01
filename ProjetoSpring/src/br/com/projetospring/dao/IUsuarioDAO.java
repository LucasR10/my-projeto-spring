/**
 * 
 */
package br.com.projetospring.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.projetospring.entity.Usuario;

/**
 * @author Joelson
 *
 */
@Component
public interface IUsuarioDAO {

	public List<Usuario> buscarTodos();

	public List<Usuario> buscaPorNome(String nome);

	public Usuario create(Usuario usuario);

	public void update(Usuario usuario);

	public void delete(Usuario usuario);

}
