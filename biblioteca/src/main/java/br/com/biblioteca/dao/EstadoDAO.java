package br.com.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.biblioteca.config.JPAUtil;
import br.com.biblioteca.model.Estado;

public class EstadoDAO implements DAOInterface<Estado> {
	
	public EstadoDAO(){}
	
	@Override
	public void inserir(Estado valor) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(valor);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(Estado valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Estado> listar() {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Estado> queryEstado = em.createQuery("select e from Estado e",Estado.class);
		List<Estado> estados = queryEstado.getResultList();
		em.close();
		return estados;
	}

	@Override
	public Estado buscar(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Estado> queryEstado = em.createQuery("select e from Estado e where e.idEstado =:codigo",Estado.class);
		queryEstado.setParameter("codigo", id);
		Estado estado = queryEstado.getSingleResult();
		em.close();
		return estado;
	}

}
