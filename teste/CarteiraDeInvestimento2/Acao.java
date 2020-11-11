package CarteiraDeInvestimento2;

public class Acao extends Instrumento {
	private int quantidade;
	Bolsa valor = new Bolsa();
	public Acao(int quantidade)
	{
		this.quantidade= quantidade;
	}
	public int getQuantidade() {
		return quantidade;
	}
	@Override
	public double valor() {
		double resultado;
		resultado = this.quantidade * valor.percento;
		return resultado;
	}
}
