package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioFormasPagamentoColecaoMap implements Repositorio<FormaPagamento>{
	
	private Map repositorio;
	
	public RepositorioFormasPagamentoColecaoMap() {
		this.repositorio = new HashMap();
	}

	@Override
	public boolean existe(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return this.repositorio.containsKey(chave);
	}

	@Override
	public void inserir(FormaPagamento entidade) throws Exception {
		// TODO Auto-generated method stub
		this.repositorio.put(entidade.getCodigo(), entidade);
	}

	@Override
	public void atualizar(FormaPagamento entidade) throws Exception {
		this.repositorio.put(entidade.getCodigo(), entidade);
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		this.repositorio.remove(chave);
	}

	@Override
	public FormaPagamento procurar(Serializable chave) throws Exception {
		return (FormaPagamento) this.repositorio.get(chave);
	}

	@Override
	public FormaPagamento[] buscarTodos() throws Exception {
		return (FormaPagamento[]) this.repositorio.values().toArray(new FormaPagamento[this.repositorio.size()]);
	}



}
