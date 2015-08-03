package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.loboalphadinamite.delivery.entidade.Pedido;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioPedidosColecaoList implements Repositorio<Pedido>{
	
	List<Pedido> repositorio;
	public RepositorioPedidosColecaoList() {
		this.repositorio = new ArrayList<>();
	}

	@Override
	public boolean existe(Serializable codigo) throws Exception {
		return procurar(codigo) != null;
	}

	@Override
	public void inserir(Pedido pedido) throws Exception {
		this.repositorio.add(pedido);
	}

	@Override
	public void atualizar(Pedido pedido) throws Exception {
		Pedido aux = procurar(pedido.getCodigo());
		int index = this.repositorio.indexOf(aux);
		this.repositorio.set(index, pedido);
		
	}

	@Override
	public void remover(Serializable codigo) throws Exception {

		Pedido aux = procurar(codigo);
		this.repositorio.remove(aux);
	}

	@Override
	public Pedido procurar(Serializable codigo) throws Exception {

		for(Pedido aux : this.repositorio){
			if(aux.getCodigo() == codigo){
				
			}
		}
		return null;
	}

	@Override
	public Pedido[] buscarTodos() throws Exception {
		Pedido[] result = new Pedido[repositorio.size()];
		result = this.repositorio.toArray(result);
		return result;
	}

}
