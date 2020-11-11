package cardDuel.telas.mesa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import cardDuel.baralho.Baralho;
import cardDuel.baralho.Carta;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaMesa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Baralho baralho;
	private JLabel lblAtaque;
	private JLabel lblDefesa;
	private JLabel lblMagia;
	private JLabel lblDefesaMagia;
	private JLabel lblVelocidade;
	private SelecionarStatus selecionarStatus;  

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public TelaMesa() {
		IniciarBaralho();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJogador = new JLabel("Voce");
		lblJogador.setBounds(388, 309, 65, 14);
		contentPane.add(lblJogador);
		
		JLabel lblJogador_1 = new JLabel("Jogador 2");
		lblJogador_1.setBounds(394, 169, 59, 14);
		contentPane.add(lblJogador_1);
		
		JLabel lblJogador_2 = new JLabel("Jogador 3");
		lblJogador_2.setBounds(225, 241, 65, 14);
		contentPane.add(lblJogador_2);
		
		JLabel lblJogador_3 = new JLabel("Jogador 4");
		lblJogador_3.setBounds(572, 241, 65, 14);
		contentPane.add(lblJogador_3);
		
		lblAtaque = new JLabel("Ataque:");
		lblAtaque.setBounds(102, 489, 134, 14);
		contentPane.add(lblAtaque);
		
		lblDefesa = new JLabel("Defesa:");
		lblDefesa.setBounds(246, 489, 118, 14);
		contentPane.add(lblDefesa);
		
		lblMagia = new JLabel("Magia:");
		lblMagia.setBounds(374, 489, 116, 14);
		contentPane.add(lblMagia);
		
		lblDefesaMagia = new JLabel("Defesa Magia:");
		lblDefesaMagia.setBounds(500, 489, 157, 14);
		contentPane.add(lblDefesaMagia);
		
		lblVelocidade = new JLabel("Velocidade:");
		lblVelocidade.setBounds(667, 489, 157, 14);
		contentPane.add(lblVelocidade);
		
		final JButton btnCard = new JButton("Card 1");
		btnCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCard.setText(baralho.getBaralhoPadrao().get(1).getNomeCarta());
				setValorLabels(baralho.getBaralhoPadrao().get(1));
			}
		});
		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompararCartas(baralho.getBaralhoPadrao().get(1));
			}
		});
		btnCard.setBounds(134, 514, 91, 101);
		contentPane.add(btnCard);
		
		final JButton btnCard_1 = new JButton("Card 2");
		btnCard_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCard_1.setText(baralho.getBaralhoPadrao().get(2).getNomeCarta());
				setValorLabels(baralho.getBaralhoPadrao().get(2));
			}
		});
		btnCard_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompararCartas(baralho.getBaralhoPadrao().get(2));

			}
		});
		btnCard_1.setBounds(235, 514, 91, 101);
		contentPane.add(btnCard_1);
		
		final JButton btnCard_2 = new JButton("Card 3");
		btnCard_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCard_2.setText(baralho.getBaralhoPadrao().get(3).getNomeCarta());
				setValorLabels(baralho.getBaralhoPadrao().get(3));
			}
		});
		btnCard_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompararCartas(baralho.getBaralhoPadrao().get(3));

			}
		});
		btnCard_2.setBounds(336, 514, 91, 101);
		contentPane.add(btnCard_2);
		
		final JButton btnCard_3 = new JButton("Card 4");
		btnCard_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCard_3.setText(baralho.getBaralhoPadrao().get(4).getNomeCarta());
				setValorLabels(baralho.getBaralhoPadrao().get(4));
			}
		});
		btnCard_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompararCartas(baralho.getBaralhoPadrao().get(4));
			}
		});
		btnCard_3.setBounds(437, 514, 91, 101);
		contentPane.add(btnCard_3);
		
		final JButton btnCard_4 = new JButton("Card 5");
		btnCard_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCard_4.setText(baralho.getBaralhoPadrao().get(5).getNomeCarta());
				setValorLabels(baralho.getBaralhoPadrao().get(5));
			}
		});
		btnCard_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompararCartas(baralho.getBaralhoPadrao().get(5));
			}
		});
		btnCard_4.setBounds(542, 514, 91, 101);
		contentPane.add(btnCard_4);
		
		final JButton btnCard_5 = new JButton("Card 6");
		btnCard_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCard_5.setText(baralho.getBaralhoPadrao().get(6).getNomeCarta());
				setValorLabels(baralho.getBaralhoPadrao().get(6));
			}
		});
		btnCard_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompararCartas(baralho.getBaralhoPadrao().get(6));
				
			}
		});
		btnCard_5.setBounds(643, 514, 91, 101);
		contentPane.add(btnCard_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaMesa.class.getResource("/cardDuel/imagens/jogadores/MARIO.JPG")));
		lblNewLabel_1.setBounds(655, 189, 199, 127);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaMesa.class.getResource("/cardDuel/imagens/jogadores/LINK.JPG")));
		lblNewLabel.setBounds(26, 189, 199, 127);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(TelaMesa.class.getResource("/cardDuel/imagens/jogadores/Kirby.JPG")));
		lblNewLabel_2.setBounds(370, 11, 101, 147);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaMesa.class.getResource("/cardDuel/imagens/jogadores/Samus.JPG")));
		lblNewLabel_3.setBounds(370, 331, 101, 147);
		contentPane.add(lblNewLabel_3);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaMesa.this.dispose();
			}
		});
		btnSair.setBounds(791, 592, 91, 23);
		contentPane.add(btnSair);
	}
	
	protected void CompararCartas(Carta carta) {
		selecionarStatus = new SelecionarStatus();
		selecionarStatus.EnviarCarta(carta,0,0,null);
		selecionarStatus.setVisible(true);
	}

	private void setValorLabels(Carta carta) {
		lblAtaque.setText("Ataque:" + (carta.getAtaque() + ".000"));
		lblDefesa.setText("Defesa:" + (carta.getDefesa() + ".000"));
		lblMagia.setText("Magia:" + (carta.getMagia()+ ".000"));
		lblDefesaMagia.setText("Defesa Magia:" + (carta.getDefesaMagia()+ ".000"));
		lblVelocidade.setText("Velocidade:" + (carta.getVelocidade() + ".000"));
		
	}

	private void IniciarBaralho() {
	baralho = new Baralho();
	baralho.montarBaralho();
		
	}
	
}
