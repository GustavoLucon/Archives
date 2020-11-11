package GrafoTotal;

public class Linha {
// Esqueci qual é aresta e qual e vertice =D
	        private String nome;
	        private Ponto Lado1 ;
	        private Ponto Lado2 ;
	       
	        public Linha(Ponto A, Ponto B,String nome) {
	                this.nome = nome;
	                this.Lado1 = A;
	                this.Lado2 = B;
	        }
	    	public String getNome() {
	    		return nome;
	    	}
	    	public Ponto Ligar(String a)
	    	{
	    		if(Lado1.getNome().equals(a))
	    		{
	    		return Lado2;
	    		}
	    		else
	    		{
	    		return Lado1;	
	    		}
	    	}
	    	public String LigarNome(String a)
	    	{
	    		if(Lado1.getNome().equals(a))
	    		{
	    		return Lado2.getNome();
	    		}
	    		else
	    		{
	    		return Lado1.getNome();	
	    		}
	    	}
	}

