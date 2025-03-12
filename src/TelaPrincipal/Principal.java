package TelaPrincipal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import TelasJFrame.Pesquisa;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frmAgendaDeContatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmAgendaDeContatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaDeContatos = new JFrame();
		frmAgendaDeContatos.setTitle("Agenda de Contatos");
		frmAgendaDeContatos.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frmAgendaDeContatos.setBounds(100, 100, 450, 300);
		frmAgendaDeContatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgendaDeContatos.getContentPane().setLayout(null);
		
		JButton btnTestarConexaoBD = new JButton("Testar conexão com o BD");
		btnTestarConexaoBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTestarConexaoBD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTestarConexaoBD.setBounds(69, 62, 298, 85);
		frmAgendaDeContatos.getContentPane().add(btnTestarConexaoBD);
		
		JMenuBar menuBar = new JMenuBar();
		frmAgendaDeContatos.setJMenuBar(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		JMenuItem subMenuContatos = new JMenuItem("Contatos");
		subMenuContatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisa telaPesquisa = new Pesquisa();
				telaPesquisa.setVisible(true);
			}
		});
		subMenuContatos.setHorizontalAlignment(SwingConstants.CENTER);
		menuArquivo.add(subMenuContatos);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);
		
		JMenuItem subMenuSair = new JMenuItem("Sair");
		subMenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgendaDeContatos.dispose();
			}
		});
		menuAjuda.add(subMenuSair);
	}
}
