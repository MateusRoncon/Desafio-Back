package br.com.teste;

import javax.swing.JOptionPane;

public class Validar {
	
	public boolean validarTexto(String texto, String nome) 
	{
		try{
			
		if(texto.equals("")){
		JOptionPane.showMessageDialog(null, "O campo "+ nome + " é obrigatório");
		return false;
		
		}
		
		}catch(Exception e)
		{}

		return true;
	
	}
	
	public boolean validarValor(String texto) 
	{
		try{

		float f = Float.parseFloat(texto);
		if (f < 560)
		{
		return false;
		}else
			return true;
		}catch(Exception e)
		{}

		return true;
	
	}
	
	public boolean validarId(int Id) 
	{
		try{
		if ((Id > 1500) && (Id < 2700))
		{
		return true;
		}else
			return false;
		}catch(Exception e)
		{}

		return false;
	
	}
	
	
	
	
}
