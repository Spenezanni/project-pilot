package br.com.java.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -5283998061571669043L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NOME_USUARIO")
	private String nome;

	@Column(name = "RG")
	private String rg;

	public Usuario(String nome, String rg) {
		super();
		this.nome = nome;
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}
