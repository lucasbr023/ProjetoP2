package br.com.loboalphadinamite.delivery.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainProgramacao2 {

	public static void main(String[] args) {

			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("delivery");
			factory.close();


			//		Cliente c = new Cliente();
			//		c.setNome("Natalia");
			//		c.setCpf("10758480406");
			//		c.setEmail("lmc3@cin.ufpe.br");
			//		c.setCelular("97869803");
			//		c.setTelefone("32286151");
			//		c.setDataNascimento(new Date());
			//		
			//		Endereco e = new Endereco();
			//		e.setBairro("Cordeiro");
			//		e.setCep("50630650");
			//		e.setCidade("Recife");
			//		e.setComplemento("Proximo...");
			//		e.setEstado("PE");
			//		e.setLogradouro("Rua Cardeal Dom Augusto");
			//		e.setNumero("914");
			//		
			//		c.setEndereco(e);
			//		
			//		FormaPagamento f = new FormaPagamento();
			//		f.setCodigo(123);
			//		f.setNome("american express2");
			//		
			//		Produto p = new Produto();
			//		p.setCodigo(45);
			//		p.setData(new Date());
			//		p.setNome("Churros");
			//		p.setPecoUnitario(10.0);
			//		
			//		Entregador en = new Entregador();
			//		en.setCpf("12345678911");
			//		en.setDataNascimento(new Date());
			//		en.setMatricula("123456");
			//		en.setModeloMoto("FORD KA");
			//		en.setNome("NATALIA");
			//		en.setPlacaMoto("PEN-4655");
			//		
			//		
			//		Pedido pedido = new Pedido();
			//		pedido.setCliente(c);
			//		pedido.setCodigo(1234);
			//		pedido.setDataPedido(new Date());
			//		pedido.setEntregador(en);
			//		pedido.setFormaPagamento(f);
			//		
			//		
			//		FormaPagamento fp1 = new FormaPagamento();
			//		fp1.setCodigo(45);
			//		fp1.setNome("Teste");
			//		
			//		Fachada fachada = Fachada.getInstancia();
			//		
			//		//fachada.procurarCliente("10758480403");
			//		try {
			//			//fachada.inserirCliente(c);
			//			//fachada.inserirFormaPagamento(fp1);
			//			fachada.buscarTodosClientes();
			//			fachada.buscarTodosEntregadores();
			//			fachada.buscarTodosFormaPagamentos();
			//			fachada.buscarTodosProdutos();
			//			fachada.procurarFormaPagamento(123);
			//			fachada.procurarProduto(45);
			//			fachada.procurarEntregador("123456");
			//			fachada.procurarCliente("10758480407");
			//			
			//		} catch (Exception e1) {
			//			// TODO Auto-generated catch block
			//			e1.printStackTrace();
			//		}
			//fachada.removerCliente("10758480407");
			//fachada.inserirFormaPagamento(f);
			//fachada.atualizarFormaPagamento(f);
			//fachada.procurarFormaPagamento(123);
			//fachada.inserirProduto(p);
			//fachada.procurarProduto(45);
			//fachada.inserirEntregador(en);
			//fachada.procurarEntregador("123456");
			//fachada.inserirPedido(pedido);





		}

	}
