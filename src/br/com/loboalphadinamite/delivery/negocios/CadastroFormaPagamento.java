package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class CadastroFormaPagamento implements Cadastro<FormaPagamento> {

	
	private Repositorio<FormaPagamento> repositorio;
	
	public CadastroFormaPagamento(Repositorio<FormaPagamento> repositorio) {
		this.repositorio = repositorio;
		
	}
	
	
	public boolean existe(Serializable chave) {
		
		return repositorio.existe(chave);
	}

	
	public void inserir(FormaPagamento entidade) {
		if (validar(entidade)){
			repositorio.inserir(entidade);
		}
	}

	
	public void atualizar(FormaPagamento entidade) {
		if(validar(entidade)){
			repositorio.atualizar(entidade);
		}
	}

	public void remover(Serializable chave) {
		repositorio.remover(chave);

	}

	public FormaPagamento procurar(Serializable chave) {
		return repositorio.procurar(chave);
	}

	
	public FormaPagamento[] buscarTodos() {
		return repositorio.buscarTodos();
	}
	
	public static boolean validar (FormaPagamento formaPagamento) {
		return true;
	}
	

}
