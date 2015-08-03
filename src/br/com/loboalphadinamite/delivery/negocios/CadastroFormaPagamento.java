package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.excecao.CampoObrigatorioNaoInformado;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;
import br.com.loboalphadinamite.delivery.interfaces.RepositorioHibernate;

public class CadastroFormaPagamento extends CadastroGenerico<FormaPagamento> {

	public CadastroFormaPagamento(
			RepositorioHibernate<FormaPagamento> repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}

	

	

}
