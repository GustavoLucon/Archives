package Arvore;



public class No {

	protected int altura;
	protected int chavePai;
	protected No esquerda, direita;

	public No(int noPai) {

		this(noPai, null, null);

	}

	public No(int noPai, No esq, No dir) {

		chavePai = noPai;
		esquerda = esq;
		direita = dir;
		altura = 0;

	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getChavePai() {
		return chavePai;
	}

	public void setChavePai(int chavePai) {
		this.chavePai = chavePai;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}

}
