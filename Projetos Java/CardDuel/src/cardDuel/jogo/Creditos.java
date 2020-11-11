package cardDuel.jogo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Creditos extends JFrame {

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
	public Creditos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 318, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Creditos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(80, 11, 126, 15);
		contentPane.add(lblNewLabel);

		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(10, 44, 46, 14);
		contentPane.add(lblGrupo);

		JTextArea txtpnGustavoPestanaLucon = new JTextArea();
		txtpnGustavoPestanaLucon.setEditable(false);
		txtpnGustavoPestanaLucon
				.setText("Andre Vicente \r\nAndre Durrazo \r\nGustavo Lucon");
		txtpnGustavoPestanaLucon.setRows(3);
		txtpnGustavoPestanaLucon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnGustavoPestanaLucon.setBounds(20, 69, 280, 54);
		contentPane.add(txtpnGustavoPestanaLucon);

		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setBounds(10, 134, 59, 14);
		contentPane.add(lblProfessor);

		JTextPane txtpnProfessor = new JTextPane();
		txtpnProfessor.setEditable(false);
		txtpnProfessor.setText("Claudinei Walker ");
		txtpnProfessor.setBounds(20, 159, 280, 20);
		contentPane.add(txtpnProfessor);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Creditos.this.dispose();
			}
		});
		btnNewButton.setBounds(115, 209, 91, 23);
		contentPane.add(btnNewButton);
	}

}
