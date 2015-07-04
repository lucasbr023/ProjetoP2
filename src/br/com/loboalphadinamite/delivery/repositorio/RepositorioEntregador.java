package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Entregador;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioEntregador implements Repositorio<Entregador>{

	private static final int TAMANHO_CACHE = 1000;
	private Entregador [] entregadores;
	private int indice;
	
	public RepositorioEntregador() {
		entregadores = new Entregador[TAMANHO_CACHE];
		indice = 0;
	}
	
	private int procurarIndice(Serializable chave){
		int posicao = -1;
		for(int i = 0; i<indice; i++){
			if(entregadores[i].getMatricula().equals(chave)){
				posicao = i;
				break;
			}
			
		}
		return posicao;
	}//fim procurarIndice
	
	public boolean existe(Serializable chave){
		return procurarIndice(chave) != -1;
	}//fim metodo existe
	
	public Entregador procurar(Serializable chave){
		Entregador retorno = null;
		int indice = 0;
		if(existe(chave)){
			indice = procurarIndice(chave);
			retorno = entregadores[indice];
		}
		return retorno;
	}//fim procurar
	
	public void inserir(Entregador entidade){
		entregadores[indice++] = entidade;
	}//fim inserir
	
	public void atualizar(Entregador entidade){
		if (existe(entidade.getMatricula())) {
			int i = procurarIndice(entidade.getMatricula());
			entregadores[i] = entidade;
		}
	}//fim atualizar
	


	
	public void remover(Serializable chave) {

		if (existe(chave)) {
			int i = 0;
			i = procurarIndice(chave);
			entregadores[i] = entregadores[indice-1];
			entregadores[indice-1] = null;
			indice--;
		}
	}//fim remover

	
	public Entregador[] buscarTodos() {
		return entregadores;
	}
}
