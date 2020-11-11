package Primeiros;
import javax.swing.*;
import java.util.Random;

public class Adivinhacoes {
	
	public static void main (String args[])
	{
		int fornecido ;
		Random random = new Random();
		int randomico = random.nextInt(50);
		if (randomico > 0 && randomico < 51)
		{
			System.out.println("Estou Pensando Em Um Numero Entre 1 e 50 . Adivinhe .");
					for(int cont = 1 ; cont < 6 ; cont++ )
			{
			fornecido = Integer.parseInt(JOptionPane.showInputDialog (null ,cont + "º tentativa"));
			if(fornecido <= 50 && fornecido > 0)
				{
				if(randomico == fornecido)
			{
				System.out.println("Voce acertou");
				cont = 10;
			}
			else if (randomico > fornecido)
			{
				System.out.println("Tente aumentar o numero");
			
			}
			else if (randomico < fornecido)
			{
				System.out.println("Tente diminuir o numero");
			
			}
			else if (cont == 5 && randomico != fornecido)
			{
				System.out.println("Voce Perdeu o numero era " + randomico );
			}
				}
			else
			{
				System.out.println("Numero invalido Tente novamente" );
				cont--;
			}
			}					
		}
	}
}
