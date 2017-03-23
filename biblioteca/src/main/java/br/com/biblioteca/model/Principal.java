package br.com.biblioteca.model;

import javax.persistence.EntityManager;

import br.com.biblioteca.config.JPAUtil;
import br.com.biblioteca.dao.EditoraDAO;

public class Principal {
	public static void main(String[] args) {
		Principal me = new Principal();
		me.saveData();
	}
	
	public void saveData(){
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Contato contato = new Contato();
		contato.setCelular("987138411");
		contato.setEmail("cleiton.ribeiro.dev@gmail.com");
		contato.setTelefoneFixo("41891585");
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Pq Flórida");
		endereco.setCep("06365190");
		endereco.setCidade("Carapicuíba");
		endereco.setEstado("SP");
		endereco.setLogradouro("R. Padre Lionel Corbeil");
		endereco.setNumero("15");
		
		Editora editora = new Editora();
		editora.setContato(contato);
		editora.setEndereco(endereco);
		editora.setNome("Campel");
		
		EditoraDAO dao = new EditoraDAO(em);
		dao.inserir(editora);
		
		em.getTransaction().commit();
	}
}
