package Primeiros;
import java.util.Random;

import javax.swing.JOptionPane;


public class Adivinha�aoInfScore {
	public static void main (String args[])
	{
		int auxiliar;
		int fornecido ;
		int resposta = 0;
		int tentativas = 0;
		int score[] = new int[10];
		for (int i = 0 ; i < 10 ; i++)
		{

			score[i] = 100 ;	
		}
		Random random = new Random();
		while (resposta == 0)
			{
			int randomico = random.nextInt(50);
		if (randomico > 0 && randomico < 51)
		{
			System.out.println("Estou Pensando Em Um Numero Entre 1 e 50 . Adivinhe .");
			for(int cont = 1 ; cont < 100 ; cont++ )
			{
			fornecido = Integer.parseInt(JOptionPane.showInputDialog (null ,cont + "� tentativa"));
			if(fornecido <= 50 && fornecido > 0)
				{
				if(randomico == fornecido)
			{
				System.out.println("Voce acertou");
				tentativas = cont;
				cont = 100;
			}
			else if (randomico > fornecido)
			{
				System.out.println("Tente aumentar o numero");
			
			}
			else if (randomico < fornecido)
			{
				System.out.println("Tente diminuir o numero");
			
			}
			else
			{
				System.out.println("Numero invalido Tente novamente" );
				cont--;
			}
			}
			}
		}
		for(int b=0 ; b < 10 ;b++)
		{
			for(int t=0 ; t < 10 ; t++)
			{
			if(score[b] > tentativas )
			{
				auxiliar = score[b];
				score[b] = tentativas;
				tentativas = auxiliar ;
			}
			}
		}
		resposta  = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite 0 se quiser continuar e 1 se nao"));
		
		}
		System.out.println("Os 10 melhores records s�o");
		for(int b=0 ; b < 10 ;b++)
		{
			System.out.println( b + 1 + "� lugar o score � " + score[b]);
		}
		
	}
}
