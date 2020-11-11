public class Printa{
 public Printa(tabuleiro){
	String matriz[][];
	System.out.print(" ");
	Printa(tabuleiro);
		for (int i = 0 ; i < 3 ; i++)
		{
			System.out.print(i);
		}
		for (int k = 0 ; k < 3 ; k++)
		{
			System.out.print("\n" + k);
			for (int l = 0 ; l < 3 ; l++)
			{
			System.out.print(matriz[k][l]);
			}
		}
		System.out.println("");
		System.out.println("O = Jogador1 e X = Jogador2");
	}
}
