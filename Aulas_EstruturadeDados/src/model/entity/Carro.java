package model.entity;

public class Carro {
	private int idCarro;
	private int numeroChassi;
	private String placa;
	private String modelo;
	private String marca;
	private double valor;
	
	public Carro() {
		
	}
	
	public Carro(int numeroChassi, String placa, String modelo, String marca, double valor) {
		this.numeroChassi = numeroChassi;
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.valor = valor;
	}

	public int getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public int getNumeroChassi() {
		return numeroChassi;
	}
	public void setNumeroChassi(int numeroChassi) {
		this.numeroChassi = numeroChassi;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

}
