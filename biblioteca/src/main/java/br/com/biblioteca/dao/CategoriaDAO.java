package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.biblioteca.model.Categoria;

public class CategoriaDAO implements DAOInterface<Categoria> {

	private EntityManager em;
	
	public CategoriaDAO(EntityManager em){
		this.em = em;
	}
	
	@Override
	public void inserir(Categoria valor) {
		em.persist(valor);
	}

	@Override
	public void remover(Categoria valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Categoria> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
