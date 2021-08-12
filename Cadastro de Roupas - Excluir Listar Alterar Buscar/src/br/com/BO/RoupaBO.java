package br.com.BO;

import java.util.ArrayList;

import br.com.DAO.RoupaDAO;
import br.com.model.RoupaModel;

public class RoupaBO {
	RoupaDAO roupaDAO = new RoupaDAO();
	
	public boolean addRoupa(RoupaModel roupa) {
		return roupaDAO.addRoupa(roupa);
	}
	public ArrayList<RoupaModel> mostrarRoupas(){
		return roupaDAO.mostrarRoupas();
	}
	public void Deletar(int id) {
		roupaDAO.Deletar(id);
	}
	public ArrayList<RoupaModel> filtrarRoupa(String filtro){
		return roupaDAO.filtrarRoupa(filtro);
	}
	public RoupaModel buscarporID(Integer id) {
		return roupaDAO.buscarporID(id);
	}
}
