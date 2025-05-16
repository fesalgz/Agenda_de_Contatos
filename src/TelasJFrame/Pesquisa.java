package TelasJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Pesquisa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaPesquisa;
	private JTextField txtConsulta;
	private JTextField txtQuantidadeDeItens;
	private JTable tabelaAgenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesquisa frame = new Pesquisa();
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
	public Pesquisa() {
		setTitle("Pesquisa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 420);
		telaPesquisa = new JPanel();
		telaPesquisa.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(telaPesquisa);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon(Pesquisa.class.getResource("/Imagens/novo.png")));
		btnNovo.setBounds(615, 11, 159, 52);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro abreTela = new Cadastro();
				abreTela.setVisible(true);			}
		});
		telaPesquisa.setLayout(null);
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telaPesquisa.add(btnNovo);
		
		JLabel lblNewLabel = new JLabel("Digite para pesquisar");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 12, 537, 52);
		telaPesquisa.add(lblNewLabel);
		
		txtConsulta = new JTextField();
		txtConsulta.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtConsulta.setBounds(12, 61, 537, 32);
		telaPesquisa.add(txtConsulta);
		txtConsulta.setColumns(10);
		
		txtQuantidadeDeItens = new JTextField();
		txtQuantidadeDeItens.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtQuantidadeDeItens.setBounds(12, 111, 114, 32);
		telaPesquisa.add(txtQuantidadeDeItens);
		txtQuantidadeDeItens.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 155, 776, 220);
		telaPesquisa.add(scrollPane);
		
		tabelaAgenda = new JTable();
		scrollPane.setViewportView(tabelaAgenda);
		tabelaAgenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Telefone", "Email" , "Endereço", "Nascimento", "Filhos"
			}
		));
		
	}
	//metodo para carregar as infos do bd
	public void carregarItens() {
		
	}
}
