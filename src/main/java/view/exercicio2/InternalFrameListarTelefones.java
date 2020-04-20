package view.exercicio2;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.entity.Telefone;
import javax.swing.JFrame;

public class InternalFrameListarTelefones extends JInternalFrame {

	private String[] colunasTabelaPecas = { "Id", "Código do País", "Ddd", "Número", "Móvel", "Ativo", "Dono" };
	private ArrayList<Telefone> telefonesList;
	private JTable tblTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrameListarTelefones frame = new InternalFrameListarTelefones();
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
	public InternalFrameListarTelefones() {
		setTitle("Listar Telefones");
		setMaximizable(true);
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 812, 500);
		getContentPane().setLayout(null);

		JComboBox cbDonos = new JComboBox(new Object[] {});
		cbDonos.setSelectedIndex(-1);
		cbDonos.setBounds(129, 51, 154, 22);
		getContentPane().add(cbDonos);

		JLabel lblDonos = new JLabel("Donos:");
		lblDonos.setBounds(82, 54, 56, 16);
		getContentPane().add(lblDonos);

		JLabel lblListarTelefones = new JLabel("Listar Telefones");
		lblListarTelefones.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListarTelefones.setBounds(343, 13, 143, 16);
		getContentPane().add(lblListarTelefones);

		JLabel lblTelefones = new JLabel("Telefones:");
		lblTelefones.setBounds(430, 54, 69, 16);
		getContentPane().add(lblTelefones);

		JComboBox cbTelefones = new JComboBox(new Object[] {});
		cbTelefones.setSelectedIndex(-1);
		cbTelefones.setBounds(511, 51, 143, 22);
		getContentPane().add(cbTelefones);

		tblTelefone = new JTable();
		tblTelefone.setBounds(82, 107, 620, 270);
		getContentPane().add(tblTelefone);

		limparTabela();

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(317, 410, 97, 25);
		getContentPane().add(btnConsultar);

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
