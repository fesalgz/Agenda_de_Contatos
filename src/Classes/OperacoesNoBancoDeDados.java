package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class OperacoesNoBancoDeDados {

	// criar um atributo
	private Connection conexao;
	
	// nosso atributo conexao vai receber uma nova conexao com o bd
	public OperacoesNoBancoDeDados() {
		this.conexao = new ConectarAoBancoDeDados().getConnection();
	}
	
	public void cadastrar(DadosAgenda objeto) {
		
		try {
			
		//vamos criar uma nova classe com o que queremos cadastrar
		String informacoesSQL = "insert into tabela_cadastro(nome, telefone, email, endereco, nascimento, filhos)"
			+ "values(?,?,?,?,?,?)";
		//insira na tela cadastro, nesses colunas(objetos) nome etc
		// cada interrogação corresponde a um valor
		
		
			PreparedStatement gravarInformacao = conexao.prepareStatement(informacoesSQL);
			gravarInformacao.setString(1, objeto.getNome());
			gravarInformacao.setString(2, objeto.getTelefone());
			gravarInformacao.setString(3, objeto.getEmail());
			gravarInformacao.setString(4, objeto.getEndereco());
			gravarInformacao.setString(5, objeto.getNascimento());
			gravarInformacao.setString(6, objeto.getFilho());
			
			//executa os comandos SQL
			gravarInformacao.execute();
			//fecha
			gravarInformacao.close();
			
			JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar os dados!");
			
		}
		
	}
	
	public List<DadosAgenda> listarItens() {
		
		List<DadosAgenda> lista = new ArrayList<DadosAgenda>();
		
		String sqlBancoDados = "select * from tabela_cadastro";
		
		try {
			PreparedStatement lerInformacoes = conexao.prepareStatement(sqlBancoDados);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
