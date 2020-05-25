package br.com.smartOdonto.DAO;

import java.sql.Connection;        // classe que faz a conexão com BD
import java.sql.PreparedStatement; // permite executar comandos SQL no JAVA
import java.sql.ResultSet;         //tabela
import java.util.ArrayList;
import java.util.List;

import br.com.smartOdonto.model.Paciente;
import br.com.smartOdonto.util.CommonUtil;
import br.com.smartOdonto.util.ConnectionFactory;

public class PacienteDAO { // CRUD >> DAO : data acess object .. oubjeto de acesso aos dados

	private Paciente paciente;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String nascimento;
	private CommonUtil dataParaMySql;
	
	
	public PacienteDAO() throws Exception{
		try {
			conn = ConnectionFactory.getConnection();
		}catch(Exception e) { 
			throw new Exception("erro" + e.getMessage());
		}
	}
	
	public void salvar(Paciente paciente) throws Exception {
		try {
			String sql ="INSERT INTO tbPaciente(cpf,nome,sexo,nascimento,"
					+ "tel,convenio,email,endereco,cidade,estado) "
					+ "values (?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,paciente.getCpf());					
			ps.setString(2, paciente.getNome());
			ps.setString(3, paciente.getSexo());
	      /*String dia = paciente.getNascimento().substring(0, 2);
			String mes = paciente.getNascimento().substring(3, 5);
			String ano = paciente.getNascimento().substring(6);
			nascimento = ano + mes + dia;*/
			nascimento = dataParaMySql.brazilianMysqlDate(paciente.getNascimento());
			ps.setString(4, nascimento);
			ps.setString(5, paciente.getTel());
			ps.setString(6, paciente.getConvenio());
			ps.setString(7, paciente.getEmail());
			ps.setString(8, paciente.getEndereco());
			ps.setString(9, paciente.getCidade());
			ps.setString(10, paciente.getEstado());
			ps.executeUpdate();
		}catch(Exception e) {
		throw new Exception ("Erro ao salvar" + e.getMessage());
		}
	}
	
	public void alterar (Paciente paciente) throws Exception {
		try {
		String sql = "UPDATE tbPaciente SET nome = ?,sexo = ?, nascimento = ?,tel = ?,"
				+ "convenio =?, email = ?, endereco = ?, cidade = ?, estado = ? WHERE cpf = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, paciente.getNome());
		ps.setString(2, paciente.getSexo());
		String dia = paciente.getNascimento().substring(0, 2);
		String mes = paciente.getNascimento().substring(3, 5);
		String ano = paciente.getNascimento().substring(6);
		nascimento = ano + mes + dia;
		ps.setString(3, nascimento);
		ps.setString(4, paciente.getTel());
		ps.setString(5, paciente.getConvenio());
		ps.setString(6, paciente.getEmail());
		ps.setString(7, paciente.getEndereco());
		ps.setString(8,paciente.getCidade());
		ps.setString(9,paciente.getEstado());
		ps.setString(10, paciente.getCpf());
		ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception ("Erro ao alterar Paciente" + e.getMessage());
		}
	}
	
	public void excluir (String cpf) throws Exception {
		try {
		String sql = "DELETE FROM tbPaciente WHERE cpf = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, cpf);
		ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro ao excluir Paciente" + e.getMessage());
		}
	}
	
	public List listarTodos() throws Exception {
		List<Paciente> lista = new ArrayList<Paciente>();
		try {
			ps = conn.prepareStatement("SELECT * FROM tbPaciente");//inserindo comando sql diretamente no PreparedStatment
			rs = ps.executeQuery();
			while(rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String nascimento = rs.getString("nascimento");
				String tel = rs.getString("tel");
				String convenio = rs.getString("convenio");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				paciente = new Paciente(cpf,nome,sexo,nascimento,tel,convenio,email,endereco,cidade,estado);
				lista.add(paciente);//adicionando paciente a lista.
			}
			return lista;
			
		}catch(Exception e) {
			throw new Exception ("Erro ao listar Pacientes" + e.getMessage());
			}
	}
	
	public Paciente consultar(String cpf) throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM tbPaciente "
					+ "WHERE cpf = ?");//inserindo comando sql diretamente no PreparedStatment
			ps.setString(1, cpf);
			rs = ps.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String nascimento = rs.getString("nascimento");
				String tel = rs.getString("tel");
				String convenio = rs.getString("convenio");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				paciente = new Paciente(cpf,nome,sexo,nascimento,tel,convenio,email,endereco,cidade, estado);
			}
			return paciente;
			
		}catch(Exception e) {
			throw new Exception ("Erro ao Consultar Paciente -> " + e.getMessage());
			}
		}

}
