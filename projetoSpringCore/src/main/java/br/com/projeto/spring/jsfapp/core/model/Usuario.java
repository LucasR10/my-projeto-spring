package br.com.projeto.spring.jsfapp.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;


/**
 * @author Lucas Rocha
 * @since 20/03/20015
 * 
 * */

@Component("usuario")
@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long    id;
	
	private String  nome;
   
	private String  email;
    
	private String  dataCadatro;
    
    
    public Usuario() {
		
	}
    
	public Usuario(String nome, String email, String dataCadatro) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataCadatro = dataCadatro;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataCadatro() {
		return dataCadatro;
	}

	@Column(name="data_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	public void setDataCadatro(String dataCadatro) {
		this.dataCadatro = dataCadatro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
}
