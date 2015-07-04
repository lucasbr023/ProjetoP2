package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class CadastroClientes implements Cadastro<Cliente>{
	
	Repositorio<Cliente> repositorio;
	
	public CadastroClientes(Repositorio<Cliente> repositorio) {
		this.repositorio = repositorio;
	}

	
	public boolean existe(Serializable chave) {
		return repositorio.existe(chave);
	}

	
	public void inserir(Cliente entidade) {
		if(validar(entidade)){
			repositorio.inserir(entidade);
		}
	}

	
	public void atualizar(Cliente entidade) {
		if(validar(entidade)){
			repositorio.atualizar(entidade);
		}
	}

	public void remover(Serializable chave) {
		repositorio.remover(chave);
	}

	
	public Cliente procurar(Serializable chave) {
		return repositorio.procurar(chave);
	}

	public Cliente[] buscarTodos() {
		return repositorio.buscarTodos();
	}
	
	
	public static final boolean validar(Cliente cliente){
		
		return true;
	}
	
	

}
