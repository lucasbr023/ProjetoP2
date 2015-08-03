package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Pedido;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;
import br.com.loboalphadinamite.delivery.interfaces.RepositorioHibernate;

public class CadastroPedidos extends CadastroGenerico<Pedido> {

	public CadastroPedidos(RepositorioHibernate<Pedido> repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}


}
