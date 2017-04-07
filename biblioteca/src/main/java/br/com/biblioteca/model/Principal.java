package br.com.biblioteca.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.biblioteca.config.JPAUtil;
import br.com.biblioteca.dao.CidadeDAO;
import br.com.biblioteca.dao.EditoraDAO;
import br.com.biblioteca.dao.EstadoDAO;

public class Principal {
	public static void main(String[] args) {
//		Principal me = new Principal();
//		me.insereEstado();
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Estado> query = em.createQuery("select e from Estado e join fetch e.cidades c",Estado.class);
		Estado saopaulo = query.getSingleResult();
		
		TypedQuery<Cidade> queryCidades = em.createQuery("select c from Cidade c where c.idEstado =:codigoEstado",Cidade.class);
		queryCidades.setParameter("codigoEstado", 1);
		List<Cidade> cidades = queryCidades.getResultList();
		
		em.getTransaction().commit();
	}

	public void insereEstado() {

//		EntityManager em = JPAUtil.getEntityManager();
//		EstadoDAO dao = new EstadoDAO(em);
//		CidadeDAO cidadeDao = new CidadeDAO(em);
//
//		Estado sp = new Estado();
//		sp.setIdEstado(1);
//		sp.setSigla("SP");
//
//		Cidade saopaulo = new Cidade();
//		saopaulo.setIdCidade(1);
//		saopaulo.setNomeCidade("São Paulo");
//		saopaulo.setEstado(sp);
//
//		Cidade carapicuiba = new Cidade();
//		carapicuiba.setIdCidade(2);
//		carapicuiba.setNomeCidade("Carapicuíba");
//		carapicuiba.setEstado(sp);
//
//		dao.inserir(sp);
//		cidadeDao.inserir(saopaulo);
//		cidadeDao.inserir(carapicuiba);
//	}
//
//	public void saveData() {
//		EntityManager em = JPAUtil.getEntityManager();
//		em.getTransaction().begin();
//
//		Contato contato = new Contato();
//		contato.setCelular("987138411");
//		contato.setEmail("cleiton.ribeiro.dev@gmail.com");
//		contato.setTelefoneFixo("41891585");
//
//		Endereco endereco = new Endereco();
//		endereco.setBairro("Pq Flórida");
//		endereco.setCep("06365190");
//		endereco.setCidade("Carapicuíba");
//		endereco.setEstado("SP");
//		endereco.setLogradouro("R. Padre Lionel Corbeil");
//		endereco.setNumero("15");
//
//		Editora editora = new Editora();
//		editora.setContato(contato);
//		editora.setEndereco(endereco);
//		editora.setNome("Campel");
//
//		EditoraDAO dao = new EditoraDAO(em);
//		dao.inserir(editora);
//
//		em.getTransaction().commit();
	}
}
