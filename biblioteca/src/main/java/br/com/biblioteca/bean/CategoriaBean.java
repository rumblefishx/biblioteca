package br.com.biblioteca.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.biblioteca.dao.CategoriaDAO;
import br.com.biblioteca.model.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaBean {
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
