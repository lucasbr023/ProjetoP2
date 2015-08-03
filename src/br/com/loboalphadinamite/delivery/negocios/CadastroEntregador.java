package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Entregador;
import br.com.loboalphadinamite.delivery.excecao.CampoObrigatorioNaoInformado;
import br.com.loboalphadinamite.delivery.excecao.CampoPreenchidoIncorreto;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;
import br.com.loboalphadinamite.delivery.interfaces.RepositorioHibernate;

public class CadastroEntregador extends CadastroGenerico<Entregador>{

	public CadastroEntregador(RepositorioHibernate<Entregador> repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}


	
}
