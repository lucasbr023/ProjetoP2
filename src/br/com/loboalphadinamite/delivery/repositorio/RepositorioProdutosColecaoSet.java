package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.loboalphadinamite.delivery.entidade.Produto;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioProdutosColecaoSet implements Repositorio<Produto>{
	
	private Set repositorio;
	
	public RepositorioProdutosColecaoSet() {
		repositorio = new HashSet();
	}

	@Override
	public boolean existe(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return procurar(chave) != null;
	}

	@Override
	public void inserir(Produto entidade) throws Exception {
		repositorio.add(entidade);
		
	}

	@Override
	public void atualizar(Produto entidade) throws Exception {
		if(repositorio.contains(entidade)){
			Produto p = procurar(entidade.getCodigo());
			repositorio.remove(p);
			repositorio.add(entidade);
		}
		
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		repositorio.remove(procurar(chave));
	}

	@Override
	public Produto procurar(Serializable chave) throws Exception {
		Produto aux = null;
		for(Object p : repositorio){
			aux = (Produto)p;
			if(aux.getCodigo() == chave){
				return aux;
			}
		}
		return null;
	}

	@Override
	public Produto[] buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
