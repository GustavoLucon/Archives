package Sodoku;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author 4406166890
 */
public class Coluna {
    private espaco Campo[] =new espaco[9];
       public Coluna()
    {
          for(int i =0 ;i<9;i++)
   {
       Campo[i] = new espaco();
    }
    }
	public boolean ChecarRepeticao()
        {
		  int soma;
		    boolean Repetido = false;
		    boolean testar = true;
		    if(testar == true)
		    {
		    soma = Campo[0].getValor();
		    for(int i = 1;i < 9; i++)
		    {
		        soma = soma + Campo[i].getValor() ;
		    }
		    if(soma == 50)
		    {
		        Repetido = true;
		    }
		    }
		    return Repetido;
        }
public void AdicionarNumero(int valor,int X,int Y,int local)
{
   for(int g = 0;g < 9; g++)
   {
   if(Campo[g].getX() == X && Campo[g].getY() == Y && Campo[g].getLocal() == local)
   {
       Campo[g].setValor(valor);
   }
   }
}
        public void PassarLocal(int i,int local)
{
        	int cont=0;
          for(int k = 0;k < 3; k++)
          {
              for(int j = 0;j < 3; j++)
              {
             Campo[cont].setX(i);
             Campo[cont].setY(j);
             Campo[cont].setLocal(local);
              cont++;
              }
              local = local + 1;
          }
}
}
