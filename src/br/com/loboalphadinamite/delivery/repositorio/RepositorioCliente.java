package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioCliente implements Repositorio<Cliente> {
	
	private static final int TAMANHO_CACHE = 1000;
	private Cliente[] clientes;
	private int indice;
	
	
	public RepositorioCliente() {
		clientes = new Cliente[TAMANHO_CACHE];
		indice = 0;
	}
	
	private int procurarIndice(Serializable chave){
		int posicao = -1;
		
		for(int i = 0; i < indice; i++){

			if(clientes[i].getCpf().equals(chave)){
				posicao = i;
				break;
			}
		}
		return posicao;
	}

	
	public boolean existe(Serializable chave) {
		return procurarIndice(chave) != -1;
	}

	
	public void inserir(Cliente entidade) {
		clientes[indice++] = entidade;
	}

	
	public void atualizar(Cliente entidade) {
		if(existe(entidade.getCpf())){
			int i = procurarIndice(entidade.getCpf());
			clientes[i] = entidade;
		}
	}


	public void remover(Serializable chave) {
		int i = 0;
		if(existe(chave)){
			i = procurarIndice(chave);
			clientes[i] = clientes[indice - 1];
			clientes[indice - 1] = null;
			indice--;
		}
	}

	
	public Cliente procurar(Serializable chave) {
		Cliente retorno = null;
		int indice = 0;
		if(existe(chave)){
			indice = procurarIndice(chave);
			retorno = clientes[indice];
		}
		return retorno;
	}

	
	public Cliente[] buscarTodos() {
		return clientes;
	}
	
	

}
