package br.com.model;

public class RoupaModel {
	private String tipo;
	private String marca;
	private int estoque;
	private String medida;
	private float vcompra;
	private float vvenda;
	private int id;
	
	public RoupaModel(String tipo, String marca, int estoque, String medida, float vcompra, float vvenda, int id) {
		this.id = id;
		this.tipo = tipo;
		this.marca = marca;
		this.estoque = estoque;
		this.medida = medida;
		this.vcompra = vcompra;
		this.vvenda = vvenda;
	}
	
	public RoupaModel(String tipo, String marca, int estoque, String medida, float vcompra, float vvenda) {
		this.tipo = tipo;
		this.marca = marca;
		this.estoque = estoque;
		this.medida = medida;
		this.vcompra = vcompra;
		this.vvenda = vvenda;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public float getVcompra() {
		return vcompra;
	}

	public void setVcompra(float vcompra) {
		this.vcompra = vcompra;
	}

	public float getVvenda() {
		return vvenda;
	}

	public void setVvenda(float vvenda) {
		this.vvenda = vvenda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
