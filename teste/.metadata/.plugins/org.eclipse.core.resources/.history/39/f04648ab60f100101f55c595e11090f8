
public class fila {
		class Fila
		{
			int vetor[];
			int tamanho , inicio , fim , total ;
			Fila(int tam)
			{
			inicio = 0 ;
			fim =0 ;
			total = 0;
			tamanho = tam ;
			vetor = new int [tam];
			}
		public boolean Filavazia() 
		{
			if(total == 0 )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		public boolean Filacheia() 
		{
			if(total >= tamanho )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		public void Enfileirar(int elemento) 
		{
			if(! Filacheia())
			{
				vetor[fim] = elemento;
				fim++;
				total++;
				if(fim >= tamanho)
				{
					fim = 0;
				}
			}
			else
			{
				System.out.println("Fila cheia");
			}
		}
		public int Desenfileirar() 
		{
			int desen = 0;
			if(Filavazia())
			{
			System.out.println("fila vazia");
			}
			else
			{
			desen = vetor[inicio];
			inicio++ ;
			total--;
			if(inicio >= tamanho)
			{
				inicio = 0;
			}
			}
			return desen;
		}
		public void Mostrador() 
		{
		int i , aux;
		aux = inicio;
		for (i = 1 ; i<= total ; i++)
		{
			System.out.println("Elemento" + vetor[aux] + "posição" + i);
			aux++;
			if(aux >= tamanho)
			{
				aux = 0;		
		}
		}
		}
		}
}
