package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.loboalphadinamite.delivery.entidade.Pedido;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioPedidosColecaoMap implements Repositorio<Pedido>{
	
	private Map repositorio;
	public RepositorioPedidosColecaoMap() {
		this.repositorio = new HashMap();
	}	
	
	
	@Override
	public boolean existe(Serializable chave) throws Exception {
		return this.repositorio.containsKey(chave);
	}

	@Override
	public void inserir(Pedido entidade) throws Exception {
		this.repositorio.put(entidade.getCodigo(), entidade);
	}

	@Override
	public void atualizar(Pedido entidade) throws Exception {
		this.repositorio.put(entidade.getCodigo(), entidade );
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		this.repositorio.remove(chave);
	}

	@Override
	public Pedido procurar(Serializable chave) throws Exception {
		return (Pedido) this.repositorio.get(chave);
	}

	@Override
	public Pedido[] buscarTodos() throws Exception {
		return (Pedido[]) this.repositorio.values().toArray(new Pedido[this.repositorio.size()]);
	}



}
