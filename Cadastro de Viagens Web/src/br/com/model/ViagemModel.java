package br.com.model;

import java.sql.Date;

public class ViagemModel {
	private int id;
	private String planejamento; 
	private String destino;
	private String estado;
	private String cidade;
	private Date dataSaida; 
	private Date dataVolta; 
	private double gasto; 
	private String descricao;

	public ViagemModel(String planejamento, String destino, String estado, String cidade, Date dataSaida,
			Date dataVolta, double gasto, String descricao) {
		super();
		this.planejamento = planejamento;
		this.destino = destino;
		this.estado = estado;
		this.cidade = cidade;
		this.dataSaida = dataSaida;
		this.dataVolta = dataVolta;
		this.gasto = gasto;
		this.descricao = descricao;
	}

	public ViagemModel(int id, String planejamento, String destino, String estado, String cidade, Date dataSaida,
			Date dataVolta, double gasto, String descricao) {
		super();
		this.id = id;
		this.planejamento = planejamento;
		this.destino = destino;
		this.estado = estado;
		this.cidade = cidade;
		this.dataSaida = dataSaida;
		this.dataVolta = dataVolta;
		this.gasto = gasto;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanejamento() {
		return planejamento;
	}

	public void setPlanejamento(String planejamento) {
		this.planejamento = planejamento;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Date getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}

	public double getGasto() {
		return gasto;
	}

	public void setGasto(double gasto) {
		this.gasto = gasto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
	
	
}
