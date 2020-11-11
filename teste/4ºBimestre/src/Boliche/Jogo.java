package Boliche;

import javax.swing.JOptionPane;

public class Jogo { 
private Jogada jogadas[];
private int corrente ;

public Jogo() { 
	jogadas = new Jogada[10];
	corrente = 1;
	for(int a = 0 ; a < 10 ;a++)
	{
	Pegar(a);
	}
	Total();
	imprimir();
}
public void Total(){
	int total;
	total = 0;
	for(int a = 0;a < 10;a++)
	{
		total = total + jogadas[a].getPontos();
		if(jogadas[a].isSpare())
		{
			total = total + jogadas[a].getPrimeiro();
		}
		else if(jogadas[a].isStrike())
		{
			if(a == 8)
			{
			total = total + jogadas[a].getPontos() + jogadas[a].getPrimeiro();
			}
			else if (a < 8)
			{
				total = total + jogadas[a].getPontos() + jogadas[a+1].getPontos();	
			}
		}
		jogadas[a].setTotal(total);
	}
}
public void Pegar(int a) {
	jogadas[a] = new Jogada();
	jogadas[a].setNumJogada(a+1);
	jogadas[a].setPontos(jogadas[a].getPrimeiro() + jogadas[a].getSegundo());		
if(jogadas[a].getPrimeiro() == 10)
{
	jogadas[a].setStrike(true);
}
else if(jogadas[a].getPontos() == 10)
{
	jogadas[a].setSpare(true);
}
if(a == 9)
{
	if(jogadas[a].isStrike())
	{
		jogadas[a].setSegundo(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pinos derrubada na Segunda jogada")));
	}
	int calculo;
	calculo = jogadas[a].getPontos(); 
	jogadas[a].setTerceiro(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pinos derrubada na Terceira jogada")));
	jogadas[a].setPontos(calculo + jogadas[a].getTerceiro() + jogadas[a].getSegundo());
}
}
public void imprimir(){
    for(int b= 0; b < 10;b++)
	{
		System.out.print(" " +jogadas[b].getNumJogada() + "  |");
	}
    System.out.println("");
    for(int b= 0; b < 10;b++)
	{
		System.out.print(jogadas[b].getPrimeiro() + "," + jogadas[b].getSegundo());
		if(b == 9)
		{
			System.out.print(","  +jogadas[b].getTerceiro() + "|" );	
		}
		else
		{
			System.out.print("|");
		}
	}
    System.out.println("");
    for(int b= 0; b < 10;b++)
	{
		System.out.print(" " + jogadas[b].getPontos() + " |");
	}
    System.out.println("");
    for(int b= 0; b < 10;b++)
	{
		System.out.print(" " + jogadas[b].getTotal() + " |");
	}
}
}
