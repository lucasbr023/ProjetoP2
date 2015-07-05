package br.com.loboalphadinamite.delivery.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

	private Util(){
		super();
	}

	public static final Connection getConexao() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoP2", "postgres" , "natalia");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static final void fechaConexao(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
//	public static void main(String[] args) {
//		try {
//			Class.forName("org.postgresql.Driver");
//			
//			try {
//				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoP2", "postgres" , "lucas");
//				System.out.println("Funfou");
//				
//				conn.close();
//				
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}


}
