package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.loboalphadinamite.delivery.entidade.Produto;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;
import br.com.loboalphadinamite.delivery.util.Util;

public class RepositorioProdutosJDBC implements Repositorio<Produto> {

	@Override
	public boolean existe(Serializable chave) throws Exception{
		return procurar(chave) != null;
	}

	@Override
	public void inserir(Produto entidade) {
		String sql = "INSERT INTO \"PRODUTO\"("
				+ "\"CODIGO\", "
				+ "\"NOME\", "
				+ "\"PRECOUNITARIO\", "
				+ "\"DATA\") "
				+ "VALUES (?, ?, ?, ?);";
		
		Connection conn = Util.getConexao();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, entidade.getCodigo());
			ps.setString(2, entidade.getNome());
			ps.setDouble(3, entidade.getPecoUnitario());
			ps.setDate(4,new java.sql.Date(entidade.getData().getTime()));
			
			int i = ps.executeUpdate();
			if(i != 1){
				throw new SQLException();
			}
			
			Util.fechaConexao(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Produto entidade) throws Exception{
		String sql = "UPDATE \"PRODUTO\" SET \"NOME\"=?, \"PRECOUNITARIO\"=?, \"DATA\"=? WHERE \"CODIGO\" =?";
		
		Connection conn = Util.getConexao();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, entidade.getNome());
			ps.setDouble(2, entidade.getPecoUnitario());
			ps.setDate(3, new java.sql.Date(entidade.getData().getTime()));
			ps.setInt(4, entidade.getCodigo());
			
			int i = ps.executeUpdate();
			if(i != 1){
				throw new SQLException();
			}
			
			Util.fechaConexao(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void remover(Serializable chave) throws Exception{
		String sql = "DELETE FROM \"PRODUTO\" WHERE \"CODIGO\" = ?;";
		
		Connection conn = Util.getConexao();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (int) chave);
			int i = ps.executeUpdate();
			
			if(i != 1){
				throw new SQLException();
				
			}
			Util.fechaConexao(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Produto procurar(Serializable chave) throws Exception {
		String sql = "SELECT * FROM \"PRODUTO\" WHERE \"CODIGO\" = ?";

		Connection conn = Util.getConexao();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (int) chave);

			ResultSet result = ps.executeQuery();

			Produto retorno = null;

			if (result.next()){
				retorno = new Produto();
				
				retorno.setCodigo(result.getInt("CODIGO"));
				retorno.setNome(result.getString("NOME"));
				retorno.setPecoUnitario(result.getDouble("PRECOUNITARIO"));
				retorno.setData(result.getDate("DATA"));
				
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
	public Produto[] buscarTodos() throws Exception{
		List<Produto> listaProdutos = new ArrayList<>();

		String sql = "SELECT * FROM \"PRODUTO\"";

		Connection conn = Util.getConexao();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);

			ResultSet result = ps.executeQuery();

			Produto produtoAtual = null;
			
			while (result.next()){
				produtoAtual = new Produto();
				produtoAtual.setCodigo(result.getInt("CODIGO"));
				produtoAtual.setNome(result.getString("NOME"));
				produtoAtual.setPecoUnitario(result.getDouble("PRECOUNITARIO"));
				produtoAtual.setData(result.getDate("DATA"));

				listaProdutos.add(produtoAtual);			
			}

			Util.fechaConexao(conn);

			return listaProdutos.toArray(new Produto[listaProdutos.size()]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
