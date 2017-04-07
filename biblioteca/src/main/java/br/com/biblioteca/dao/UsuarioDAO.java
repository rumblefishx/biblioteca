package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.biblioteca.config.JPAUtil;
import br.com.biblioteca.model.Usuario;

public class UsuarioDAO implements DAOInterface<Usuario> {
	
	public UsuarioDAO(){}

	@Override
	public void inserir(Usuario valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Usuario valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscar(int id) {
		return null;
	}
	
	public Usuario buscar(String nome){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.nomeUsuario = :nome",Usuario.class);
		query.setParameter("nome", nome);
		Usuario usuario = query.getSingleResult();
		return usuario;
	}
	

}
