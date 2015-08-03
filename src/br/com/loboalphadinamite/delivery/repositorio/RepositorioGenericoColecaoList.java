package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.loboalphadinamite.delivery.entidade.EntidadeBasica;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioGenericoColecaoList<T extends EntidadeBasica> implements Repositorio<T>{

	private List<T> repositorio;
	
	public RepositorioGenericoColecaoList() {
		repositorio = new ArrayList<>();
	}
	
	@Override
	public boolean existe(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return procurar(chave) != null;
	}

	@Override
	public void inserir(T entidade) throws Exception {

		repositorio.add(entidade);
	}

	@Override
	public void atualizar(T entidade) throws Exception {
		int index = repositorio.indexOf(entidade);
		repositorio.set(index, entidade);
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		repositorio.remove(procurar(chave));
	}

	@Override
	public T procurar(Serializable chave) throws Exception {
		for(T t : repositorio){
			if(t.getId().equals(chave)){
				return t;
			}
		}
		return null;
	}

	@Override
	public T[] buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return (T[]) repositorio.toArray();
	}

	


}
