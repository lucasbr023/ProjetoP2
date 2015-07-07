package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.entidade.Entregador;
import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.entidade.Pedido;
import br.com.loboalphadinamite.delivery.entidade.Produto;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioClienteJDBC;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioEntregadorJDBC;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioFormaPagamentoJDBC;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioPedido;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioProdutosJDBC;

public class Fachada {


	public static Fachada instancia;
	private CadastroClientes cadastroClientes;
	private CadastroFormaPagamento cadastroFormaPagamento;
	private CadastroProdutos cadastroProduto;
	private CadastroEntregador cadastroEntregador;
	private CadastroPedidos cadastroPedidos;


	private Fachada(){
		super();
		init();
	}

	public static Fachada getInstancia(){
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}

	public void init(){
		cadastroClientes = new CadastroClientes(new RepositorioClienteJDBC());
		cadastroFormaPagamento = new CadastroFormaPagamento(new RepositorioFormaPagamentoJDBC());
		cadastroProduto = new CadastroProdutos(new RepositorioProdutosJDBC());
		cadastroEntregador = new CadastroEntregador(new RepositorioEntregadorJDBC());
		cadastroPedidos = new CadastroPedidos(new RepositorioPedido());
	}

	public void inserirCliente(Cliente cliente)throws Exception{
		cadastroClientes.inserir(cliente);
	}

	public void removerCliente(String cpf)throws Exception{
		cadastroClientes.remover(cpf);
	}

	public void atualizarCliente(Cliente cliente)throws Exception{
		cadastroClientes.atualizar(cliente);
	}
	public Cliente procurarCliente(String cpf)throws Exception{
		return cadastroClientes.procurar(cpf);
	}

	public Cliente[] buscarTodosClientes()throws Exception{
		return cadastroClientes.buscarTodos();
	}

	public void inserirFormaPagamento(FormaPagamento formaPagamento)throws Exception{
		cadastroFormaPagamento.inserir(formaPagamento);
	}

	public void removerFormaPagamento(Serializable codigo)throws Exception{
		cadastroFormaPagamento.remover(codigo);
	}
	public void atualizarFormaPagamento(FormaPagamento formaPagamento)throws Exception{
		cadastroFormaPagamento.atualizar(formaPagamento);

	}
	public FormaPagamento procurarFormaPagamento(Integer codigo)throws Exception{
		return cadastroFormaPagamento.procurar(codigo);
	}

	public FormaPagamento[] buscarTodosFormaPagamentos()throws Exception{
		return cadastroFormaPagamento.buscarTodos();
	}
	public void inserirProduto(Produto produto)throws Exception{
		cadastroProduto.inserir(produto);
	}
	public void atualizarProduto(Produto produto)throws Exception{
		cadastroProduto.atualizar(produto);	
	}
	public void removerProduto(Serializable codigo)throws Exception{
		cadastroProduto.remover(codigo);
	}
	public Produto procurarProduto (Serializable codigo)throws Exception{
		return cadastroProduto.procurar(codigo);
	}
	public  Produto[] buscarTodosProdutos()throws Exception{
		return cadastroProduto.buscarTodos();
	}

	public void inserirEntregador(Entregador entidade)throws Exception{
		cadastroEntregador.inserir(entidade);
	}
	public void removerEntregador(String chave)throws Exception{
		cadastroEntregador.remover(chave);
	}

	public void atualizarEntregador(Entregador entidade)throws Exception{
		cadastroEntregador.atualizar(entidade);
	}

	public Entregador procurarEntregador(Serializable chave)throws Exception{
		return cadastroEntregador.procurar(chave);
	}

	public Entregador [] buscarTodosEntregadores()throws Exception{
		return cadastroEntregador.buscarTodos();
	}

	public void inserirPedido(Pedido entidade)throws Exception{
		cadastroPedidos.inserir(entidade);
	}
	public void removerPedido(Serializable chave)throws Exception{
		cadastroPedidos.remover(chave);
	}

	public void atualizarPedido(Pedido entidade)throws Exception{
		cadastroPedidos.atualizar(entidade);
	}

	public Pedido procurarPedido(Serializable chave)throws Exception{
		return cadastroPedidos.procurar(chave);
	}

	public Pedido[] buscarTodosPedidos()throws Exception{
		return cadastroPedidos.buscarTodos();
	}
}

