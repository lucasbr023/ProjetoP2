package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioFormasPagamentoColecaoSet implements Repositorio<FormaPagamento>{

	private Set repositorio;
	
	public RepositorioFormasPagamentoColecaoSet() {
		repositorio = new HashSet();
	}
	
	@Override
	public boolean existe(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return procurar(chave) != null;
	}

	@Override
	public void inserir(FormaPagamento entidade) throws Exception {
		repositorio.add(entidade);
	}

	@Override
	public void atualizar(FormaPagamento entidade) throws Exception {
		if(repositorio.contains(entidade)){
			FormaPagamento formaPagamento = procurar(entidade.getCodigo());
			repositorio.remove(formaPagamento);
			repositorio.add(entidade);
		}
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		repositorio.remove(procurar(chave));
	}

	@Override
	public FormaPagamento procurar(Serializable chave) throws Exception {
		FormaPagamento aux = null;
		for(Object f : repositorio){
			aux = (FormaPagamento) f;
			if(aux.getCodigo() == chave){
				return aux;
			}
		}
		return null;
	}

	@Override
	public FormaPagamento[] buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return (FormaPagamento[])repositorio.toArray(new FormaPagamento[repositorio.size()]);
	}



}
