/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sodoku;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 *
 * @author 35895842895
 */
public class Campo {
private Linha lin[] =new Linha[9];
private Coluna col[] =new Coluna[9];
private Casa cas[] =new Casa[9];

public Campo()
{
boolean vitoria=false;
int Resposta;
int X;
int Y;
int Valor;
int Local;
ConstruirPreparar(cas,lin,col);
PreencherCampo();
while(vitoria==false){
    Mostrar();
    System.out.println();
    Resposta = Integer.parseInt(JOptionPane.showInputDialog("Digite: \n 1-Para Adicionar \n 2-Para Checar o Campo \n 3 Para Sair "));
    if(Resposta == 1)
    {
        Local = Integer.parseInt(JOptionPane.showInputDialog("Digite o Numero correspondete ao quadrado \n 0 1 2 \n 3 4 5 \n 6 7 8"));
        X = Integer.parseInt(JOptionPane.showInputDialog("Digite a linha"));
        Y = Integer.parseInt(JOptionPane.showInputDialog("Digite a coluna"));
        Valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor"));
        if(Valor > 0 &&  Valor < 10 && X < 3 && Y < 3 && Local < 9)
        {
           Adicionar(Valor,X,Y,Local) ;
        }
        else
        {
        	System.out.print("Local ou Valor invalido");
        }

    }
    else if(Resposta == 2)
    {
        if(Vitoria())
        {
         System.out.print("Voce Venceu");
         System.exit(0);
        }
        else
        {
         System.out.print("Existe algo errado");
        }
    }
    else if(Resposta == 3)
    {
        System.exit(0);
    }
}

}
public boolean Vitoria()
{
    int e = 0;
      for(int i =0 ;i<9;i++)
   {
      if(cas[i].ChecarRepetido() && lin[i].ChecarRepeticao() && col[i].ChecarRepeticao())
      {
          e++;
      }
    }
    if(e == 9)
    {
        return true;
    }
    else
    {
        return false;
    }
}
public void ConstruirPreparar(Casa casa[],Linha linha[], Coluna coluna[])
{
	int local = 0;
   for(int i =0 ;i<9;i++)
   {
       casa[i] = new Casa();
      linha[i] = new Linha();
      coluna[i] = new Coluna();
      linha[i].PassarLocal(local,i);
      coluna[i].PassarLocal(local,i);
      if( i % 3 == 0)
      {
    	  local++;
      }
   }
}
public int GerarNumRandomico()
{
    int numero;
    Random ale = new Random();
    numero = ale.nextInt(8);
  return numero;  
}
public void PreencherCampo()
{
	int a, b ,c , d , e;
	for(int i=0; i < 200;i++)
	{
		a = GerarNumRandomico();
		b = GerarNumRandomico();
		c = GerarNumRandomico();
		d = GerarNumRandomico();
		e = GerarNumRandomico();
		cas[a].AdicionarNumero(b,c,d);
		lin[a].AdicionarNumero(b,c,d,e);
		col[a].AdicionarNumero(b,c,d,e);
	}
}
public void Mostrar()
{
   for(int i =0 ;i<9;i++)
   {
     lin[i].Mostre();
       if( i == 2 || i == 5 )
     {
         System.out.print("-----------\n");
     }
   }
   for(int i =0 ;i<9;i++)
   {
	   System.out.print("\n O Status da Casa " + i + " é :" + cas[i].getStatus());
   }
}
public void Adicionar(int valor , int x,int y , int local)
{
	lin[local].AdicionarNumero(valor,x,y,local);
    col[local].AdicionarNumero(valor,x,y,local);
    cas[local].AdicionarNumero(valor,x,y);
}

public void ChequeLinhaColuna(){
    for(int i =0 ;i<9;i++){
    	lin[i].ChecarRepeticao();
    col[i].ChecarRepeticao();
    cas[i].ChecarRepetido();
    }
   }
}

