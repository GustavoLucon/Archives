package PacienciaHungara;

import javax.swing.JOptionPane;

public class Paciencia {
	
	private static int local2 = 0;
	private static int cont = 0;
	private static int novo = 0;
	private static No campo[];
	
	   public static void main(String[] args) 
	   {
		   campo = new No[36];
		   campo[novo] = new No(local2);
		   local2 = local2 +1;
		   int Resposta = 1;
		   InserirCartas();

	while (Resposta != 0)
	{
		Resposta = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para continuar e 0 para sair"));
		if(Resposta != 0)
		{
			if(Comparar() == true)
			{
			if(ChegouAoFinal() != true)
			{
			CriarNovo();
			}
			}
		}	
	}
}
	   public static boolean Comparar() 
	   {
		   boolean a = true;
		   if(local2 != 1 || novo > 0)
		   {
		   String  comparado = campo[novo].resultado();
		   for (int b = 0; b < 36 ;b++)
		   {
			  if(campo[b] != null)
			  {
				  for (int i = 0; i < campo[b].Tamanho()+1 ;i++)
				  {
					  if(comparado.equals(campo[b].GetVetor(i)) && b != novo)
					  {
						  campo[novo].SetFilho(campo[i]);
						  a = false;  
						  System.out.println("Este ja existe \n Aqui os resultados: \n");
						  MostrarFinal();
						  InserirCartas();
						   return a;
					  }
				  }
			  }
		   }
		  }
		   return a;
	   }
	   public static void InserirCartas() 
	   {
		   int triangular;
		   int cartas;
		   triangular = Integer.parseInt(JOptionPane.showInputDialog("Digite o Numero triangular desejado 1 , 3 ,6 ,10"));
		   campo[novo].Dividir(1+Integer.parseInt(JOptionPane.showInputDialog("Digite o Numero de Montes Que Deseja Dividir")));
		   cartas = triangular;
		   while(cartas > 0)
		   {
		   	int local;
		   	int valor;
		   	valor = Integer.parseInt(JOptionPane.showInputDialog("Digite Quantas cartas deve-se separar"));
		   	local = Integer.parseInt(JOptionPane.showInputDialog("Digite em qual monte eles devem ficar"));
		   	campo[novo].Valores(valor, local);
		   	cartas = cartas - valor;
		   }
	   }
	   public static void CriarNovo()
	   {
		   campo[novo].Mostrar(cont);
			cont++;
			campo[novo].NovoNo();
			local2++;	
	   }
	   public static void MostrarFinal()
	   {
			int g =0;
			while(g <= campo[novo].Tamanho())
			{
				campo[novo].Mostrar(g);
				 g++;
			}
	   }
	   public static boolean ChegouAoFinal()
	   {
		   boolean teste = false;
		   if(campo[novo].GetVetor(local2-1).equals(",1,2,3,4") || campo[novo].GetVetor(local2-1).equals(",1,2,3") || campo[novo].GetVetor(local2-1).equals(",1,2") || campo[novo].GetVetor(local2-1).equals(",1"))
			{
				System.out.println("Voce chegou ao fim desta partida \n os resultados foram");
				MostrarFinal();
				int Resposta = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 Para ir a outra partida e 0 Para Sair"));
				if(Resposta == 1)
				{
				teste = true;
				novo++;
				local2 = 0;
				campo[novo] = new No(local2);
				local2++;
				InserirCartas();
				}
				else if(Resposta == 0)
				{
					System.exit(0);
				}
				else
				{
					System.out.println("Numero Invalido");
					System.exit(0);
				}
			}
		   return teste;
	   }
}
