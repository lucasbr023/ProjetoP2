package br.com.loboalphadinamite.delivery.interfaces;

import java.io.Serializable;

public interface Repositorio<T> {
	
	boolean existe(Serializable chave);
	void inserir(T entidade);
	void atualizar(T entidade);
	void remover(Serializable chave);
	T procurar(Serializable chave);
	T[] buscarTodos();

}
