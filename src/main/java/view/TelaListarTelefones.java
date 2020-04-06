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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import controller.TelefoneController;
import model.entity.Cliente;
import model.entity.Telefone;

public class TelaListarTelefones extends JFrame {

	private ClienteController clienteController = new ClienteController();
	private TelefoneController telefoneController = new TelefoneController();
	private Telefone telefone = new Telefone();
	private Cliente cliente = new Cliente();
	private ArrayList<Cliente> clientes;
	private ArrayList<Telefone> telefones;
	private ArrayList<Telefone> telefonesList;
	private String[] colunasTabelaPecas = { "Id", "Código do País", "Ddd", "Número", "Móvel", "Ativo", "Dono" };
	private String msg = "";
	private JPanel contentPane;
	private JTable tblTelefone;
	private JLabel lblDonos;
	private JComboBox cbDono;
	private JLabel lblTelefones;
	private JComboBox cbTelefone;
	private JButton btnConsultar;
	private JLabel lblListarTelefones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarTelefones frame = new TelaListarTelefones();
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
	public TelaListarTelefones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDonos = new JLabel("Donos:");
		lblDonos.setBounds(67, 54, 56, 16);
		contentPane.add(lblDonos);

		lblListarTelefones = new JLabel("Listar Telefones");
		lblListarTelefones.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListarTelefones.setBounds(328, 13, 143, 16);
		contentPane.add(lblListarTelefones);

		lblTelefones = new JLabel("Telefones:");
		lblTelefones.setBounds(415, 54, 69, 16);
		contentPane.add(lblTelefones);

		clientes = clienteController.consultarTodos();
		cbDono = new JComboBox(clientes.toArray());
		cbDono.setBounds(114, 51, 154, 22);
		contentPane.add(cbDono);
		cbDono.setSelectedIndex(-1);

		telefones = telefoneController.consultarTodos();
		cbTelefone = new JComboBox(telefones.toArray());
		cbTelefone.setBounds(496, 51, 143, 22);
		contentPane.add(cbTelefone);
		cbTelefone.setSelectedIndex(-1);

		tblTelefone = new JTable();
		tblTelefone.setBounds(67, 107, 620, 270);
		contentPane.add(tblTelefone);

		limparTabela();

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telefone = (Telefone) cbTelefone.getSelectedItem();
				int dono = cbDono.getSelectedIndex();

				telefonesList = telefoneController.consultaTelefones(telefone, dono);
				atualizarTabelaPecas();
			}
		});
		btnConsultar.setBounds(302, 410, 97, 25);
		contentPane.add(btnConsultar);
	}

	protected void atualizarTabelaPecas() {

		limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblTelefone.getModel();
		for (Telefone telefone : telefonesList) {
			String[] novaLinha = new String[7];
			novaLinha[0] = String.valueOf(telefone.getId());
			novaLinha[1] = telefone.getCodigoPais();
			novaLinha[2] = String.valueOf(telefone.getDdd());
			novaLinha[3] = String.valueOf(telefone.getNumero());
			novaLinha[4] = String.valueOf(telefone.isAtivo());
			novaLinha[5] = String.valueOf(telefone.isMovel());
			novaLinha[6] = String.valueOf(telefone.getDono());

			model.addRow(novaLinha);
		}
	}

	private void limparTabela() {

		tblTelefone.setModel(new DefaultTableModel(new Object[][] { colunasTabelaPecas, }, colunasTabelaPecas));
	}
}
