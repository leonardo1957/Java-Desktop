package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import model.entity.Cliente;
import model.entity.Endereco;

public class EnderecoDAO implements BaseDAO<Endereco> {

	public Endereco salvar(Endereco novaEntidade) {
		Connection conn = Banco.getConnection();
		String sql = " INSERT INTO ENDERECO (CEP, ESTADO, CIDADE, RUA, BAIRRO, NUMERO) VALUES (?,?,?,?,?,?); ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);

		try {
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			System.out.println(" Erro ao salvar endereço. Erro: " + e.getMessage());
		}
		return novaEntidade;
	}

	public boolean alterar(Endereco novaEntidade) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Endereco> consultarTodos() {
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM ENDERECO ";

		Statement stmt = Banco.getStatement(conn);
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);

			while (resultadoDaConsulta.next()) {
				Endereco endereco = construirResultSet(resultadoDaConsulta);
				enderecos.add(endereco);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar telefones");
			System.out.println("Erro: " + e.getMessage());
		}

		return enderecos;
	}

	public Endereco consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM ENDERECO WHERE ID=?; ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		Endereco enderecoConsultado = null;
		try {
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				enderecoConsultado = construirResultSet(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar endereço. id:" + id + "Causa:" + e.getMessage());
		}
		return enderecoConsultado;
	}

	public Endereco construirResultSet(ResultSet resultado) {
		Endereco endereco = new Endereco();
		try {
			endereco.setId(resultado.getInt("id"));
			endereco.setCep(resultado.getInt("cep"));
			endereco.setBairro(resultado.getString("bairro"));
			endereco.setCidade(resultado.getString("cidade"));
			endereco.setEstado(resultado.getString("estado"));
			endereco.setRua(resultado.getString("rua"));
		} catch (SQLException e) {
			System.out.println("Erro ao consultar endereços. Causa:" + e.getMessage());
		}
		return endereco;
	}

}
