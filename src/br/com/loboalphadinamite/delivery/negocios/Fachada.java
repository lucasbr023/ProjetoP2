package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.entidade.Produto;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioCliente;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioFormaPagamento;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioProdutos;

public class Fachada {
	
	
	public static Fachada instancia;
	private CadastroClientes cadastroClientes;
	private CadastroFormaPagamento cadastroFormaPagamento;
	private CadastroProdutos cadastroProduto;
	
	
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
		cadastroClientes = new CadastroClientes(new RepositorioCliente());
		cadastroFormaPagamento = new CadastroFormaPagamento(new RepositorioFormaPagamento());
		cadastroProduto = new CadastroProdutos(new RepositorioProdutos());
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
	public Produto procurarProduto (Integer codigo){
		return cadastroProduto.procurar(codigo);
	}
	public  Produto[] buscarTodosProdutos(){
		return cadastroProduto.buscarTodos();
	}
}

