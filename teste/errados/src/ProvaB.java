import java.util.Random;
import javax.swing.*;

import Primeiros.Fila1;
import Primeiros.Impar;
import Primeiros.Multi;
import Primeiros.Par;

class Prova
{
	public static void main (String args[])
	 {
		int aux;
		Fila1 fil = new Fila1(50);
		Multi multi = new Multi();
		Par par = new Par();
		Impar impar = new Impar();
		Random random = new Random();
		int randomico = random.nextInt();
		Fila1.class.getClasses();
		aux = Integer.parseInt(JOptionPane.showInputDialog ("Digite 1 para Fila vazia 2 para fila cheia 3 para enfileirar 4 para desenfileirar e 5 para elemento do inicio e 6 para mostrar a fila 7 ou mais para sair"));
		while(aux >0  && aux < 7 )
		{
		if (aux == 1)
		{
			Fila1.Fila1Vazia();
		}
		else if (aux == 2)
		{
			if(Fila1.Fila1Cheia());
			{
			for (int i=0 ; i < 51 ; i++)
			{
				impar.ElementoInicio();
				par.ElementoInicio();
				Fil.ElementoInicio();
				if ((impar.ElementoInicio()/3) *3 == impar.ElementoInicio() || (impar.ElementoInicio()/5) *5 == impar.ElementoInicio() || (impar.ElementoInicio()/7) *7 == impar.ElementoInicio())
				{
				multi.Enfileirar(impar.ElementoInicio()) ;	
				}
				else if ((par.ElementoInicio()/3) *3 == par.ElementoInicio()|| (par.ElementoInicio()/5) *5 == par.ElementoInicio() || (par.ElementoInicio()/7) *7 == par.ElementoInicio())
				{
				multi.Enfileirar(par.ElementoInicio()) ;	
				}
				else if ((Fil.ElementoInicio()/3) *3 == Fil.ElementoInicio()|| (Fil.ElementoInicio()/5) *5 == Fil.ElementoInicio()|| (Fil.ElementoInicio()/7) *7 == Fil.ElementoInicio())
				{
				multi.Enfileirar(Fil.ElementoInicio()) ;	
				}
				else
				{
				multi.Desenfileirar() ;
				}
				impar.Desenfileirar() ;
				par.Desenfileirar() ;
				Fila1.Desenfileirar() ;
			}
			multi.MostrarFila1() ;
			}
		}
		else if (aux == 3)
		{
			if((randomico/2) * 2 == randomico)
			{
				par.Enfileirar(Randomico) ;
				
			}
			else
			{
				impar.Enfileirar(Randomico) ;
			}
			Fil.Enfileirar(Randomico) ;
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
			Fil.MostrarFila1( );
		}
		else 
		{
			System.exit(0);
		}
		}
	 }

}