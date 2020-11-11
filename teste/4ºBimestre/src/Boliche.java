import javax.swing.JOptionPane;


public class Boliche {
	public static void main(String[] args)
	{
		int terminou= 0;
		int pinos;
		int a = 0;
		int pinos2;
		int cont = 0;
		int placar[][] = new int [10][2];
		int pontos[] =new int [21];
		for(int i = 0 ; i < 10; i++)
		{
		placar[i][1] = i;
		}        
		while(terminou != 1)
		{
			for(int jogada = 0; jogada < 4 ;jogada++)
			{
				if(jogada < 9)
				{
				pinos = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pinos derrubada na Primeira jogada"));
				if(pinos <= 9 && pinos >= 0)
				{
					pinos2 = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pinos derrubada na Segunda jogada"));
					pontos[cont] = pinos;
					cont++;
					pontos[cont] = pinos2;
					cont++;	
				}
				else if(pinos == 10)
				{
					pontos[cont] = pinos;
					cont++;
					pontos[cont] = 0;
					cont++;
				}
				else
				{
					System.out.println("Valor Incorreto");
				
				}
				}
				else
				{
						pinos = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pinos derrubada na Primeira jogada"));
						pinos2 = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pinos derrubada na Segunda jogada"));
						pontos[cont] = pinos;
						cont++;
						pinos = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pinos derrubada na Terceira jogada"));
						pontos[cont] = pinos2;
						cont++;
						pontos[cont] = pinos;
			}
		}
		for(int y =0; y < 8;y = y++)
		{
		if(a == 0)
		{
			placar[a][2] = pontos[y]+pontos[y+1];
		}
		else
		{
		if(y < 19)
		{
		if(pontos[y]+pontos[y+1] == 10)
		{
			if(pontos[y] == 10)
			{
				placar[a][2] = placar[a-1][2]+ pontos[y]+pontos[y+2] +pontos[y+3];
			}	
			else
			{
			placar[a][2] = placar[a-1][2]+ pontos[y]+pontos[y+1] +pontos[y+2];
			}
		}   
		else
		{
		placar[a][2] = placar[a-1][2]+ pontos[y]+pontos[y+1];
		}
		placar[a][1] = pontos[y]+pontos[y+1];
		}
		else
		{
			placar[a][2] = placar[a-1][2] + pontos[y]+pontos[y+1] +pontos[y+2];	
			y++;
		}
		a++;
		y++;
		}
		}
        for(int b= 0; b < 10;b++)
		{
			System.out.print(placar[b][0] + "|");
		}
        System.out.println("");
        for(int b= 0; b < 21;b++)
		{
			System.out.print(pontos[b] + "|");
			
		}
        System.out.println("");
        for(int b= 0; b < 10;b++)
		{
			System.out.print(placar[b][1] + "|");
		}
        System.out.println("");
        for(int b= 0; b < 10;b++)
		{
			System.out.print(placar[b][2]);
		}
	   terminou = Integer.parseInt(JOptionPane.showInputDialog("Digite 0 para continuar e 1 para encerrar"));
		}	
}
}
