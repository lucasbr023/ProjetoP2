package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Produto;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioProdutos implements Repositorio<Produto> {

	public static final int TAMANHO_CACHE = 1000;
	private Produto[] produtos;
	private int indice;

	public RepositorioProdutos(){
		produtos = new Produto[TAMANHO_CACHE];
		indice = 0;
	}

	private int procurarIndice(Serializable chave) {
		int posicao = -1;
		for (int i = 0; i < indice; i++) {
			if((produtos[i].getCodigo() == chave)) {
				posicao = i;
				break;
			}
		}
		return posicao;

	}
	
	public boolean existe(Serializable chave) {
		return procurarIndice(chave) != -1;
	}

	public void inserir(Produto entidade) {
		produtos [indice++] = entidade;
	}

	public void atualizar(Produto entidade) {
		if(existe(entidade.getCodigo())){
			int i = procurarIndice(entidade.getCodigo());
			produtos [i] = entidade;
		}

	}

	public void remover(Serializable chave) {
		int i = 0;
		if(existe(chave)){
			i = procurarIndice(chave);
			produtos [i] = produtos [indice];
			produtos [indice -1] = null;
			indice--;
		}
	}

	public Produto procurar(Serializable chave) {
		Produto retorno = null;
		int indice = 0;
		if (existe(chave)){
			indice = procurarIndice(chave);
			retorno = produtos[indice];
		}
		return retorno;
	}

	public Produto[] buscarTodos() {
		return produtos;
	}

}
