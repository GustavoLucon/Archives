import javax.swing.JOptionPane;


public class app {
	String tabuleiro[][] = new String [3][3];
	
	int linha , coluna;
	public app(){
		public static void main (String args[]){
			
	enchermatriz(tabuleiro);
	
	for(int p = 0 ; p < 9 ; p++)
	{
		Printa(tabuleiro);
		linha = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero da linha"));
		coluna = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero da coluna"));
		if (linha < 4 && coluna < 4)
		{
			if ((p % 2 ) == 0 )
			{
				tabuleiro[linha][coluna] = "O";
			}
			else
			{
				tabuleiro[linha][coluna] = "X";
			}
			ler(tabuleiro,jogador,jogador2);
		}			
		else
		{
			System.out.println("Numero invalido");
			p--;
		}
		if(p == 9)
		{
			System.out.println("Deu velha");
		}
	}
	
	
}
}
}
