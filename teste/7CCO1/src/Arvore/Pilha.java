package Arvore;

public class Pilha {

	
	// Pilha para usar na busca de profundidade empilhando nós ja passados na arvore e retirando eles assim que tiver de voltar
	public int altura =0;
	public int[] pilha ;
	
	public Pilha (int tamanho)
	{
		pilha = new int[tamanho];
	}
	
	public void inserirPilha(int node)
	{
		pilha[altura] = node;
		altura++;
	}
	public int retirarPilha()
	{
		int valor = pilha[altura-1];
		altura= altura - 1;
		return valor;
	}
	public void verPilha()
	{
		if (altura == 0)
		{
			System.out.println("Vazia");	
		}
		for(int i = 0; i < altura;i++)
		{
			System.out.println(pilha[i]);
		}
	}
}
