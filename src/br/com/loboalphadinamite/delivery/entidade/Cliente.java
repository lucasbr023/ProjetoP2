package br.com.loboalphadinamite.delivery.entidade;

public class Cliente extends Pessoa{

	
	private Endereco endereco;
	private String celular;
	private String telefone;
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
	
	@Override
	public String toString() {
		return "Cliente [endereco=" + endereco + ", celular=" + celular
				+ ", telefone=" + telefone + ", email=" + email + "]";
	}
	
	
}
