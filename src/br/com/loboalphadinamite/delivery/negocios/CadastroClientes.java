package br.com.loboalphadinamite.delivery.negocios;

import java.io.Serializable;

import br.com.loboalphadinamite.delivery.entidade.Cliente;
import br.com.loboalphadinamite.delivery.excecao.CampoNumericoPreenchidoComLetras;
import br.com.loboalphadinamite.delivery.excecao.CampoObrigatorioNaoInformado;
import br.com.loboalphadinamite.delivery.excecao.CampoPreenchidoIncorreto;
import br.com.loboalphadinamite.delivery.interfaces.Cadastro;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;

public class CadastroClientes implements Cadastro<Cliente>{
	
	Repositorio<Cliente> repositorio;
	
	public CadastroClientes(Repositorio<Cliente> repositorio) {
		this.repositorio = repositorio;
	}

	
	public boolean existe(Serializable chave) throws Exception {
		return repositorio.existe(chave);
	}

	
	public void inserir(Cliente entidade) throws Exception {
		if(validar(entidade)){
			repositorio.inserir(entidade);
		}
	}

	
	public void atualizar(Cliente entidade) throws Exception {
		if(validar(entidade)){
			repositorio.atualizar(entidade);
		}
	}

	public void remover(Serializable chave) throws Exception {
		repositorio.remover(chave);
	}

	
	public Cliente procurar(Serializable chave) throws Exception{
		return repositorio.procurar(chave);
	}

	public Cliente[] buscarTodos() throws Exception{
		return repositorio.buscarTodos();
	}
	
	
	public static final boolean validar(Cliente cliente) throws Exception{
		
		if (cliente.getNome() == null || cliente.getNome().isEmpty()){
			throw new CampoObrigatorioNaoInformado("Nome não informado!");
		}
		if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
			throw new CampoObrigatorioNaoInformado("CPF não informado");
		}
		if (cliente.getCpf().length() != 11) {
			throw new CampoPreenchidoIncorreto("O CPF deve conter apenas 11 digitos!");
		}
//		if (cliente.getCpf().matches("\\d+")) {
//			throw new CampoNumericoPreenchidoComLetras("CPF deve conter apenas numeros!") ;
//		}
		if (cliente.getCelular() == null || cliente.getCelular().isEmpty()) {
			throw new CampoObrigatorioNaoInformado("Celular não informado!");
		}
		if (cliente.getCelular().matches("^[d]+")) {
			throw new CampoNumericoPreenchidoComLetras("Celular deve conter apenas numeros!");
		}
		if (cliente.getCelular().length() < 8 || cliente.getCelular().length() > 12) {
			throw new CampoPreenchidoIncorreto("Celular deve conter de 8 a 12 digitos");
		}
		if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
			throw new CampoObrigatorioNaoInformado("Telefone não informado");
		}
		if (cliente.getTelefone().matches("^[d]+")) {
			throw new CampoNumericoPreenchidoComLetras("Telefone deve conter apenas numeros!");
		}
		if (cliente.getTelefone().length() < 8 || cliente.getTelefone().length() > 12) {
			throw new CampoPreenchidoIncorreto("Telefone deve conter de 8 a 12 digitos");
		}
		if (cliente.getDataNascimento() == null) {
			throw new CampoObrigatorioNaoInformado("Data de Nascimento não informada");
		}
		if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
			throw new CampoObrigatorioNaoInformado("Email não informado");
		}
		if (!cliente.getEmail().contains("@") || !cliente.getEmail().contains(".")) {
			throw new CampoPreenchidoIncorreto("Email deve conter os caracteres @ e .");
		}
		if (cliente.getEmail().matches("[A-Z]+")) {
			throw new CampoPreenchidoIncorreto("Email deve conter apenas letras minusculas");
		}
		
		return true;
	}
	
	

}
