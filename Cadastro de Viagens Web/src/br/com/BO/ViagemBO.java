package br.com.BO;

import java.util.ArrayList;

import br.com.DAO.ViagemDAO;
import br.com.model.ViagemModel;

public class ViagemBO {
	
	ViagemDAO viagemDAO = new ViagemDAO();
	public boolean addViagem(ViagemModel viagem) {
		return viagemDAO.addViagem(viagem);
	}
	public ArrayList<ViagemModel> mostrarViagem(){
		return viagemDAO.mostrarViagem();
	}
	public boolean Deletar(int id) {
		return viagemDAO.Deletar(id);
	}
	public ArrayList<ViagemModel> filtrarViagem(String filtro){
		return viagemDAO.filtrarViagem(filtro);
	}
	public ViagemModel buscarporRG(int id) {
		return viagemDAO.buscarporRG(id);
	}
	public boolean Alterar(ViagemModel viagem) {
		return viagemDAO.Alterar(viagem);
	}
}
