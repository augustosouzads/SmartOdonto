package br.com.smartOdonto.DAO;

import java.sql.Connection;        // classe que faz a conexão com BD
import java.sql.PreparedStatement; // permite executar comandos SQL no JAVA
import java.sql.ResultSet;         //tabela
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.smartOdonto.model.Paciente;
import br.com.smartOdonto.model.Tratamento;
import br.com.smartOdonto.util.CommonUtil;
import br.com.smartOdonto.util.ConnectionFactory;

public class TratamentoDAO { // CRUD >> DAO : data acess object .. oubjeto de acesso aos dados
	
	private Tratamento tratamento;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String nascimento;
	private CommonUtil dataParaMySql;
	
	public TratamentoDAO() throws Exception{
		try {
			conn = ConnectionFactory.getConnection();
		}catch(Exception e) { 
			throw new Exception("erro" + e.getMessage());
		}
	}
	
	public void salvar(Tratamento tratamento) throws Exception {
		try {
			String sql ="INSERT INTO tbTratamento(CodTratamento,tratamento,tipo,valor) "
					+ "values (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,tratamento.getCodTratamento());					
			ps.setString(2, tratamento.getTratamento());
			ps.setString(3, tratamento.getTipo());
	      	ps.setDouble(4, tratamento.getValor());
			ps.executeUpdate();
		}catch(Exception e) {
		throw new Exception ("Erro ao salvar tratamento!" + e.getMessage());
		}
	}
	
	public void alterar (Tratamento tratamento) throws Exception {
		try {
		String sql = "UPDATE tbTratamento SET tratamento = ?,tipo = ?, valor =? WHERE codTratamento = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, tratamento.getTratamento());
		ps.setString(2, tratamento.getTipo());
		ps.setDouble(3, tratamento.getValor());
		ps.setInt(4, tratamento.getCodTratamento());
		ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception ("Erro ao alterar tratamento" + e.getMessage());
		}
	}
	
	public void excluir (int codTratamento) throws Exception {
		try {
		String sql = "DELETE FROM tbTratamento WHERE codTratamento = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, codTratamento);
		ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro ao excluir tratamento" + e.getMessage());
		}
	}
	
	public List listarTodos() throws Exception {
		List<Tratamento> lista = new ArrayList<Tratamento>();
		try {
			ps = conn.prepareStatement("SELECT * FROM tbTratamento");//inserindo comando sql diretamente no PreparedStatment
			rs = ps.executeQuery();
			while(rs.next()) {
				int codTratamento = rs.getInt("codTratamento");
				String tratamen = rs.getString("tratamento");
				String tipo = rs.getString("tipo");
				double valor = rs.getDouble("valor");
				tratamento = new Tratamento(codTratamento,tratamen,tipo,valor);
				lista.add(tratamento);//adicionando leitor a lista.
			}
			return lista;
			
		}catch(Exception e) {
			throw new Exception ("Erro ao listar tratamento" + e.getMessage());
			}
	}
	
	public Tratamento consultar(int codTratamento) throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM tbtratamento "
					+ "WHERE codTratamento = ?");//inserindo comando sql diretamente no PreparedStatment
			ps.setInt(1, codTratamento);
			rs = ps.executeQuery();
			if(rs.next()) {
				String tratamen = rs.getString("tratamento");
				String tipo = rs.getString("tipo");
				double valor = rs.getDouble("valor");				
				tratamento = new Tratamento(codTratamento,tratamen,tipo,valor);
			}
			return tratamento;
			
		}catch(Exception e) {
			throw new Exception ("Erro ao Consultar tratamento -> " + e.getMessage());
			}
		}

}
