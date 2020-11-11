/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sodoku;

/**
 *
 * @author 35895842895
 */
public class espaco {
	private int X;
	private int Y;
	private int local;
	private int Valor = 0;
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
	public int getValor() {
		return Valor;
	}
	public void setValor(int valor) {
		Valor = valor;
	}
	public void setLocal(int local) {
		this.local = local;
	}
	public int getLocal() {
		return local;
	}
}
