package br.com.loboalphadinamite.delivery.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.loboalphadinamite.delivery.excecao.CampoNumericoPreenchidoComLetras;
import br.com.loboalphadinamite.delivery.excecao.CampoObrigatorioNaoInformado;
import br.com.loboalphadinamite.delivery.excecao.CampoPreenchidoIncorreto;
import br.com.loboalphadinamite.delivery.util.Util;


@Entity
@Table(name="cliente")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.INTEGER, name="tipo_pessoa")
public class Pessoa implements Serializable, EntidadeBasica {
	
	@Column(name="nome")
	private String nome;
	@Id
	@Column(name="cpf")
	private String cpf;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	public Pessoa() {
		super();
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	public String toString() {
		return super.toString() + "Pessoa [nome=" + nome + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + "]";
	}


	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return cpf;
	}


	@Override
	public boolean validar() throws Exception {
		if (Util.isNullOrEmpty(nome)) {
			throw new CampoObrigatorioNaoInformado("Nome não preenchido !");
		}
		if (Util.isNullOrEmpty(cpf)) {
			throw new CampoObrigatorioNaoInformado("CPF não preenchido !");
		}
		if (!Util.onlyNumbers(cpf)){
			throw new CampoNumericoPreenchidoComLetras("CPF só deve conter números !");
		}
		if (Util.hasLenght(cpf, 11)) {
			throw new CampoPreenchidoIncorreto("CPF deve conter 11 dígitos !");
		}
		return true;
	}
	
	
	
	

}
