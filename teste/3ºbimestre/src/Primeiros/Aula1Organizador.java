package Primeiros;
import java.util.Random;
import javax.swing.JOptionPane;

public class Aula1Organizador {
public static int buscaBinaria( int[] array, int valor , int esq , int dir , int parou)
	{
		int valorMeio;

		valorMeio = (esq + dir) / 2;  
		if (array.length > valorMeio && valorMeio >= 0)
		{
			if(valorMeio != parou )
			{
			parou = valorMeio;
			if ( array[valorMeio] < valor ) 
			{
				esq = valorMeio + 1;
				valorMeio = buscaBinaria (array , valor ,esq , dir , parou );
				
			}
			else if( array[valorMeio] > valor ) {
				dir = valorMeio - 1;
				valorMeio = buscaBinaria (array , valor ,esq , dir , parou );
			} 
			}
			if (valorMeio != -1 && array[valorMeio] == valor )
			{
				return valorMeio;
			}
			else
			{
			return -1;
			}
		}
		else
		{
		return -1;
		}
			
	}
	
public static int sequencial(int[] a, int x){
		for(int i = 0, n = a.length; i < n; i++){
			if(a[i] == x){
				return i;
			}
		}
		return -1;
	}

public static void radix_sort_uint(int[] a, int bits)
         {
     
             int[] b = new int[a.length];
             int[] b_orig = b;
     
     
             int rshift = 0;
             for (int mask = ~(-1 << bits); mask != 0; mask <<= bits, rshift += bits) {
     
                 int[] cntarray = new int[1 << bits];
     
                 for (int p = 0; p < a.length; ++p) {
                     int key = (a[p] & mask) >> rshift;
                     ++cntarray[key];
                 }
     
     
         		for (int i = 1; i < cntarray.length; ++i)
                             cntarray[i] += cntarray[i-1];
     
     
                 for (int p = a.length-1; p >= 0; --p) {
                     int key = (a[p] & mask) >> rshift;
                     --cntarray[key];
                     b[cntarray[key]] = a[p];
                 }
     
     
                 int[] temp = b; b = a; a = temp;
             }
     
     
             if (a == b_orig)
                 System.arraycopy(a, 0, b, 0, a.length);
         }
	
public static void quicksort(int[] a) {
	       quicksort(a, 0, a.length - 1);
	    }

public static void quicksort(int[] a, int left, int right) {
	        if (right <= left) return;
	        int i = partition(a, left, right);
	        quicksort(a, left, i-1);
	        quicksort(a, i+1, right);
	    }
public static  int BuscaLinear(int []lista, int buscar){
	for(int i = 0, n = lista.length; i < n; i++){
		if(lista[i] == buscar){
			return i;
		}
	}
	return -1;
	
}
public static int buscaLogaritimica( int[] array, int valor , int esq , int dir , int parou)
{
	int valorMeio;

	valorMeio = (esq + dir) / 2;  
	if (array.length > valorMeio && valorMeio >= 0)
	{
		if(valorMeio != parou )
		{
		parou = valorMeio;
		if ( array[valorMeio] < valor ) 
		{
			esq = valorMeio + 1;
			valorMeio = buscaBinaria (array , valor ,esq , dir , parou );
			
		}
		else if( array[valorMeio] > valor ) {
			dir = valorMeio - 1;
			valorMeio = buscaBinaria (array , valor ,esq , dir , parou );
		} 
		}
		if (valorMeio != -1 && array[valorMeio] == valor )
		{
			return valorMeio;
		}
		else
		{
		return -1;
		}
	}
	else
	{
	return -1;
	}
		
}
private static int partition(int[] a, int left, int right) {
	        int i = left - 1;
	        int j = right;
	        while (true) {
	            while (less(a[++i], a[right]))      // find item on left to swap
	                ;                               // a[right] acts as sentinel
	            while (less(a[right], a[--j]))      // find item on right to swap
	                if (j == left) break;           // don't go out-of-bounds
	            if (i >= j) break;                  // check if pointers cross
	            exch(a, i, j);                      // swap two elements into place
	        }
	        exch(a, i, right);                      // swap with partition element
	        return i;
	    }

private static boolean less(int x, int y) {
	        return (x < y);
	    }

private static void exch(int[] a, int i, int j) {
	      int v;
	       v = a[i];
	        a[i] = a[j];
	        a[j] = v;
	    }

public static void SelectionSort(int[] v) {
		   int index_min,
	       aux;
	 
	   for (int i=0; i<v.length; i++) {
	       index_min = i;
	       for (int j=i+1; j<v.length; j++) {
	          if (v[j]<v[index_min]) {
	             index_min=j;
	          }
	       }
	       if(index_min != i){
	         aux = v[index_min];
	         v[index_min] = v[i];
	         v[i] = aux;
	       }
	 
	   }
	}

public static void insertionSort(int[] numbers) {
	    for (int i = 0; i < numbers.length; i++) {
	        int copyNumber = numbers[i];
	        int j = i;
	        while (j > 0 && copyNumber < numbers[j-1]) {
	            numbers[j] = numbers[j-1];
	            j--;
	        }
	        numbers[j] = copyNumber;
	    }
	}

public static void mostrar(int[] numbers) {
		System.out.println("");
		for(int cont=0 ; cont < numbers.length; cont++ )
		{
		System.out.print(numbers[cont] + "|");
		}
	}

public static void main (String args[])
	{
		int resposta = 0;
		int resposta2;
		int achado;
		int algoritimos;
		algoritimos = Integer.parseInt(JOptionPane.showInputDialog (null ,"Quantos numeros aleatorios deseja que sejam gerados? \n Quanto maior o numero maior o tempo utilizado para processa-los")) ; 
		int lista[] = new int[algoritimos];
		for(int cont=0 ; cont < lista.length; cont++ )
		{
			Random random = new Random();
			lista[cont] = random.nextInt(100);
			System.out.print(lista[cont] + "|");
		}
		resposta2 =Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite: \n 1 Para Ordenar o Vetor \n 2 Para Pesquisar um Numero ")) ; 
		if (resposta2 == 1)
		{
		while(resposta != 6)
		{
			resposta = Integer.parseInt(JOptionPane.showInputDialog (null , "1 para Seleção \n 2 para Troca \n 3 para Distribuição \n 4 para Inserção \n 5 para Intercalação \n 6 para Sair "));
			if (resposta < 1 && resposta > 6)
			{
				System.out.println("Este numero nao faz nada");
			}
			else
			{
				if (resposta == 1)
				{
					SelectionSort(lista);
					mostrar(lista);
				}
				if (resposta == 2)
				{
				Aula1Organizador.quicksort(lista);
				mostrar(lista);
				}
				if (resposta == 3)
				{
					radix_sort_uint(lista, 4);
					mostrar(lista);
				}
				if (resposta == 4)
				{
					insertionSort(lista);
					mostrar(lista);
				}
				if (resposta == 5)
				{
					
				}
				if (resposta == 6)
				{
					System.out.println("");
					System.out.println("Espero Ter Sido Util \n Tenha um Bom Dia");
				}
			}
		}
		}
		else if (resposta2 == 2)
		{
			while (resposta != 5)
			{
			int buscar;
			System.out.println("");
			System.out.println("Este e o vetor atual");
			mostrar(lista);
			resposta = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite \n 1 para Sequencial  \n 2 para  Binaria (Vai Ordenar o Vetor) \n 3 Para Linear \n 4  Para Logaritimica para Sair"));
			if(resposta == 1)
			{
				buscar = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero a ser Procurado"));
				achado = sequencial(lista ,buscar);
					
				if(achado == -1)
				{
					System.out.println("");
					System.out.println("O numero nao foi encontrado no Vetor ");
				}
				else 
				{
					System.out.println("");
					System.out.println("O numero foi encontrado no Vetor ");
				}
			}
			else if (resposta == 2)
			{
				buscar = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero a ser Procurado"));
				int inico = 0;
				int fim = lista.length;
				int parou = -2;
				SelectionSort(lista);
				achado = buscaBinaria(lista , buscar , inico , fim, parou);
				if(achado == -1)
				{
					System.out.println("");
					System.out.println("O numero nao foi encontrado no Vetor ");
				}
				else 
				{
					System.out.println("");
					System.out.println("O numero foi encontrado no Vetor ");
				}
			}
			else if (resposta == 3)
			{
				buscar = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero a ser Procurado"));
				achado = BuscaLinear(lista , buscar);
				if(achado == -1)
				{
					System.out.println("");
					System.out.println("O numero nao foi encontrado no Vetor ");
				}
				else 
				{
					System.out.println("");
					System.out.println("O numero foi encontrado no Vetor ");
				}
			}
			else if (resposta == 4)
			{
				buscar = Integer.parseInt(JOptionPane.showInputDialog (null , "Digite o numero a ser Procurado"));
				int inico = 0;
				int fim = lista.length;
				int parou = -2;
				SelectionSort(lista);
				achado = buscaLogaritimica(lista , buscar , inico , fim, parou);
				if(achado == -1)
				{
					System.out.println("");
					System.out.println("O numero nao foi encontrado no Vetor ");
				}
				else 
				{
					System.out.println("");
					System.out.println("O numero foi encontrado no Vetor ");
				}
			}
			else if (resposta == 5)
			{
				System.out.println("");
				System.out.println("Espero Ter Sido Util \n Tenha um Bom Dia");
			}
			else if (resposta > 5)
			{
				System.out.println("");
				System.out.println("Opçao invalida");
			}
			}
		}
		else
		{
			System.out.println("");
			System.out.println("Opçao Invalida");
		}
		
}
}


