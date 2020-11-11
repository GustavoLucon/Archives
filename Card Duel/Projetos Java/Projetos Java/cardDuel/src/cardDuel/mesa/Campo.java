package cardDuel.mesa;

import cardDuel.baralho.Carta;

public class Campo {
	private int Jogadores;
	private Carta carta = new Carta();

	public Campo(int jogadores) {
		super();
		setJogadores(jogadores);
	}

	public int getJogadores() {
		return Jogadores;
	}

	public void setJogadores(int jogadores) {
		Jogadores = jogadores;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

}
