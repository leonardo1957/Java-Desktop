package view.exercicio2;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class InternalFrameAlterarTelefone extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrameAlterarTelefone frame = new InternalFrameAlterarTelefone();
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
	public InternalFrameAlterarTelefone() {
		setTitle("Alterar Telefones");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);

		JLabel lblAlterarTelefones = new JLabel("Alterar Telefone");
		lblAlterarTelefones.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlterarTelefones.setBounds(199, 13, 191, 16);
		getContentPane().add(lblAlterarTelefones);

		JLabel lblCodigoPais = new JLabel("C\u00F3digo Pa\u00EDs:");
		lblCodigoPais.setBounds(72, 48, 78, 16);
		getContentPane().add(lblCodigoPais);

		JFormattedTextField txtCodigoPais = new JFormattedTextField((AbstractFormatter) null);
		txtCodigoPais.setBounds(148, 45, 56, 22);
		getContentPane().add(txtCodigoPais);

		JFormattedTextField txtDDD = new JFormattedTextField((AbstractFormatter) null);
		txtDDD.setBounds(112, 77, 56, 22);
		getContentPane().add(txtDDD);

		JLabel lblDDD = new JLabel("DDD:");
		lblDDD.setBounds(72, 80, 56, 16);
		getContentPane().add(lblDDD);

		JRadioButton rbMovel = new JRadioButton("M\u00F3vel");
		rbMovel.setBounds(72, 112, 73, 25);
		getContentPane().add(rbMovel);

		JRadioButton rbFixo = new JRadioButton("Fixo");
		rbFixo.setBounds(160, 112, 61, 25);
		getContentPane().add(rbFixo);

		JFormattedTextField txtNumero = new JFormattedTextField((AbstractFormatter) null);
		txtNumero.setBounds(131, 158, 90, 22);
		getContentPane().add(txtNumero);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(72, 158, 56, 16);
		getContentPane().add(lblNumero);

		JRadioButton rbAtivo = new JRadioButton("Ativo");
		rbAtivo.setBounds(72, 202, 56, 25);
		getContentPane().add(rbAtivo);

		JRadioButton rbInativo = new JRadioButton("Inativo");
		rbInativo.setBounds(148, 202, 78, 25);
		getContentPane().add(rbInativo);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(72, 252, 56, 16);
		getContentPane().add(lblCliente);

		JComboBox cbCliente = new JComboBox(new Object[] {});
		cbCliente.setSelectedIndex(-1);
		cbCliente.setBounds(131, 249, 161, 22);
		getContentPane().add(cbCliente);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(417, 279, 97, 25);
		getContentPane().add(btnCadastrar);

	}

}
