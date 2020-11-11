package cardDuel.mesa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import cardDuel.jogador.Jogador;

public class NumeroJogadores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private Jogador jogador = new Jogador();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public NumeroJogadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Numero de Jogadores:");
		lblNewLabel.setBounds(10, 11, 144, 14);
		contentPane.add(lblNewLabel);

		final JRadioButton rdbtnNewRadioButton = new JRadioButton("2");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(10, 32, 109, 23);
		contentPane.add(rdbtnNewRadioButton);

		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("3");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(121, 32, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("4");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(232, 32, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);

		final JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("0");
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(10, 83, 109, 23);
		contentPane.add(rdbtnNewRadioButton_3);

		JLabel lblNumeroDeComputadores = new JLabel("Numero de Bots:");
		lblNumeroDeComputadores.setBounds(10, 62, 109, 14);
		contentPane.add(lblNumeroDeComputadores);

		final JRadioButton radioButton = new JRadioButton("1");
		buttonGroup_1.add(radioButton);
		radioButton.setBounds(121, 83, 109, 23);
		contentPane.add(radioButton);

		final JRadioButton radioButton_1 = new JRadioButton("2");
		buttonGroup_1.add(radioButton_1);
		radioButton_1.setBounds(232, 83, 109, 23);
		contentPane.add(radioButton_1);

		final JRadioButton radioButton_2 = new JRadioButton("3");
		buttonGroup_1.add(radioButton_2);
		radioButton_2.setBounds(343, 83, 109, 23);
		contentPane.add(radioButton_2);

		JButton btnComearJogo = new JButton("Come\u00E7ar Jogo");
		btnComearJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int numJogadores, numBots;

				numJogadores = ConferirSelecioando();
				numBots = ConferirBots();

				if (numJogadores != 0) {
					if (numBots != -1) {
						if (numJogadores > numBots) {



							String nomeJogador; //JOptionPane.showInputDialog(null,"Qual seu Nick");
							nomeJogador = jogador.modificarNomeJogador(JOptionPane.showInputDialog(null,"Qual seu Nick"));


							Mesa frame = new Mesa(numJogadores, numBots, nomeJogador);
							frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
							frame.setVisible(true);
							NumeroJogadores.this.dispose();
						} else {
							JOptionPane.showMessageDialog(null,"Numero de Jogadores Invalido \nNumero de Jogadores:" + numJogadores + "\nbots:" + numBots);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Selecione o numero de Bots");
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"Selecione o numero de Jogadores");
				}
			}

			private int ConferirBots() {
				int bots = -1;
				if (rdbtnNewRadioButton_3.isSelected()) {
					bots = 0;
				}
				if (radioButton.isSelected()) {
					bots = 1;
				}
				if (radioButton_1.isSelected()) {
					bots = 2;
				}
				if (radioButton_2.isSelected()) {
					bots = 3;
				}

				return bots;

			}

			private int ConferirSelecioando() {

				int jogadores = 0;
				if (rdbtnNewRadioButton.isSelected()) {
					jogadores = 2;
				}
				if (rdbtnNewRadioButton_1.isSelected()) {
					jogadores = 3;
				}
				if (rdbtnNewRadioButton_2.isSelected()) {
					jogadores = 4;
				}

				return jogadores;
			}

		});
		btnComearJogo.setBounds(60, 128, 144, 23);
		contentPane.add(btnComearJogo);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumeroJogadores.this.dispose();
			}
		});
		btnSair.setBounds(216, 128, 89, 23);
		contentPane.add(btnSair);
	}
}
