package br.com.loboalphadinamite.delivery.repositorio;
	
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioFormasPagamentoColecaoList implements Repositorio<FormaPagamento> {
	
	List<FormaPagamento> repositorio;
	
	public RepositorioFormasPagamentoColecaoList() {
		this.repositorio = new ArrayList<>();
	}

	@Override
	public boolean existe(Serializable codigo) throws Exception {
		return procurar(codigo) != null;
	}

	@Override
	public void inserir(FormaPagamento formaPagamento) throws Exception {
		this.repositorio.add(formaPagamento);
		
	}

	@Override
	public void atualizar(FormaPagamento formaPagamento) throws Exception {
		FormaPagamento aux = procurar(formaPagamento.getCodigo());
		int index = this.repositorio.indexOf(aux);
		this.repositorio.set(index, formaPagamento);
		
	}

	@Override
	public void remover(Serializable codigo) throws Exception {

		FormaPagamento aux = procurar(codigo);
		this.repositorio.remove(aux);
	}

	@Override
	public FormaPagamento procurar(Serializable codigo) throws Exception {
		for(FormaPagamento aux : this.repositorio){
//			if(aux.getCodigo() == codigo){
//				
//				
//			}
		}
		return null;
	}

	@Override
	public FormaPagamento[] buscarTodos() throws Exception {
		FormaPagamento[] result = new FormaPagamento[repositorio.size()];
		result = this.repositorio.toArray(result);
		return result;
	}

}
