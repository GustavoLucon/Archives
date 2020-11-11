package BatalhaNaval;
import javax.swing.*;
import java.util.Random;

public class provaPratica {
	public static void preencher_vetor(int matriz[])
	{
		for (int i = 0 ; i < 20 ; i++)
		{
			matriz[i] = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite seu " + i + "º numero"));
			
		}
	}
	public static void exibir_vetor(int matriz[])
	{
		for (int i = 0 ; i < 20 ; i++)
		{
			System.out.print(matriz[i] + "|");
		}
		System.out.println("");
	}
	public static void soma_vetor(int matriz[])
	{
		int primeiro;
		int ultimo;
		int resultado;
		resultado = 0;
		primeiro = 0 ;
		ultimo = matriz.length - 1;
		for (int i = 0 ; i < 10 ; i++)
		{
       resultado  = matriz[primeiro] - matriz[ultimo] + resultado;
       primeiro++;
       ultimo--;
		if(i == 9)
		{
		resultado  = resultado * -1 ;
		System.out.println("");
		System.out.println("O resultado é " + resultado);
		}
		}
	}
	public static void main (String args[])
	{
		 int vetor[] = new int[20] ;
		 int resposta ;
		do
		 {
		 resposta = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite a opção equivalente \n 1 = Preencher o vetor \n 2 = Mostrar os elementos do vetor \n 3 = Somar os elementos do vetor  \n 4 = Encerrar"));
	     if(resposta == 1)
		 {
	    	 preencher_vetor(vetor); 
		 }
		 else if (resposta == 2)
		 {
			 exibir_vetor(vetor);
		 }
		 else if (resposta == 3)
		 {
			 soma_vetor(vetor);
		 }
		 else if ( resposta < 4)
		 {
			 System.out.println("Numero Invalido");
		 }
		 else
		 {
			 System.out.println("");
			 System.out.println("Adeus");
		 }
		 }while(resposta != 4);
		}
	}

