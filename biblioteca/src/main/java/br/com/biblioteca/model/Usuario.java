package br.com.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	@Column(length=15)
	private String nomeUsuario;
	@Column(length=15)
	private String senha;
	
	@ManyToOne
	private Nivel_Acesso nivelAcesso;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Nivel_Acesso getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(Nivel_Acesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	};
	
	
	
}
