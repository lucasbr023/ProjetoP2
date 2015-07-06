package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.excecao.CampoObrigatorioNaoInformado;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class CadastroFormaPagamento implements Cadastro<FormaPagamento> {

	
	private Repositorio<FormaPagamento> repositorio;
	
	public CadastroFormaPagamento(Repositorio<FormaPagamento> repositorio) {
		this.repositorio = repositorio;
		
	}
	
	
	public boolean existe(Serializable chave) throws Exception{
		
		return repositorio.existe(chave);
	}

	
	public void inserir(FormaPagamento entidade) throws Exception{
		if (validar(entidade)){
			repositorio.inserir(entidade);
		}
	}

	
	public void atualizar(FormaPagamento entidade) throws Exception{
		if(validar(entidade)){
			repositorio.atualizar(entidade);
		}
	}

	public void remover(Serializable chave) throws Exception{
		repositorio.remover(chave);

	}

	public FormaPagamento procurar(Serializable chave) throws Exception{
		return repositorio.procurar(chave);
	}

	
	public FormaPagamento[] buscarTodos() throws Exception{
		return repositorio.buscarTodos();
	}
	
	public static boolean validar (FormaPagamento formaPagamento) throws Exception{
		
		if (formaPagamento.getNome() == null || formaPagamento.getNome().isEmpty()) {
			throw new CampoObrigatorioNaoInformado("Forma de Pagamento não informada");
		}
		
		if (!formaPagamento.getNome().matches("[w]+")) {
			throw new CampoObrigatorioNaoInformado(" ");
		}

		
		return true;
	}
	

}
