package br.com.biblioteca.dao;

import java.util.List;

public interface DAOInterface<T> {

	public void inserir(T valor);
	public void remover(T valor);
	public List<T> listar();
	public void buscar(int id);
}
