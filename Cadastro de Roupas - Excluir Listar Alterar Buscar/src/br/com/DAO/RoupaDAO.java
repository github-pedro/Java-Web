package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.Connection.ConnectionFactory;
import br.com.model.RoupaModel;




public class RoupaDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private ArrayList<RoupaModel> roupa = new ArrayList<RoupaModel>();
	private ArrayList<RoupaModel> filtrar = new ArrayList<RoupaModel>();
	
	public RoupaDAO(){
		connection = new ConnectionFactory().getConnection();
	}
	
	public boolean addRoupa(RoupaModel roupa) {
		String sql = "INSERT INTO roupa(tipo,marca,estoque,medida,compra,venda)values(?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, roupa.getTipo());
			ps.setString(2, roupa.getMarca());
			ps.setInt(3, roupa.getEstoque());
			ps.setString(4, roupa.getMedida());
			ps.setFloat(5, roupa.getVcompra());
			ps.setFloat(6, roupa.getVvenda());
			ps.execute();
			ps.close();
			return true;
		}catch(Exception error) {
			return false;
		}
	}
	public ArrayList<RoupaModel> mostrarRoupas(){
		String sql = "Select * from roupa";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				roupa.add(new RoupaModel(rs.getString("tipo"), rs.getString("marca"), rs.getInt("estoque"), rs.getString("medida"),rs.getFloat("compra"),rs.getFloat("venda"), rs.getInt("id_roupa")));
			}
		}catch(Exception error) {
			System.out.println("Erro "+error);
		}
		return roupa;
	}
	public void Deletar(int id){
		String sql = "DELETE FROM roupa WHERE id_roupa = ?";
		try {
			PreparedStatement preparador = connection.prepareStatement(sql);
			preparador.setInt(1, id);
			preparador.execute();
			preparador.close();

			System.out.println("Deletado com Sucesso!");
		} catch (Exception erro) {
			System.out.println("Erro - " + erro);
		}

	}
	public ArrayList<RoupaModel> filtrarRoupa(String filtro){
		String sql = "SELECT * FROM roupa WHERE tipo = '"+filtro+"' OR marca = '"+filtro+"' OR medida = '"+filtro+"'";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				filtrar.add(new RoupaModel(rs.getString("tipo"), rs.getString("marca"), rs.getInt("estoque"), rs.getString("medida"),rs.getFloat("compra"),rs.getFloat("venda"), rs.getInt("id_roupa")));
			}
		}catch(Exception error) {
			System.out.println("Erro "+error);
		}
		return filtrar;
	}
	public RoupaModel buscarporID(Integer id) {
		RoupaModel roupaRetorno = null;
		String sql = "select * from roupa where id_roupa=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		
			if (rs.next()) {
				roupaRetorno = new RoupaModel(rs.getString("tipo"), rs.getString("marca"), rs.getInt("estoque"), rs.getString("medida"),rs.getFloat("compra"),rs.getFloat("venda"), rs.getInt("id_roupa"));
			}
			System.out.println("Encontrado com sucesso!");
		} catch (Exception error) {
			System.out.println("Erro de SQL:" + error.getMessage());
		}
		return roupaRetorno;
	}
	public void Alterar(RoupaModel roupa) {
		String sql = "UPDATE roupa SET tipo = ?, marca = ?, estoque = ?, medida = ?, compra = ?, venda = ? where id_roupa = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, roupa.getTipo());
			ps.setString(2, roupa.getMarca());
			ps.setInt(3, roupa.getEstoque());
			ps.setString(4, roupa.getMedida());
			ps.setFloat(5, roupa.getVcompra());
			ps.setFloat(6, roupa.getVvenda());
			ps.setInt(7, roupa.getId());

			ps.execute();
			ps.close();

			System.out.println("Alterada com Sucesso!");
		} catch (Exception error) {
			System.out.println("Erro - " + error.getMessage());
		}

	}
	
	
}
