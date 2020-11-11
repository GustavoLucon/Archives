package CarteiraDeInvestimento2;
public abstract class Instrumento{
	public String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	public abstract double valor();
}