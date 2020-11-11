package Pai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class Lembretes {
	public int altura = 0 ;
	public static BD banco = new BD() ;
	 private static String curDir = System.getProperty("user.dir");
	 
	 public static void main(String args[]){
		 if(altura != 0)
		 {
			 
		 }
	 }
	 
	 
	 
	   private static void Escrever(String Texto, String caminho) {
	       	 try {  
	       	
	       		          File arquivo;  
	       		   
	       		          arquivo = new File(caminho);  
	       		          FileOutputStream fos = new FileOutputStream(arquivo);        		        
	       		          fos.write(Texto.getBytes());  
	       		          fos.close();  
	       }
			       catch (Exception ee) {  
	    		          ee.printStackTrace(); 
	    		          Escrever("Erro De Escrita\n \n" + ee,curDir + "\\DB.txt"); 
	     	        	 System.exit(0);
	    		       }  
	       }
	   
		private static String[] ImportarEmail(String Caminho) { 
			String[] Vetor = new String[10];

		       try {  
		          BufferedReader leitor = new BufferedReader(new FileReader(Caminho));
		          String linhas;
		          linhas = leitor.readLine();
		          int cont = 0 ;
		          int i = 0 ;
		          int a = 0 ;
		          String[] b= linhas.split("");
		          
		          String bandeira = "¬";
		          String Nome = "";
		          String ID = "";
		          String Anotacao = "";
		   
		          while (linhas != null) 
		          {  
		        	  b= linhas.split("");
		        			if(b.length > a)
		        			{
		        				if(b[a].equals("¢"))
		        				{
		        				bandeira = "¢";
		        				a++;
		        				}
		        				else if(b[a].equals("£"))
		        				{
		        					bandeira = "£";
			        				a++;
		        				}
		        				if(bandeira.equals("¬"))
		        				{
		        					Nome = Nome  + b[a];
		        				}
		        				else if(bandeira.equals("¢"))
		        				{
		        					ID = ID  + b[a];
		        				}
		        				else if(bandeira.equals("£"))
		        				{
		        					Anotacao  = Anotacao  + b[a];
		        				}        			
		        			i++;
		        			
		        			}
		        			else
		        			{
		        			banco.CriarFilho(Integer.parseInt(ID), Nome, Anotacao);
							i=0;
							a=0;
							linhas = leitor.readLine();

		        			}
		        			a++;
		    			}  
		        		
		        	    
		        	            leitor.close();  
		        	             
		        	     
		        	         } catch (Exception e) {  
		        	        	 Escrever("Erro De Variavel Incorreta\n \n" + e,curDir + "\\erro.txt"); 
		        	        	 System.exit(0);
		        	        }
		        	        
		      return Vetor;                                
		
	}
}
