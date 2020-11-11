package Primeiros;
import javax.swing.JOptionPane;

public class recursividade3 {
	static int exibir (int num)
	{
		int f = 0;
		int g;
		g = num ;
		if(num == 0)
		{
		return 0;	
		}
		else if ((g/2)*2 == g)
		{
		f = exibir(num-1) + g ;
		System.out.println(f);
		return f ;
		}
		else
		{
			f = exibir(num-1);
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
