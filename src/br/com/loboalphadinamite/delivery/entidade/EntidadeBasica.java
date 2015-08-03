package br.com.loboalphadinamite.delivery.entidade;

import java.io.Serializable;

public interface EntidadeBasica {
	
	public Serializable getId();
	public abstract boolean validar() throws Exception;

}
