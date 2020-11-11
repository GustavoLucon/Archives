package Arvore;

public class Main {
	public static void main (String args[]){  
		
		// teste da arvore = Funcionando
        Arvore t = new Arvore();  
        t.inserir(1);  
        t.inserir(2);  
        t.inserir(3);  
        t.inserir(4);  
        t.inserir(5);  
        t.inserir(6);  
        t.inserir(7);  
        t.inserir(8);  
        t.inserir(9);  
        System.out.print(t.busca(5).chavePai);
        System.out.print("\n ----------------------------------- \n");
        t.MostrarArvore();  
        
    	// teste da Pilha = Funcionando
        
        System.out.print("----------------------------------- \n");
        
        Pilha pilha = new Pilha(3);
        pilha.inserirPilha(1);
        pilha.inserirPilha(2);
        pilha.verPilha();
        System.out.print("----------------------------------- \n");
        pilha.inserirPilha(3);
        pilha.verPilha();
        System.out.print("----------------------------------- \n");
        pilha.retirarPilha();
        pilha.retirarPilha();
        pilha.verPilha();
        System.out.print("----------------------------------- \n");
        pilha.retirarPilha();
        pilha.verPilha();
        
        
        
        
        
    }  
	
}
