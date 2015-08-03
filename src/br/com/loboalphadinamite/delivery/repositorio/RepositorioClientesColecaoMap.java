package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioClientesColecaoMap implements Repositorio<Cliente> {
	
	private Map repositorio;
	
	public RepositorioClientesColecaoMap() {
		this.repositorio = new HashMap();
	}

	@Override
	public boolean existe(Serializable chave) throws Exception {
		return this.repositorio.containsKey(chave);
	}

	@Override
	public void inserir(Cliente entidade) throws Exception {
		this.repositorio.put(entidade.getCpf(), entidade);
	}

	@Override
	public void atualizar(Cliente entidade) throws Exception {
		this.repositorio.put(entidade.getCpf(), entidade);
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		this.repositorio.remove(chave);
	}

	@Override
	public Cliente procurar(Serializable chave) throws Exception {
		return (Cliente) this.repositorio.get(chave);
	}
	
	

	@Override
	public Cliente[] buscarTodos() throws Exception {
		return (Cliente[]) this.repositorio.values().toArray(new Cliente[this.repositorio.size()]);
	}

	

}
