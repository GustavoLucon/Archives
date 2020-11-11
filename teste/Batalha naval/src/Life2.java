import javax.swing.*;

public class Life2 {
	public static void lermatriz(String matriz[][], int numero , String backu[][])
	{
		int vizinhos;
		vizinhos = 0;

			for (int j =0 ; j <matriz.length ; j++)
			{
				for (int k = 0 ; k < matriz[0].length ; k++)
				{
					contarvizinhos(matriz,backu , vizinhos , k , j);
				}
				}
			}
	public static void gerarbackup(String matriz2[][], String backup[][])
	{
		for (int j =0 ; j <matriz2.length ; j++)
			{
				for (int k = 0 ; k < matriz2[0].length ; k++)
				{
				backup[j][k] = matriz2[j][k];
				}
				}
			}
	public static void printamatriz(String matriz[][])
	{
		System.out.print(" ");
		for (int i = 0 ; i < matriz[0].length ; i++)
		{
			System.out.print(i);
		}
		for (int k = 0 ; k < matriz.length ; k++)
		{
			System.out.print("\n" + k);
			for (int l = 0 ; l < matriz[0].length ; l++)
			{
			System.out.print(matriz[k][l]);
			}
		}
		System.out.println("\n- = Bacteria Morta \n* = Bacteria");
	}
	public static void enchermatriz(String matriz[][])
	{
		for (int i = 0 ; i < matriz.length ; i++)
		{
			for (int j = 0 ; j < matriz[0].length ; j++)
			{
			matriz[i][j] = "-" ;	
			}
		}
	}
		public static void contarvizinhos(String backup[][] ,String matriz[][] ,  int vizinho , int k , int j)
		{	
		int vivo ;
		if(backup[j][k] == "*")
		{
			vivo = 1;
		}
		else
		{
			vivo = 0;
		}
		vizinho = 0;
		int tamanho ;
		int tamanho2 ;
		tamanho2 = matriz.length -1;
		tamanho = matriz[0].length -1  ;
			if(j == 0 && k == 0)
			{
			if (matriz[j+1][k+1] == "*")
			{
				vizinho++;
			}
			if (matriz[j][k+1] == "*")
			{
				vizinho++;
			}
			if (matriz[j+1][k] == "*")
			{
				vizinho++;
			}
		}
			else if (j == tamanho && k == tamanho2)
			{
				if (matriz[j-1][k-1] == "*")
				{
					vizinho++;
				}
				if (matriz[j][k-1] == "*")
				{
					vizinho++;
				}
				if (matriz[j-1][k] == "*")
				{
					vizinho++;
				}
			}
			else if (j == 0 && k == tamanho2)
			{
				if (matriz[j][k-1] == "*")
				{
					vizinho++;
				}
				if (matriz[j+1][k] == "*")
				{
					vizinho++;
				}
				if (matriz[j+1][k-1] == "*")
				{
					vizinho++;
				}
				
			}
			else if (k == 0 && j == tamanho)
			{
				if (matriz[j][k+1] == "*")
				{
					vizinho++;
				}
				if (matriz[j-1][k] == "*")
				{
					vizinho++;
				}
				if (matriz[j-1][k+1] == "*")
				{
					vizinho++;
				}
				
			}
		else if (j == 0 && k != 0 && k != tamanho2)
		{
			if (matriz[j][k-1] == "*")
			{
				vizinho++;
			}
			if (matriz[j][k+1] == "*")
			{
				vizinho++;
			}
			if (matriz[j+1][k] == "*")
			{
				vizinho++;
			}
			if (matriz[j+1][k+1] == "*")
			{
				vizinho++;
			}
			if (matriz[j+1][k-1] == "*")
			{
				vizinho++;
			}
		}
		else if (k == 0 && j!= 0 && j != tamanho2)
		{
			if (matriz[j-1][k] == "*")
			{
				vizinho++;
			}
			if (matriz[j+1][k] == "*")
			{
				vizinho++;
			}
			if (matriz[j][k+1] == "*")
			{
				vizinho++;
			}
			if (matriz[j+1][k+1] == "*")
			{
				vizinho++;
			}
			if (matriz[j-1][k+1] == "*")
			{
				vizinho++;
			}
		}
		else if (k == tamanho2 && j != 0 && j != tamanho )
		{
			if (matriz[j-1][k] == "*")
			{
				vizinho++;
			}
			if (matriz[j+1][k] == "*")
			{
				vizinho++;
			}
			if (matriz[j-1][k-1] == "*")
			{
				vizinho++;
			}
			if (matriz[j][k-1] == "*")
			{
				vizinho++;
			}
			if (matriz[j+1][k-1] == "*")
			{
				vizinho++;
			}
		}
		else if (j == tamanho && k != 0 && k != tamanho2 )
		{
			if (matriz[j][k+1] == "*")
			{
				vizinho++;
			}
			if (matriz[j][k-1] == "*")
			{
				vizinho++;
			}
			if (matriz[j-1][k+1] == "*")
			{
				vizinho++;
			}
			if (matriz[j-1][k-1] == "*")
			{
				vizinho++;
			}
			if (matriz[j-1][k] == "*")
			{
				vizinho++;
			}
		}
		
			else
			{
				    if (matriz[j-1][k-1] == "*")
					{
						vizinho++;
					}
					if (matriz[j][k-1] == "*")
					{
						vizinho++;
					}
					if (matriz[j+1][k-1] == "*")
					{
						vizinho++;
					}
					if (matriz[j-1][k] == "*")
					{
					vizinho++;
					}
					if (matriz[j+1][k] == "*")
					{
					vizinho++;
					}
					if (matriz[j-1][k+1] == "*")
					{
						vizinho++;
					}
					if (matriz[j][k+1] == "*")
					{
						vizinho++;
					}
					if (matriz[j+1][k+1] == "*")
					{
						vizinho++;
					}
			}
			if(vivo == 1)
			{
			if(vizinho < 2)
			{
				backup[j][k] = "-";
			}
			
			if (vizinho >= 4)
			{
				backup[j][k] = "-";
			}	
			}
			else
			{
				if(vizinho == 3)
				{
				backup[j][k] = "*";
				}
			}			
		}

	public static void main (String args[]){
	String testar1 ;
	int linhas , colunas , bacterias ;
	boolean resposta ;
	int resp;
	System.out.println("Este é um simulador do programa Life");
	linhas = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero de linhas de sua matriz quadrada"));
	if(linhas > 0)
	{	
		String tabuleiro[][] = new String [linhas][linhas];
		String backup[][] = new String [linhas][linhas];
		enchermatriz(tabuleiro);
		enchermatriz(backup);
		System.out.println("Sua matriz inicial é ");  
		printamatriz(tabuleiro);
		bacterias = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero de bacterias"));
		if(bacterias < linhas*linhas+1)
		{
		for(int l = 0 ; l < bacterias ; l++)
		{
		linhas = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero da linhas da sua bacteria"));
		colunas = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero da colunas da sua bacteria"));
		if(linhas >= 0 && colunas >= 0 && linhas < tabuleiro.length && colunas < tabuleiro.length)
		{
		   tabuleiro[linhas][colunas] = "*";
		   printamatriz(tabuleiro);
		}		
		else
		{
			System.out.print("Numero de bacterias Invalido");
			l--;
		}
		}
		}
		gerarbackup(tabuleiro ,backup);
		do
		{
			
	  		resp = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite quaquer numero para ver a proxima geração  ou digite 0 para encerrar."));
			if(resp == 0)
			{
				System.out.println("\nPrograma Encerrado tenha um Bom Dia \n Abaixo sua matriz final \n");
			}
			else
			{
				lermatriz(tabuleiro, bacterias , backup );
			}
			gerarbackup(tabuleiro ,backup);
			printamatriz(backup);
	}while(resp != 0);
	}
	}
}
