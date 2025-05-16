package TelasJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Classes.DadosAgenda;
import Classes.OperacoesNoBancoDeDados;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	
	public static MaskFormatter txtTelefone;
	public static MaskFormatter txtNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro.class.getResource("/Imagens/cadastro.png")));
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 26, 282, 53);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setToolTipText("teste");
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtId.setBounds(10, 73, 140, 44);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 110, 282, 44);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNome.setBounds(10, 150, 764, 44);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 187, 282, 53);
		contentPane.add(lblNewLabel_2);
		
		JFormattedTextField txtTelefone = new JFormattedTextField(arrumaMascaraTelefone());
		txtTelefone.setFocusLostBehavior(JFormattedTextField.REVERT);
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTelefone.setBounds(10, 233, 290, 44);
		contentPane.add(txtTelefone);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(310, 187, 282, 53);
		contentPane.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setBounds(310, 233, 464, 44);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Endereço:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 270, 290, 62);
		contentPane.add(lblNewLabel_4);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEndereco.setBounds(10, 321, 764, 44);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nascimento:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(10, 358, 290, 37);
		contentPane.add(lblNewLabel_5);
		
		JFormattedTextField txtNascimento = new JFormattedTextField(arrumaMascaraNascimento());
		txtNascimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNascimento.setBounds(10, 394, 290, 44);
		contentPane.add(txtNascimento);
		
		JLabel lblNewLabel_6 = new JLabel("Filhos:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(310, 358, 282, 37);
		contentPane.add(lblNewLabel_6);
		
		JComboBox<String> comboBox_filhos = new JComboBox<>();
		comboBox_filhos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_filhos.setModel(new DefaultComboBoxModel<String>(new String[] {"-", "Sim", "Não"}));
		comboBox_filhos.setBounds(310, 394, 102, 44);
		contentPane.add(comboBox_filhos);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					DadosAgenda objeto = new DadosAgenda();
					objeto.setNome(txtNome.getText());
					objeto.setTelefone(txtTelefone.getText());
					objeto.setEmail(txtEmail.getText());
					objeto.setEndereco(txtEndereco.getText());
					objeto.setNascimento(txtNascimento.getText());
					objeto.setFilho(comboBox_filhos.getSelectedItem().toString());
					
					//instanciando a classe opnobd para usar os metodos dela
					OperacoesNoBancoDeDados salvarDados = new OperacoesNoBancoDeDados();					
					salvarDados.cadastrar(objeto);
					
					//fechar o form apos salvar os dados
					dispose();
					
				} catch (Exception trata) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar os dados no Banco!");
				}
				
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvar.setIcon(new ImageIcon(Cadastro.class.getResource("/Imagens/salvar.png")));
		btnSalvar.setBounds(577, 45, 197, 54);
		contentPane.add(btnSalvar);
	}
	
	public static MaskFormatter arrumaMascaraTelefone() {
		try {
			txtTelefone = new MaskFormatter ("(##) #####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtTelefone.setPlaceholderCharacter('_');
		
		return txtTelefone;
	}
	
	public static MaskFormatter arrumaMascaraNascimento() {
		try {
			txtNascimento = new MaskFormatter ("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtNascimento.setPlaceholderCharacter('_');
		
		return txtNascimento;
	}
}
