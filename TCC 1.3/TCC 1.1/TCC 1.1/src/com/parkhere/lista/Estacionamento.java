package com.parkhere.lista;

public class Estacionamento {

	private String NomeEstacionamento;
	private String endere�o;
	private double latitude;
	private double longitude;
	private double preco;
	private int vagas;
	private String opcionais;
	
	
	public void TESTANDO()
	{
		
		this.endere�o = "teste end";
		this.NomeEstacionamento = "teste nome";
		this.vagas = 1;
		this.opcionais = "";
		this.preco = 19.90;
		this.latitude = 1.0;
		this.longitude = 1.0;
		
				
	}
	
	
	
	public String getNomeEstacionamento() {
		return NomeEstacionamento;
	}
	public void setNomeEstacionamento(String nomeEstacionamento) {
		NomeEstacionamento = nomeEstacionamento;
	}
	public String getEndere�o() {
		return endere�o;
	}
	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getVagas() {
		return vagas;
	}
	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	public String getOpcionais() {
		return opcionais;
	}
	public void setOpcionais(String opcionais) {
		this.opcionais = opcionais;
	}
	
	
	
	
	
}
