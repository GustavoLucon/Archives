package Jogo1a8;


public class Arvore {
	private No noRaiz;
	private Tabuleiro tabuleiroInicial;

	
	public Arvore() {
		noRaiz = null;
		tabuleiroInicial = new Tabuleiro();
		tabuleiroInicial.Randomiza();
		tabuleiroInicial.fazerIdeal();
		System.out.println("tabuleiro Randomico");
		tabuleiroInicial.mostrarMatriz(tabuleiroInicial.tabuleiro);
		System.out.println("tabuleiro Ideal");
		tabuleiroInicial.mostrarMatriz(tabuleiroInicial.ideal);
	}
	//criar tabuleiro (se ele não existe) e cria as outras possibilidades como subsequentes
	public void CriarTabuleiro()
	{
		if(noRaiz == null)
		{
			noRaiz = new No(tabuleiroInicial.getTabuleiro());
			System.out.println("O total de vizinhos do zero(espaco) são " + noRaiz.contarVizinhos());
		}
		else
		{
			int vizinhos = noRaiz.contarVizinhos();			
			noRaiz.criarFilho(vizinhos);
		}
	}
	
	// Final do que gustavo alterou
}
