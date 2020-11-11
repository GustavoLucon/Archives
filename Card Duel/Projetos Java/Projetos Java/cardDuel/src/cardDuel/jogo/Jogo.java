package cardDuel.jogo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cardDuel.mesa.NumeroJogadores;

public class Jogo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo frame = new Jogo();
					Musica musica = new Musica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public Jogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 246, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblIconeCardduel = new JLabel("Icone cardDuel");
		lblIconeCardduel.setBounds(0, 0, 238, 124);
		lblIconeCardduel.setEnabled(false);
		lblIconeCardduel.setIcon(null);
		lblIconeCardduel.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnIniciarJogo = new JButton("Iniciar Jogo");
		btnIniciarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				NumeroJogadores frame = new NumeroJogadores();
				frame.setVisible(true);
			}
		});
		btnIniciarJogo.setBounds(56, 135, 121, 31);
		contentPane.setLayout(null);
		contentPane.add(lblIconeCardduel);
		contentPane.add(btnIniciarJogo);

		JButton btnNewButton = new JButton("Ajuda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajuda frame = new Ajuda();
				frame.setVisible(true);

			}
		});
		btnNewButton.setBounds(56, 177, 121, 31);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cr\u00E9ditos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Creditos frame = new Creditos();
				frame.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(56, 219, 121, 30);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Sair");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(56, 260, 121, 31);
		contentPane.add(btnNewButton_2);
	}
}
