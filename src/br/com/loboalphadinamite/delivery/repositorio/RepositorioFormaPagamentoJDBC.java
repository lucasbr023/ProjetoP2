package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.loboalphadinamite.delivery.entidade.FormaPagamento;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;
import br.com.loboalphadinamite.delivery.util.Util;

public class RepositorioFormaPagamentoJDBC implements Repositorio<FormaPagamento>{
	
	

	@Override
	public boolean existe(Serializable chave) {
		return procurar(chave) != null;
	}

	@Override
	public void inserir(FormaPagamento entidade) {
		String sql = "INSERT INTO \"FORMAPAGAMENTO\"(\"NOME\", \"CODIGO\") VALUES (?, ?);";
		
		Connection conn = Util.getConexao();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, entidade.getNome());			
			ps.setInt(2, entidade.getCodigo());
			
			
			int i = ps.executeUpdate();

			if (i != 1){
				throw new SQLException();
			}

			Util.fechaConexao(conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void atualizar(FormaPagamento entidade) {

		String sql = "UPDATE \"FORMAPAGAMENTO\"   SET \"NOME\"=?  WHERE \"CODIGO\"=?;";
		
		Connection conn = Util.getConexao();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, entidade.getNome());
			ps.setInt(2, entidade.getCodigo());
			
			int i = ps.executeUpdate();
			if(i != 1){
				throw new SQLException();
			}
			Util.fechaConexao(conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(Serializable chave) {
		String sql = "DELETE FROM \"FORMAPAGAMENTO\" WHERE \"CODIGO\" = ?;";
		
		Connection conn = Util.getConexao();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (int) chave);
			
			int i = ps.executeUpdate();
			if(i != 1){
				throw new SQLException();
			}
			
			Util.fechaConexao(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
	}

	@Override
	public FormaPagamento procurar(Serializable chave) {
		
		String sql = "SELECT * FROM \"FORMAPAGAMENTO\" where \"CODIGO\" = ?;";
		
		Connection conn = Util.getConexao();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (int) chave);
			
			ResultSet result = ps.executeQuery();

			FormaPagamento retorno = null;
			if(result.next()){
				retorno = new FormaPagamento();
				retorno.setCodigo(result.getInt("CODIGO"));
				retorno.setNome(result.getString("NOME"));
				
				return retorno;
				
			}
			
			Util.fechaConexao(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public FormaPagamento[] buscarTodos() {
		List<FormaPagamento> listaFormaPagamento = new ArrayList<>();
		String sql = "SELECT * FROM \"FORMAPAGAMENTO\";";
		
		Connection conn = Util.getConexao();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			FormaPagamento fp = null;
			while(result.next()){
				fp = new FormaPagamento();
				fp.setCodigo(result.getInt("CODIGO"));
				fp.setNome(result.getString("NOME"));
				listaFormaPagamento.add(fp);
				
				for (int i = 0; i < listaFormaPagamento.size(); i++) {
					FormaPagamento formap = listaFormaPagamento.get(i);
					System.out.println(formap.getNome());
				}
				
			}
			
			Util.fechaConexao(conn);
			return listaFormaPagamento.toArray(new FormaPagamento[listaFormaPagamento.size()]);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
