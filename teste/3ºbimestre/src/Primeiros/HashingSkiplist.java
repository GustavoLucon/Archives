package Primeiros;
import java.util.Random;

import javax.swing.JOptionPane;

public class HashingSkiplist {
    public static void printar(String[] n,String chave,sub j) 
    {
    	for(int o = 0;n.length > o;o++)
    	{
    		if(n[o] != null && n[o] != chave)
    		{
    			System.out.println(n[o] + " : Na posição " +o);
    		}
    	}
    	printarsub(n,j);
    }
    public static void printarsub(String[] n,sub j) 
    {
		if(j.conx != null)
		{
			printarsub(n,j.conx); 
		}
		else
		{
			System.out.print(j.nome + " ");
		}
	}
    public static void printarlista(sub j) 
    {
    	if(j.conx != null)
    	{
    		printarlista(j.conx);
    		System.out.print(j.nome+ " ");
    	}
    	else
    	{
    		System.out.print(j.nome+ " ");	
    	}
    }
    public static void buscarSeq(String[] n, String nome, int posicao,int vezes,int controle) 
    {
    	if(n[posicao] != null)
    	{
    	if(posicao < n.length)
    	{
    	if(nome.equals(n[posicao]))
    	{
    		System.out.println("Valor encontrado na posicao " + posicao);
    	}
    	else
    	{
    		posicao = posicao +(vezes * controle);
     		int res = vezes;
    		vezes = controle * vezes;
     		controle = res;    		
    		buscarSeq(n,nome,posicao,vezes,controle);
     	}
    	}
    	else
    	{
    		System.out.println("Valor nao foi encontrado");
    	}
    	}
    	else
    	{
    		System.out.println("Valor nao foi encontrado");
    	}
    }
    public static void buscar(String[] n, String nome, int posicao) 
    {
    	if(n[posicao] != null)
    	{
    	if(posicao < n.length)
    	{
    	if(nome.equals(n[posicao]))
    	{
    		System.out.print("Valor encontrado na posicao " + posicao);
    	}
    	else
    	{
    		buscar(n,nome,posicao++);
    	}
    	}
    	else
    	{
    		System.out.print("Valor nao foi encontrado");
    	}
    	}
    	else
    	{
    		System.out.print("Valor nao foi encontrado");
    	}
    }
    public static void procuraDuplo(String nome,String chave , sub j) 
    {
    	if(nome == j.nome)
    	{
    		System.out.print("Valor encontrado");
    	}
    	else
    	{
    		procuraDuplo(nome,chave,j);
    	}
    }
    public static void buscarDuplo(String[] n, String nome, int posicao,String chave , sub j) 
    {
    	if(n[posicao] != null)
    	{
    	if(posicao < n.length)
    	{
    	if(nome.equals(n[posicao]))
    	{
    		System.out.print("Valor encontrado na posicao " + posicao);
    	}
    	else
    	{
    		if(chave.equals(n[posicao]))
    		{
    			procuraDuplo(nome,chave,j);
    		}
    		else
    		{
    		buscarDuplo(n,nome,posicao++,chave,j);
    		}
    	}
    	}
    	else
    	{
    		System.out.print("Valor nao foi encontrado");
    	}
    	}
    	else
    	{
    		System.out.print("Valor nao foi encontrado");
    	}
    	
    }
    public static void inserirSeq(String[] n, String nome,String chave ,int posicao,int vezes, int controle) 
    {
    	boolean resp = true;
      	do{
    	if(n[posicao] == null)
    	{
    		n[posicao] = nome;
			resp = false;
    	}
    	else
    	{
    		posicao = posicao +(vezes * controle);
     		int res = vezes;
    		vezes = controle * vezes;
     		controle = res;    		
    		inserirSeq(n,nome,chave,posicao,vezes,controle);
    		resp = false;
    	}
    	}
    while(n[posicao] != "" && resp == true);	
    }
    public static void inserirlin(String[] n, String nome,String chave , sub novo) 
    {
    	boolean resp = true;
    	int o;
    	o =atribuir(n,nome);
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
    while(n[o] != "" && resp == true);	
    }
    public static void inserir(String[] n, String nome,String chave , sub novo) 
    {
    	boolean resp = true;
    	int o;
    	o =atribuir(n,nome);
    	do{
    	if(n[o] == null)
    	{
    		n[o] = nome;
			resp = false;
    	}
    	else
    	{
    		if(n[o] == chave )
    		{
    		subclasse(nome,o,novo);
    		resp = false;
    		}
    		else if(n[o] != chave)
    		{
        	subclasse(n[o],o,novo);
        	subclasse(nome,o,novo);
        	n[o] = chave;
        	resp = false;
    		}
    		}
    	}	
    while(n[o] != "" && resp == true);	
    }
    
    private static void subclasse(String nome, int o , sub k) {
		if(k.nome == null)
		{
        k.pos = o;
    	k.nome = nome;
		}
		else
		{
			if(k.conx != null)
			{
				subclasse(nome,o,k.conx);
			}
	}
	}
	public static int atribuir(String[] n,String nome) 
    {
    	int res = 0;
    	String[] separado;
    	separado = nome.split("");
    	for(int i=1;separado.length > i;i++){
   		if(separado[i].equals("a"))
    	{
    		res = res + 1; 
    		res = res^i;
    	}
    	if(separado[i].equals("b"))
    	{
    		res = res + 2;  
    		res = res^i;
    	}
    	if(separado[i].equals("c"))
    	{
    		res = res + 3;
    		res = res^i;
    	}
    	if(separado[i].equals("d"))
    	{
    		res = res + 4;
    		res = res^i;
    	}
    	if(separado[i].equals("e"))
    	{
    		res = res + 5; 
    		res = res^i;
    	}
    	if(separado[i].equals("f"))
    	{
    		res = res + 6;  
    		res = res^i;
    	}
    	if(separado[i].equals("g"))
    	{
    		res = res + 7;
    		res = res^i;
    	}
    	if(separado[i].equals("h"))
    	{
    		res = res + 8;
    		res = res^i;
    	}
    	if(separado[i].equals("i"))
    	{
    		res = res + 9;
    		res = res^i;
    	}
    	if(separado[i].equals("j"))
    	{
    		res = res + 10;
    		res = res^i;
    	}
    	if(separado[i].equals("k"))
    	{
    		res = res + 11;
    		res = res^i;
    	}
    	if(separado[i].equals("l"))
    	{
    		res = res + 12;
    		res = res^i;
    	}
    	if(separado[i].equals("m"))
    	{
    		res = res + 13;
    		res = res^i;
    	}
    	if(separado[i].equals("n"))
    	{
    		res = res + 14;  
    		res = res^i;
    	}
    	if(separado[i].equals("o"))
    	{
    		res = res + 15;  
    		res = res^i;
    	}
    	if(separado[i].equals("p"))
    	{
    		res = res + 16;  
    		res = res^i;
    	}
    	if(separado[i].equals("q"))
    	{
    		res = res + 17;
    		res = res^i;
    	}
    	if(separado[i].equals("r"))
    	{
    		res = res + 18;
    		res = res^i;
    	}
    	if(separado[i].equals("s"))
    	{
    		res = res + 19;
    		res = res^i;
    	}
    	if(separado[i].equals("t"))
    	{
    		res = res + 20; 
    		res = res^i;
    	}
    	if(separado[i].equals("u"))
    	{
    		res = res + 21;  
    		res = res^i;
    	}
    	if(separado[i].equals("v"))
    	{
    		res = res + 22;  
    		res = res^i;
    	}
    	if(separado[i].equals("x"))
    	{
    		res = res + 23;  
    		res = res^i;
    	}
    	if(separado[i].equals("w"))
    	{
    		res = res + 24; 
    		res = res^i;
    	}
    	if(separado[i].equals("y"))
    	{
    		res = res + 25;
    		res = res^i;
    	}
    	if(separado[i] == "z")
    	{
    		res = res + 26; 
    		res = res^i;
    	}
    	}
    	res = 10000 * 50 * res/n.length;
    	while(res > n.length)
    	{
    		res--;	
    	}
    	return res;
    }
	public static void main(String[] args){
		String[] lista = new String[10000];
		Random chave = new Random();
		sub novo = new sub();
		chave.nextInt(50000);
		String random = chave.toString(); 
		String entrar;
		int resposta = 0;
		
		while(resposta != 4)
		{
		resposta = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite : \n 1 para Inseriçoes \n 2 Para Buscar  \n 3 Para ver toda lista \n 4 para Sair")) ;
		if(resposta == 1)
			{
			resposta = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite : \n 1 Para Linear \n 2 Para Quadratica \n 3 Duplo Hash \n 4 Sair")) ;
			if(resposta == 1)
			{
			entrar = JOptionPane.showInputDialog("Digite o nome para adicionar");
			inserirlin(lista,entrar,random,novo);
			}
			if(resposta == 2)
			{
			int vzs = 1;
			int cntrl = 2;
			entrar = JOptionPane.showInputDialog("Digite o nome para adicionar");
			int pos = atribuir(lista,entrar);
			inserirSeq(lista,entrar,random,pos,vzs,cntrl);
			}
			if(resposta == 3)
			{
			entrar = JOptionPane.showInputDialog("Digite o nome para adicionar");
			inserir(lista,entrar,random , novo);	
			}
			resposta = 5;
			}
		if (resposta == 2)
		{
			resposta = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite : \n 1 Para Linear \n 2 Para Quadratica \n 3 Duplo Hash \n 4 Para Universal \n 5 Sair")) ;
			if(resposta == 1)
			{	
			int calculo;
			entrar = JOptionPane.showInputDialog("Digite o nome para procurar");
			calculo = atribuir(lista,entrar);
			buscar(lista ,entrar, calculo);
			}
			if(resposta == 2)
			{	
				int calculo;
				int vzs = 1;
				int cntrl = 1;
				entrar = JOptionPane.showInputDialog("Digite o nome para procurar");
				calculo = atribuir(lista,entrar);
				buscarSeq(lista ,entrar, calculo,vzs,cntrl);
			}
			if(resposta == 3)
			{	
				int calculo;
				entrar = JOptionPane.showInputDialog("Digite o nome para procurar");
				calculo = atribuir(lista,entrar);
				buscarDuplo(lista ,entrar, calculo,random,novo);
			}
			if(resposta == 4)
			{
				Random escolha = new Random();
				int esc = escolha.nextInt(3);
				if(esc == 1)
				{
					int calculo;
					entrar = JOptionPane.showInputDialog("Digite o nome para procurar");
					calculo = atribuir(lista,entrar);
					buscar(lista ,entrar, calculo);
				}
				if(esc == 2)
				{
					int calculo;
					int vzs = 1;
					int cntrl = 2;
					entrar = JOptionPane.showInputDialog("Digite o nome para procurar");
					calculo = atribuir(lista,entrar);
					buscarSeq(lista ,entrar, calculo,vzs,cntrl);
				}
				if(esc == 3)
				{
					int calculo;
					entrar = JOptionPane.showInputDialog("Digite o nome para procurar");
					calculo = atribuir(lista,entrar);
					buscarDuplo(lista ,entrar, calculo,random,novo);
				}
			}			
			resposta = 5;
		}
		if (resposta == 3)
		{
		printar(lista,random,novo);
		}
		}
	}

}
