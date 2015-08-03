package br.com.loboalphadinamite.delivery.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.loboalphadinamite.delivery.interfaces.EntidadeBasica;

public class Util {

	private Util(){
		super();
	}

	public static final Connection getConexao() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste", "postgres" , "lucas");
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

	public static final boolean isNullOrEmpty(String string){
		return Objects.isNull(string) || string.isEmpty();
	}

	public static final boolean hasLenght(String string, int lenght){
		return !Objects.isNull(string) && string.length() == lenght;
	}

	public static final boolean onlyNumbers(String value) {
		return value.matches("[0-9]+");
	}

	public static final void toUpperCaseAllStrings(Object object) throws IllegalArgumentException, IllegalAccessException {
		if (Objects.isNull(object)) {
			throw new IllegalArgumentException("Não pode ser passado um objeto nulo !");
		}
		Class clazz = object.getClass();
		List<Field> fields = new ArrayList<>();
		while(clazz != null) {
			fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		for (Field f : fields) {
			f.setAccessible(true);
			if (f.getType().equals(String.class)){
				try {
					f.set(object, String.valueOf(f.get(object)).trim().toUpperCase());
				} catch (IllegalArgumentException ex) {
					Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else if (f.getClass().isAssignableFrom(EntidadeBasica.class)) {
				toUpperCaseAllStrings(f.get(object));
			}
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
