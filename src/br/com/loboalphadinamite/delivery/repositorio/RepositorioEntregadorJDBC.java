package br.com.loboalphadinamite.delivery.repositorio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.loboalphadinamite.delivery.entidade.Entregador;
import br.com.loboalphadinamite.delivery.interfaces.Repositorio;
import br.com.loboalphadinamite.delivery.util.Util;

public class RepositorioEntregadorJDBC implements Repositorio<Entregador>{

	@Override
	public boolean existe(Serializable chave) {
		return procurar(chave) != null;
	}

	@Override
	public void inserir(Entregador entidade) {
		String sql = "INSERT INTO \"ENTREGADOR\"("
				+ "\"NOME\", "
				+ "\"CPF\", "
				+ "\"DATANASCIMENTO\", "
				+ "\"MATRICULA\", "
				+ "\"PLACAMOTO\", "
				+ "\"MODELOMOTO\") "
				+ "VALUES (?, ?, ?, ?, ?, ?);";

		Connection conn = Util.getConexao();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, entidade.getNome());
			ps.setString(2, entidade.getCpf());
			ps.setDate(3, new java.sql.Date(entidade.getDataNascimento().getTime()));
			ps.setString(4, entidade.getMatricula());
			ps.setString(5, entidade.getPlacaMoto());
			ps.setString(6, entidade.getModeloMoto());

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
	public void atualizar(Entregador entidade) {
		String sql = "UPDATE \"ENTREGADOR\" SET "
				+ "\"NOME\"=?, "
				+ "\"CPF\"=?, "
				+ "\"DATANASCIMENTO\"=?, "
				+ "\"PLACAMOTO\"=?, "
				+ "\"MODELOMOTO\"=? "
				+ "WHERE \"MATRICULA\"=? ;";

		Connection conn = Util.getConexao();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, entidade.getNome());
			ps.setString(2, entidade.getCpf());
			ps.setDate(3, new java.sql.Date(entidade.getDataNascimento().getTime()));
			ps.setString(4, entidade.getPlacaMoto());
			ps.setString(5, entidade.getModeloMoto());
			ps.setString(6, entidade.getMatricula());

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
		String sql = "DELETE FROM \"ENTREGADOR\" WHERE \"MATRICULA\" = ?;";
		Connection conn = Util.getConexao();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, (String) chave);

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
	public Entregador procurar(Serializable chave) {
		String sql = "SELECT *  FROM \"ENTREGADOR\" WHERE \"MATRICULA\" = ?;";

		Connection conn = Util.getConexao();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, (String) chave);

			ResultSet result = ps.executeQuery();
			Entregador retorno = null;
			if(result.next()){
				retorno = new Entregador();
				retorno.setNome(result.getString("NOME"));
				retorno.setCpf(result.getString("CPF"));
				retorno.setDataNascimento(result.getDate("DATANASCIMENTO"));
				retorno.setMatricula(result.getString("MATRICULA"));
				retorno.setPlacaMoto(result.getString("PLACAMOTO"));
				retorno.setModeloMoto(result.getString("MODELOMOTO"));
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
	public Entregador[] buscarTodos() {
		String sql = "SELECT * FROM \"ENTREGADOR\"";
		List<Entregador> listaEntregadores = new ArrayList<>();

		Connection conn = Util.getConexao();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();

			Entregador entregadorAtual = null;

			while(result.next()){
				entregadorAtual = new Entregador();	
				entregadorAtual.setNome(result.getString("NOME"));
				entregadorAtual.setCpf(result.getString("CPF"));
				entregadorAtual.setDataNascimento(result.getDate("DATANASCIMENTO"));
				entregadorAtual.setMatricula(result.getString("MATRICULA"));
				entregadorAtual.setPlacaMoto(result.getString("PLACAMOTO"));
				entregadorAtual.setModeloMoto(result.getString("MODELOMOTO"));
				listaEntregadores.add(entregadorAtual);

			}
			Util.fechaConexao(conn);

			return listaEntregadores.toArray(new Entregador[listaEntregadores.size()]);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return null;
	}

}
