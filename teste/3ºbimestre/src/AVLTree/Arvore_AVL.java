package AVLTree;

import javax.swing.JOptionPane;

 public class  Arvore_AVL {  
	        No raiz;  
	        public class No{  
	            int info, fat_bal;  
	            No dir, esq;  
	              
	            public No(int dado){  
	                esq = dir = null;  
	                this.info = dado;  
	               this.fat_bal = 0;  
	           }  
	     
	           public void inserir( int valor ){  
	              if( valor < info ){  
	                  if( esq == null ){  
	                      esq = new No( valor );  
	                  }  
	                  else{  
	                      esq.inserir( valor );  
	                  }  
	              }  
	              else if( valor > info ){  
	                  if( dir == null ){  
	                      dir = new No( valor );  
	                  }  
	                  else{  
	                      dir.inserir( valor );  
	                  }  
	              }  
	           }  
	                     
	       }  
	     
	       public Arvore_AVL(){  
	           {  
	               raiz = null;  
	           }  
	       }  

	       public static void main(String args[]){  
	    	   AvlTree arvore = new AvlTree();  
  
	        int ordem =0;
	        int marcas = 0;
	        int var;
	        int respo;
	        while (ordem != 8)
	        {
	        	ordem = Integer.parseInt(JOptionPane.showInputDialog("Digite : \n 1 Para Inserir \n 2 Mostrar Com Marcadores  \n 3 Mostrar Sem Marcadores \n 4 Para Buscar \n 5 Para Eliminar \n 6 Para Contar Nós \n 7 Para Ver Altura \n 8 Para Sair"));
	        	if(ordem == 1)
	        	{
	         		var = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a ser Inserido"));
	        		arvore.insert(var);
	        		System.out.println(var +" Adicionado com sucesso"); 
	           	}
	        	if(arvore.isEmpty()!= true)
	        	{
	        	if(ordem == 2)
	        	{
	        		arvore.displayTree();  
	        	}
	        	if(ordem == 3)
	        	{
	        		while (marcas != 4)
	        		{
	        		marcas = Integer.parseInt(JOptionPane.showInputDialog("Digite : \n 1 Para Pre-Ordem \n 2 Para Pos-ordem \n 3 Para In-Ordem \n 4 Para Sair"));
	        		if(marcas == 1)
	        		{
	        			arvore.preorder(); 
	        		}
	        		if(marcas == 2)
		        	{
	        			arvore.postorder(); 
			        }
	        		if(marcas == 3)
	        		{
	        			arvore.inorder(); 
			        }
	        		}
	        		marcas = 0;

		        }
	        	else if(ordem == 4)
	        	{
	           		AvlNode resposta;
	        		var = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a ser Procurado"));
	        		resposta = arvore.search(var);
	        		if(resposta == null)
	        		{
	        			System.out.println("Valor Nao Encontrado"); 
	        		}
	        		else
	        		{
	        			System.out.println("Valor Encontrado"); 
	    	  
	        		}
	        	}
	        	}
	        	else
	        	{
	        		if(ordem > 1 && ordem < 8)
	        		{
	        		System.out.println("Arvore Vazia Adicione Algo Antes de Realizar Esta Opercao"); 	
	        		}
	        		else
	        		{
	        			System.out.println("Comando Nao Existe"); 
	        		}
	        		}
	        	if(ordem == 5)
	        	{
	        		
	        		var = Integer.parseInt(JOptionPane.showInputDialog("Digite : \n 1 Para Arvore \n 2 Para Numero"));
	        		if(var == 1)
	        		{
	           		respo = Integer.parseInt(JOptionPane.showInputDialog("Tem Certeza Que Deseja Fazer Isto? \n Toda Sua Arvora Sera Perdida. \n Digite 9090 Para Sim \n Qualquer Outro Para Nao "));
		        	if (respo == 9090)
		        	{
		        		arvore.clear();
		        		System.out.println("Arvore Eliminada "); 
		        	}
	        		}
	        		else if(var == 2)
	        		{
	 	        	respo = Integer.parseInt(JOptionPane.showInputDialog("Digite o Numero a Ser Deletado "));
			        arvore.remove(respo);		
	        		}
	        	}
	        	if(ordem == 6)
	        	{
	           		respo = arvore.ContarNo();
	        		System.out.println("Existem " + respo + " Nos"); 
	        	}
	        	if(ordem == 7)
	        	{
	        		arvore.altura(); 
	        	}
	        	if(ordem == 8)
	        	{
	        		System.out.println("");
	        		System.out.println("Tenha um Bom Dia"); 
	        		 System.exit(0);  
	        	}
	        }
	             
	       }
 }