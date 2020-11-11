package Noburo;

import javax.swing.JOptionPane;

public class TempoPorCiclo {
	public static void main(String args[])
	{
//Estress0();
//Estress1();
//Estress2();
//Estress3();

	}

	private static void Estress3() {
		long startTempo=System.currentTimeMillis();
		for(int i = 0; i < 10 ; i++)
		{
			for(int o = 0; o < 1000000000 ; o++)
			{
				int cont = 0;
				if(cont == 0)
				{
					cont = 1;
				}
				else
				{
					cont =0;
				}
				
			}
			
		}
		long startTempo2=System.currentTimeMillis();
		long total = startTempo2 - startTempo;
		JOptionPane.showMessageDialog(null, "Estress : Nivel 3 \n Tempo Total para 1000000000 \nAdicoes " + total + " Milesegundos", "Informação", JOptionPane.INFORMATION_MESSAGE);
		
	}

	private static void Estress2() {
		long startTempo=System.currentTimeMillis();
		for(int i = 0; i < 10 ; i++)
		{
			for(int o = 0; o < 1000000000 ; o++)
			{
			
			}
			
		}
		long startTempo2=System.currentTimeMillis();
		long total = startTempo2 - startTempo;
		JOptionPane.showMessageDialog(null, "Estress : Nivel 2 \n Tempo Total para 1000000000 \nAdicoes " + total + " Milesegundos", "Informação", JOptionPane.INFORMATION_MESSAGE);
		
	}

	private static void Estress1() {
		long startTempo=System.currentTimeMillis();
		for(int i = 0; i < 1000000000 ; i++)
		{
			int cont = 0;
			if(cont == 0)
			{
				cont = 1;
			}
			else
			{
				cont =0;
			}
			
		}
		long startTempo2=System.currentTimeMillis();
		long total = startTempo2 - startTempo;
		JOptionPane.showMessageDialog(null, "Estress : Nivel 1 \n Tempo Total para 1000000000 \nAdicoes " + total + " Milesegundos", "Informação", JOptionPane.INFORMATION_MESSAGE);
		
	}

	private static void Estress0() {
		long startTempo=System.currentTimeMillis();
		for(int i = 0; i < 1000000000 ; i++)
		{
			
		}
		long startTempo2=System.currentTimeMillis();
		long total = startTempo2 - startTempo;
		JOptionPane.showMessageDialog(null, "Estress : Nivel 0 \n Tempo Total para 1000000000 \n Adicoes " + total + " Milesegundos", "Informação", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
