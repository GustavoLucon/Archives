package GrafoTotal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Grafo {
 private static Ponto pontos[] = new Ponto[200000];
 private static int altura=0;
 
 public static void main(String[] args) 
 {
	 int resposta = 1;
	 // Menu
	 while (resposta != 0)
	 {
	 resposta = Integer.parseInt(JOptionPane.showInputDialog("Digite : \n 1 Para Inserir Vertice \n 2  Para Inserir Aresta \n 3 Para Checar \n 4 Para Exibir \n 5 Para Importar Arquivo Texto \n 6 Para Ajuda \n 0 Para Sair"));
	
	 // Inseri um vertice (ponto)nao sei ainda qual e qual =P
	 if(resposta == 1)
	 {
		String nome = JOptionPane.showInputDialog("Digite o nome do Vertice");
		 CriarVertice(nome);
	 }
	 if(altura != 0)
	 {
	// Inseri uma aresta (linha)nao sei ainda qual e qual =P
	 if(resposta == 2)
	 {
		 String nome = JOptionPane.showInputDialog("Digite o nome do Vertice");
		 String nome2 = JOptionPane.showInputDialog("Digite o nome do Outro Vertice");
		 CriarAresta(nome,nome2);
	 }
	 // Checa Se ele é oileriano e a outra coisa que ele tambem tinha q ser a qual eu esqueci lol
	 else if(resposta == 3)
	 {
		 if(ChecarOileriano())
		 {
			 System.out.println("Ele é Oileriano");
		 }
		 else
		 {
			 System.out.println("Ele Não é Oileriano");
		 }
		 if(ChecarHamiltoniano())
		 {
			 System.out.println("Ele é Hamiltoniano");	 
		 }
		 else
		 {
			 System.out.println("Ele Não é Hamiltoniano");
		 }
	 }
	 //Exibe o grafo (auto-explicativo)
	 else if(resposta == 4)
	 {
			for(int i =0; i < altura;i++)
			{
				System.out.println("O vertice :"+pontos[i].getNome() + "\n Esta Ligado a:" + pontos[i].LerConexoes());
			}
	 }
	 }
	 else if(resposta == 3 || resposta == 4 || resposta == 2)
	 {
		 System.out.println("O Grafo Esta Vazio");
	 }
	 if(resposta == 6)
	 {
		 System.out.println("1-Inseri um vertice(ponto) no grafo");
		 System.out.println("2-Inseri uma aresta (linha) no grafo");
		 System.out.println("3-Checa Se ele é oileriano ou amiltoniano");
		 System.out.println("4-Exibe o grafo (auto-explicativo)");
		 System.out.println("5-Importa Um arquivo .txt e o tranforma em matriz \n Deve se Digitar O endereço dele como \n Por exemplo : C:/Pasta/Arquivo.txt \n Com as Barras invertidas Em Relação ao Desenho");
	 }
	 else if(resposta == 5)
	 {
		 String nome = JOptionPane.showInputDialog("Digite o Caminho do Arquivo");
		 ImportarTxt(nome);
	 }
	 else if(resposta == 0)
	 {
		 System.out.println("Obrigado Por Utilizar Este Software"); 
	 }
	 }
 }
 
private static void CriarAresta(String nome, String nome2) {
	Ponto A =ProcurarVertice(nome);
	 Ponto B =ProcurarVertice(nome2);
	 String nomearesta = nome + "-"+  nome2;
	 if(A != null && B != null)
	 {
		 A.GerarConexões(A, B,nomearesta);
		 B.GerarConexões(B, A,nomearesta);
		 System.out.println("Aresta entre " + nome + " e " + nome2 + " Foi Criada");
	 }
	 else
	 {
		 System.out.println("Nao pode ser criada aresta porque nao foi encontrado algum Vetor");
	 }
	
}

private static void CriarVertice(String nome) {

	 if(ProcurarVertice(nome) == null)
	 {
	 pontos[altura] = new Ponto(nome);
	 altura++;
	 System.out.println("Vertice " + nome + " Foi Criado");
	 }
	 else
	 {
		 System.out.println(nome + " Ja Existe no Grafo");
	 }
	
}

//Importa o arquivo Txt 
private static void ImportarTxt(String Caminho) {
	       String linha = null;  
	   
	       try {  
	    	   String linhas;
	    	   int i =0;
	          FileReader reader = new FileReader(Caminho);  
	          BufferedReader leitor = new BufferedReader(reader);
	          linhas = leitor.readLine();
	   
	          while (linhas != null && linhas.toString() != "") 
	          {  
	        	  String[] b = linhas.split("");
	        		for(int a =0; a < b.length;a++)
	    			{
	        			if(b.length > i)
	        			{
	        			if(b[a].equals("") == false && b[a].equals(" ") == false)
	        			{
	        				if(a+1 <  b.length && b[a+1] != null &&  b[a+1].equals("-"))
	        				{
	        					CriarAresta(b[a],b[a+2]);
	        					i = i+3;
	        				}
	        				else if(ProcurarVertice(b[a]) == null)
						    {
						    	CriarVertice(b[a]);
						    }
							i++;

	        			}
	        			}
					else
					{
						i=0;
						linhas = leitor.readLine();
					}
	    			}        	             
	        	    }  
	        	            leitor.close();  
	        	            reader.close();  
	        	     
	        	         } catch (Exception e) {  
	        	        	 System.out.println("Arquivo Não Encontrado");  
	        	        }                                 
	
}


//Checar se é Hamiltoniano
private static boolean ChecarHamiltoniano() {
int i=0;
int pont ;
for(int a = 0;a< altura;a++)
{
	pont =pontos[i].getNumeroConexoes();
	 if(pont%2 == 0 && pont != 0)
	 {
		i++; 
	 }
	 
}
if(i == altura)
{
	return true;
}
else
{
	return false;
}	
}
//Checa se e oileriano
private static boolean ChecarOileriano() {

	String inicial;
	String Caminho[] = new String [10];
	int local = 0;
	for(int i =0; i < altura;i++)
	{
	inicial = pontos[i].getNome();
	if(pontos[i].ChecarCaminho(inicial,Caminho, local,altura+1))
	{
		return true;
	}
	}
	return false;
	
}
//Procura por um Vertice de todos os conhecidos
private static Ponto ProcurarVertice(String nome) {
	for(int i =0; i < altura;i++)
	{
		if(pontos[i].getNome().equals(nome))
		{
			return pontos[i];
		}	
	}
	return null;
}
 
}
