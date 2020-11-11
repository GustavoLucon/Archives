package Primeiros;
import javax.swing.JOptionPane;


public class trocado {
	public static void main (String args[]){
		{
			int recebido;
			int cont = 0;
			recebido = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero em centavos"));
			while(recebido - 100 >= 0 )
			{
				cont++;
			recebido = 	recebido - 100;
			}
			System.out.println(cont + " Moedas de 1,00 real");
			cont = 0;
			while(recebido - 50 >= 0 )
			{
				cont++;
			recebido = 	recebido - 50;
			}
			System.out.println(cont + " Moedas de 0,50 real");
			cont = 0;
			while(recebido - 25 >= 0 )
			{
				cont++;
			recebido = 	recebido - 25;
			}
			System.out.println(cont + " Moedas de 0,25 real");
			cont = 0;
			while(recebido - 10 >= 0 )
			{
				cont++;
			recebido = 	recebido - 10;
			}
			System.out.println(cont + " Moedas de 0,10 real");
			cont = 0;
			while(recebido - 5 >= 0 )
			{
				cont++;
			recebido = 	recebido - 5;
			}
			System.out.println(cont + " Moedas de 0,05 real");
			cont = 0;
			while(recebido - 1 >= 0 )
			{
				cont++;
			recebido = 	recebido - 1;
			}
			System.out.println(cont + " Moedas de 0,01 real");		
		}
}
}