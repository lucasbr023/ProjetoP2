package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Entregador;
import br.com.loboalphadinamite.delivery.excecao.CampoObrigatorioNaoInformado;
import br.com.loboalphadinamite.delivery.excecao.CampoPreenchidoIncorreto;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class CadastroEntregador implements Cadastro<Entregador>{

	private Repositorio<Entregador> repositorio;
	
	public CadastroEntregador(Repositorio<Entregador> repositorio) {
		// TODO Auto-generated constructor stub
		this.repositorio = repositorio;
	}
	
	
	public boolean existe(Serializable chave) throws Exception{
		// TODO Auto-generated method stub
		return repositorio.existe(chave);
	}

	
	public void inserir(Entregador entidade) throws Exception{
		// TODO Auto-generated method stub
		if(validar(entidade)){
			repositorio.inserir(entidade);
		}
	}//fim do inserir

	
	public void atualizar(Entregador entidade) throws Exception{
		// TODO Auto-generated method stub
		if(validar(entidade)){
			repositorio.atualizar(entidade);
		}
	}

	
	public void remover(Serializable chave) throws Exception{
		// TODO Auto-generated method stub
		repositorio.remover(chave);
		
	}

	
	public Entregador procurar(Serializable chave) throws Exception{
		return repositorio.procurar(chave);
	}

	
	public Entregador[] buscarTodos() throws Exception{		
		return repositorio.buscarTodos();
	}
	
	public static boolean validar(Entregador entregador)throws Exception{
		
		if (entregador.getNome() == null || entregador.getNome().isEmpty()) {
			throw new CampoObrigatorioNaoInformado("Nome do entregador não informado");
		}
		
		if (entregador.getNome().matches("^[w]+")) {
			throw new CampoPreenchidoIncorreto("Não pode conter numeros");
		}
		
		if(entregador.getMatricula() == null || entregador.getMatricula().isEmpty()){
			throw new CampoObrigatorioNaoInformado("Matricula não informada!");
		}
		
		if (entregador.getMatricula().matches("^[d]+")) {
			throw new CampoPreenchidoIncorreto("Matricula deve conter apenas numeros");
		}
		
		if (entregador.getModeloMoto() == null || entregador.getModeloMoto().isEmpty()) {
			throw new CampoObrigatorioNaoInformado("Modelo moto nao informada");
		}
		
		if (entregador.getPlacaMoto() == null || entregador.getPlacaMoto().isEmpty()) {
			throw new CampoObrigatorioNaoInformado("Placa nao informada");
		}
		
//		if (entregador.getTelefone() == null || entregador.getTelefone().isEmpty()) {
//			throw new CampoObrigatorioNaoInformado("Telefone nao informado");
//		}
// 		
//		if (entregador.getTelefone().matches("^[d]+")) {
//			throw new CampoPreenchidoIncorreto("Telefone deve conter apenas numeros");
//		}

		return true;
	}

	
}
