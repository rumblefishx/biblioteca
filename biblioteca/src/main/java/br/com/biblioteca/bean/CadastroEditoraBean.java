package br.com.biblioteca.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.biblioteca.model.Editora;

@ManagedBean
public class CadastroEditoraBean {
	private Editora editora;
	
	@ManagedProperty(value="#{contatoBean}")
	private ContatoBean contato;
	@ManagedProperty(value="#{enderecoBean}")
	private EnderecoBean endereco;
	
	public CadastroEditoraBean(){
		this.editora = new Editora();
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public ContatoBean getContato() {
		return contato;
	}

	public void setContato(ContatoBean contato) {
		this.contato = contato;
	}

	public EnderecoBean getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoBean endereco) {
		this.endereco = endereco;
	}
	
	public void gravarCadastro(){
		this.editora.setContato(contato.getContato());
		this.editora.setEndereco(endereco.getEndereco());
	}
	
}
