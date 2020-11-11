package Primeiros;
import javax.swing.JOptionPane;


public class testador {
	 public static void inserir(String[] n, String nome) 
	    {
	    	boolean resp = true;
	    	int o;
	    	o = atribuir(n,nome);
	    	do{
	    	if(n[o] == null)
	    	{
	    		n[o] = nome;
	    		resp = false;
	    	}
	    	else
	    	{
	    		o++;
	    	}
	    		
	    }
	    while(n[o] != ""&& resp == true);	
	    }
	    public static int atribuir(String[] n,String nome) 
	    {
	    	int res = 0;
	    	String[] separado;
	    	separado = nome.split("");
	    	for(int i=1;separado.length > i;i++){
	    	separado[i].toString();
	   		if(separado[i].equals("a"))
	    	{
	    		res = res + 1;  
	    	}
	    	if(separado[i].equals("b"))
	    	{
	    		res = res + 2;  
	    	}
	    	if(separado[i].equals("c"))
	    	{
	    		res = res + 3;  
	    	}
	    	if(separado[i].equals("d"))
	    	{
	    		res = res + 4;  
	    	}
	    	if(separado[i].equals("e"))
	    	{
	    		res = res + 5;  
	    	}
	    	if(separado[i].equals("f"))
	    	{
	    		res = res + 6;  
	    	}
	    	if(separado[i].equals("g"))
	    	{
	    		res = res + 7;  
	    	}
	    	if(separado[i].equals("h"))
	    	{
	    		res = res + 8;  
	    	}
	    	if(separado[i].equals("i"))
	    	{
	    		res = res + 9;  
	    	}
	    	if(separado[i].equals("j"))
	    	{
	    		res = res + 10;  
	    	}
	    	if(separado[i].equals("k"))
	    	{
	    		res = res + 11;  
	    	}
	    	if(separado[i].equals("l"))
	    	{
	    		res = res + 12;  
	    	}
	    	if(separado[i].equals("m"))
	    	{
	    		res = res + 13;  
	    	}
	    	if(separado[i].equals("n"))
	    	{
	    		res = res + 14;  
	    	}
	    	if(separado[i].equals("o"))
	    	{
	    		res = res + 15;  
	    	}
	    	if(separado[i].equals("p"))
	    	{
	    		res = res + 16;  
	    	}
	    	if(separado[i].equals("q"))
	    	{
	    		res = res + 17;  
	    	}
	    	if(separado[i].equals("r"))
	    	{
	    		res = res + 18;  
	    	}
	    	if(separado[i].equals("s"))
	    	{
	    		res = res + 19;  
	    	}
	    	if(separado[i].equals("t"))
	    	{
	    		res = res + 20;  
	    	}
	    	if(separado[i].equals("u"))
	    	{
	    		res = res + 21;  
	    	}
	    	if(separado[i].equals("v"))
	    	{
	    		res = res + 22;  
	    	}
	    	if(separado[i].equals("x"))
	    	{
	    		res = res + 23;  
	    	}
	    	if(separado[i].equals("w"))
	    	{
	    		res = res + 24;  
	    	}
	    	if(separado[i].equals("y"))
	    	{
	    		res = res + 25;  
	    	}
	    	if(separado[i] == "z")
	    	{
	    		res = res + 26;  
	    	}
	    	}
	    	res =  res * 1000 /n.length;
	    	System.out.print(res);
	    	return res;
	    }
	    	public static void main(String[] args){
	    		String[] lista = new String[10000];
	    		String entrar;
	    		int resposta = 0;
	    		while(resposta != 4)
	    		{
	    		resposta = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite : \n 1 para Inserir \n 2 Para ver toda lista \n 3 Para Buscar \n 4 para Sair")) ;
	    		if(resposta == 1)
	    			{
	    			entrar = JOptionPane.showInputDialog("Digite o nome para adicionar");
	    			inserir(lista,entrar);
	    			}
	    		if (resposta == 2)
	    		{
	    		}
	    		if (resposta == 3)
	    		{
	    			int calculo;
	    			entrar = JOptionPane.showInputDialog("Digite o nome para procurar");
	    			
	    		}
	    		
	    		}

}}
