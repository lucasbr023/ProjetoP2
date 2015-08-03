package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.entidade.Entregador;
import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.entidade.Pedido;
import br.com.loboalphadinamite.delivery.entidade.Produto;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioClienteHibernate;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioEntregadorHibernate;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioFormaPagamentoHibernate;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioPedidoHibernate;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioProdutosHibernate;

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
		cadastroClientes = new CadastroClientes(new RepositorioClienteHibernate());
		cadastroFormaPagamento = new CadastroFormaPagamento(new RepositorioFormaPagamentoHibernate());
		cadastroProduto = new CadastroProdutos(new RepositorioProdutosHibernate());
		cadastroEntregador = new CadastroEntregador(new RepositorioEntregadorHibernate());
		cadastroPedidos = new CadastroPedidos(new RepositorioPedidoHibernate());
	}
	//------------------------------------------------------------------------------
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
	public Collection<Cliente> filtrarClientes(Cliente cliente) {
		return cadastroClientes.filtrar(cliente);
	}
	public Collection<Cliente> findCollectionClienteByHQL(String hql, Map<String, Object> parameters) {
		return cadastroClientes.findCollectionByHQL(hql, parameters);
	}
	public Cliente findUniqueClienteByHQL(String hql, Map<String, Object> parameters) {
		return cadastroClientes.findUniqueByHQL(hql, parameters);
	}

	//------------------------------------------------------------------------------
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
	public Collection<FormaPagamento> filtrarFormaPagamento(FormaPagamento formaPagamento) {
		return cadastroFormaPagamento.filtrar(formaPagamento);
	}
	public Collection<FormaPagamento> findCollectionFormaPagamentoByHQL(String hql, Map<String, Object> parameters) {
		return cadastroFormaPagamento.findCollectionByHQL(hql, parameters);
	}
	public FormaPagamento findUniqueFormaPagamentoByHQL(String hql, Map<String, Object> parameters) {
		return cadastroFormaPagamento.findUniqueByHQL(hql, parameters);
	}
	//------------------------------------------------------------------------------
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
	public Collection<Produto> filtrarProdutos(Produto produto) {
		return cadastroProduto.filtrar(produto);
	}
	public Collection<Produto> findCollectionProdutoByHQL(String hql, Map<String, Object> parameters) {
		return cadastroProduto.findCollectionByHQL(hql, parameters);
	}
	public Produto findUniqueProdutoByHQL(String hql, Map<String, Object> parameters) {
		return cadastroProduto.findUniqueByHQL(hql, parameters);
	}
	//------------------------------------------------------------------------------
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
	public Collection<Entregador> filtrarEntregadores(Entregador entregador) {
		return cadastroEntregador.filtrar(entregador);
	}
	public Collection<Entregador> findCollectionEntregadoresByHQL(String hql, Map<String, Object> parameters) {
		return cadastroEntregador.findCollectionByHQL(hql, parameters);
	}
	public Entregador findUniqueEntregadorByHQL(String hql, Map<String, Object> parameters) {
		return cadastroEntregador.findUniqueByHQL(hql, parameters);
	}
	//------------------------------------------------------------------------------
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
	public Collection<Pedido> filtrarPedido(Pedido pedido) {
		return cadastroPedidos.filtrar(pedido);
	}
	public Collection<Pedido> findCollectionPedidoByHQL(String hql, Map<String, Object> parameters) {
		return cadastroPedidos.findCollectionByHQL(hql, parameters);
	}
	public Pedido findUniquePedidoByHQL(String hql, Map<String, Object> parameters) {
		return cadastroPedidos.findUniqueByHQL(hql, parameters);
	}
}

