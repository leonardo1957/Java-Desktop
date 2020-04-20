package principal;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.ClienteDAO;
import model.dao.EnderecoDAO;
import model.dao.TelefoneDAO;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Telefone;

public class Executavel {

	public static void main(String[] args) {

		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco endereConsultado = new Endereco();

		endereConsultado = endDAO.consultarPorId(3);
		System.out.println("Endereco:" + endereConsultado);

		Endereco e1 = new Endereco();

		//Cliente c1 = obterClienteDaTela();
		ClienteDAO clienteDAO = new ClienteDAO();

		//Telefone telefone = obterTelefone();
		//System.out.println(telefone);
		Telefone telefoneCliente = obterTelefoneCliente();
		System.out.println(telefoneCliente);

	}

	private static Telefone obterTelefoneCliente() {
		String ddd = (String) JOptionPane.showInputDialog("Digite o ddd");
		String codPais = (String) JOptionPane.showInputDialog("Digite o codigo do pais");
		String numeroTel = JOptionPane.showInputDialog("Digite o numero do telefone");
		int movel = JOptionPane.showConfirmDialog(null, "É móvel?");
		int temCliente = JOptionPane.showConfirmDialog(null, "Tem um cliente associado?");
		boolean isMovel;
		
		if (movel == JOptionPane.OK_OPTION) {
			isMovel = true;
		} else {
			isMovel = false;
		}
		Telefone tel = new Telefone();
		tel.setDdd(ddd);
		tel.setMovel(isMovel);
		tel.setCodigoPais(codPais);
		tel.setNumero(numeroTel);

		if (temCliente == JOptionPane.OK_OPTION) {
			Cliente cliente = consultaCliente();
			tel.setDono(cliente);
		}
		
		TelefoneDAO telDao = new TelefoneDAO();
		telDao.salvar(tel);
		return tel;
	}
	
	public static Cliente consultaCliente() {
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> cliente = clienteDAO.consultarTodos();
		Object[] clientes = cliente.toArray();
		Cliente client = (Cliente) JOptionPane.showInputDialog(null, 
				"Selecione um cliente", "Cliente", 
				JOptionPane.QUESTION_MESSAGE, 
				null, clientes, null);
		return client;
	}

//	private static Telefone obterTelefone() {
//		String ddd = (String) JOptionPane.showInputDialog("Digite o ddd");
//		String codPais = (String) JOptionPane.showInputDialog("Digite o codigo do pais");
//		String numeroTel = JOptionPane.showInputDialog("Digite o numero do telefone");
//		int movel = JOptionPane.showConfirmDialog(null, "É móvel?");
//		boolean isMovel;
//		if (movel == JOptionPane.OK_OPTION) {
//			isMovel = true;
//		} else {
//			isMovel = false;
//		}
//		Telefone tel = new Telefone();
//		tel.setDdd(ddd);
//		tel.setMovel(isMovel);
//		tel.setCodigoPais(codPais);
//		tel.setNumero(numeroTel);
//		TelefoneDAO telDao = new TelefoneDAO();
//		telDao.salvar(tel);
//
//		return tel;
//	}

//	private static Cliente obterClienteDaTela() {
//		String nome = JOptionPane.showInputDialog("Informe o nome");
//		String sobrenome = JOptionPane.showInputDialog("Informe o sobrenome");
//		String cpf = JOptionPane.showInputDialog("Informe o CPF");
//
//		EnderecoDAO endDAO = new EnderecoDAO();
//		TelefoneDAO telDAO = new TelefoneDAO();
//		ArrayList<Endereco> listaEnderecos = endDAO.consultarTodos();
//		ArrayList<Telefone> telefones = telDAO.consultarTodos();
//
//		Object[] enderecos = listaEnderecos.toArray();
//		Endereco enderecoSelecionado = (Endereco) JOptionPane.showInputDialog(null, "Selecione um endereço", "Endereço",
//				JOptionPane.QUESTION_MESSAGE, null, enderecos, null);
//
//		Cliente novoCliente = new Cliente();
//		novoCliente.setNome(nome);
//		novoCliente.setSobrenome(sobrenome);
//		novoCliente.setCpf(cpf);
//		return novoCliente;
//	}

}
