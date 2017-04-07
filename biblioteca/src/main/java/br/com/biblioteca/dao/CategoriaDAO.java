package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.biblioteca.config.JPAUtil;
import br.com.biblioteca.model.Categoria;

public class CategoriaDAO implements DAOInterface<Categoria> {

	private EntityManager em;
	
	public CategoriaDAO(){
		em = JPAUtil.getEntityManager();
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
