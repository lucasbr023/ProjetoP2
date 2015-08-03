package br.com.loboalphadinamite.delivery.interfaces;

import java.io.Serializable;

public interface EntidadeBasica {

	public abstract Serializable getId();
	
	public abstract boolean validar() throws Exception;
}
