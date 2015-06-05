package br.com.projeto.spring.jsfapp.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.spring.jsfapp.core.dao.DAO;
import br.com.projeto.spring.jsfapp.core.model.Usuario;

@Service(value = "service")
@Transactional
public class UsuarioService {

	private DAO dao;
	

	@Autowired
	public UsuarioService(DAO dao ) {
		this.dao = dao;
	}
	
	public UsuarioService() {
		
	}
	
	public void save(Usuario usuario){
		
		dao.salve(usuario);
	}

}
