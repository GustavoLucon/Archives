package Primeiros;
import javax.* ;
import javax.swing.JOptionPane;
import java.util.Random;

public class Fil extends ProvaB {

	  public static int vetor[] = new int[50]; 
	  public static int indice = 1;

	 public static void main (String args[])
	 {
		int aux = 0 ;
		Random random = new Random();
		int randomico = random.nextInt(50);
		Fila1.class.getClasses();
		System.out.print("Digite 1 para Fila vazia 2 para fila cheia 3 para enfileirar 4 para desenfileirar e 5 para elemento do inicio e 6 para mostrar a fila 7 ou mais para sair");
		if (aux == 1)
		{
			
		}
		else if (aux == 2)
		{
			Fil.Fila1Cheia();
		}
		else if (aux == 3)
		{
			Fil.Enfileirar(rand);
		}
		else if (aux == 4)
		{
			Fil.Desenfileirar() ;
		}
		else if (aux == 5)
		{
			Fil.ElementoInicio();
		}
		else if (aux == 6)
		{
			Fil.MostrarFila1( )
		}
		else (aux > 6 || aux < 1)
		{
			System.exit(0);
		}
		
	 }
	}






