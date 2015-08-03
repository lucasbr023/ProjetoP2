package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.interfaces.RepositorioHibernate;

public class CadastroClientes extends CadastroGenerico<Cliente>{

	public CadastroClientes(RepositorioHibernate<Cliente> repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	
	public void remover(Serializable chave) throws Exception {
		super.remover(chave);
	}
	



	

}
