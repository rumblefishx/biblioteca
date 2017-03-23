package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.biblioteca.model.Livro;

public class LivroDAO implements DAOInterface<Livro> {

	private EntityManager em;
	
	public LivroDAO(EntityManager em){
		this.em = em;
	}
	
	@Override
	public void inserir(Livro valor) {
		em.persist(valor);	
	}

	@Override
	public void remover(Livro valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Livro> listar() {
		TypedQuery<Livro> livroQuery = em.createQuery("select l from Livro l", Livro.class);
		return livroQuery.getResultList();
	}

	@Override
	public Livro buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
