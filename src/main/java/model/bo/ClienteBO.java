package model.bo;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.entity.Cliente;

public class ClienteBO {
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	private Cliente cliente = new Cliente();
	private ArrayList<Cliente> clientes;
	private String msg = "";

	public String verificaCpf(Cliente cliente2) {
		cliente = clienteDAO.verificaCPF(cliente2);
		if (cliente != null) {
			msg = " Este cliente já existe. ";
		} else {
			cliente = clienteDAO.salvar(cliente2);
			if (cliente != null) {
				msg = " Cliente salvo com sucesso. ";
			}
		}
		return msg;
	}

	public String verificaIndice(int valorCombo) {
		boolean quantidadeLinhasAfetadas = false;
		if (valorCombo != -1) {
			quantidadeLinhasAfetadas = clienteDAO.deletar(valorCombo + 1);
			if (quantidadeLinhasAfetadas == true) {
				msg = " Cliente excluido com sucesso.";
			} else {
				msg = " Ocorreu um problema ao consultar cliente ";
			}
		} else {
			msg = " Selecione algum cliente, pf. ";
		}
		return msg;
	}

	public ArrayList<Cliente> consultarTodos() {
		return clientes = clienteDAO.consultarTodos();
	}

}
