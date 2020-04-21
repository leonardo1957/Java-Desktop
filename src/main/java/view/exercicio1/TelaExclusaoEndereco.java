package view.exercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.EnderecoController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaExclusaoEndereco {

	private JFrame frmExclusaoDeEndereos;
	private JTextField txtIdEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExclusaoEndereco window = new TelaExclusaoEndereco();
					window.frmExclusaoDeEndereos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaExclusaoEndereco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExclusaoDeEndereos = new JFrame();
		frmExclusaoDeEndereos.setTitle("Exclusao de endere\u00E7os");
		frmExclusaoDeEndereos.setBounds(100, 100, 450, 300);
		frmExclusaoDeEndereos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExclusaoDeEndereos.getContentPane().setLayout(null);

		JLabel lblInformeId = new JLabel("Informe o id:");
		lblInformeId.setBounds(36, 31, 75, 16);
		frmExclusaoDeEndereos.getContentPane().add(lblInformeId);

		txtIdEndereco = new JTextField();
		txtIdEndereco.setBounds(114, 28, 116, 22);
		frmExclusaoDeEndereos.getContentPane().add(txtIdEndereco);
		txtIdEndereco.setColumns(10);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnderecoController enderecoCotroller = new EnderecoController();
				String msg = "";
				try {
					int id = Integer.parseInt(txtIdEndereco.getText());
					msg = enderecoCotroller.excluir(id);
				} catch (NumberFormatException e) {
					msg = "Digite um nomero.";
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnExcluir.setBounds(35, 140, 370, 82);
		frmExclusaoDeEndereos.getContentPane().add(btnExcluir);
	}
}
