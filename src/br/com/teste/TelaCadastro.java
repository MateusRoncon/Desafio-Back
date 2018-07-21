package br.com.teste;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.teste.dao.ClienteDAO;



public class TelaCadastro extends JFrame implements ActionListener{

	public TelaCadastro(){
		setSize(500, 700);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Smart System");
		init();
		setVisible(true);
	}
	
	JLabel lblTitulo, lblNome,lblCpf,lblAtivo,lblValor,lblCheck,lblMedia;
	JTextField txtNome, txtCpf, txtAtivo, txtValor;
	JButton btnCadastrar;
	JCheckBox checkAtivo;
	
	private void init(){
	
		lblTitulo = new JLabel("Cadastro de usuários");
		lblTitulo.setBounds(20, 20, getWidth()-50, 40);
		lblTitulo.setFont(new Font("Century Gothic",0,22));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitulo);
		
		Font font = new Font("Century Gothic",0,17);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, lblTitulo.getY()+lblTitulo.getHeight()+30, getWidth(), 40);
		lblNome.setFont(font);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(20, lblNome.getY()+lblNome.getHeight()+5, getWidth()-50, 40);
		txtNome.setFont(font);
		add(txtNome);
		
		
		lblCpf = new JLabel("Cpf/Cnpj");
		lblCpf.setBounds(20, txtNome.getY()+txtNome.getHeight()+10, getWidth(), 40);
		lblCpf.setFont(font);
		add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(20, lblCpf.getY()+lblCpf.getHeight()+5, getWidth()-50, 40);
		txtCpf.setFont(font);
		add(txtCpf);
		
		
		
		checkAtivo = new JCheckBox("Ativo");
		checkAtivo.setBounds(20, lblCpf.getY()+lblCpf.getHeight()+70, getWidth()-50, 40);
		checkAtivo.setFont(font);
		add(checkAtivo);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(20, checkAtivo.getY()+checkAtivo.getHeight()+10, getWidth(), 40);
		lblValor.setFont(font);
		add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(20, lblValor.getY()+lblValor.getHeight()+5, getWidth()-50, 40);
		txtValor.setFont(font);
		add(txtValor);
		
		
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(20, txtValor.getY()+txtValor.getHeight()+60, getWidth()-50, 40);
		btnCadastrar.setFont(font);
		add(btnCadastrar);
		btnCadastrar.addActionListener(this);
		
	
	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(btnCadastrar)){
			Cliente user = new Cliente();
			Validar v = new Validar();
			
			
			try {
			boolean flg = true;
			flg &= v.validarTexto(txtCpf.getText(), lblCpf.getText());
			flg &= v.validarTexto(txtNome.getText(), lblNome.getText());
			flg &= v.validarTexto(txtValor.getText(), lblValor.getText());
			
			
			
			user.setCpf_cnpj(txtCpf.getText());
			user.setNm_customer(txtNome.getText());
			user.setIs_active(checkAtivo.isSelected());
			user.setVl_total(Integer.parseInt(txtValor.getText()));
			
			ClienteDAO uBanco = new ClienteDAO();
			
				if(flg)
				{
					
					if(uBanco.inserir(user))
					{
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
						clear();
						
					}else
					
					{
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
					}
				}
			}catch(Exception e)
			{}
		}
	}
	
	private void clear(){
		txtCpf.setText("");
		txtNome.setText("");
		txtValor.setText("");
		
	}
}
