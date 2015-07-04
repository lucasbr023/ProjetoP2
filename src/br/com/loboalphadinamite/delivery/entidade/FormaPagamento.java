package br.com.loboalphadinamite.delivery.entidade;

import java.io.Serializable;

public class FormaPagamento {
	
	private Integer codigo;
	private String nome;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Serializable getId(){
		return getCodigo();
	}
	
	
	public String toString() {
		return "FormaPagamento [codigo=" + codigo + ", nome=" + nome + "]";
	}
	}


