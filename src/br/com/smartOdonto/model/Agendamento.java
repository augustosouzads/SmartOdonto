package br.com.smartOdonto.model;

public class Agendamento {

	private int codAgendamento;
	private String data;
	private String horario;
	private int tratamentoAgenda;
	private String cpfAgenda;
	
	public Agendamento() {
	}

	public Agendamento(int codAgendamento, String data, String horario, int tratamentoAgenda, String cpfAgenda) {
		super();
		this.codAgendamento = codAgendamento;
		this.data = data;
		this.horario = horario;
		this.tratamentoAgenda = tratamentoAgenda;
		this.cpfAgenda = cpfAgenda;
	}

	public int getCodAgendamento() {
		return codAgendamento;
	}

	public void setCodAgendamento(int codAgendamento) {
		this.codAgendamento = codAgendamento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getTratamentoAgenda() {
		return tratamentoAgenda;
	}

	public void setTratamentoAgenda(int tratamentoAgenda) {
		this.tratamentoAgenda = tratamentoAgenda;
	}

	public String getCpfAgenda() {
		return cpfAgenda;
	}

	public void setCpfAgenda(String cpfAgenda) {
		this.cpfAgenda = cpfAgenda;
	}

	
	
}