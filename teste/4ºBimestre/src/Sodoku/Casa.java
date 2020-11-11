/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sodoku;

import java.util.Random;

/**
 *
 * @author 4406166890
 */
public class Casa {
private espaco Campo[]= new espaco[9];
private String status = "Errada";

public Casa()
{
    for(int i = 0;i < 9; i++)
    {
    Campo[i] = new espaco();
    }
    PassarLocal();
    PreencherCampo();
}
public void PreencherCampo()
{
	for(int i=0; i < 4;i++)
	{
		Campo[GerarNumRandomico()].setValor(GerarNumRandomico());
	}
}
public void PassarLocal()
{
	int cont =0;
     for(int i = 0;i < 3; i++)
    {
          for(int j = 0;j < 3; j++)
          {
             Campo[cont].setX(i);
             Campo[cont].setY(j);
             cont++;
          }
     }
}
public boolean ChecarRepetido()
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
    Marcar(Repetido);
    return Repetido;
}
public int GerarNumRandomico()
{
    int numero;
    Random ale = new Random();
    numero = ale.nextInt(9);
  return numero;  
}
public void AdicionarNumero(int valor,int X,int Y)
{
   for(int g = 0;g < 9; g++)
   {
   if(Campo[g].getX() == X && Campo[g].getY() == Y)
   {
       Campo[g].setValor(valor);
       System.out.println("Valor Adicionado");
   }
   }
}
public void Marcar(boolean certo)
{
    String Status;
    if(certo == true)
    {
        Status = "Certa";
    }
    else
    {
        Status = "Errada";
    }
     this.setStatus(Status);
}
public int RetornarValor(int X,int Y)
{
    int i = 0;
   for(int g = 0;g < 9; g++)
   {
   if(Campo[g].getX() == X && Campo[g].getY() == Y)
   {
   i = Campo[g].getValor();
   }
   }
   if(i == 0)
   {
     System.out.println("Valor Não Encotrado");
   }
   return i ;
}
public void Mostre( int Local)
{
     System.out.println("");

    for(int k =0 ;k<9;k++){
              System.out.print(Campo[k].getValor());
        if( k == 2 || k == 5 )
       {
           System.out.println("");
       }

       }
     System.out.println("");
    System.out.println("--------- Local " + Local);
}
public void setStatus(String status) {
	this.status = status;
}
public String getStatus() {
	return status;
}
}

