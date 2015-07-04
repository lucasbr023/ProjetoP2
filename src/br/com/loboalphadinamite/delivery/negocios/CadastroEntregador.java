package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Entregador;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class CadastroEntregador implements Cadastro<Entregador>{

	private Repositorio<Entregador> repositorio;
	
	public CadastroEntregador(Repositorio<Entregador> repositorio) {
		// TODO Auto-generated constructor stub
		this.repositorio = repositorio;
	}
	
	
	public boolean existe(Serializable chave) {
		// TODO Auto-generated method stub
		return repositorio.existe(chave);
	}

	
	public void inserir(Entregador entidade) {
		// TODO Auto-generated method stub
		if(validar(entidade)){
			repositorio.inserir(entidade);
		}
	}//fim do inserir

	
	public void atualizar(Entregador entidade) {
		// TODO Auto-generated method stub
		if(validar(entidade)){
			repositorio.atualizar(entidade);
		}
	}

	
	public void remover(Serializable chave) {
		// TODO Auto-generated method stub
		repositorio.remover(chave);
		
	}

	
	public Entregador procurar(Serializable chave) {
		return repositorio.procurar(chave);
	}

	
	public Entregador[] buscarTodos() {		
		return repositorio.buscarTodos();
	}
	
	public static boolean validar(Entregador entregador){
		return true;
	}

	
}
