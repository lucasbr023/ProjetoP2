package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.loboalphadinamite.delivery.entidade.Entregador;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class RepositorioEntregadoresColecaoSet implements Repositorio<Entregador> {

private Set repositorio;
	
	public RepositorioEntregadoresColecaoSet() {
		repositorio = new HashSet();
	}

	@Override
	public boolean existe(Serializable matricula) throws Exception {
		// TODO Auto-generated method stub
		return procurar(matricula) != null;
	}

	@Override
	public void inserir(Entregador entregador) throws Exception {
		repositorio.add(entregador);
		
	}

	@Override
	public void atualizar(Entregador entregador) throws Exception {
		if(repositorio.contains(entregador)){
			Entregador e = procurar(entregador.getMatricula());
			repositorio.remove(e);
			repositorio.add(entregador);
		}
	}

	@Override
	public void remover(Serializable matricula) throws Exception {
		repositorio.remove(procurar(matricula));
	}

	@Override
	public Entregador procurar(Serializable matricula) throws Exception {
		Entregador aux = null;
		for(Object e : repositorio){
			aux = (Entregador) e;
			if(aux.getMatricula() == matricula){
				return aux;
			}
		}
		return null;
	}

	@Override
	public Entregador[] buscarTodos() throws Exception {
		return (Entregador[]) repositorio.toArray(new Entregador[repositorio.size()]);
	}

}