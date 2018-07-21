package br.com.teste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.teste.dao.ClienteDAO;



public class TelaCustomers extends JFrame implements ActionListener{

	JLabel lblTitulo,lblMedia;
	JButton btnCadastrar, btnEditar, btnExcluir;
	JList<String> listaNomes;
	ArrayList<String> nomes = new ArrayList<String>();
	ClienteDAO us = new ClienteDAO();
    ArrayList<Cliente> users = us.listar();
    DefaultTableModel modelo = new DefaultTableModel();
    JScrollPane barraRolagem;
	JPanel painel;
	JTable tabela;
	Container cp;
	float mediaFinal;
	
	public TelaCustomers(){
		super("Cliente");
		setSize(500, 550);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Smart System");
		init();
		setVisible(true);
		
	}
	
	
	
	private void init(){
		
	
		lblTitulo = new JLabel("Customers");
		lblTitulo.setBounds(20, 20, getWidth()-50, 40);
		lblTitulo.setFont(new Font("Century Gothic",0,22));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitulo);
		
		Font font = new Font("Century Gothic",0,17);
	
		painel = new JPanel();
		tabela = new JTable(modelo);
		barraRolagem = new JScrollPane(tabela);
		

        modelo.addColumn("Id");
        modelo.addColumn("Cpf/Cnpj");
        modelo.addColumn("Nome");
        modelo.addColumn("Ativo");
        modelo.addColumn("valor");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        
		pesquisar(modelo);
		
		
		DefaultTableCellRenderer dtcrCentro = new DefaultTableCellRenderer();
		dtcrCentro.setHorizontalAlignment(SwingConstants.CENTER);
		tabela.getColumnModel().getColumn(0).setCellRenderer(dtcrCentro);
		
		tabela.getTableHeader().setReorderingAllowed(false); 
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 

		
		cp = getContentPane(); 
		cp.setLayout(null); 
		cp.setBackground(new Color(255,160,122));
		barraRolagem.setBounds(20, 80, 460, 200);
		cp.add(barraRolagem);

		
		JPanel panel = new JPanel();
		
		panel.setSize(450,450);
		panel.setLayout(null);
		
       
		
		listaNomes = new JList<String>();
		listaNomes.setBounds(20, 20,20,20);
		listaNomes.setBackground(Color.WHITE);
		
		JScrollPane scroll = new JScrollPane(listaNomes);
		scroll.setBounds(20, 80,
				460, 200);
		add(scroll);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		
		
       
		
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(20, 320, 460, 40);
		btnCadastrar.setFont(font);
		add(btnCadastrar);
		btnCadastrar.addActionListener(this);
		
		
		lblMedia = new JLabel("Media Final: "+mediaFinal+"");
		lblMedia.setBounds(20, btnCadastrar.getY()+btnCadastrar.getHeight()+50, getWidth(), 40);
		lblMedia.setFont(font);
		add(lblMedia);
		
	}


	private void pesquisar(DefaultTableModel modelo2) {
		
		modelo.setNumRows(0);
        ClienteDAO dao = new ClienteDAO();
        Collections.sort(dao.listar());
        System.out.println(dao.listar());
		Validar v = new Validar();
		
		
        for (Cliente c : dao.listar()) {
        	if(v.validarValor(String.valueOf(c.getVl_total())) == true )
        	{
        		if(v.validarId(c.getId_customer()) == true)
        		{
        		mediaFinal += c.getVl_total();
        	    modelo.addRow(new Object[]{c.getId_customer(), c.getCpf_cnpj(), c.getNm_customer(), c.getIs_active(), c.getVl_total()});
        	}
        }
            
        }
        
    }


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(btnCadastrar)){
			
			new TelaCadastro();	
	}
		
		}
	
}