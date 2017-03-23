package br.com.biblioteca.bean;

import javax.faces.bean.ManagedBean;

import br.com.biblioteca.model.Contato;

@ManagedBean
public class ContatoBean {

	private Contato contato;
	
	public ContatoBean(){
		this.contato = new Contato();
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
}
