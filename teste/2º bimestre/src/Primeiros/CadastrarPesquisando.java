package Primeiros;
import javax.swing.JOptionPane;


class Cadastro {
		String nome ;
		String endereco ;
		int telefone ;
		Cadastro(String n ,String e,int tel)
		{
			nome = n ;
			endereco = e;
			telefone = tel;
		}
	}
public class CadastrarPesquisando {
	public static void main (String args[]){
		{
			int resposta = 0;
			String pergunta;
					Cadastro pessoa[] = new Cadastro[10];
			for(int cont = 0; cont < 9 ;cont++ )
			{
				pessoa[cont] = new Cadastro("" , "" , 0 );
			}
			for(int cont = 0; cont < 9 ;cont++ )
			{
				pessoa[cont].nome = JOptionPane.showInputDialog (null , "Digite o nome da pessoa");			
			    pessoa[cont].endereco = JOptionPane.showInputDialog (null , "Digite o endere�o dela");
			    pessoa[cont].telefone = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o telefone dela"));
			}
			resposta = Integer.parseInt(JOptionPane.showInputDialog (null , "Deseja pesquisar algum nome Digite 0 para SIM  1 para apresentar todos e qualquer outro para n�o"));
			while(resposta == 0 || resposta == 1)
			{
				if (resposta == 0 )
					{
					pergunta = JOptionPane.showInputDialog (null , "Digite o nome da pessoa");
				for(int cont = 0; cont < 9 ;cont++ )
				{
					if(pergunta.equals(pessoa[cont].nome))
					{
					System.out.println ("O nome � " + pessoa[cont].nome	+ " o telefone � " +  pessoa[cont].telefone + " e o endere�o � " + pessoa[cont].endereco);
					}
					else if (cont == 8)
					{
						System.out.println ("A pessoa nao foi encontrada");	
					}
				}
					}
			else 
			{
				for(int cont = 0; cont < 9 ;cont++ )
				{
					System.out.println ("O nome � " + pessoa[cont].nome	+ " o telefone � " +  pessoa[cont].telefone + " e o endere�o � " + pessoa[cont].endereco);
				}
			}
			resposta = Integer.parseInt(JOptionPane.showInputDialog (null , "Deseja pesquisar algum nome Digite 0 para SIM  1 para apresentar todos e qualquer outro para n�o"));
			}
			}
		}	
}
