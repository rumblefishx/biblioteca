package br.com.biblioteca.config.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.biblioteca.config.JPAUtil;
import br.com.biblioteca.config.SessionContext;
import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Usuario;

@ManagedBean
public class AcessoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public AcessoBean(){}
	
	private EntityManager em;

	private String email;
	private String login;
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String doLogout(){
		SessionContext.getInstance().encerrarSessao();
		return "encerrarSessao";
	}
	
	public String doLogin(){
		
		UsuarioDAO dao = new UsuarioDAO();
		
		try {
            Usuario user = dao.buscar(this.login);
  
            if (user == null || !user.getSenha().equals(senha)) {
	          FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Falha no procedimento de login","Usuário ou senha incorretos!");
	          FacesContext.getCurrentInstance().addMessage(null, mensagem);
              FacesContext.getCurrentInstance().validationFailed();
              return "";
            }
  
            SessionContext.getInstance().setAttribute("usuarioLogado", user);
            return "testeRedirect";
        } catch (Exception e) {
        	e.printStackTrace();
        	FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Falha no procedimento de login",e.getMessage());
        	FacesContext.getCurrentInstance().addMessage(null, mensagem);
            FacesContext.getCurrentInstance().validationFailed();
            e.printStackTrace();
            return "";
        }
	}
}
