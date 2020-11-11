package Applet1;

import java.awt.Graphics;
import javax.swing.JOptionPane;

public class pratica extends Teste {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3596194431048740257L;
	int var;
	int primo2;
	int primo3;

	private static int fatorial(int n) {
		int a;
		if(n > 1)
		{
		a = n * fatorial(n-1);
		return a;
		}
		else
		{
		return 1;
		}		
	}
	private static int primo(int n , int a) {
		int cont = 2;
		if (n > 1)
		{
		if(0 < a%primo(n-1 , a))
		{
			cont++;
			return n;
		}
		else
		{
			return cont;
		}
		}
		else
		{
		return n;
		}
	}
	public void init ()
	{
		var = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o numero")) ; 
		primo2 = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o numero para checar se é primo")) ; 
		primo3 = primo2;
	}
	public void paint (Graphics g)
	{
	g.drawString("O numero "+ primo2,80,35);
	primo2 = primo(primo2,primo3);
	if(primo2 == 2)
	{
		g.drawString(" Nao é primo",80,50);
	}
	else
	{
		g.drawString(" È primo",80,50);
	}
	g.drawString("" + fatorial(var),100,20);
	}
	

}
