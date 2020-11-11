package JogoDaVelha;

import javax.swing.JOptionPane;

public class Tabela {
	private Trios A = new Trios();
	public Tabela()
	{	
		
	}
	public void MostrarTabela()
	{	
	for(int i = 0 ; i < 9 ; i++)
	{
		System.out.print(A.getCasa(i));
		if(i == 2 || i == 5)
		{
			System.out.println();
		}
	}
}
}
