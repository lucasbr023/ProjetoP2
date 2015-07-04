package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioFormaPagamento implements Repositorio<FormaPagamento>{

	private static final int TAMANHO_CACHE = 1000;
	private FormaPagamento[] formasPagamento;
	private int indice;

	public RepositorioFormaPagamento() {
		formasPagamento = new FormaPagamento[TAMANHO_CACHE];
		indice = 0;
	}

	private int procurarIndice(Serializable codigo){

		int posicao = -1;

		for (int i = 0; i < indice; i++) {
			if((formasPagamento[i]).getCodigo() == codigo) {
				posicao = i;
				break;
			}
		}
		return posicao;
	}

	
	public boolean existe(Serializable chave) {
		return procurarIndice(chave) != -1;
	}

	
	public void inserir(FormaPagamento entidade) {
		formasPagamento [indice++] = entidade;
	}

	
	public void atualizar(FormaPagamento entidade) {
		if(existe(entidade.getCodigo())){
			int i = procurarIndice(entidade.getCodigo());
			formasPagamento [i] = entidade;
		}
	}

	
	public void remover(Serializable chave) {
		int i = 0;
		if(existe(chave)){
			i = procurarIndice(chave);
			formasPagamento[i] = formasPagamento [indice -1];
			formasPagamento [indice - 1] = null;
			indice --;
		}
	}

	
	public FormaPagamento procurar(Serializable chave) {
		FormaPagamento retorno = null;
		int indice = 0;
		if(existe(chave)){
			indice = procurarIndice(chave);
			retorno = formasPagamento[indice];
		}
		return retorno;
	}

	
	public FormaPagamento[] buscarTodos() {
		return formasPagamento;
	}


}
