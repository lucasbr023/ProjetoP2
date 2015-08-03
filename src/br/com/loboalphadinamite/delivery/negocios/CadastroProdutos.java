package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;
import java.sql.Date;

import br.com.loboalphadinamite.delivery.entidade.Produto;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;
import br.com.loboalphadinamite.delivery.interfaces.RepositorioHibernate;

public class CadastroProdutos extends CadastroGenerico<Produto> {

	public CadastroProdutos(RepositorioHibernate<Produto> repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}


}