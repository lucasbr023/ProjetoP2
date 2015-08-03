package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.loboalphadinamite.delivery.entidade.EntidadeBasica;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioGenericoColecaoMap<T> implements Repositorio<T>, EntidadeBasica{
	
	private Map repositorio;
	
	public RepositorioGenericoColecaoMap() {
		repositorio = new HashMap();
	}

	@Override
	public boolean existe(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return repositorio.containsKey(chave);
	}

	@Override
	public void inserir(T entidade) throws Exception {
		//repositorio.put(entidade., value)
	}

	@Override
	public void atualizar(T entidade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T procurar(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}



}
