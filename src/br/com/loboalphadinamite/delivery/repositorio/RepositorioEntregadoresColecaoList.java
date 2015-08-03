package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.loboalphadinamite.delivery.entidade.Entregador;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioEntregadoresColecaoList implements Repositorio<Entregador>{
	
	List<Entregador> repositorio;
	
	public RepositorioEntregadoresColecaoList() {
		this.repositorio = new ArrayList<>();
	}

	@Override
	public boolean existe(Serializable matricula) throws Exception {
		return procurar(matricula) != null;
	}

	@Override
	public void inserir(Entregador entregador) throws Exception {
		this.repositorio.add(entregador);
		
	}

	@Override
	public void atualizar(Entregador entregador) throws Exception {
		Entregador aux = procurar(entregador.getMatricula());
		int index = this.repositorio.indexOf(aux);
		this.repositorio.set(index, entregador);
		
		
	}

	@Override
	public void remover(Serializable matricula) throws Exception {
		Entregador aux = procurar(matricula);
		this.repositorio.remove(matricula);
	}

	@Override
	public Entregador procurar(Serializable matricula) throws Exception {
		for(Entregador aux : this.repositorio){
			if(aux.getMatricula().equals(matricula)){
				return aux;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entregador[] buscarTodos() throws Exception {
		Entregador[] result = new Entregador[repositorio.size()];
		result = this.repositorio.toArray(result);
		return result;
	}
	
	


}
