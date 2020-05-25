package br.com.smartOdonto.model;

public class Tratamento {

	private int codTratamento;
	private String tratamento;
	private String tipo;
	private double valor;
	
	public Tratamento() {
	}
		
	public Tratamento(int codTratamento, String tratamento, String tipo, double valor) {
		super();
		this.codTratamento = codTratamento;
		this.tratamento = tratamento;
		this.tipo = tipo;
		this.valor = valor;
	}

	public int getCodTratamento() {
		return codTratamento;
	}

	public void setCodTratamento(int codTratamento) {
		this.codTratamento = codTratamento;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
