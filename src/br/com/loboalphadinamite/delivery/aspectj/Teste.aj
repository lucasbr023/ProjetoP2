package br.com.loboalphadinamite.delivery.aspectj;

import br.com.loboalphadinamite.delivery.entidade.Cliente;

public aspect Teste {

	pointcut inserir(): execution(public void br.com.loboalphadinamite.delivery.negocios.Fachada.inserir*(..));
	
	
	pointcut procurar(): execution(public * br.com.loboalphadinamite.delivery.negocios.Fachada.procurar*(..));
	
	
	pointcut buscarTodos():  execution(public * br.com.loboalphadinamite.delivery.negocios.Fachada.buscar*(..));
	
	
	
	
	after(): inserir(){
		System.out.println("Cadastro Realizado com sucesso!");
		
	}
	
	before(): procurar(){
		System.out.print("O item procurado foi: ");
	}
}
