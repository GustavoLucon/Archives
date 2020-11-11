package CalcularDistanciaPontos;

public class Segmento {
	private double distancia;
	public Segmento()
	{
		double auxiliar1;
		double auxiliar2;
		Ponto[] ponto = new Ponto[2];
		System.out.println("Voce vai inserir as informações do Ponto A");
		ponto[0] = new Ponto();
		System.out.println("Voce vai inserir as informações do Ponto B");
		ponto[1] = new Ponto();
		auxiliar1 = (ponto[0].getX() - ponto[1].getX());
		auxiliar2 = (ponto[0].getY()- ponto[1].getY());
		distancia =  Math.sqrt(Math.pow(auxiliar1,2) + Math.pow(auxiliar2,2));
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
}
