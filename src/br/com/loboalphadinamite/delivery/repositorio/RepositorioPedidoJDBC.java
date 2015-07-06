package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Pedido;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioPedidoJDBC implements Repositorio<Pedido>{

	@Override
	public boolean existe(Serializable chave) {
		return procurar(chave) != null;
	}

	@Override
	public void inserir(Pedido entidade) {
		String sql = "";
		
		
	}

	@Override
	public void atualizar(Pedido entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Serializable chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido procurar(Serializable chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido[] buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
