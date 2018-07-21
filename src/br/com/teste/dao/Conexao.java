package br.com.teste.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection getConnection(){
		String usuario = "root";
		String senha = "1710";
		String servidor = "localhost";
		String banco = "db_projeto";
		try {
			String path="jdbc:mysql://"+servidor+"/"+banco;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
								path,usuario,senha);
			return conn; //Atenção
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public void fecharConexao(Connection conn){
		if(conn!=null){
			try {
				conn.close();//Fechar a conexao
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}