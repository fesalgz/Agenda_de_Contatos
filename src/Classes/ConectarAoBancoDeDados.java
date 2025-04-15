package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConectarAoBancoDeDados {
	
	public Connection getConnection() {
		
		// Conexão com Banco, teste de conexão
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdagenda", "root", "1234");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"O driver do banco de dados não foi encontrado" + e);
		}
		return null;
		
	}
			
	// Tela de cadastro

}
