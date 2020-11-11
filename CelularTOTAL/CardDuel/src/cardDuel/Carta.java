package cardDuel;

public class Carta {
    public Carta(int ataque, int defesa, int magia, int defesaMagia,
			int velocidade) {
		super();
		this.ataque = ataque;
		this.defesa = defesa;
		this.magia = magia;
		this.defesaMagia = defesaMagia;
		this.velocidade = velocidade;
	}
	private int ataque;
    private int defesa;
    private int magia;
    private int defesaMagia;
    private int velocidade;
    
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	public int getMagia() {
		return magia;
	}
	public void setMagia(int magia) {
		this.magia = magia;
	}
	public int getDefesaMagia() {
		return defesaMagia;
	}
	public void setDefesaMagia(int defesaMagia) {
		this.defesaMagia = defesaMagia;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
}
