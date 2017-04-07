package br.com.biblioteca.config;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.biblioteca.dao.CategoriaDAO;
import br.com.biblioteca.dao.EditoraDAO;
import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.model.Categoria;
import br.com.biblioteca.model.Contato;
import br.com.biblioteca.model.Editora;
import br.com.biblioteca.model.Endereco;
import br.com.biblioteca.model.Livro;

public class DatabaseInitializer {

	private static EntityManager em = JPAUtil.getEntityManager();
	
	public static void main(String args[]){
		DatabaseInitializer.categoriaInitializer();
		DatabaseInitializer.editoraInitializer();
		DatabaseInitializer.livroInitializer();
	}	
	
	public static void categoriaInitializer(){
		em.getTransaction().begin();
		CategoriaDAO categoriaDao = new CategoriaDAO();
		Categoria categoria = new Categoria();
		categoria.setNome("Ficcao");
		categoria.setDescricao("Livros de universos ficticios");
		
		categoriaDao.inserir(categoria);
		em.getTransaction().commit();
	}
	
	public static void editoraInitializer(){	
		em.getTransaction().begin();
		EditoraDAO editoraDao = new EditoraDAO();
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Jardim Angélica");
		endereco.setCep("06365190");
		endereco.setCidade("Carapicuíba");
		endereco.setEstado("SP");
		endereco.setLogradouro("Rua Padre Lionel Corbeil");
		endereco.setNumero("15");
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Contato contato = new Contato();
		contato.setCelular("11987138411");
		contato.setEmail("galera@galera.com");
		contato.setTelefoneFixo("1141891585");
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Editora galera = new Editora();
		galera.setNome("Galera");
		galera.setEndereco(em.find(Endereco.class, 1));
		galera.setContato(em.find(Contato.class, 1));
		
		editoraDao.inserir(galera);
		em.getTransaction().commit();
	}
	
	public static void livroInitializer(){
		em.getTransaction().begin();
		LivroDAO livroDao = new LivroDAO();
		Livro livro = new Livro();
		
		livro.setDataLancamento(new Date());
		livro.setDescricao("Livro do assassins creed");
		livro.setEdicao(3);
		livro.setISBN(9788501098344L);
		livro.setNumeroPaginas(336);
		livro.setTitulo("Assassin's Creed : A cruzada secreta");
		
		Categoria categoria = em.find(Categoria.class,1);
		Editora editora = em.find(Editora.class, 1);
		
		livro.setCategorias(Arrays.asList(categoria));
		livro.setEditora(editora);
		
		livroDao.inserir(livro);
		em.getTransaction().commit();
	}
}
