package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe criada na disciplina de POO (2019/1).
 * 
 * Representa um banco de dados que se conecta Ã  aplicaÃ§Ã£o
 * 
 * Encapsula mÃ©todos da API JDBC, com a definiÃ§Ã£o, criaÃ§Ã£o e fechamento de
 * conexÃµes Ã  bancos de dados relacionais
 * 
 * @author Adriano de Melo
 * 
 *         Vilmar CÃ©sar Pereira JÃºnior (continuaÃ§Ã£o em Desenvolvimento Desktop
 *         2018/2) -- ALTERADO remotamente (no github)
 * 
 *         DiferenÃ§as entre Statement e PreparedStatement:
 * 
 *         A maioria dos bancos de dados relacionais lida com uma consulta
 *         (query) JDBC / SQL em quatro passos:
 *
 *         1- Interpretar (parse) a consulta SQL;
 * 
 *         2- Compilar a consulta SQL;
 * 
 *         3- Planejar e otimizar o caminho de busca dos dados;
 * 
 *         4- Executar a consulta otimizada, buscando e retornando os dados.
 * 
 *         Um Statement irÃ¡ sempre passar pelos quatro passos acima para cada
 *         consulta SQL enviada para o banco. JÃ¡ um Prepared Statement
 *         prÃ©-executa os passos (1) a (3).
 * 
 *         EntÃ£o, ao criar um Prepared Statement alguma prÃ©-otimizaÃ§Ã£o Ã© feita
 *         de imediato. O efeito disso Ã© que, se vocÃª pretende executar a mesma
 *         consulta repetidas vezes mudando apenas os parÃ¢metros de cada uma, a
 *         execuÃ§Ã£o usando Prepared Statements serÃ¡ mais rÃ¡pida e com menos
 *         carga sobre o banco.
 * 
 *         Outra vantagem dos Prepared Statements Ã© que, se utilizados
 *         corretamente, ajudam a evitar <b>ataques de InjeÃ§Ã£o de SQL</b>.
 * 
 *         Note que para isso Ã© preciso que os parÃ¢metros da consulta sejam
 *         atribuÃ­dos atravÃ©s dos mÃ©todos setInt(), setString(), etc. presentes
 *         na interface PreparedStatement e nÃ£o por concatenaÃ§Ã£o de strings.
 * 
 *         Para uma consulta que vai ser executada poucas vezes e nÃ£o requer
 *         nenhum parÃ¢metro, Statement basta. Para os demais casos, prefira
 *         PreparedStatement.
 * 
 *         FONTE:
 *         {@link https://pt.stackoverflow.com/questions/99620/qual-a-diferen%C3%A7a-entre-o-statement-e-o-preparedstatement}
 *         ======= Classe responsÃ¡vel pela conexÃ£o JDBC com o banco de dados
 *         escolhido.
 * 
 * @author Adriano de Melo
 *
 */
public class Banco {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String BANCODADOS = "exemplos";
	private static final String CONEXAO = "jdbc:mysql://localhost:3306/" + BANCODADOS
			+ "?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static final int CODIGO_RETORNO_ERRO_EXCLUSAO = 0;
	public static final int CODIGO_RETORNO_SUCESSO_EXCLUSAO = 1;

	/**
	 * Estabelece a conexÃ£o JBDC considerando as configuraÃ§Ãµes da classe Banco.
	 * 
	 * @return Connection um objeto de conexÃ£o JDBC.
	 * 
	 * @throws ClassNotFoundException caso o nome completo de DRIVER_MYSQL esteja
	 *                                incorreto ou o driver JDBC do banco
	 *                                selecionado nÃ£o foi adicionado ao projeto (via
	 *                                .jar ou dependÃªncia no pom.xml).
	 * 
	 * @throws SQLException           caso a URL_CONEXAO, USUARIO e/ou SENHA estejam
	 *                                incorretos.
	 */
	public static Connection getConnection() {
		try {
			Connection conn = null;
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(CONEXAO, USER, PASSWORD);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe do Driver nÃ£o foi encontrada. Causa: " + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println("Erro ao obter a Connection. Causa: " + e.getMessage());
			return null;
		}
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento da conexÃ£o. Causa: " + e.getMessage());
		}
	}

	/**
	 * 
	 * Solicita um objeto Statement para uma conexÃ£o. Este objeto serve para
	 * executar as operaÃ§Ãµes SQL.
	 * 
	 * Este mÃ©todo deve ser sempre chamado nos DAOs apÃ³s a criaÃ§Ã£o da expressÃ£o SQL,
	 * geralmente com os mÃ©todos execute(sql), executeUpdate(sql) ou
	 * executeQuery(sql), onde "sql" Ã© do tipo String.
	 * 
	 * @param conn uma conexÃ£o anteriormente criada.
	 * @return stmt um objeto do tipo Statement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static Statement getStatement(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			return stmt;
		} catch (SQLException e) {
			System.out.println("Erro ao obter o Statement. Causa: " + e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * Fecha um objeto Statement anteriormente criado.
	 * 
	 * Este mÃ©todo deve ser sempre chamado nos DAOs apÃ³s a execuÃ§Ã£o da expressÃ£o
	 * SQL.
	 * 
	 * @param stmt um objeto do tipo Statement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do Statement. Causa: " + e.getMessage());
		}
	}

	/**
	 * 
	 * Solicita um objeto PreparedStatement para uma conexÃ£o. Este objeto serve para
	 * executar as operaÃ§Ãµes SQL.
	 * 
	 * @param conn uma conexÃ£o anteriormente criada.
	 * @return stmt um objeto do tipo PreparedStatement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static PreparedStatement getPreparedStatement(Connection conn) {
		try {
			PreparedStatement stmt = null;
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement. Causa: " + e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * Solicita um objeto PreparedStatement para uma conexÃ£o. Este objeto serve para
	 * executar as operaÃ§Ãµes SQL.
	 * 
	 * @param conn uma conexÃ£o anteriormente criada.
	 * @return stmt um objeto do tipo PreparedStatement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			return null;
		}
	}

	public static PreparedStatement getPreparedStatement(Connection conn, String sql, int tipoRetorno) {
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, tipoRetorno);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			return null;
		}
	}

	/**
	 * 
	 * Fecha um objeto PreparedStatement anteriormente criado.
	 * 
	 * Este mÃ©todo deve ser sempre chamado nos DAOs apÃ³s a execuÃ§Ã£o da expressÃ£o
	 * SQL.
	 * 
	 * @param stmt um objeto do tipo PreparedStatement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closePreparedStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do PreparedStatement. Causa: " + e.getMessage());
		}
	}

	/**
	 * 
	 * Fecha um objeto ResultSet anteriormente criado.
	 * 
	 * Este mÃ©todo deve ser sempre chamado nos DAOs apÃ³s a consulta de todos os
	 * resultados e conversÃ£o para objetos.
	 * 
	 * @param result um objeto do tipo ResultSet
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closeResultSet(ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do ResultSet. Causa: " + e.getMessage());
		}
	}
}
