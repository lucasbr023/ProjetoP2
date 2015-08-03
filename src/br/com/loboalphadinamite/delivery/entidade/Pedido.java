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
ax.persistence.TemporalType;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable,EntidadeBasica{
	
	@Id
	@Column
	private Integer codigo;
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	@Column
	private Cliente cliente;
	@Column
	private Entregador entregador;
	@Column
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
	
	public String toString() {
		return "Pedido [codigo=" + codigo + ", dataPedido=" + dataPedido
				+ ", cliente=" + cliente + ", entregador=" + entregador
				+ ", formaPagamento=" + formaPagamento + "]";
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
