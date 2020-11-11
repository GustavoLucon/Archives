package fdfdf;

import javax.swing.JOptionPane;

public class Trios {
	private Casa Campo[] =new Casa[3];
	private int jogador = 0;
	public Trios()
	{
        for(int i = 0 ; i < 3;i++)
        {
        Campo[i] = new Casa();
        }
	}
        public String AvisarCasa(int X , int Y,String Jogador){
        for(int i = 0 ; i < 3 ; i++)
        {
         if(X == Campo[i].getX() && Y == Campo[i].getY())
         {
             Campo[i].setValor(Jogador);
         }        
        }
        return Checar();
        }
        public String Checar() {
            if(Campo[0].getValor() == "X" && Campo[1].getValor() == "X" && Campo[2].getValor() == "X")
            {
              return "Venceu";
            }
            else if(Campo[0].getValor() == "O" && Campo[1].getValor() == "O" && Campo[2].getValor() == "O")
            {
                return "Venceu";
            }
            else
            {
                return "";
            }
        }
	public void EnviarCordenadas(int A, int B,int controle)
	{
	Campo[controle].setX(A);
	Campo[controle].setY(B);
	}
	public String getCasa(int i) {
		return Campo[i].getValor();
	}
}
