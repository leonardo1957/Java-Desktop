package view.exercicio2;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class InternalFrameExcluirTelefone extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrameExcluirTelefone frame = new InternalFrameExcluirTelefone();
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
	public InternalFrameExcluirTelefone() {
		setTitle("Excluir Telefones");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(null);

		JLabel lblExcluirTelefones = new JLabel("Excluir Telefones");
		lblExcluirTelefones.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblExcluirTelefones.setBounds(192, 13, 186, 16);
		getContentPane().add(lblExcluirTelefones);

		JLabel lblSelecionaTelefone = new JLabel("Selecione o Telefone:");
		lblSelecionaTelefone.setBounds(41, 89, 139, 16);
		getContentPane().add(lblSelecionaTelefone);

		JComboBox cbTelefones = new JComboBox(new Object[] {});
		cbTelefones.setSelectedIndex(-1);
		cbTelefones.setBounds(192, 86, 186, 22);
		getContentPane().add(cbTelefones);

		JButton btnExcluirTelefone = new JButton("Excluir");
		btnExcluirTelefone.setBounds(317, 202, 97, 25);
		getContentPane().add(btnExcluirTelefone);

	}

}
