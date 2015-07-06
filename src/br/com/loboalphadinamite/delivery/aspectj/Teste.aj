package br.com.loboalphadinamite.delivery.aspectj;

public aspect Teste {

	pointcut inserir(): execution(public void br.com.loboalphadinamite.delivery.negocios.Fachada.inserir*(..));

	pointcut procurar(): execution(public * br.com.loboalphadinamite.delivery.negocios.Fachada.procurar*(..));

	pointcut buscarTodos():  execution(public * br.com.loboalphadinamite.delivery.negocios.Fachada.buscar*(..));

	pointcut remover(): execution(public * br.com.loboalphadinamite.delivery.negocios.Fachada.remover*(..));

	pointcut atualizar(): execution(public * br.com.loboalphadinamite.delivery.negocios.Fachada.atualizar*(..));




	after(): inserir(){
		System.out.println("Cadastro Realizado com sucesso!");
	}
	before(): procurar(){
		System.out.print("O item procurado foi: ");
	}
	after() returning(Object r) :procurar(){
		System.out.println(r.toString());
	}
	after(): atualizar(){
		System.out.println("Item atualizado com sucesso!");
	}
	before(): buscarTodos(){
		System.out.println("Todos os itens: ");
	}
	after(): remover(){
		System.out.println("Item removido com sucesso!");
	}


}
