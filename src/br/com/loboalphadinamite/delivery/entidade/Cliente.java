package br.com.loboalphadinamite.delivery.entidade;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.loboalphadinamite.delivery.excecao.CampoNumericoPreenchidoComLetras;
import br.com.loboalphadinamite.delivery.excecao.CampoObrigatorioNaoInformado;
import br.com.loboalphadinamite.delivery.excecao.CampoPreenchidoIncorreto;
import br.com.loboalphadinamite.delivery.interfaces.EntidadeBasica;
import br.com.loboalphadinamite.delivery.util.Util;







@Entity
@DiscriminatorValue("1")
public class Cliente extends Pessoa implements Serializable,EntidadeBasica{


	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Endereco endereco;
	@Column
	private String celular;
	@Column
	private String telefone;
	@Column
	private String email;


	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String toString() {
		return super.toString()+ "Cliente [endereco=" + endereco + ", celular=" + celular
				+ ", telefone=" + telefone + ", email=" + email + "]";
	}
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean validar() throws Exception {
		super.validar();

		if (Util.isNullOrEmpty(telefone)){
			throw new CampoObrigatorioNaoInformado("Favor informar o telefone !");
		}
		if (!Util.onlyNumbers(telefone)) {
			throw new CampoPreenchidoIncorreto("Telefone só deve conter números !");
		}
		if (Util.isNullOrEmpty(celular)){
			throw new CampoObrigatorioNaoInformado("Favor informar o celular !");
		}
		if (!Util.onlyNumbers(celular)){
			throw new CampoNumericoPreenchidoComLetras("Celular só deve conter números !");
		}
		if (Util.isNullOrEmpty(email)){
			throw new CampoObrigatorioNaoInformado("Favor preencher o email !");
		}
		if (Objects.isNull(endereco)) {
			throw new CampoObrigatorioNaoInformado("Favor preencher o endereço !");
		}
		if (!endereco.validar()) {
			throw new CampoPreenchidoIncorreto("Favor verificar os dados do endereço !");
		}
		return true;
	}


}
