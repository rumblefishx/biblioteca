package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.biblioteca.config.JPAUtil;
import br.com.biblioteca.model.Cidade;
import br.com.biblioteca.model.Estado;

public class CidadeDAO implements DAOInterface<Cidade>{

	public CidadeDAO() {}

	@Override
	public void inserir(Cidade valor) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(valor);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(Cidade valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cidade> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cidade buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Cidade> cidadeByEstado(Estado estado){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Cidade> queryEstado = em.createQuery("select c from Cidade c where c.idEstado =:codigoEstado",Cidade.class);
		queryEstado.setParameter("codigoEstado", estado);
		List<Cidade> cidades = queryEstado.getResultList();
		em.close();
		return cidades;
	}

}
