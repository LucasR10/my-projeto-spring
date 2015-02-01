/**
 * 
 */
package br.com.projetospring.entity;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * @author Joelson
 *
 */
@Entity
public class Usuario implements Serializable {
	
	private Long id;
	private String nome;
	private String endereco;

}
