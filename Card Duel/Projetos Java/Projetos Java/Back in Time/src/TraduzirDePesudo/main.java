package TraduzirDePesudo;

import javax.swing.JOptionPane;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			double salb , desc, sall;
			salb=0;
			desc=0;
			sall=0;
			
			salb = Double.parseDouble(JOptionPane.showInputDialog(null,"Entre com o Salario"));

			if(salb> 4001)
			{
				desc = salb * 0.725;
				sall = salb - desc;
			}
			else if((salb >= 3001) && (salb < 4001))
			{
				desc = salb * 0.25;
				sall = salb - desc;
			}
			else if((salb >= 2001) && (salb < 3001))
			{
				desc = salb * 0.2;
				sall = salb - desc;
			}
			else if((salb >= 1001) && (salb < 2001))
			{
				desc = salb * 0.15;
				sall = salb - desc;
			}
			else if((salb >= 500) && (salb < 1001))
			{
				desc = salb * 0.1;
				sall = salb - desc;
			}
			
			JOptionPane.showMessageDialog(null,"Valor do desconto "+ desc);
			JOptionPane.showMessageDialog(null,"valor do salario liquido " + sall);
	}
	

}
