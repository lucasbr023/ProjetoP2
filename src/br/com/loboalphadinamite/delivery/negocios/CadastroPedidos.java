package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Pedido;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class CadastroPedidos implements Cadastro<Pedido> {

	Repositorio<Pedido> repositorio;
	
	public CadastroPedidos(Repositorio<Pedido> repositorio) {
		this.repositorio = repositorio;
	}
	
public boolean existe(Serializable chave) {
		
		return repositorio.existe(chave);
	}

	
	public void inserir(Pedido entidade) {
		if (validar(entidade)){
			repositorio.inserir(entidade);
		}
	}

	
	public void atualizar(Pedido entidade) {
		if(validar(entidade)){
			repositorio.atualizar(entidade);
		}
	}

	public void remover(Serializable chave) {
		repositorio.remover(chave);

	}

	public Pedido procurar(Serializable chave) {
		return repositorio.procurar(chave);
	}

	
	public Pedido[] buscarTodos() {
		return repositorio.buscarTodos();
	}
	
	public static boolean validar (Pedido pedido) {
		return true;
	}

}
