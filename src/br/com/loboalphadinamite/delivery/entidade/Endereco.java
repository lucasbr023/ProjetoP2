package br.com.loboalphadinamite.delivery.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable, EntidadeBasica {
	
	private static final long serialVersionUID = 857463443516615038L;
	
	@Id
	@Column(name="cpf_cliente")
	private String cpfCliente;
	@Column(name="logradouro")
	private String logradouro;
	@Column(name="numero")
	private String numero;
	@Column(name="bairro")
	private String bairro;
	@Column(name="cidade")
	private String cidade;
	@Column(name="estado")
	private String estado;
	@Column(name="cep")
	private String cep;
	@Column(name="complemento")
	private String complemento;
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado="
				+ estado + ", cep=" + cep + ", complemento=" + complemento
				+ "]";
	}
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return cpfCliente;
	}
	@Override
	public boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
