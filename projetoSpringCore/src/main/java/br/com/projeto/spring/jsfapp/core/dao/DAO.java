package br.com.projeto.spring.jsfapp.core.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.projeto.spring.jsfapp.core.model.Usuario;

/**
 * @author Lucas Rocha
 * @since 20/03/20015
 * 
 * */

@Component("dao")
public interface DAO   {

	public Usuario salve(Usuario entity);

	public Usuario update(Usuario entity);

	public Usuario remove(Usuario entity);

	public Usuario findById(Long key);

	public List<Usuario> findAll();
	
	public Usuario loadByUserEmailAndPassword(String email ,String password);
	
	public List<Usuario> loadPagination (int first, int pageSize) ;

}
