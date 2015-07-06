package br.com.loboalphadinamite.delivery.entidade;

public class Entregador extends Pessoa{

	private String matricula;
	private String placaMoto;
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
	
	public String toString() {
		return super.toString()+ "Entregador [matricula=" + matricula + ", placaMoto=" + placaMoto + ", modeloMoto=" + modeloMoto + "]";
	}
	
	
	
}
