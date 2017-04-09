package br.com.biblioteca.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.biblioteca.dao.CategoriaDAO;
import br.com.biblioteca.model.Categoria;

@Named
@ViewScoped
public class CategoriaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Categoria categoria;	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public CategoriaBean(){
		this.categoria = new Categoria();
	}
	
	public String gravarCategoria(){
		try{
			CategoriaDAO dao = new CategoriaDAO();
			dao.inserir(categoria);
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("SUCESSO!","Categoria salva com sucesso!"));
			return "paginaPrincipal";
		}catch(Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO","FALHA AO GRAVAR CATEGORIA!"));
			return "";	
		}
	}
	
	public void limparCampos(){
		this.categoria = new Categoria();
	}
}
