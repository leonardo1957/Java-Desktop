package view.exercicio2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class Autor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autor frame = new Autor();
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
	public Autor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Autor.class.getResource("/icones/icons8-treinamento.png")));
		setTitle("Autor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblDemetrio = new JLabel("Leonardo Vieira - Senac 2020 Dev Desktop");
		lblDemetrio.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblDemetrio, BorderLayout.NORTH);
	}

}
