package br.com.loboalphadinamite.delivery.excecao;

public class RegistroNaoCadastradoException extends Exception {

	private static final long serialVersionUID = -8199827468366715503L;

	public RegistroNaoCadastradoException(String mensagem){
		super(mensagem);
	}
	
	public RegistroNaoCadastradoException() {
		this("Registro não encontrado !");
	}
	
}
