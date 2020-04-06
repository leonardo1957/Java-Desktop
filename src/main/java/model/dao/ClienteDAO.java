package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Cliente;
import model.entity.Telefone;

public class ClienteDAO implements BaseDAO<Cliente> {

	public Cliente salvar(Cliente novaEntidade) {
		Connection conn = Banco.getConnection();
		String sql = " INSERT INTO CLIENTE (nome,sobrenome,cpf, idEndereco) VALUES (?,?,?,?); ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			stmt.setString(1, novaEntidade.getNome());
			stmt.setString(2, novaEntidade.getSobrenome());
			stmt.setString(3, novaEntidade.getCpf());
			stmt.setInt(4, novaEntidade.getEndereco().getId());
			stmt.execute();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				novaEntidade.setId(idGerado);
			}

		} catch (SQLException e) {
			System.out.println(" Erro ao salvar cliente. Erro: " + e.getMessage());
		}
		return novaEntidade;
	}

	public boolean alterar(Cliente novaEntidade) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletar(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM CLIENTE WHERE ID=" + id;
		Statement stmt = Banco.getStatement(conn);

		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir telefone.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public ArrayList<Cliente> consultarTodos() {
		Connection conn = Banco.getConnection();
		String sql = " SELECT * " + " FROM CLIENTE ";

		Statement stmt = Banco.getStatement(conn);
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);

			while (resultadoDaConsulta.next()) {
				Cliente cliente = construirResultSet(resultadoDaConsulta);
				clientes.add(cliente);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar telefones");
			System.out.println("Erro: " + e.getMessage());
		}

		return clientes;
	}

	public Cliente consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM CLIENTE WHERE ID=?; ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		Cliente cliente = null;

		try {
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				cliente = construirResultSet(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente no id=" + id + " Causa " + e.getMessage());
		}

		return cliente;

	}

	public Cliente construirResultSet(ResultSet resultado) {
		Cliente cliente = new Cliente();
		EnderecoDAO endDao = new EnderecoDAO();
		try {
			cliente.setId(resultado.getInt("id"));
			cliente.setNome(resultado.getString("nome"));
			cliente.setSobrenome(resultado.getString("sobrenome"));
			cliente.setCpf(resultado.getString("cpf"));
//			if (cliente.getEndereco()!= null) {
//				cliente.setId(resultado.getInt("id"));
//				endDao.consultarPorId(cliente.getEndereco(resultado.getInt("id"));
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}

	public Cliente verificaCPF(Cliente cliente2) {
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM CLIENTE WHERE CPF=?; ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		Cliente cliente = null;

		try {
			stmt.setString(1, cliente2.getCpf());
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				cliente = construirResultSet(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente por cpf Causa " + e.getMessage());
		}

		return cliente;
	}

}
