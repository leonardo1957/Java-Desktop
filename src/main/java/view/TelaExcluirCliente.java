package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ClienteController;
import model.entity.Cliente;

public class TelaExcluirCliente extends JFrame {

	private ClienteController clienteController = new ClienteController();
	private Cliente cliente = new Cliente();
	private String msg = "";
	private JComboBox cbClientes;
	private ArrayList<Cliente> clientes;
	private JPanel contentPane;
	private JLabel lblSelecioneOCliente;
	private JButton btnPesquisar;
	private JLabel lblExcluirClientes;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExcluirCliente frame = new TelaExcluirCliente();
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
	public TelaExcluirCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblSelecioneOCliente = new JLabel("Selecione o Cliente:");
		lblSelecioneOCliente.setBounds(22, 80, 114, 16);
		contentPane.add(lblSelecioneOCliente);

		lblExcluirClientes = new JLabel("Excluir Clientes");
		lblExcluirClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblExcluirClientes.setBounds(194, 17, 139, 16);
		contentPane.add(lblExcluirClientes);

		clientes = clienteController.consultarTodos();
		cbClientes = new JComboBox(clientes.toArray());
		cbClientes.setBounds(146, 77, 186, 22);
		contentPane.add(cbClientes);
		cbClientes.setSelectedIndex(-1);

		btnPesquisar.setBounds(350, 43, 97, 25);
		contentPane.add(btnPesquisar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int valorCombo = cbClientes.getSelectedIndex();
				msg = clienteController.verificaIndice(valorCombo);

				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnExcluir.setBounds(233, 145, 97, 25);
		contentPane.add(btnExcluir);
	}
}
