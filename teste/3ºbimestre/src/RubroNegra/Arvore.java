package RubroNegra;
import javax.swing.JOptionPane;

public class Arvore extends RubroNegra{
	public static void main(String[] args) {
		RubroNegra Tree = new RubroNegra();
		int resposta= 0;
		while (resposta != 4)
		{
			resposta = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite sua opção \n 1 Para Inserir")) ; 
			if(resposta == 1)
			{
				int var;
				var = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o numero para Inserir")) ; 
								
			}
		}
	}
}
