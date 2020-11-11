/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sodoku;

/**
 *
 * @author 4406166890
 */
public class Linha {
	private espaco Campo[] =new espaco[9];
    public Linha()
    {
          for(int i =0 ;i<9;i++)
   {
       Campo[i] = new espaco();
    }
    }
    public void Mostre()
    {
        System.out.print("");
        for(int k =0 ;k<9;k++){
            System.out.print(Campo[k].getValor());
            if( k == 2 || k == 5 )
           {
               System.out.print("|");
           }
           }
         System.out.println("");
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
        public void PassarLocal(int y,int local)
{
        	int cont = 0;
          for(int k = 0;k < 3; k++)
          {
              for(int j = 0;j < 3; j++)
              {
             Campo[cont].setX(j);
             Campo[cont].setY(y);
             Campo[cont].setLocal(local);
              cont++;
              }
              local = local + 3;
          }

}
}
