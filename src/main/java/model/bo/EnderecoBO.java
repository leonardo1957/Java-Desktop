package model.bo;

import java.util.ArrayList;

import model.dao.EnderecoDAO;
import model.entity.Endereco;

public class EnderecoBO {
	
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	private ArrayList<Endereco> enderecos;

	public ArrayList<Endereco> consultarTodos() {
		return enderecos = enderecoDAO.consultarTodos();
	}

}
