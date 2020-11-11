package Primeiros;
import javax.swing.JOptionPane;

public class recursividade2 {
	public static int exibir(int num)
	{
		int f;
		int g;
		if(num == 0)
		{
		return 0;	
		}
		else
		{
			g = num ;
		f = exibir(num-1) + g ;
		System.out.println(f);
		return f ;
		}
	}
	public static void main (String args[])
	{
		int recebido ;
		recebido = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o numero desejado"));	
		exibir(recebido);	
			
	}
}
