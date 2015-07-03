package br.com.loboalphadinamite.delivery.main;

import java.util.Date;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.entidade.Endereco;
import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.negocios.Fachada;

public class MainProgramacao2 {
	
	public static void main(String[] args) {
		Cliente c = new Cliente();
		c.setNome("Lucas");
		c.setCpf("10758480407");
		c.setEmail("lmc3@cin.ufpe.br");
		c.setCelular("97869803");
		c.setTelefone("32286151");
		c.setDataNascimento(new Date());
		
		Endereco e = new Endereco();
		e.setBairro("Cordeiro");
		e.setCep("50630650");
		e.setCidade("Recife");
		e.setComplemento("Proximo...");
		e.setEstado("Pernambuco");
		e.setLogradouro("Rua Cardeal Dom Augusto");
		e.setNumero("914");
		
		c.setEndereco(e);
		
		FormaPagamento f = new FormaPagamento();
		f.setCodigo(123);
		f.setNome("american express");
		
		Fachada fachada = Fachada.getInstancia();
		fachada.inserirCliente(c);
		System.out.println(fachada.procurarCliente("10758480407"));
		fachada.inserirFormaPagamento(f);
		System.out.println(fachada.procurarFormaPagamento(123));
		
		
	}

}
