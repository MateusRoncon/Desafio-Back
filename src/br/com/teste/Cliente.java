package br.com.teste;


public class Cliente implements Comparable<Cliente> {
	
	
	private int id_customer;//PK
	private String nm_customer;
	private String cpf_cnpj;
	private boolean is_active;
	private float vl_total;
	
	
	
	public int getId_customer() {
		return id_customer;
	}
	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}
	public String getNm_customer() {
		return nm_customer;
	}
	public void setNm_customer(String nm_customer) {
		this.nm_customer = nm_customer;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(boolean b) {
		this.is_active = b;
	}
	public float getVl_total() {
		return vl_total;
	}
	public void setVl_total(float vl_total) {
		this.vl_total = vl_total;
	}
	
	
	
	@Override
	public int compareTo(Cliente outroCliente) {
		
		if (this.vl_total > outroCliente.getVl_total()) {
	          return -1;
	     }
	     if (this.vl_total < outroCliente.getVl_total()) {
	          return 1;
	     }
	     return 0;
	     
	}
	
	@Override
	public String toString() {
	return nm_customer + " - " + vl_total;
	}
	
	

}
