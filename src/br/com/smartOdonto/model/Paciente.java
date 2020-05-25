package br.com.smartOdonto.model;

public class Paciente {
	
	private String cpf;
	private String nome;
	private String sexo;		
	private String nascimento;
	private String tel;
	private String convenio;
	private String email;
	private String endereco;
	private String cidade;
	private String estado;

	public Paciente () {
	}

	public Paciente(String cpf, String nome, String sexo, String nascimento, String tel, String convenio, String email,
			String endereco, String cidade, String estado) {
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.tel = tel;
		this.convenio = convenio;
		this.email = email;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
