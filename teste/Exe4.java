import java.util.Random;
import javax.swing.*;
	class Bintno{
		int valor;
		Bintno esq,dir;
		Bintno(int novovalor){
			valor =novovalor;
		}
		}
	public class Exe4 {
		public Bintno raiz;
		public Bintno inserir (Bintno ar, int novonum){
			if(ar == null){
				return new Bintno(novonum);
			}
			else{
				if(novonum<ar.valor){
					ar.esq = inserir(ar.esq,novonum);
				}
				else{
					ar.dir =inserir(ar.dir, novonum);
				}
			}
			return ar;
		}
	
	public void inserirnum (int novovalor){
		raiz = inserir(raiz,novovalor);
	}
	private void exibiresquerda(Bintno arv){
		if(arv !=null){
			exibiresquerda(arv.esq);
			System.out.println(arv.valor+ " ");
		}
	}
	private void exibirdireita(Bintno arv){
		if(arv != null){
			exibirdireita(arv.dir);
			System.out.println(" "+ arv.valor);
		}
	}
	public void exibirraiz(){
		System.out.println("Raiz" + raiz.valor);
		}
	public void exibirnumesquerda(){
		exibiresquerda(raiz);
		}
	public void exibirnumdireita(){
		exibirdireita(raiz);
		}
	public void exibirnum(){
		exibirraiz();
		exibirnumesquerda();
		exibirnumdireita();
		}
	
	private static boolean Busca(int[] ver, int ini, int valor, int fim , int x) {
		 boolean achou;
			if(x != valor)
			{
			 achou = false;  
			}
			else
			{
				achou = true;
			}
			if (ini >= fim && fim <= ver.length && ini >= 0)
			{
		 int mid = (ini + fim)/2;
		 if (x < ver[mid])
		 {
			 return Busca(ver, ini, fim-2, x, valor);
		 }
		 else if (x > ver[mid])
			 {
			 return Busca(ver, ini+2, fim, x,valor);
			 }
		 else
		 {
		return achou;
		}
		}
		else
		{
		return false;
		}
	}
	
	public static void main (String[]args){
			Arvore arv = new Arvore();
			
			Random random = new Random();   
			int ver [] = new int[11];   
			int d;	
			for( int i = 0; i < 11; i++ ){
				d = random.nextInt(50);
			ver[i]= d;
				}
			int a = 0;
			while(a != 7)
			{
			int i;
				for(i =0; i <ver.length; i++){
				System.out.println(ver[i]);
				}
		 a = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opçoes" + "\n1 - Inserir Informaçao"+"\n2 - Consultar Informaçao"+ "\n3 - Percurso em Ordem"+ "\n4 - Percurso em PreOrdem"+ "\n5 - Percurso em PosOrdem"+ "\n6 - Caminho de Euler"+ "\n7 - Sair"));
			
			
			if(a==1){
			 do{
				int f ;
				 f =Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro e digite 0 para continuar"));
				 arv.inserirnum(f);
				 a= f;
			 }
				while(a != 0);	
			 arv.exibirnum();
			 }
				
			if(a==2){
				int haha;
			int x= Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a ser procurado"));	
			haha =  ver[i];
			System.out.println();
		 }
			if(a==3){
			 if(arv != null) {
	    	arv.exibirnumesquerda();
	        System.out.println(arv.raiz+ " ");
	        arv.exibirnumdireita();
	        return; 
				    }
		 }
	        if(a==4){
	         if(arv != null) {
	        System.out.println(arv.raiz+ " ");
	        arv.exibirnumesquerda();
	        arv.exibirnumdireita();
	        return; 
	        	    }
	     }
	        if(a==5){
	       	 if(arv != null) {
	       	arv.exibirnumesquerda();
	        arv.exibirnumdireita();
	       	System.out.println(arv.raiz+ " ");     
	       	return; 
	 	 }
	        }
	        if(a==6){
	        arv.exibirnumesquerda();
	        System.out.println(arv.raiz + " "); 
	        arv.exibirnumdireita(); 
	      }
	        while(a!=7)
	        	System.exit(0);
			}
			}
		}

	