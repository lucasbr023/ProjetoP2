package br.com.loboalphadinamite.delivery.entidade;

import java.util.Date;

public class Produto {
	private Integer codigo;
	private String nome;
	private double pecoUnitario;
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
	
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome
				+ ", pecoUnitario=" + pecoUnitario + ", data=" + data + "]";
	} 
}