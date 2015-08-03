package br.com.loboalphadinamite.delivery.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.loboalphadinamite.delivery.excecao.CampoNumericoPreenchidoComLetras;
import br.com.loboalphadinamite.delivery.excecao.CampoObrigatorioNaoInformado;
import br.com.loboalphadinamite.delivery.interfaces.EntidadeBasica;
import br.com.loboalphadinamite.delivery.util.Util;

@Entity
@DiscriminatorValue("2")
public class Entregador extends Pessoa implements Serializable, EntidadeBasica{

	
	@Column(name = "matricula")
	private String matricula;
	@Column
	private String placaMoto;
	@Column
	private String modeloMoto;
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getPlacaMoto() {
		return placaMoto;
	}
	public void setPlacaMoto(String placaMoto) {
		this.placaMoto = placaMoto;
	}
	public String getModeloMoto() {
		return modeloMoto;
	}
	public void setModeloMoto(String modeloMoto) {
		this.modeloMoto = modeloMoto;
	}
	
	@Override
	public Serializable getId() {
		return matricula;
	}
	
	@Override
	public boolean validar() throws Exception {
		
		if (Util.isNullOrEmpty(matricula)) {
			throw new CampoObrigatorioNaoInformado("Favor informar matrícula do entregador !");
		}
		if (!Util.onlyNumbers(matricula)){
			throw new CampoNumericoPreenchidoComLetras("Matricula do entregador não pode conter letras !");
		}
		if (Util.isNullOrEmpty(modeloMoto)){
			throw new CampoObrigatorioNaoInformado("Favor informar modelo da moto do entregador !");
		}
		return true;
	}
	
	public String toString() {
		return super.toString()+ "Entregador [matricula=" + matricula + ", placaMoto=" + placaMoto + ", modeloMoto=" + modeloMoto + "]";
	}
	
	
	
}
