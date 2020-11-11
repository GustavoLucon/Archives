package CalcularDistanciaPontos;

import javax.swing.JOptionPane;

public class Ponto {
	/*latitude = X 
	 *longitude = Y */
	private int X;
	private int Y;
	public Ponto()
	{
		X = Integer.parseInt(JOptionPane.showInputDialog("Digite a Latitude do Ponto"));
		Y = Integer.parseInt(JOptionPane.showInputDialog("Digite a Longitude do Ponto"));
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
}
