package br.com.biblioteca.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import br.com.biblioteca.dao.EditoraDAO;
import br.com.biblioteca.model.Editora;

@ManagedBean
public class CadastroEditoraBean {
	private Editora editora;
	
	@ManagedProperty(value="#{contatoBean}")
	private ContatoBean contato;
	@ManagedProperty(value="#{enderecoBean}")
	private EnderecoBean endereco;
	
	private void clearValues(){
		this.editora = new Editora();
		this.contato = new ContatoBean();
		this.endereco = new EnderecoBean();
	}
	
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
	
	public String gravarCadastro(){
		try{
			this.editora.setContato(contato.getContato());
			this.editora.setEndereco(endereco.getEndereco());
			
			EditoraDAO dao = new EditoraDAO();
			dao.inserir(editora);
			
			clearValues();
			
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro Concluído!","Registro inserido com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return "";
		}catch(Exception e){
			e.printStackTrace();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,"Erro","Erro interno!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return "";	
		}
	}
}
