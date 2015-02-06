/**
 * 
 */
package br.com.projetospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.projetospring.dao.impl.UsuarioDAO;
import br.com.projetospring.entity.Usuario;

/**
 * @author Joelson
 *
 */
@Service("usuarioService")
@Qualifier("usuarioService")
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO dao;
	
	public UsuarioService() {
		
	}		
	
	public UsuarioService(UsuarioDAO dao) {
		super();
		this.dao = dao;
	}



	public List<Usuario> getTodosUsuarios(){
		return dao.buscarTodos();
	}
	
	public List<Usuario> getUsuariosPorNome(String nome){
		return dao.buscaPorNome(nome);		
	}
	
	public Usuario create(Usuario usuario){
		return dao.create(usuario);		
	}
	
	public void update(Usuario usuario){
		 dao.update(usuario);
	}
	
	public void delete(Usuario usuario){
		dao.delete(usuario);
	}

	public UsuarioDAO getDao() {
		return dao;
	}

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}	
	
}
