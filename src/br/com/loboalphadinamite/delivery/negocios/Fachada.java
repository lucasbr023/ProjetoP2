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
import br.com.loboalphadinamite.delivery.repositorio.RepositorioProdutoJDBC;

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
		cadastroProduto = new CadastroProdutos(new RepositorioProdutoJDBC());
		cadastroEntregador = new CadastroEntregador(new RepositorioEntregadorJDBC());
		cadastroPedidos = new CadastroPedidos(new RepositorioPedido());
	}

	public void inserirCliente(Cliente cliente){
		cadastroClientes.inserir(cliente);
	}

	public void removerCliente(String cpf){
		cadastroClientes.remover(cpf);
	}

	public void atualizarCliente(Cliente cliente){
		cadastroClientes.atualizar(cliente);
	}
	public Cliente procurarCliente(String cpf){
		return cadastroClientes.procurar(cpf);
	}

	public Cliente[] buscarTodosClientes(){
		return cadastroClientes.buscarTodos();
	}

	public void inserirFormaPagamento(FormaPagamento formaPagamento){
		cadastroFormaPagamento.inserir(formaPagamento);
	}

	public void removerFormaPagamento(Serializable codigo){
		cadastroFormaPagamento.remover(codigo);
	}
	public void atualizarFormaPagamento(FormaPagamento formaPagamento){
		cadastroFormaPagamento.atualizar(formaPagamento);

	}
	public FormaPagamento procurarFormaPagamento(Integer codigo){
		return cadastroFormaPagamento.procurar(codigo);
	}

	public FormaPagamento[] buscarTodosFormaPagamentos(){
		return cadastroFormaPagamento.buscarTodos();
	}
	public void inserirProduto(Produto produto){
		cadastroProduto.inserir(produto);
	}
	public void atualizarProduto(Produto produto){
		cadastroProduto.atualizar(produto);	
	}
	public void removerProduto(Serializable codigo){
		cadastroProduto.remover(codigo);
	}
	public Produto procurarProduto (Serializable codigo){
		return cadastroProduto.procurar(codigo);
	}
	public  Produto[] buscarTodosProdutos(){
		return cadastroProduto.buscarTodos();
	}

	public void inserirEntregador(Entregador entidade){
		cadastroEntregador.inserir(entidade);
	}
	public void removerEntregador(String chave){
		cadastroEntregador.remover(chave);
	}

	public void atualizarEntregador(Entregador entidade){
		cadastroEntregador.atualizar(entidade);
	}

	public Entregador procurarEntregador(Serializable chave){
		return cadastroEntregador.procurar(chave);
	}

	public Entregador [] buscarTodosEntregadores(){
		return cadastroEntregador.buscarTodos();
	}
	
	public void inserirPedido(Pedido entidade){
		cadastroPedidos.inserir(entidade);
	}
	public void removerPedido(Serializable chave){
		cadastroPedidos.remover(chave);
	}

	public void atualizarPedido(Pedido entidade){
		cadastroPedidos.atualizar(entidade);
	}

	public Pedido procurarPedido(Serializable chave){
		return cadastroPedidos.procurar(chave);
	}

	public Pedido[] buscarTodosPedidos(){
		return cadastroPedidos.buscarTodos();
	}
}

