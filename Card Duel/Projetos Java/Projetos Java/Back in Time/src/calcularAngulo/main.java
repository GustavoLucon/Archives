package calcularAngulo;

import javax.swing.JOptionPane;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int angulo;
		
		angulo = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o angulo desejado"));
		
		if(AnguloValido(angulo))
		{
			String mensagem = localizar(angulo);
		
			JOptionPane.showMessageDialog(null,mensagem);
		}
		else
		{
			JOptionPane.showMessageDialog(null,MensagemAnguloValido(angulo));
		}
		
	}

	private static String localizar(int angulo) {
		if(angulo > 0 && angulo < 90)
		{
			return "10";
		}
		else 		if(angulo > 90 && angulo < 180)
		{
			return "20";
		}
		else 		if(angulo > 180 && angulo < 270)
		{
			return "30";
		}
		else 
		{
			return "40";
		}

	}

	private static boolean AnguloValido(int angulo) {
		if(angulo == 0 || angulo == 90 || angulo == 180 || angulo == 270 || angulo == 370)
		{
			return false;
		}
		if (angulo < 0 || angulo > 370)
		{
			return false;
		}
		return true;
	}
	
	private static String MensagemAnguloValido(int angulo) {
		if(angulo == 0 || angulo == 90 || angulo == 180 || angulo == 270 || angulo == 370)
		{
			return "Angulo Invalido";
		}
		else
		{
			return "Angulo fora dos Parametros";
		}
	}

}
