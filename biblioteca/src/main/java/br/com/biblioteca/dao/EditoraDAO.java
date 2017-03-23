package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.biblioteca.model.Editora;

public class EditoraDAO implements DAOInterface<Editora>{
	
	private EntityManager em;
	
	public EditoraDAO(EntityManager em){
		this.em = em;
	}
	
	@Override
	public void inserir(Editora valor) {
		em.persist(valor);
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
