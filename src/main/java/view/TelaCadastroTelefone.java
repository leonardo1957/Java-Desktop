package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.TelefoneController;
import model.entity.Cliente;
import model.entity.Telefone;

public class TelaCadastroTelefone extends JFrame {

	private TelefoneController telefoneController = new TelefoneController();
	private ClienteController clienteController = new ClienteController();
	private Telefone telefone = new Telefone();
	private ArrayList<Cliente> clientes;
	private String msg = "";
	private JPanel contentPane;
	private JFormattedTextField txtFormCodPais;
	private JFormattedTextField txtFormNumero;
	private JFormattedTextField txtFormtDdd;
	private JComboBox cbCliente;
	private JRadioButton rdbtnInativo;
	private JRadioButton rdbtnAtivo;
	private JRadioButton rdbtnFixo;
	private JRadioButton rdbtnMovel;
	private ButtonGroup buttonGroup1;
	private ButtonGroup buttonGroup2;
	private JLabel lblDdd;
	private JLabel lblCdigoPas;
	private JLabel lblCadastroDeTelefone;
	private JLabel lblNumero;
	private JButton btnCadastrar;
	private JLabel lblCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone frame = new TelaCadastroTelefone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroTelefone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCadastroDeTelefone = new JLabel("Cadastro de Telefone");
		lblCadastroDeTelefone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDeTelefone.setBounds(195, 13, 191, 16);
		contentPane.add(lblCadastroDeTelefone);

		lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(184, 48, 56, 16);
		contentPane.add(lblDdd);

		lblCdigoPas = new JLabel("C\u00F3digo Pa\u00EDs:");
		lblCdigoPas.setBounds(38, 48, 78, 16);
		contentPane.add(lblCdigoPas);

		lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(306, 48, 56, 16);
		contentPane.add(lblNumero);

		MaskFormatter formatoDDD;
		try {
			formatoDDD = new MaskFormatter("##");
			txtFormtDdd = new JFormattedTextField(formatoDDD);
			txtFormtDdd.setBounds(222, 45, 56, 22);
			contentPane.add(txtFormtDdd);
		} catch (ParseException e) {
			e.getMessage();
		}

		MaskFormatter formatoCodPais;
		try {
			formatoCodPais = new MaskFormatter("##");
			txtFormCodPais = new JFormattedTextField(formatoCodPais);
			txtFormCodPais.setBounds(108, 47, 56, 22);
			contentPane.add(txtFormCodPais);
		} catch (ParseException e) {
			e.getMessage();
		}

		MaskFormatter formatoNumero;
		try {
			formatoNumero = new MaskFormatter("#####-####");
			txtFormNumero = new JFormattedTextField(formatoNumero);
			txtFormNumero.setBounds(358, 45, 90, 22);
			contentPane.add(txtFormNumero);
		} catch (ParseException e) {
			e.getMessage();
		}

		rdbtnMovel = new JRadioButton("M\u00F3vel");
		rdbtnMovel.setBounds(38, 98, 73, 25);
		contentPane.add(rdbtnMovel);

		rdbtnFixo = new JRadioButton("Fixo");
		rdbtnFixo.setBounds(103, 98, 61, 25);
		contentPane.add(rdbtnFixo);

		rdbtnAtivo = new JRadioButton("Ativo");
		rdbtnAtivo.setBounds(38, 140, 56, 25);
		contentPane.add(rdbtnAtivo);

		rdbtnInativo = new JRadioButton("Inativo");
		rdbtnInativo.setBounds(97, 140, 78, 25);
		contentPane.add(rdbtnInativo);

		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup1.add(rdbtnAtivo);
		buttonGroup1.add(rdbtnInativo);

		buttonGroup2 = new javax.swing.ButtonGroup();
		buttonGroup2.add(rdbtnMovel);
		buttonGroup2.add(rdbtnFixo);

		lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(38, 218, 56, 16);
		contentPane.add(lblCliente);

		clientes = clienteController.consultarTodos();
		cbCliente = new JComboBox(clientes.toArray());
		cbCliente.setBounds(80, 215, 161, 22);
		contentPane.add(cbCliente);
		cbCliente.setSelectedIndex(-1);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codPais = txtFormCodPais.getText();
				String ddd = txtFormtDdd.getText();
				String numero = txtFormNumero.getText();
				Cliente dono = (Cliente) cbCliente.getSelectedItem();
				boolean ativo = false;
				boolean movel = false;

				if (rdbtnAtivo.isSelected()) {
					ativo = true;
				} else if (rdbtnInativo.isSelected()) {
					ativo = false;
				}

				if (rdbtnMovel.isSelected()) {
					movel = true;
				} else if (rdbtnFixo.isSelected()) {
					movel = false;
				}

				msg = telefoneController.validarCampos(codPais, ddd, numero);

				if (msg.isEmpty()) {

					telefone.setCodigoPais(codPais);
					telefone.setDdd(ddd);
					telefone.setNumero(numero);
					telefone.setDono(dono);
					telefone.setAtivo(ativo);
					telefone.setMovel(movel);

					msg = telefoneController.salvar(telefone);
				}

				JOptionPane.showMessageDialog(null, msg);

			}
		});
		btnCadastrar.setBounds(222, 301, 97, 25);
		contentPane.add(btnCadastrar);

	}
}
