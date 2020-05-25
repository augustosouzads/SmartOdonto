package br.com.smartOdonto.model;

public class Orcamento {
	
	private int codOrcamento;
	private int codTratamento;
	private String cpfOrcamento;
	private int qtde;
	private double valorOrcamento;
	
	public Orcamento () {
		
	}

	public Orcamento(int codOrcamento, int codTratamento, String cpfOrcamento, int qtde, double valorOrcamento) {

		this.codOrcamento = codOrcamento;
		this.codTratamento = codTratamento;
		this.cpfOrcamento = cpfOrcamento;
		this.qtde = qtde;
		this.valorOrcamento = valorOrcamento;
	}

	public int getCodOrcamento() {
		return codOrcamento;
	}

	public void setCodOrcamento(int codOrcamento) {
		this.codOrcamento = codOrcamento;
	}

	public int getCodTratamento() {
		return codTratamento;
	}

	public void setCodTratamento(int codTratamento) {
		this.codTratamento = codTratamento;
	}

	public String getCpfOrcamento() {
		return cpfOrcamento;
	}

	public void setCpfOrcamento(String cpfOrcamento) {
		this.cpfOrcamento = cpfOrcamento;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getValorOrcamento() {
		return valorOrcamento;
	}

	public void setValorOrcamento(double valorOrcamento) {
		this.valorOrcamento = valorOrcamento;
	}
	
	
	
}
