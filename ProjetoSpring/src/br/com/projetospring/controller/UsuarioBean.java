/**
 * 
 */
package br.com.projetospring.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.projetospring.entity.Usuario;
import br.com.projetospring.service.UsuarioService;

/**
 * @author Joelson
 *
 */
@Controller
@ManagedBean(name="usuarioBean")
@ViewScoped
public class UsuarioBean {
	

	@ManagedProperty("#{usuarioService}")	
	private UsuarioService usuarioService;
	
	
	public UsuarioBean(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	public UsuarioBean() {
		
	}
	
	private Usuario usuario = new Usuario();
	
	public List<Usuario> usuarios;
	
	private String nomeUsuario;
	
	private boolean editMode;		

	public Usuario getUsuario() {
		
		if(usuario == null){
			usuario = new Usuario();
		}		
		return usuario;
	}	

	public List<Usuario> getUsuarios() {
		
		if(usuarios == null){
			usuarios = usuarioService.getTodosUsuarios();
		}
		return usuarios;
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
		

}
