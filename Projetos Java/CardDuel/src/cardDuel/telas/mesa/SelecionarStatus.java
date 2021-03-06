package cardDuel.telas.mesa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cardDuel.baralho.Carta;
import cardDuel.jogador.Jogador;
import cardDuel.mesa.Mesa;
import cardDuel.telas.CampoBatalha;

public class SelecionarStatus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAtaque;
	private JLabel lblDefesa;
	private JLabel lblMagia;
	private JLabel lblDefesaMagia;
	private JLabel lblVelocidade;
	private JLabel lblNome;
	private JButton btnVelocidade;
	private JButton btnDefesaMagia;
	private JButton btnMagia;
	private JButton btnDefesa;
	private JButton btnAtaque;
	private JLabel lblNewLabel_1; 
	private int turno;
	private int idJogador;
	private Mesa mesa;

	public void EnviarCarta(Carta carta,int turno,int idJogador, Mesa mesa)
	{
		this.mesa = mesa;
		lblNewLabel_1.setIcon(new ImageIcon(Mesa.class.getResource("/cardDuel/imagens/cartas/"+ (turno + 1) +".jpg")));
		this.idJogador = idJogador;
		this.turno = turno;
		btnAtaque.setText("" + (carta.getAtaque() + ".0"));
		btnDefesa.setText("" + (carta.getDefesa() + ".0"));
		btnMagia.setText("" + (carta.getMagia()+ ".0"));
		btnDefesaMagia.setText("" + (carta.getDefesaMagia()+ ".0"));
		btnVelocidade.setText("" + (carta.getVelocidade() + ".0"));
	}

	public SelecionarStatus() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(800, 200, 317, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNome = new JLabel("Carta:");
		lblNome.setBounds(29, 28, 254, 14);
		contentPane.add(lblNome);

		lblAtaque = new JLabel("Ataque:");
		lblAtaque.setBounds(39, 246, 110, 14);
		contentPane.add(lblAtaque);

		lblDefesa = new JLabel("Defesa:");
		lblDefesa.setBounds(39, 279, 110, 14);
		contentPane.add(lblDefesa);

		lblMagia = new JLabel("Magia:");
		lblMagia.setBounds(39, 310, 110, 14);
		contentPane.add(lblMagia);

		lblDefesaMagia = new JLabel("Defesa Magia:");
		lblDefesaMagia.setBounds(38, 340, 145, 14);
		contentPane.add(lblDefesaMagia);

		lblVelocidade = new JLabel("Velocidade:");
		lblVelocidade.setBounds(39, 371, 149, 14);
		contentPane.add(lblVelocidade);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(29, 53, 254, 182);
		contentPane.add(lblNewLabel_1);

		btnAtaque = new JButton("Ataque");
		btnAtaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comparar(0);

			}
		});
		btnAtaque.setBounds(222, 242, 61, 29);
		contentPane.add(btnAtaque);

		btnDefesa = new JButton("Defesa");
		btnDefesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comparar(1);
			}
		});
		btnDefesa.setBounds(222, 275, 61, 23);
		contentPane.add(btnDefesa);

		btnMagia = new JButton("Magia");
		btnMagia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comparar(2);
			}
		});
		btnMagia.setBounds(222, 308, 61, 20);
		contentPane.add(btnMagia);

		btnDefesaMagia = new JButton("Defesa Magia");
		btnDefesaMagia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comparar(3);
			}
		});
		btnDefesaMagia.setBounds(222, 336, 61, 23);
		contentPane.add(btnDefesaMagia);

		btnVelocidade = new JButton("Velocidade");
		btnVelocidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comparar(4);
			}
		});
		btnVelocidade.setBounds(222, 367, 61, 23);
		contentPane.add(btnVelocidade);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SelecionarStatus.this.dispose();
			}
		});
		btnNewButton.setBounds(82, 446, 145, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SelecionarStatus.class.getResource("/cardDuel/imagens/jogadores/Carta.png")));
		lblNewLabel.setBounds(0, 0, 313, 435);
		contentPane.add(lblNewLabel);
	}


	private Jogador[] getListaJogadores() {
		return mesa.getListaJogadores();
	}


	public void comparar (int atributo)
	{	
		this.enable(false);
		
		CampoBatalha campoBatalha = new  CampoBatalha();
		
		Carta cartaJogador = getListaJogadores()[idJogador].getBaralho().getCarta(turno); 
		int maior = 0;
		switch(atributo){
		case 0:
			maior =cartaJogador.getAtaque();
			break;
		case 1:
			maior = cartaJogador.getDefesa();
			break;
		case 2:
			maior = cartaJogador.getMagia();
			break;
		case 3:
			maior = cartaJogador.getDefesaMagia();
			break;
		case 4:
			maior = cartaJogador.getVelocidade();
			break;
		}

		int winner = idJogador;
		String recompensa = "";
		

		campoBatalha = PassarValor(idJogador,atributo,campoBatalha);
		for (int i = 0; i < getListaJogadores().length; i++) {
			if(getListaJogadores()[i].getMorreu() == false)
			{
				if(idJogador != i)
				{	
					campoBatalha = PassarValor(i,atributo,campoBatalha);
					if (maior < getListaJogadores()[i].SelecionarMaior(atributo,turno)) {
						maior = getListaJogadores()[i].SelecionarMaior(atributo,turno);
						winner = i;
					}
				}
			}
		}		
		campoBatalha.setVisible(true);
		
		campoBatalha.setResultado(getListaJogadores()[winner].getNome() + "" );
		

		for (int i = 0; i < getListaJogadores().length; i++) {
			if(winner != i)
			{
				Carta c = null;
				if(i != 0)
				{
					c = getListaJogadores()[i].SelecionarMaiorCarta(atributo,turno);
				}
				else
				{
					c = cartaJogador;
				}
				if(getListaJogadores()[i].getMorreu() == false)
				{
					getListaJogadores()[i].removerCarta(c);
					recompensa = recompensa + c.getNomeCarta() + " | ";
					getListaJogadores()[winner].adicionarCarta(c);
				}
			}
		}
		
		campoBatalha.CriarCampo(mesa,winner);
	
		SelecionarStatus.this.dispose();
		


	}

	private CampoBatalha PassarValor(int idJogador, int atributo, CampoBatalha campoBatalha) {
		Carta carta = getListaJogadores()[idJogador].getBaralho().getCarta(turno);
		String maior = "";
		if(atributo == 0 )
		{
			maior = carta.getAtaque() + ".0";
		}
		else if(atributo == 1)
		{
			maior = carta.getDefesa()+ ".0";
		}
		else if(atributo == 2)
		{
			maior = carta.getMagia() + ".0";
		}
		else if(atributo == 3)
		{
			maior = carta.getDefesaMagia() + ".0";
		}
		else if(atributo == 4)
		{
			maior = carta.getVelocidade() + ".0";
		}
		campoBatalha.setValoresCampos(idJogador, getListaJogadores()[idJogador].getNome(), maior,StatusIntParaNome(atributo));
		return campoBatalha;
		
	}

	private String StatusIntParaNome(int numMelhorStatus) {
		String nomeStatus = "";
		if(numMelhorStatus == 0)
		{
			nomeStatus = "Ataque";
		}
		else 		if(numMelhorStatus == 1)
		{
			nomeStatus = "Defesa";
		}
		else 		if(numMelhorStatus == 2)
		{
			nomeStatus = "Magia";
		}
		else 		if(numMelhorStatus == 3)
		{
			nomeStatus = "Defesa Magica";
		}
		else 		if(numMelhorStatus == 4)
		{
			nomeStatus = "Velocidade";
		}
		return nomeStatus;
	}


}

