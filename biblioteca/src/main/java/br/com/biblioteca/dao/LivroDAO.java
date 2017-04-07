package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.biblioteca.config.JPAUtil;
import br.com.biblioteca.model.Livro;

public class LivroDAO implements DAOInterface<Livro> {

	
	public LivroDAO(){}
	
	@Override
	public void inserir(Livro valor) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(valor);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(Livro valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Livro> listar() {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Livro> livroQuery = em.createQuery("select l from Livro l", Livro.class);
		List<Livro> livros = livroQuery.getResultList();
		em.close();
		return livros;
	}

	@Override
	public Livro buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
