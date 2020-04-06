package model.bo;

import java.util.ArrayList;

import model.dao.TelefoneDAO;
import model.entity.Telefone;

public class TelefoneBO {

	private TelefoneDAO telefoneDAO = new TelefoneDAO();
	private Telefone telefone = new Telefone();
	private ArrayList<Telefone> telefones;
	private String msg = "";

	public String salvar(Telefone telefone) {
		telefone = telefoneDAO.salvar(telefone);

		if (telefone != null) {
			msg = " Telefone salvo com sucesso. ";
		} else {
			msg = " Ocorreu um erro, o telefone não foi salvo. ";
		}
		return msg;
	}

	public ArrayList<Telefone> consultarTodos() {
		return telefones = telefoneDAO.consultarTodos();
	}

	public ArrayList<Telefone> consultaTelefones(Telefone telefone2, int dono) {

		if (telefone2 != null && dono != -1) {
			telefones = telefoneDAO.consultaTelefonesCliente(telefone2, dono);
		} else if (telefone2 == null && dono == -1) {
			telefones = telefoneDAO.consultarTodos();
		} else if (telefone2 == null && dono != -1) {
			telefones = telefoneDAO.consultarTodosPorIdCliente(dono);
		} else if (telefone2 != null && dono == -1) {
			telefones = telefoneDAO.consultarPorIdList(telefone2.getId());
		}
		
		return telefones;
	}

}
