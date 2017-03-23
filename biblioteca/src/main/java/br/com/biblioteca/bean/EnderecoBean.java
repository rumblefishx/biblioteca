package br.com.biblioteca.bean;

import javax.faces.bean.ManagedBean;

import br.com.biblioteca.model.Endereco;

@ManagedBean
public class EnderecoBean {
	
	private Endereco endereco;
	
	public EnderecoBean(){
		this.endereco = new Endereco();
	}
	
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}
	
	public Endereco getEndereco(){
		return this.endereco;
	}
}
