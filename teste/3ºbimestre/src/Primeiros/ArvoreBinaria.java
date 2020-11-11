package Primeiros;
import javax.swing.JOptionPane;

class arvore1{
	int valor;
	arvore1 antes ,depois;
	arvore1(int novo)
	{
		this.valor = novo;
	}
	
	public void inserir(arvore1 n, int valor) {
		if (valor < n.valor) {
		if (n.antes != null) {
		inserir(n.antes, valor);
		} else {
		System.out.println(" Inserindo " + valor + " a esqueda de " + n.valor);
		n.antes = new arvore1(valor);
		}
		} else if (valor > n.valor) {
		if (n.depois != null) {
		inserir(n.depois, valor);
		} else {
		System.out.println(" Inserindo " + valor + " a direita de " + n.valor);
		n.depois = new arvore1(valor);
		}
		}
		}
}
public class ArvoreBinaria
{
	public static void main(String[] args) {
		int resposta = 0;
		int var = 1;
		arvore1 arvore2 = new arvore1(1);
		while (resposta != 7)
		{
			resposta = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite : \n 1 para Inserir informação \n 2 para Consultar informação \n 3 para Percurso em pré-ordem \n 4 para Percurso em ordem \n 5 para Percurso em pós-ordem \n 6 para Caminhamento de Euler \n 7 para Sair.")) ; 		
			if (resposta == 1)
			{
				while (var != 0)
				{
				var = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o numero a ser adicionado e digite 0 para encerrar")) ; 
				if(var != 0)
				{
				arvore2.inserir(arvore2 , var);
				}
			}
			}	
			else if (resposta == 2)
			{
			var = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o numero a ser procurado")) ; 
			buscar(arvore2 , var);
			}
			else if (resposta == 3)
			{
				System.out.println("");
				pre(arvore2);
			}
			else if (resposta == 4)
			{
				System.out.println("");
				ordem(arvore2);
			}
			else if (resposta == 5)
			{
				System.out.println("");
				pos(arvore2);
			}
			else if (resposta == 6)
			{
				System.out.println("");
				caminhamento(arvore2);
			}
			
		}
}

	private static void pre(arvore1 n) {
			if(n != null)
			{
			System.out.print(n.valor +" ");
			pre(n.antes);
			pre(n.depois);		
			}
		}
	private static void ordem(arvore1 n) {
		if(n != null)
		{
		ordem(n.antes);
		System.out.print(n.valor +" ");
		ordem(n.depois);		
		}
	}
	private static void pos(arvore1 n) {
		if(n != null)
		{
		pos(n.antes);
		pos(n.depois);	
		System.out.print(n.valor +" ");
		}
	}
	private static void caminhamento(arvore1 n) {
		if(n != null)
		{
		caminhamento(n.antes);
		System.out.print(n.valor +" ");
		caminhamento(n.depois);
		System.out.print(n.valor +" ");
		}
	}


	private static void buscar(arvore1 n, int valor) {
		if (n.valor != valor)
		{
			if (n.valor > valor)
			{
				if(n.antes != null)
				{
				buscar(n.antes , valor);
				}
				else
				{
					System.out.println("Valor nao foi encontrado");
				}
			}
			else
			{
				if(n.depois != null)
				{
				buscar(n.depois , valor);
				}
				else
				{
					System.out.println("Valor nao foi encontrado");
				}
			}
			}
		else
		{
			System.out.println("Valor encontrado");
		}
	}
	}
