package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ClienteController;
import controller.EnderecoController;
import model.entity.Cliente;
import model.entity.Endereco;
import javax.swing.JComboBox;

public class TelaCadastroCliente extends JFrame {

	private ClienteController clienteController = new ClienteController();
	private EnderecoController enderecoController = new EnderecoController();
	private Cliente cliente = new Cliente();
	private Endereco endereco = new Endereco();
	private ArrayList<Endereco> enderecos;
	private String msg = "";
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JLabel lblCpf;
	private JTextField txtCpf;
	private JButton btnCadastrar;
	private JComboBox cbEndereco;
	private JLabel lblEndereco;
	private JLabel lblCadastroDeCliente;
	private JLabel lblNome;
	private JLabel lblSobrenome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCadastroDeCliente = new JLabel("Cadastro de Cliente");
		lblCadastroDeCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDeCliente.setBounds(166, 13, 195, 16);
		contentPane.add(lblCadastroDeCliente);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(38, 49, 56, 16);
		contentPane.add(lblNome);

		lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(232, 49, 81, 16);
		contentPane.add(lblSobrenome);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(38, 90, 56, 16);
		contentPane.add(lblCpf);

		lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(38, 152, 81, 16);
		contentPane.add(lblEndereco);

		txtNome = new JTextField();
		txtNome.setBounds(82, 46, 116, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(309, 46, 116, 22);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setBounds(82, 87, 116, 22);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		enderecos = enderecoController.consultarTodos();
		cbEndereco = new JComboBox(enderecos.toArray());
		cbEndereco.setBounds(89, 149, 272, 22);
		contentPane.add(cbEndereco);
		cbEndereco.setSelectedIndex(-1);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String sobrenome = txtSobrenome.getText();
				String cpf = txtCpf.getText();
				Endereco endereco = (Endereco) cbEndereco.getSelectedItem();

				cliente.setNome(nome);
				cliente.setSobrenome(sobrenome);
				cliente.setCpf(cpf);
				cliente.setEndereco(endereco);

				msg = clienteController.verificaCpf(cliente);
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnCadastrar.setBounds(216, 214, 97, 25);
		contentPane.add(btnCadastrar);
		
		
		// botao sem funcionar para limpar dados cadastrados
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.setBounds(60, 215, 89, 23);
		contentPane.add(btnNewButton);

	}
}
