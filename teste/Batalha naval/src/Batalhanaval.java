import javax.swing.*;
import java.util.Random;

public class Batalhanaval {
	public static void printamatriz(String matriz[][])
	{
		System.out.print("  1 2 3 4 5 6 7 8 ");
		System.out.println("");
		for (int k = 0 ; k < 8 ; k++)
		{
			System.out.print(k+1);
			for (int l = 0 ; l < 8 ; l++)
			{
				
		
			System.out.print("|" + matriz[k][l]);
				
			}
			System.out.println("");
			System.out.println("  ---------------");
		}
	}
	public static void fim(String matriz[][])
	{
		System.out.print("  1 2 3 4 5 6 7 8 ");
		System.out.println("");
		for (int k = 0 ; k < 8 ; k++)
		{
			System.out.print(k+1);
			for (int l = 0 ; l < 8 ; l++)
			{
				
		
			System.out.print("|" + matriz[k][l]);
				
			}
			System.out.println("");
			System.out.println("  ---------------");
		}
	}
	static void limpar()
	{
		for(int limpeza = 0 ; limpeza < 12 ; limpeza++)
		{
		System.out.println("");
		}	
	}
	public static void enchermatrizes(String matriz1[][] ,String matriz2[][])
	{
		for (int i = 0 ; i < 8 ; i++)
		{
			for (int j = 0 ; j < 8 ; j++)
			{
			matriz1[i][j] = "*" ;	
			}
		}
		for (int i = 0 ; i < 8 ; i++)
		{
			for (int j = 0 ; j < 8 ; j++)
			{
			matriz2[i][j] = "O" ;	
			}
		}
	}
	public static void main (String args[]){
    String campo[][] = new String[9][9] ;
    String validar ;
    String validar2 ;
    String subs[][] = new String[9][9] ;
    int longitude ;
    int latitude ;
    int atingidos ;
    atingidos = 0 ;
    System.out.println("Bem Vindo ao jogo de Batalha Naval \nHá 10 submarinos escondidos aqui \nEncontre-os para ganhar \nVoce tem 32 tentativas");
    enchermatrizes(campo,subs);
	for(int posicoes = 0 ; posicoes <= 10 ; posicoes++)
	{
		Random random = new Random();
		Random random2 = new Random() ;
		longitude = random.nextInt(8);
		latitude = random2.nextInt(8);
	    if (subs[longitude][latitude] != "O")
		{
		subs[longitude][latitude] = "X" ;	
		}
	}
	for(int tentativas = 1 ;tentativas <= 32 && atingidos < 10 ;tentativas++)
	{
	printamatriz(campo);
	validar = JOptionPane.showInputDialog (null , "Digite a linha do tabuleiro");
	validar2 =JOptionPane.showInputDialog (null , "Digite a coluna do tabuleiro");
	if(validar != "" && validar2 != "")
	{	
	longitude = Integer.parseInt(validar);
	latitude = Integer.parseInt(validar2);
	if(longitude >= 1 && longitude-1 < 8 && latitude >= 1 && latitude-1 < 8)
	{
		if(campo[longitude-1][latitude-1] == "*")
		{
		campo[longitude-1][latitude-1] = subs[longitude-1][latitude-1];
		limpar();
		if (subs[longitude-1][latitude-1] == "O")
			{
			System.out.println("Agua");
			}
			else
			{
			System.out.println("Acertou");
			atingidos++;
			}
		}
		else
		{
			System.out.println("Voce ja atirou ai");
			tentativas--;
		}
	System.out.println("Voce esta na rodada Nº" + tentativas);
	}
	else
	{
		System.out.println("Numero incorreto digite novamente");
		tentativas--;
	}
	}
	else
	{
		System.out.println("Digite algum numero");
		tentativas--;
	}
	}
	System.out.println("Revelando o campo de Batalha");
	fim(subs);
	System.out.println("Voce atingiu " + atingidos + " submarinos");
	if(atingidos == 10)
	{
		System.out.println("Voce Ganhou");
	}
	else
	{
		System.out.println("Voce perdeu , tente novamente");
	}
}		
}
  
