package br.com.loboalphadinamite.delivery.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.loboalphadinamite.delivery.interfaces.EntidadeBasica;

@Entity
@Table(name="produto")
public class Produto implements Serializable, EntidadeBasica{
	@Id
	@Column
	private Integer codigo;
	@Column
	private String nome;
	@Column
	private double pecoUnitario;
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public Produto(){
		
	}
	
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
	public double getPecoUnitario() {
		return pecoUnitario;
	}
	public void setPecoUnitario(double pecoUnitario) {
		this.pecoUnitario = pecoUnitario;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome
				+ ", pecoUnitario=" + pecoUnitario + ", data=" + data + "]";
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return false;
	} 
}