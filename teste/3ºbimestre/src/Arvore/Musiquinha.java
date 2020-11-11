package Arvore;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

class arvore{
		arvore conx = null;
		String valor;
		int linha[] = new int[10];
		public void arvore(String n, int linha2) 
		{
			this.valor = n;
	        int h =0 ;
	        boolean ficar = true;
	        while(ficar)
				{
			if(this.linha[h] == 0 )
			{
			this.linha[h] = linha2;	
			ficar = false;
			}
			else
			{
			h++;
			}
		}
}
}
public class Musiquinha 
{
	public static void main(String[] args) throws IOException{
			try{
				int resposta = 0;
			arvore arv = new arvore();
			String comparar;
					int linha = 1; 
			BufferedReader reader = new BufferedReader(new FileReader("hino.txt"));
			comparar = reader.readLine();
			for(int i = 0; i < comparar.length()&& comparar != "";)
			{ 
			String[] b = comparar.split(" ");
							if(b.length > i)
						{
							ins(arv ,b[i].toLowerCase(), linha);
							i++;
						}
						else
						{
							i=0;
							linha++;
							comparar = reader.readLine();
						}
					}
			while(resposta == 0)
			{
				resposta = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite 1 quando desejar prosseguir para exibição da arvore")) ; 
				if(resposta == 1)
				{
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				pos(arv);
				}
				
			}
			reader.close();  
			}   
        catch (FileNotFoundException e1) { 
        	System.out.println("File not found!");          	
        }
	     }
        public static void ins(arvore a ,String n, int linha) 
        {
           	if (n.length() >= 3) 
        	{
        	if(a.valor == null)
        	{
           a.arvore(n,linha);
           a.conx = new arvore();
        	}
        	else
        	{
            	if(n.contentEquals(a.valor))
            	{
            		int li = 0;
            		buscar(a,n,li);
            	}
              	else
            	{
              		ins(a.conx, n , linha);
            	}
           	}
        	}
        	else 
        	{
        		System.out.println("A palavra " + n + " tem menos de 3 caracteres e nao sera adicionado");
        	}
		}
        private static void buscar(arvore n, String valor , int linha) {
           	if(n.valor != null)
    		{
        	if (n.valor != valor)
    		{
        		linha++;
    			buscar(n.conx , valor , linha);
    		}
    		else
    		{
    			n.arvore(valor,linha);	
    		}
    		}
    	}
        private static void pos(arvore n) {
    		if(n != null && n.conx != null)
    		{
    		pos(n.conx);
    		if(n.valor != null || n.valor != "null" || n.valor != "")
    		{
    		System.out.print(n.valor + "  Na(s) Linha(s) :");
    		for(int j = 0; j < n.linha.length && n.linha[j] != 0;)
    		{
    			System.out.print(n.linha[j] + ",");
    			j++;
    		}
    		System.out.println();
    		}
    		}
    	}
}
	



