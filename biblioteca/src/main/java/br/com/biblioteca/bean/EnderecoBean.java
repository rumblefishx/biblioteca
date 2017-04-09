package br.com.biblioteca.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.biblioteca.dao.CidadeDAO;
import br.com.biblioteca.dao.EstadoDAO;
import br.com.biblioteca.model.Cidade;
import br.com.biblioteca.model.Endereco;
import br.com.biblioteca.model.Estado;

@Named
@ViewScoped
public class EnderecoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Endereco endereco;
	private Estado estadoEscolhido;
	private Cidade cidadeEscolhida;
	private List<Estado> listaEstados;
	private List<Cidade> listaCidades;
	private CidadeDAO cidadeDao;
	
	public EnderecoBean(){
		this.endereco = new Endereco();
		cidadeDao = new CidadeDAO();
		EstadoDAO dao = new EstadoDAO();
		listaEstados = dao.listar();
	}
	
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}
	
	public Endereco getEndereco(){
		return this.endereco;
	}

	public Estado getEstadoEscolhido() {
		return estadoEscolhido;
	}

	public void setEstadoEscolhido(Estado estadoEscolhido) {
		this.estadoEscolhido = estadoEscolhido;
	}

	public Cidade getCidadeEscolhida() {
		return cidadeEscolhida;
	}

	public void setCidadeEscolhida(Cidade cidadeEscolhida) {
		this.cidadeEscolhida = cidadeEscolhida;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}
	

	public void alterarCidadesPorEstado(final AjaxBehaviorEvent event){
		if(estadoEscolhido == null)
			return;		
		
		try{
			this.listaCidades = cidadeDao.cidadeByEstado(estadoEscolhido);
		}catch(Exception e){
			e.printStackTrace();
			FacesMessage msgErro = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO","Falha ao buscar as cidades atreladas ao estado selecionado!");
			FacesContext.getCurrentInstance().addMessage(null, msgErro);
		}
	}
}
