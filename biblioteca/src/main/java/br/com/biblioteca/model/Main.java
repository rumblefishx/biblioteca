package br.com.biblioteca.model;


import br.com.biblioteca.dao.UsuarioDAO;

public class Main {

	public static void main(String[] args) {
				
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscar("cleiton");
		
		System.out.println("Achei ?? Nivel acesso: " + usuario.getNivelAcesso());
		
		System.out.println("Criei conexao");
	}
}
