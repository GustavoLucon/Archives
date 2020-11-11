package nodo.arvore;

import nodo.No;

public class Arvore {
	private No noRaiz;

	
	public Arvore() {
		noRaiz = null;
	}
	
	
	 public boolean arvoreVazia() {  
	        return getNoRaiz() == null;  
	    }  
	
	 
	 
	 public static int alturaArvore(No noAltura){
		 return noAltura == null ?-1 :noAltura.getAltura(); 
		 
	 }
	 
	 public static int maiorNoFilho(int filhoEsq, int filhoDir){
		 
		 return filhoEsq > filhoDir ? filhoDir : filhoEsq;
	 }
	 
	 
	    public boolean inserir (int x) {  
	        noRaiz = inserirNo (x, noRaiz);  
	        return true;  
	    }  

	    private No inserirNo (int x, No t) {  
	        if( t == null )  
	            t = new No( x, null, null );  
	        else if( x < t.getChavePai() ) inserirNo(x,t.getEsquerda());  
	        else if( x > t.getChavePai()) inserirNo( x, t.getDireita() );  
	        
	        return t;  
	    } 
	 
	    
	    public void remover (int x){
	    	noRaiz = removerNo(x, noRaiz);
	    }
	    
	    
	    private No removerNo(int x, No t){
	    	if(t != null){
	    		if(t.getChavePai() == x){
	    			t = kill(x,noRaiz,t,t.getDireita());
	        		t = null;
	        		System.out.println("Valor " + x + " foi Deletado"); 
	        		
	        		if( x > t.getChavePai())  t = removerNo( x, t.getDireita() );
	        		if( x < t.getChavePai() ) t = removerNo( x, t.getEsquerda() );  
	    		}
	    	}
	    	 else
	    	    {
	    	    	System.out.println("Valor " + x + " nao foi Encontrado"); 
	    	    }
	    	        return t;
	    	    }
	    
	    
	    private No kill (int x, No t ,No local ,No mudar ) { 
	    	if(t.left != local)
	    	{
	    	t.left = mudar;	
	    	}
	    	if(t.right != local)
	    	{
	    	t.right = mudar;	
	    	}
	    	 if( x<t.key ) t = kill( x, t.left,local,mudar );  
	         if( x>t.key)  t = kill( x, t.right,local,mudar );
	    	return t;
	    	
	    }
	    
	    
	public No getNoRaiz() {
		return noRaiz;
	}

	public void setNoRaiz(No noRaiz) {
		this.noRaiz = noRaiz;
	}
}
