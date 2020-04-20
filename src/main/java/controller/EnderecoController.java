package controller;

import java.util.ArrayList;

import model.bo.EnderecoBO;
import model.entity.Endereco;

public class EnderecoController {
	
	private EnderecoBO enderecoBO = new EnderecoBO();
	private ArrayList<Endereco> enderecos;

	public String excluir(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Endereco> consultarTodos() {
		return enderecos = enderecoBO.consultarTodos();
	}

}
