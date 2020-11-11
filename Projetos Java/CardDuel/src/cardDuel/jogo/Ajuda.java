package cardDuel.jogo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Ajuda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Ajuda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOJogo = new JLabel("O jogo:");
		lblOJogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOJogo.setBounds(10, 38, 62, 23);
		contentPane.add(lblOJogo);

		JLabel lblAjuda = new JLabel("Ajuda");
		lblAjuda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjuda.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAjuda.setBounds(231, 11, 87, 22);
		contentPane.add(lblAjuda);

		JTextPane txtpnOJogoSe = new JTextPane();
		txtpnOJogoSe.setEditable(false);
		txtpnOJogoSe
				.setText("O jogo se baseia no classico \"Super Trunfo\" , que consiste do jogador selecionar uma carta de sua m\u00E3o e um dos atributos para que seja comparado com cartas de outros jogadores, o vencedor fica com as cartas jogadas pelos outros jogadores at\u00E9 que s\u00F3 ouvesse um jogador com cartas.");
		txtpnOJogoSe.setBounds(20, 72, 570, 68);
		contentPane.add(txtpnOJogoSe);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajuda.this.dispose();
			}
		});
		btnVoltar.setBounds(500, 164, 91, 23);
		contentPane.add(btnVoltar);
	}
}
