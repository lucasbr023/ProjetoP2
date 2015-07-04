package br.com.loboalphadinamite.delivery.main;

import java.util.Date;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.entidade.Endereco;
import br.com.loboalphadinamite.delivery.entidade.Entregador;
import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.entidade.Produto;
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
		
		Produto p = new Produto();
		p.setCodigo(45);
		p.setData(new Date());
		p.setNome("Churros");
		p.setPecoUnitario(10.0);
		
		Entregador en = new Entregador();
		en.setCpf("12345678911");
		en.setDataNascimento(new Date());
		en.setMatricula("123456");
		en.setModeloMoto("FORD KA");
		en.setNome("NATALIA");
		en.setPlacaMoto("PEN-4655");
		
		
		
		Fachada fachada = Fachada.getInstancia();
		fachada.inserirCliente(c);
		System.out.println(fachada.procurarCliente("10758480407"));
		fachada.inserirFormaPagamento(f);
		System.out.println(fachada.procurarFormaPagamento(123));
		fachada.inserirProduto(p);
		System.out.println(fachada.procurarProduto(45));
		fachada.inserirEntregador(en);
		System.out.println(fachada.procurarEntregador("123456"));
		
		
	}

}
