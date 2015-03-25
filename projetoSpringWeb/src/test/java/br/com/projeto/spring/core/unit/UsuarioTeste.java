package br.com.projeto.spring.core.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/WEB-INF/applicationContext.xml"})
@WebAppConfiguration
public class UsuarioTeste {

	@Test
	public void salvausuario() {

	}

}
