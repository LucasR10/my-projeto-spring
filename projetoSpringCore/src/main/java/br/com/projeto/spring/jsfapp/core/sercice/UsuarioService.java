package br.com.projeto.spring.jsfapp.core.sercice;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.projeto.spring.jsfapp.core.daoImpl.GenericDaoImpl;
import br.com.projeto.spring.jsfapp.core.model.Usuario;

@Service
@Component("usuarioService")
public class UsuarioService extends GenericDaoImpl<Usuario> {

	public UsuarioService() {
		super(Usuario.class);
		
	}

		

}
