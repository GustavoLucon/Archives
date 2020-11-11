package cardDuel.baralho;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {

	private Carta carta = new Carta();
	private List<Carta> baralhoPadrao;
	private Integer atributoRandomico;
	protected Random random = new Random();

	public Baralho() {
		// TODO Auto-generated constructor stub
	}

	public List<Carta> montarBaralho() {

		baralhoPadrao = new ArrayList<Carta>();
		for (int i = 1; i <= 40; i++) {
			carta = new Carta(i, "card " + i, getAtributoRandomico(),
					getAtributoRandomico(), getAtributoRandomico(),
					getAtributoRandomico(), getAtributoRandomico());
			baralhoPadrao.add(carta);
			carta = new Carta();
		}

		return baralhoPadrao;
	}

	public Integer getAtributoRandomico() {
		int r = random.nextInt(11);
		if (r != 0) {
			atributoRandomico = r;
		} else {
			atributoRandomico = getAtributoRandomico();
		}
		return atributoRandomico;
	}

	public void setAtributoRandomico(Integer atributoRandomico) {
		this.atributoRandomico = atributoRandomico;
	}

	public Carta getCarta(int numero) {
		return baralhoPadrao.get(numero);
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public List<Carta> getBaralhoPadrao() {
		return baralhoPadrao;
	}
	
   public void adicionarCarta (Carta c)
   {
 	this.baralhoPadrao.add(c);
   }
   public void removerCarta (Carta c)
   {
 	this.baralhoPadrao.remove(c);
   }

	public void setBaralhoPadrao(List<Carta> baralhoPadrao) {
		this.baralhoPadrao = baralhoPadrao;
	}

}
