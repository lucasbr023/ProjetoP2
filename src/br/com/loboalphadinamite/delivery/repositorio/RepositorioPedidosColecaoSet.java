package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.loboalphadinamite.delivery.entidade.Pedido;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioPedidosColecaoSet implements Repositorio<Pedido>{

	private Set repositorio;

	public RepositorioPedidosColecaoSet() {
		repositorio = new HashSet();
	}

	@Override
	public boolean existe(Serializable chave) throws Exception {
		// TODO Auto-generated method stub
		return procurar(chave) != null;
	}

	@Override
	public void inserir(Pedido entidade) throws Exception {
		repositorio.add(entidade);
	}

	@Override
	public void atualizar(Pedido entidade) throws Exception {
		if(repositorio.contains(entidade)){
			Pedido p = procurar(entidade.getCodigo());
			repositorio.remove(p);
			repositorio.add(entidade);
		}
	}

	@Override
	public void remover(Serializable chave) throws Exception {
		repositorio.remove(procurar(chave));
	}

	@Override
	public Pedido procurar(Serializable chave) throws Exception {
		Pedido aux = null;
		for(Object o : repositorio){
			aux = (Pedido) o;
			if(aux.getCodigo() == chave){
				return aux;
			}
			
		}
		return null;
	}

	@Override
	public Pedido[] buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return (Pedido[]) repositorio.toArray(new Pedido[repositorio.size()]);
	}



}
