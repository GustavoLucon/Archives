package JogoDaVelha;

import javax.swing.JOptionPane;

public class Trios {
	private Casa Campo[] =new Casa[9];
	private int jogador = 0;
	public Trios()
	{
		EnviarCordenadas(Campo);
		EnviarValor(Campo);
	}
	public void EnviarValor(Casa A[])
	{
		int X;
		int Y;
		String marca;
		if(jogador == 0)
		{
			marca = "X";
		}
		else
		{
			marca = "O";
		}
		System.out.println("Jogador " + jogador + "Marca por " + marca);
		X = Integer.parseInt(JOptionPane.showInputDialog("Digite a Latitude do Ponto"));
		Y = Integer.parseInt(JOptionPane.showInputDialog("Digite a Longitude do Ponto"));
		for(int t=0;t<9;t++)
		{
			if(X == A[t].getX() && Y == A[t].getY())
			{
				if(A[t].getValor() == "-")
				{
					A[t].setValor(marca);
					if(jogador == 0)
					{
						jogador++;
					}
					else
					{
						jogador--;
					}
				}
			else
			{
				System.out.println("Ja existe algo nesta casa");
			}
			}
		}
		
	}
	public void EnviarCordenadas(Casa A[])
	{
		int controle = 0;
	for(int i = 0 ; i < 3 ; i++)
	{
		for(int g = 0 ; g < 3 ; g++)
		{
			A[controle].setX(i);
			A[controle].setY(g);
			controle++;
		}
	}
	}
	public String getCasa(int i) {
		return Campo[i].getValor();
	}
}
