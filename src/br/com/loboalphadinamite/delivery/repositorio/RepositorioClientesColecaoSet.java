package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioClientesColecaoSet implements Repositorio<Cliente>{;
	
	private Set repositorio;
	
	public RepositorioClientesColecaoSet() {
		repositorio = new HashSet();
	}

	@Override
	public boolean existe(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return procurar(chave) != null;
	}

	@Override
	public void inserir(Cliente entidade) throws Exception {
		repositorio.add(entidade);
	}

	@Override
	public void atualizar(Cliente entidade) throws Exception {
		if(repositorio.contains(entidade)){
			Cliente c = procurar(entidade.getCpf());
			repositorio.remove(entidade);
			repositorio.add(entidade);
		}
		
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		repositorio.remove(procurar(chave));
	}

	@Override
	public Cliente procurar(Serializable chave) throws Exception {
		Cliente aux = null;
		for(Object c : repositorio){
			aux = (Cliente) c;
			if(aux.getCpf() == chave){
				return aux;
			}
		}
		return null;
	}

	@Override
	public Cliente[] buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return (Cliente[]) repositorio.toArray(new Cliente[repositorio.size()]);
	}

	

}
