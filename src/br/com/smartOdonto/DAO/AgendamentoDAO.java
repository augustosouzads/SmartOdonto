package br.com.smartOdonto.DAO;

import java.sql.Connection;        // classe que faz a conexão com BD
import java.sql.PreparedStatement; // permite executar comandos SQL no JAVA
import java.sql.ResultSet;         //tabela
import java.util.ArrayList;
import java.util.List;

import br.com.smartOdonto.model.Agendamento;
import br.com.smartOdonto.util.CommonUtil;
import br.com.smartOdonto.util.ConnectionFactory;

public class AgendamentoDAO { // CRUD >> DAO : data acess object .. oubjeto de acesso aos dados

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String dataAgendamento;
	private CommonUtil dataParaMySql;
	private Agendamento agendamento;
	
	
	public AgendamentoDAO() throws Exception{
		try {
			conn = ConnectionFactory.getConnection();
		}catch(Exception e) { 
			throw new Exception("erro" + e.getMessage());
		}
	}
	
	public void salvar(Agendamento agendamento) throws Exception {
		try {
			String sql ="INSERT INTO tbAgendamento(data,horario,tratamento,cpf) "
					+ "values (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			//convertendo (manualmente) data dia/mes/ano para data no formato MySQL yyyy/mm/dd
			/*
			  String dia = agendamento.getData().substring(0, 2);
			  String mes = agendamento.getData().substring(3, 5);
			  String ano = agendamento.getData().substring(6);
			  dataAgendamento = ano + mes + dia;
			*/
			dataAgendamento = dataParaMySql.brazilianMysqlDate(agendamento.getData());
			ps.setString(1, dataAgendamento);
			ps.setString(2, agendamento.getHorario());
			ps.setInt(3, agendamento.getTratamentoAgenda());
			ps.setString(4, agendamento.getCpfAgenda());
			ps.executeUpdate();
		}catch(Exception e) {
		throw new Exception ("Erro ao agendar ->" + e.getMessage());
		}
	}
	
	public void alterar (Agendamento agendamento) throws Exception {
		try {
		String sql = "UPDATE tbAgendamento SET data = ?,horario = ?, tratamento = ? "
				+ "WHERE cpf = ?";
		ps = conn.prepareStatement(sql);
		dataAgendamento = dataParaMySql.brazilianMysqlDate(agendamento.getData());
		ps.setString(1, dataAgendamento);
		ps.setString(2, agendamento.getHorario());
		ps.setInt(3, agendamento.getTratamentoAgenda());
		ps.setString(4, agendamento.getCpfAgenda());
		ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception ("Erro ao alterar agendamento" + e.getMessage());
		}
	}
	
	public void excluir (String cpf) throws Exception {
		try {
		String sql = "DELETE FROM tbAgendamento WHERE cpf = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, cpf);
		ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro ao cancelar agendamento ->" + e.getMessage());
		}
	}
	
	public List listarTodos() throws Exception {
		List<Agendamento> lista = new ArrayList<Agendamento>();
		try {
			ps = conn.prepareStatement("SELECT * FROM tbAgendamento");//inserindo comando sql diretamente no PreparedStatment
			rs = ps.executeQuery();
			while(rs.next()) {
				int codAgendamento = rs.getInt("codAgendamento");
				String data = rs.getString("data");
				String horario = rs.getString("horario");
				int tratamento = rs.getInt("tratamento");
				String cpf = rs.getString("cpf");
				agendamento = new Agendamento(codAgendamento,data,horario,tratamento,cpf);
				lista.add(agendamento);//adicionando paciente a lista.
			}
			return lista;
			
		}catch(Exception e) {
			throw new Exception ("Erro ao listar agendamentos ->" + e.getMessage());
			}
	}
	
	public Agendamento consultar(String cpf) throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM tbAgendamento "
					+ "WHERE cpf = ?");//inserindo comando sql diretamente no PreparedStatment
			ps.setString(1, cpf);
			rs = ps.executeQuery();
			if(rs.next()) {
				int codAgendamento = rs.getInt("codAgendamento");
				String data = rs.getString("data");
				String horario = rs.getString("horario");
				int tratamento = rs.getInt("tratamento");
				agendamento = new Agendamento(codAgendamento,data,horario,tratamento,cpf);
			}
			return agendamento;
			
		}catch(Exception e) {
			throw new Exception ("Erro ao consultar agendamento -> " + e.getMessage());
			}
		}

}
