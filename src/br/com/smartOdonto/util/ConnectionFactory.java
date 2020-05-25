package br.com.smartOdonto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception {
		// método getconnection - não ira tratar erros
		try {
		// indica o DB Mysql e aponta para o driver	
		Class.forName("com.mysql.cj.jdbc.Driver");
		//conexão com DB
		String login = "root";
		String senha = "";
		String url   = "jdbc:mysql://localhost:3308/ smartOdonto?useTimezone=true&serverTimezone=UTC"; 
		return DriverManager.getConnection(url,login,senha);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/*public static void main(String[] args) throws Exception {
		try { Connection conn = getConnection();
		JOptionPane.showMessageDialog(null, "conectado ao DB");			
		}catch(Exception e){
			throw new Exception("erro ->" + e.getMessage());
		}
	}*/
	
}
