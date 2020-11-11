package Decodificador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

	class arvore{
		arvore conx = null;
		String valor;
		String linha;
		public void arvore(String n, String linha2) 
		{
			this.valor = n;
	        int h =0 ;
	        boolean ficar = true;
			this.linha = linha2;	
		}
}

	public class Menu 
	{
		public static void main(String[] args) throws IOException{
		arvore arv = new arvore();
		int linha = 1;
		int i = 0;
		int ordem =0;
	 	int resposta = 0;
	 	int opt ;
	 	 while (ordem != 5)
	     {
	     	ordem = Integer.parseInt(JOptionPane.showInputDialog("Digite : \n 1 Para Receber Arquivo de Texto \n 2 Comprimir o arquivo Texto \n 3 Para Extrair o Arquvio \n 4 Mostrar a Arvore \n 5 Para Sair"));
	     	if(ordem == 1)
	     	{
	     		opt = 1;
	     		entrada(arv,i,linha);
	     		System.out.println("");
	     		Escrever(arv,opt);
	     	}
	     	else if( ordem == 2)
	     	{
	     		opt = 1;
	     		System.out.println("");
	     		Escrever(arv,opt);
	     	}
	     	else if( ordem == 3)
	     	{
	     		opt = 2;
	     		System.out.println("");
	     		Escrever(arv,opt);
	     	}
	     	else if( ordem == 4)
	     	{
	     		int resposta2 = 0;
	     		resposta2 = Integer.parseInt(JOptionPane.showInputDialog("Digite : \n 1 Para Palavras \n 2 Para Marcadores \n 3 Para Palavras Com Marcadores"));
	     		System.out.println("");
	   	    	 pos(arv,resposta2);
	     	}
	     	else if(ordem == 5)
	     	{
	     		System.out.println("");
	    		System.out.println("Tenha um Bom Dia"); 
	    		System.exit(0);  
	     	}
	     	else
	     	{
	    		System.out.println("Este Numero Nao Faz Nada"); 

	     	}
	     }
	     }
		public static String OndeEsta(arvore arv) 
    	{
		String local = "0";
		if(arv.conx != null)
    	{
		local = local + OndeEsta(arv.conx);
		String[] b = local.split("");
		local = Juntar(b);
     	return local;
    	}
		else
		{
			local = "0";
			return local;
		}
    	}
		public static String Juntar(String[] b) 
    	{
			String local = "";
			int i = b.length - 1;
			while(i > 1 && b[i-1] != "")
	    	{
	    		if(b[i].equals("0"))
	    			{
	    		if(b[i-1].equals("0"))
	    		{
	    		b[i] = "";
	    		b[i-1] = "1";
	    		}
	    	}
	    	i--;
	    	}
			for(int h = b.length - 1;h >= 0;h--)
	    	{
				if(b[h] != "")
				{
				local = local + b[h];	
				}
	    	}
			return local;
    	}
		public static void entrada(arvore arv ,int i, int linha) throws IOException 
    {
		try{
			String comparar;
			BufferedReader reader = new BufferedReader(new FileReader("teste.txt"));
			comparar = reader.readLine();
			while(comparar != null && i < comparar.length()&& comparar.toString() != "")
			{ 
			String[] b = comparar.split(" ");
							if(b.length > i)
						{
							ins(arv ,b[i].toLowerCase(), OndeEsta(arv));
							i++;
						}
						else
						{
							i=0;
							linha++;
							comparar = reader.readLine();
						}
					}			
			reader.close();  
			}   
        catch (FileNotFoundException e1) { 
        	System.out.println("File not found!");          	
        }
    }
        public static void ins(arvore a ,String n, String linha) 
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
            		String li = linha;
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
        private static void buscar(arvore n, String valor , String linha) {
           	if(n.valor != null)
    		{
        	if (n.valor != valor)
    		{
    			buscar(n.conx , valor , linha);
    		}
    		else
    		{
    			n.arvore(valor,linha);	
    		}
    		}
    	}
        private static void pos(arvore n,int opcao) {
    		if(n != null && n.conx != null)
    		{
    		pos(n.conx,opcao);
     		if(n.valor != null || n.valor != "null" || n.valor != "")
    		{
     		if(opcao == 1)
     		{
        		System.out.println("Palavra :" + n.valor);
     		}
     		else if(opcao == 2 )
     		{
        		System.out.println("Marcador :" + n.linha);
     		}
     		else if(opcao == 3)
     		{
        		System.out.println("A Palvra :" + n.valor + "  Na Marcaçao :" + n.linha);
     		}
    		}
    		}      	
        }
        private static String mesclar(arvore arv) {
        	String a = "" ;
        	if(arv != null && arv.conx != null)
    		{
        		a = arv.valor + " " + a + ""+ mesclar(arv.conx);
    		}
        	return a;
        	
        }
        private static String mesclar2(arvore arv) {
        	String a = "" ;
        	if(arv != null && arv.conx != null)
    		{
        		a = arv.linha + " " + a + ""+ mesclar2(arv.conx);
    		}
        	return a;
        	
        }
        private static void Escrever(arvore arv,int a) {
        	 try {  
        	
        		          File arquivo;  
        		   
        		          arquivo = new File("arquivoComprimido.txt");  
        		          FileOutputStream fos = new FileOutputStream(arquivo); 
        		          String texto = "Vazio";
        		          if(a == 2)
        		          {
        		          texto = mesclar(arv);
        		          }
        		          if (a == 1)
        		          {
        		          texto = mesclar2(arv);
        		          }
        		          fos.write(texto.getBytes());  
        		          fos.close();  
        		          FileInputStream fis = new FileInputStream(arquivo);  
        		          int ln;  
        		          System.out.println("Arquivo Criado com Nome arquivoComprimido.txt Com Conteudo ");
        		          while ( (ln = fis.read()) != -1 ) {  
        		             System.out.print( (char)ln );  
        		          }  
        		   
        		          fis.close();  
        		       }  
        		       catch (Exception ee) {  
        		          ee.printStackTrace();  
        		       }  
        }
        }
	



