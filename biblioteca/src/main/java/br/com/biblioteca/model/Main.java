package br.com.biblioteca.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");
		EntityManager em = factory.createEntityManager();
		
		System.out.println("Criei conexao");
	}
}
