package Arvore;

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
	    	if(noRaiz == null)
	    	{
	    	noRaiz = inserirNo (x, noRaiz);  
	    	}
	    	else if(noRaiz.chavePai >= x)
	    	{
	        inserirNo (x, noRaiz);  
	    	}
	    	else
	    	{
	    	inserirNo (x, noRaiz); 	
	    	}
	        return true;  
	    }  

	    private No inserirNo (int x, No t) {  
	        if( t == null )
	        {
	            t = new No( x, null, null );
	        }
	        else if( x < t.getChavePai())
	        	{
	        	t.esquerda = inserirNo(x,t.esquerda);
	        	}
	        else if( x > t.getChavePai())
	        	{
	        	t.direita = inserirNo(x, t.direita );  
	        	}
	        
	        return t;  
	    } 
	 
	    
	    public void remover (int x){
	    	noRaiz = removerNo(x, noRaiz);
	    }
	     // inicio alterado por gustavo
	    
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
	    	if(t.esquerda != local)
	    	{
	    	t.esquerda  = mudar;	
	    	}
	    	if(t.direita  != local)
	    	{
	    	t.direita  = mudar;	
	    	}
	    	 if( x<t.chavePai ) t = kill( x, t.esquerda,local,mudar );  
	         if( x>t.chavePai)  t = kill( x, t.direita,local,mudar );
	    	return t;
	    	
	    }
	   public int Contar() {  
	        int no;
	    	no = ContarNo(noRaiz);  
	        return no ;  
	    }      
	    private int ContarNo (No t) 
	    {  
	    	 int a = 0 ;
	    	 if( t != null ) 
	    	 {
	             a++;
	             a = a + ContarNo(t.esquerda);  
	             a = a + ContarNo(t.direita);
	             return a;
	    	 }
	    	 return a;
	    } 
	    	    
	    
	    public No busca(int el) {  
	        return buscaNo(noRaiz,el);  
	    }  
	    protected No buscaNo(No p, int el) {  
	        while (p != null) {  
	            /* se valor procuradp == chave do nó retorna referência ao nó */   
	            if (el==p.chavePai) return p;  
	            /* se valor procurado < chave do nó, procurar na sub-árvore esquerda deste nó */  
	            else if (el<p.chavePai ) p = p.esquerda ;  
	            /* se valor procurado > chave do nó, procurar na sub-árvore direita deste nó */  
	            else p = p.direita ;  
	        }  
	        // caso chave não foi achada, retorna null  
	        return null;  
	    }  
	    
	    public boolean estaVazio() {  
	        return noRaiz == null;  
	    }  
	/*    
	    public void MostrarArvore() {  
	    	 if (estaVazio()){  
	    	     System.out.println("Árvore vazia!");  
	    	     return;  
	    	 }             
	    	 String separator = String.valueOf("  |__");  
	    	 System.out.println(this.noRaiz.chavePai+"("+noRaiz.altura+")");  
	    	 mostrarNo(noRaiz.esquerda ,  separator);  
	    	 mostrarNo(noRaiz.direita , separator);  
	    	}  
	    	*/
	    public void MostrarArvore() {  
	    	 if (estaVazio()){  
	    	     System.out.println("Árvore vazia!");  
	    	     return;  
	    	 }  
	    	 else
	    	 {
		    	 mostrarNo(noRaiz ,false,"||");   
	    	}
	    }
	    
	      
	    protected No buscaPai (int el) {  
	        No p = noRaiz;  
	        No prev = null;  
	        while (p != null && !(p.chavePai ==el)) {  // acha o nó p com a chave el  
	            prev = p;                             
	            if (p.chavePai <el)  
	                  p = p.direita ;  
	            else p = p.esquerda ;  
	        }  
	        if (p!=null && p.chavePai ==el) return prev;  
	        return null;  
	    }  
	    
	    private void mostrarNo(No node,boolean direita, String separator) {  
	    	   
	    	 if (node != null) {
	    	       
	    		if(direita = true)
	    		{
	    	     System.out.println(" " + node.chavePai + "\n" + separator);
	    		}
	    		else
	    		{
	    		 System.out.println(node.chavePai + "\n" + separator);	
	    		}
	    	     if (node.esquerda != null) {  
	    		 mostrarNo(node.esquerda ,false,separator);  
	    	     }
	    	     if (node.direita != null) { 
	    	     mostrarNo(node.direita ,true,separator);  
	    	     }
	    	 }  
	    	}  
	    
	public No getNoRaiz() {
		return noRaiz;
	}

	public void setNoRaiz(No noRaiz) {
		this.noRaiz = noRaiz;
	}
	
	
	// Final do que gustavo alterou
}
