package br.com.loboalphadinamite.delivery.entidade;

import java.util.Date;

public class Pedido {
	
	private Integer codigo;
	private Date dataPedido;
	private Cliente cliente;
	private Entregador entregador;
	private FormaPagamento formaPagamento;
	//private StatusPedido statusPedido;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Entregador getEntregador() {
		return entregador;
	}
	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", dataPedido=" + dataPedido
				+ ", cliente=" + cliente + ", entregador=" + entregador
				+ ", formaPagamento=" + formaPagamento + "]";
	}

	
	
}
