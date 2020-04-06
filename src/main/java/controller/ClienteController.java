package controller;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.entity.Cliente;

public class ClienteController {

	private ClienteBO clienteBO = new ClienteBO();
	private Cliente cliente = new Cliente();
	private String msg = "";
	private ArrayList<Cliente> clientes;

	public String verificaIndice(int valorCombo) {
		msg = clienteBO.verificaIndice(valorCombo);
		return msg;
	}

	public ArrayList<Cliente> consultarTodos() {
		return clientes = clienteBO.consultarTodos();
	}

	public String verificaCpf(Cliente cliente2) {
		msg = clienteBO.verificaCpf(cliente2);
		return msg;
	}

}
