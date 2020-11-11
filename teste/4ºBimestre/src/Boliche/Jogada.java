package Boliche;

import javax.swing.JOptionPane;

public class Jogada {
private int numJogada ;
private int primeiro  ;
private int segundo;
private int terceiro;
private int pontos;
private int total;
private boolean spare;
private boolean strike;
public Jogada(){
	int controle = 1;
		primeiro = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pinos derrubada na Primeira jogada"));
		if(primeiro < 10)
		{
		segundo = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pinos derrubada na Segunda jogada"));
		}
		else
		{
			segundo = 0;
		}
		total = primeiro + segundo;
			while(total > 11 || total <= 0)
			{
				System.out.print("Numero Invalido");
				primeiro = Integer.parseInt(JOptionPane.showInputDialog("Digite novamente o valor da primeira jogada"));
				if(primeiro < 10)
				{
				segundo = Integer.parseInt(JOptionPane.showInputDialog("Digite novamente o valor da segunda jogada"));
				}
				else
				{
					segundo = 0;
				}
				}
	}	

public int getNumJogada() {
	return numJogada;
}
public void setNumJogada(int numJogada) {
	this.numJogada = numJogada;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
} 
public int getPrimeiro() {
	return primeiro;
}
public void setPrimeiro(int primeiro) {
	this.primeiro = primeiro;
}
public int getSegundo() {
	return segundo;
}
public void setSegundo(int segundo) {
	this.segundo = segundo;
}
public int getPontos() {
	return pontos;
}
public void setPontos(int pontos) {
	this.pontos = pontos;
}
public boolean isSpare() {
	return spare;
}
public void setSpare(boolean spare) {
	this.spare = spare;
}
public boolean isStrike() {
	return strike;
}
public void setStrike(boolean strike) {
	this.strike = strike;
}
public int getTerceiro() {
	return terceiro;
}

public void setTerceiro(int terceiro) {
	this.terceiro = terceiro;
}
}
