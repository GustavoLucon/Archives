import java.util.Random;

import javax.swing.*;

class Bintno{
	int valor;
	Bintno esq,dir;
	Bintno(int novovalor){
		valor =novovalor;
	}
	}
class Arvore{
	private Bintno raiz;
	private Bintno inserir (Bintno ar, int novonum){
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

static boolean pesquisaRec(int vet[], int ini, int fim, int x){
if(x == vet[]){
	   boolean achou = false;                 
 int mid = (ini + fim)/2;
 if (x == vet[mid])
     return achou = true;
 if (x < vet[mid] && mid >= 1 && !achou && mid < fim)
     return pesquisaRec(vet, ini, fim-2, x);
 else if (x > vet[mid] && mid < vet.length-1 && !achou && mid > ini)
     return pesquisaRec(vet, ini-2, fim, x);
return achou;
}
}

public static class Exe4 {
	public static void main (String[]args){
		Arvore arv = new Arvore();
		System.out.println("Bem vindo a arvore versao 2");
		int a = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opçoes" + "\n1 - Inserir Informaçao"+"\n2 - Consultar Informaçao"+ "\n3 - Percurso em Ordem"+ "\n4 - Percurso em PreOrdem"+ "\n5 - Percurso em PosOrdem"+ "\n6 - Caminho de Euler"+ "\n7 - Sair"));
		if(a==1){
		 while(a > 0){	
		arv.inserirnum(Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro e digite 0 para continuar")));
		arv.exibirnum();
		  if(a==0){ 
		return ;	
		}	
		}
		}
		if(a==2){
		int x= Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a ser procurado"));	
			
		}
		if(a==3){
		 if(arv != null) {
    	arv.exibirnumesquerda();
        System.out.println(arv.raiz+ " ");
        arv.exibirnumdireita();
        return; //ordem
			    }
	 }
        if(a==4){
         if(arv != null) {
        System.out.println(arv.raiz+ " ");
        arv.exibirnumesquerda();
        arv.exibirnumdireita();
        return; //preordem
        	    }
     }
        if(a==5){
       	 if(arv != null) {
       	arv.exibirnumesquerda();
        arv.exibirnumdireita();
       	System.out.println(arv.raiz+ " ");     
       	return; //posordem
 	 }
        }
	}
}
}
       /* if(a==6){
        exibirnumesquerda();
        System.out.println(arv.raiz+ " ");
        exibirnumdireita(); //euler
        	}
     }
		if(a==7){
			System.exit(0);
		}
		}
}
}*/
