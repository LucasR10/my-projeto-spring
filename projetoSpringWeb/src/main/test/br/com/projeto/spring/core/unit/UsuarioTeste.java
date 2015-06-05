package br.com.projeto.spring.core.unit;



import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.projeto.spring.jsfapp.core.model.Usuario;
import br.com.projeto.spring.jsfapp.core.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/WEB-INF/applicationContext.xml"})
@WebAppConfiguration
public class UsuarioTeste {

	
	
     private Usuario usuario = new Usuario();
	 
	 @Autowired
	 private UsuarioService service ;
	
	@Test
	public void salvaUsuario() {
     
		try {
			usuario.setDataCadatro(new Date(0));
			usuario.setEmail("cd@cd.com");
			usuario.setNome("cdi com JSF 2");

			service.save(usuario);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
