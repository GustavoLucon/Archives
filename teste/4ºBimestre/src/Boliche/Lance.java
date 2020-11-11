package Boliche;

import javax.swing.JOptionPane;

public class Lance {
	private int lances[];
	private int numlances;
	public Lance(){
		int total;
		lances = new int[21];	
	}
	public int[] getLances() {
		return lances;
	}
	public void setLances(int[] lances) {
		this.lances = lances;
	}

}
