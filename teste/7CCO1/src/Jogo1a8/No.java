package Jogo1a8;

public class No {
	
	protected int[][] chavePai;
	protected static No[] filhos;
	public static Tabuleiro tabula;
	public static int altura;

	public No(int[][] noPai) {

		chavePai = noPai;
		filhos = new No[4];
		tabula = new Tabuleiro();
		altura = 0;
	}

	public static void CriarTabuleiro(int[][] tabuleiroCriado,int trocado)
	{
		int[][] novoTabuleiro= tabuleiroCriado;
		int linhaZero = 0, colunaZero = 0,linhaTroca = 0, colunaTroca = 0;
		for(int i= 0;i < tabuleiroCriado.length;i++){
			for(int j= 0;j<tabuleiroCriado[i].length;j++ ){
				if(tabuleiroCriado[i][j] == 0)
				{
					linhaZero = i;
					colunaZero = j;
				}
				else if(tabuleiroCriado[i][j] == trocado)
				{
					linhaTroca = i;
					colunaTroca = j;
				}					
			}
		}
		novoTabuleiro[linhaZero][colunaZero] = novoTabuleiro[linhaTroca][colunaTroca];
		novoTabuleiro[linhaTroca][colunaTroca] = 0;		
		filhos[altura] = new No(novoTabuleiro);
		altura++;
	}
	public int contarVizinhos()
	{
		int vizinhos=0;
		for(int i= 0;i < this.chavePai.length;i++){
			for(int j= 0;j<this.chavePai[i].length;j++ ){
				if (this.chavePai[i][j] == 0)
				{
					if(i - 1 >= 0)
					{
						vizinhos++;
					}
					if(i+1 < 3)
					{
						vizinhos++;	
					}
					if(j - 1 >= 0)
					{
						vizinhos++;
					}
					if(j+1 < 3)
					{
						vizinhos++;
					}
						
					
				}
			}
		}
		return vizinhos;
		
	}
	public void criarFilho(int vizinhos) {
		
		if(filhos[0] != null)
		{
			for(int i = 0 ;i < filhos.length;i++)
			{
			filhos[i].criarFilho(vizinhos);	
			}
		}
		else
		{
			int cont = 0 ;
			boolean voltar = true;
			int[][] inicial = this.getChavePai();
			
			
			for(int i= 0;i < chavePai.length;i++){
				for(int j= 0;j< chavePai[i].length;j++ ){
					if(chavePai[i][j] == 0 && voltar)
					{
						if(i-1 >= 0)
						{
							System.out.println("\nMatriz " + cont + " criada");
							int [][] teste = TrocarTabuleiro(chavePai,chavePai[i-1][j],i-1,j);
							filhos[cont] = new No(teste);
							cont++;
						}
						if(i+1 < 3)
						{
							System.out.println("Matriz " + cont + " criada");
							filhos[cont] = new No(TrocarTabuleiro(chavePai,chavePai[i-1][j],i+1,j));
							chavePai = inicial;
							cont++;
						}
						if(j-1 >= 0)
						{
							System.out.println("Matriz " + cont + " criada");
							filhos[cont] = new No(TrocarTabuleiro(chavePai,chavePai[i-1][j],i,j-1));
							chavePai = inicial;
							cont++;
						}
						if(j+1 < 3)
						{
							System.out.println("Matriz " + cont + " criada");
							filhos[cont] = new No(TrocarTabuleiro(chavePai,chavePai[i-1][j],i,j+1));
							chavePai = inicial;
							cont++;
						}
						voltar = false;
						}
					}
				}
			}
	}
	
	/**
	 * 
	 * metodo para retornar uma nova matriz, nao pode alterar a matriz pai 
	 * @param matriz, recebe a matrizPai para cria uma nova matriz
	 * @param valor
	 * @param linha
	 * @param coluna
	 * @return 
	 */
	public int[][] TrocarTabuleiro(int[][] matriz,int valor,int linha, int coluna) {
		for (int i=0; i<matriz.length; i++) {
			for (int j=0; j<matriz[i].length; j++) {
				if(matriz[i][j] == 0)
				{
					matriz[i][j] = valor ;
					matriz[linha][coluna] = 0;
				}
			}
		}
		mostrarMatriz(matriz);
		return matriz;
	}
	public int[][] getChavePai() {
		return chavePai;
	}
	public void mostrarMatriz(int[][] tab) {
		for (int i=0; i<tab.length; i++) {
			for (int j=0; j<tab[i].length; j++) {
				System.out.printf("%d ", tab[i][j]);
				}
			System.out.println();
			}


	}
	public void setChavePai(int[][] chavePai) {
		this.chavePai = chavePai;
	}
}
