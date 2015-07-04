package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Produto;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class CadastroProdutos implements Cadastro<Produto> {
	
	private Repositorio<Produto> repositorio;
	
	public CadastroProdutos(Repositorio<Produto> repositorio) {
		this.repositorio = repositorio;
	}
	

	public boolean existe(Serializable chave) {
		return repositorio.existe(chave);
	}

	public void inserir(Produto entidade) {
		if(validar(entidade)){
			repositorio.inserir(entidade);
		}
	}

	public void atualizar(Produto entidade) {
		if(validar(entidade)){
			repositorio.atualizar(entidade);
		}
	}

	public void remover(Serializable chave) {
		repositorio.remover(chave);
	}

	public Produto procurar(Serializable chave) {
		return repositorio.procurar(chave);
	}

	public Produto[] buscarTodos() {
		return repositorio.buscarTodos();
	}
	
	public static boolean validar(Produto produto){
		
		return true;
		
	}
}