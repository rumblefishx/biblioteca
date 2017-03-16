package br.com.biblioteca.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");
	
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
}
