package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.connection.ConnectionFactory;
import br.com.model.ViagemModel;

public class ViagemDAO {
	private Connection connection;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private ArrayList<ViagemModel> viagem = new ArrayList<ViagemModel>();
	private ArrayList<ViagemModel> filtrar = new ArrayList<ViagemModel>();
	
	public ViagemDAO(){
		connection = new ConnectionFactory().getConnection();
	}
	
	public boolean addViagem(ViagemModel viagem) {
		String sql = "INSERT INTO viagem(planejamento,destino,estado,cidade,dataSaida,dataVolta,gasto,descricao)values(?,?,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, viagem.getPlanejamento());
			ps.setString(2, viagem.getDestino());
			ps.setString(3, viagem.getEstado());
			ps.setString(4, viagem.getCidade());
			ps.setDate(5, viagem.getDataSaida());
			ps.setDate(6, viagem.getDataVolta());
			ps.setDouble(7, viagem.getGasto());
			ps.setString(8, viagem.getDescricao());
			ps.execute();
			ps.close();
			return true;
		}catch(Exception error) {
			return false;
		}
	}
	public ArrayList<ViagemModel> mostrarViagem(){
		String sql = "Select * from viagem";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				viagem.add(new ViagemModel(rs.getInt("id"), rs.getString("planejamento"), rs.getString("destino"),rs.getString("estado"),rs.getString("cidade"), rs.getDate("dataSaida"),rs.getDate("dataVolta"),rs.getDouble("gasto"), rs.getString("descricao")));
			}
		}catch(Exception error) {
			System.out.println("Erro "+error);
		}
		return viagem;
	}
	public boolean Deletar(int id){
		String sql = "DELETE FROM viagem WHERE id = ?";
		try {
			PreparedStatement preparador = connection.prepareStatement(sql);
			preparador.setInt(1, id);
			preparador.execute();
			preparador.close();

			System.out.println("Deletado com Sucesso!");
			return true;
		} catch (Exception erro) {
			System.out.println("Erro - " + erro);
			return false;
		}
		
	}
	public ArrayList<ViagemModel> filtrarViagem(String filtro){
		String sql = "SELECT * FROM viagem WHERE id = '"+filtro+"' OR planejamento = '"+filtro+"' OR destino = '"+filtro+"'OR estado = '"+filtro+"' OR cidade = '"+filtro+"' OR gasto = '"+filtro+"' OR descricao = '"+filtro+"'";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				filtrar.add(new ViagemModel(rs.getInt("id"), rs.getString("planejamento"), rs.getString("destino"),rs.getString("estado"),rs.getString("cidade"), rs.getDate("dataSaida"),rs.getDate("dataVolta"),rs.getDouble("gasto"), rs.getString("descricao")));
			}
		}catch(Exception error) {
			System.out.println("Erro "+error);
		}
		return filtrar;
	}
	public ViagemModel buscarporRG(int id){
		ViagemModel viagemRetorno = null;
		String sql = "select * from viagem where id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		
			if (rs.next()) {
				viagemRetorno = new ViagemModel(rs.getInt("id"), rs.getString("planejamento"), rs.getString("destino"),rs.getString("estado"),rs.getString("cidade"), rs.getDate("dataSaida"),rs.getDate("dataVolta"),rs.getDouble("gasto"), rs.getString("descricao"));
			}
			System.out.println("Encontrado com sucesso!");
		} catch (Exception error) {
			System.out.println("Erro de SQL:" + error.getMessage());
		}
		return viagemRetorno;
	}
	public boolean Alterar(ViagemModel viagem) {
		String sql = "UPDATE viagem SET planejamento = ?, destino = ?, cidade = ?, estado = ?, dataSaida = ?, dataVolta = ?, gasto = ?, descricao = ? where id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, viagem.getPlanejamento());
			ps.setString(2, viagem.getDestino());
			ps.setString(3, viagem.getEstado());
			ps.setString(4, viagem.getCidade());
			ps.setDate(5, viagem.getDataSaida());
			ps.setDate(6, viagem.getDataVolta());
			ps.setDouble(7, viagem.getGasto());
			ps.setString(8, viagem.getDescricao());
			ps.setInt(9, viagem.getId());

			ps.execute();
			ps.close();

			System.out.println("Alterada com Sucesso!");
			return true;
		} catch (Exception error) {
			System.out.println("Erro - " + error.getMessage());
			return false;
		}
	}
}
