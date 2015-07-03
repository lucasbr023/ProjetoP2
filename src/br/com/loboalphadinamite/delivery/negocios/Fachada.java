package br.com.loboalphadinamite.delivery.negocios;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.repositorio.RepositorioCliente;

public class Fachada {
	
	
	public static Fachada instancia;
	private CadastroClientes cadastroClientes;
	
	
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

}
