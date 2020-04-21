package view.exercicio2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class TelaPrincipal extends JFrame {

	private boolean mostraTelaAutor = false;
	private boolean mostraTelaListarTel = false;
	private boolean mostraTelaExcluirTelefones;
	private boolean mostraTelaAlterarTelefones = false;
	private boolean mostraTelaCadastrarTelefones = false;
	private InternalFrameCadastrarTelefone internalFrameCadastrarTelefone = null;
	private InternalFrameAlterarTelefone internalFrameAlterarTelefone = null;
	private InternalFrameListarTelefones internalFrameListarTelefones = null;
	private InternalFrameExcluirTelefone internalFrameExcluirTelefone = null;
	private Autor autor = null;
	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/icones/icons8-p\u00E1gina-inicial-40.png")));
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
				JMenu mnListar = new JMenu("Listar");
				mnListar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/Documents-icon.png")));
				menuBar.add(mnListar);
				
						JMenuItem mntmTelefone4 = new JMenuItem("Telefone");
						mntmTelefone4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								if (internalFrameListarTelefones == null) {
									internalFrameListarTelefones = new InternalFrameListarTelefones();
								}

								abrir(internalFrameListarTelefones);

							}
						});
						mnListar.add(mntmTelefone4);

		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnCadastrar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-adicionar-48.png")));
		menuBar.add(mnCadastrar);

		JMenuItem mntmTelefone = new JMenuItem("Telefone");
		mntmTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (internalFrameCadastrarTelefone == null) {
					internalFrameCadastrarTelefone = new InternalFrameCadastrarTelefone();
				}

				abrir(internalFrameCadastrarTelefone);
			}
		});
		mnCadastrar.add(mntmTelefone);

		JMenu mnAlterar = new JMenu("Alterar");
		mnAlterar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/settings-icon.png")));
		menuBar.add(mnAlterar);

		JMenuItem mntmTelefone2 = new JMenuItem("Telefone");
		mntmTelefone2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (internalFrameAlterarTelefone == null) {
					internalFrameAlterarTelefone = new InternalFrameAlterarTelefone();
				}

				abrir(internalFrameAlterarTelefone);

			}
		});
		mnAlterar.add(mntmTelefone2);

		JMenu mnExcluir = new JMenu("Excluir");
		mnExcluir.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-excluir-26.png")));
		menuBar.add(mnExcluir);

		JMenuItem mntmTelefone3 = new JMenuItem("Telefone");
		mntmTelefone3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (internalFrameExcluirTelefone == null) {
					internalFrameExcluirTelefone = new InternalFrameExcluirTelefone();
				}

				abrir(internalFrameExcluirTelefone);
			}
		});
		mnExcluir.add(mntmTelefone3);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/Help-icon.png")));
		menuBar.add(mnSobre);

		JMenuItem mntmAutor = new JMenuItem("Autor");
		mntmAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (autor == null) {
					autor = new Autor();
				}

				if (!autor.isVisible()) {

					autor.setVisible(true);
					autor.setLocationRelativeTo(null);

				} else if (mostraTelaAutor == false) {
					JOptionPane.showMessageDialog(null, "Tela já está sendo mostrada.");
				}

			}
		});
		mnSobre.add(mntmAutor);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(5, 5, 1900, 1000);
		contentPane.add(desktopPane);
	}

	private void abrir(JInternalFrame jInternalFrame) {

		if (!jInternalFrame.isSelected()) {
			desktopPane.add(jInternalFrame);
			jInternalFrame.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Tela já está sendo mostrada.");
		}

	}

}
