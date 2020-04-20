package controller;

import java.util.ArrayList;

import model.bo.TelefoneBO;
import model.entity.Telefone;

public class TelefoneController {
	
	private TelefoneBO telefoneBO = new TelefoneBO();
	private ArrayList<Telefone> telefones;
	private String msg = "";

	public String validarCampos(String codPais, String ddd, String numero) {
		if (codPais.trim().isEmpty()) {
			msg += " Digite o codigo do país. ";
		}
		if (ddd.trim().isEmpty()) {
			msg += " Digite o ddd. ";
		}
		if (numero.trim().isEmpty()) {
			msg += " Digite o numero ";
		}
		return msg;
	}

	public String salvar(Telefone telefone) {
		msg = telefoneBO.salvar(telefone);
		return msg;
	}

	public ArrayList<Telefone> consultarTodos() {
		return telefones = telefoneBO.consultarTodos();
	}

	public ArrayList<Telefone> consultaTelefones(Telefone telefone, int dono) {
		if (dono != -1) {
			dono += 1;
		}
		return telefones = telefoneBO.consultaTelefones(telefone, dono);
	}

}
