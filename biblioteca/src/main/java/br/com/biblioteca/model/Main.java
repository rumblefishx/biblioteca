package br.com.biblioteca.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.biblioteca.dao.UsuarioDAO;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");
		EntityManager em = factory.createEntityManager();
		
		UsuarioDAO dao = new UsuarioDAO(em);
		Usuario usuario = dao.buscar("cleiton");
		
		System.out.println("Achei ?? Nivel acesso: " + usuario.getNivelAcesso());
		
		System.out.println("Criei conexao");
	}
}
