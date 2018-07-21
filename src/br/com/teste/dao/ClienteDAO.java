package br.com.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.com.teste.dao.Conexao;
import br.com.teste.Cliente;

public class ClienteDAO {

	
	
	public boolean inserir(Cliente cliente){
		String sql = "INSERT INTO tb_customer_account (cpf_cnpj, nm_customer, is_active, vl_total) VALUES "
				+ " ( ? , ? , ? , ?) ";
		Connection conn =null;
		try {
			conn = new Conexao().getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getCpf_cnpj());
			pstm.setString(2, cliente.getNm_customer());
			pstm.setBoolean(3, cliente.getIs_active());
			pstm.setFloat(4, cliente.getVl_total());
			
			pstm.execute();
			return true;
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}finally{
			new Conexao().fecharConexao(conn);
		}
	}

	public ArrayList<Cliente> listar(){
		String sql = "select * from tb_customer_account";
		Connection conn =null;
		ArrayList<Cliente> users = new ArrayList<Cliente>();
		
		try {
			conn = new Conexao().getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);	
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Cliente user = new Cliente();
				user.setId_customer(rs.getInt("id_customer"));
				user.setCpf_cnpj(rs.getString("cpf_cnpj"));
				user.setNm_customer(rs.getString("nm_customer"));
				user.setIs_active(rs.getBoolean("is_active"));
				user.setVl_total(rs.getFloat("vl_total"));
				users.add(user);
				Collections.sort(users);
				
			}
			return users;
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally{
			new Conexao().fecharConexao(conn);
		}
	}


	
	
	
	
	
	
	
}
