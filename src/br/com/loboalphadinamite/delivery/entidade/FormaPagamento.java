package br.com.loboalphadinamite.delivery.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.loboalphadinamite.delivery.interfaces.EntidadeBasica;

@Entity
@Table(name = "formaPagamento")
public class FormaPagamento implements Serializable, EntidadeBasica{
	@Id
	@Column
	private Integer codigo;
	@Column
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
	@Override
	public boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	}


