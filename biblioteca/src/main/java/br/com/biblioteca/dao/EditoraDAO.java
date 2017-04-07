package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.biblioteca.config.JPAUtil;
import br.com.biblioteca.model.Editora;

public class EditoraDAO implements DAOInterface<Editora>{
	
	public EditoraDAO(){}
	
	@Override
	public void inserir(Editora valor) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(valor);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(Editora valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Editora> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editora buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
