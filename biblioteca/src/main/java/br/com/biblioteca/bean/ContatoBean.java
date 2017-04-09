package br.com.biblioteca.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.biblioteca.model.Contato;

@Named
@ViewScoped
public class ContatoBean implements Serializable {

	private static final long serialVersionUID = 1L;
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
