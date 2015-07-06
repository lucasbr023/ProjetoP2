package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;
import java.sql.Date;

import br.com.loboalphadinamite.delivery.entidade.Produto;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class CadastroProdutos implements Cadastro<Produto> {

	private Repositorio<Produto> repositorio;

	public CadastroProdutos(Repositorio<Produto> repositorio) {
		this.repositorio = repositorio;
	}


	public boolean existe(Serializable chave) throws Exception{
		return repositorio.existe(chave);
	}

	public void inserir(Produto entidade) throws Exception{
		if(validar(entidade)){
			repositorio.inserir(entidade);
		}
	}

	public void atualizar(Produto entidade) throws Exception{
		if(validar(entidade)){
			repositorio.atualizar(entidade);
		}
	}

	public void remover(Serializable chave) throws Exception{
		repositorio.remover(chave);
	}

	public Produto procurar(Serializable chave) throws Exception{
		return repositorio.procurar(chave);
	}

	public Produto[] buscarTodos() throws Exception{
		return repositorio.buscarTodos();
	}

	public static boolean validar(Produto produto)throws Exception{
		if (produto.getData()== null) {
			return false;
		}

//		if (produto.getData().before(new Date())) {
//			return false;
//		}

		if (produto.getPecoUnitario() < 0) {
			return false;
		}

		if (produto.getNome() == null || produto.getNome().isEmpty()) {
			return false;
		}

		return true;

	}
}