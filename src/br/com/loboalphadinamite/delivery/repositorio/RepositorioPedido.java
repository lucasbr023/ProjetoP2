package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.entidade.Pedido;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioPedido implements Repositorio<Pedido> {
	
	private int indice;
	private static final int TAMANHO_CACHE = 100;
	private Pedido[] pedidos;
	
	public RepositorioPedido() {
		pedidos = new Pedido[TAMANHO_CACHE];
		indice = 0;
	
	}
	
	private int procurarIndice(Serializable chave){
		int posicao = -1;
		
		for(int i = 0; i < indice; i++){

			if(pedidos[i].getCodigo().equals(chave)){
				posicao = i;
				break;
			}
		}
		return posicao;
	}

	public boolean existe(Serializable chave) {
		return procurarIndice(chave) != -1;
	}
	
	

	public void inserir(Pedido entidade) {
		pedidos[indice++] = entidade;
	}

	public void atualizar(Pedido entidade) {
		if(existe(entidade.getCodigo())){
			int i = procurarIndice(entidade.getCodigo());
			pedidos[i] = entidade;
		}
	}

	public void remover(Serializable chave) {
		int i = 0;
		if(existe(chave)){
			i = procurarIndice(chave);
			pedidos[i] = pedidos[indice - 1];
			pedidos[indice - 1] = null;
			indice--;
		}
		
	}

	public Pedido procurar(Serializable chave) {
		Pedido retorno = null;
		int indice = 0;
		if(existe(chave)){
			indice = procurarIndice(chave);
			retorno = pedidos[indice];
		}
		return retorno;
	}

	public Pedido[] buscarTodos() {
		// TODO Auto-generated method stub
		return pedidos;
	}

}
