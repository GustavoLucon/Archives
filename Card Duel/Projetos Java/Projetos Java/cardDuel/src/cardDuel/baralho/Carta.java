package cardDuel.baralho;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import cardDuel.mesa.Mesa;

public class Carta {

	public Carta() {
		// TODO Auto-generated constructor stub
	}

	public Carta(Integer idCarta, String nomeCarta, Integer ataque,
			Integer defesa, Integer magia, Integer defesaMagia,
			Integer velocidade) {
		super();
		this.idCarta = idCarta;
		this.imagem = new ImageIcon(Mesa.class
				.getResource("/cardDuel/imagens/cartas/"+ idCarta + ".JPG"));
		this.nomeCarta = nomeCarta;
		this.ataque = ataque;
		this.defesa = defesa;
		this.magia = magia;
		this.defesaMagia = defesaMagia;
		this.velocidade = velocidade;
	}

	public ImageIcon getImagem() {
		return imagem;
	}

	public void setImagem(ImageIcon imagem) {
		this.imagem = imagem;
	}

	private Integer idCarta;
	private String nomeCarta;
	private Integer ataque;
	private Integer defesa;
	private Integer magia;
	private Integer defesaMagia;
	private Integer velocidade;
	private ImageIcon imagem;

	public Integer getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(Integer idCarta) {
		this.idCarta = idCarta;
	}

	public String getNomeCarta() {
		return nomeCarta;
	}

	public void setNomeCarta(String nomeCarta) {
		this.nomeCarta = nomeCarta;
	}

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

	public Integer getMagia() {
		return magia;
	}

	public void setMagia(Integer magia) {
		this.magia = magia;
	}

	public Integer getDefesaMagia() {
		return defesaMagia;
	}

	public void setDefesaMagia(Integer defesaMagia) {
		this.defesaMagia = defesaMagia;
	}

	public Integer getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}

}
