package conjunto;

public class conjunto {

	private int[] Intersecao(int[] a ,int b[])
	{
		int contA = 0;
		int contB = 0;
		int contT = 0;
		int repetidos = 0;
		while(contA < a.length)
		{
			while(contB < b.length)
			{
				if(a[contA] == b[contB])
				{
					repetidos++;
				}
				contB++;
			}
			contA++;
		}
		int resultado[] = new int[repetidos];
		
		while(contA < a.length)
		{
			while(contB < b.length)
			{
				if(a[contA] == b[contB])
				{
					resultado[contT] = a[contA];
					contT++;
				}
				contB++;
			}
			contA++;
		}
		return resultado;
		
	}
	private int[] União(int[] a ,int b[])
	{
		int resultado[];
		int altura = 0;
		if(a.length <= b.length)
		{
		resultado = new int[a.length];
		}
		else
		{
		resultado = new int[b.length];
		}
		for(int cont = 0;cont > a.length;cont++)
		{
			int i =0;
			for(int conta = 0;conta > b.length;conta++)
			{
				if(a[cont] == b[conta])
				{
					i++;
				}
			}
			if(i ==0)
			{
				resultado[altura] = a[cont];
				altura++;
			}
		}
		return resultado;
		
	}
	private int[] Diferenca(int[] a ,int b[])
	{
		int resultado[];
		int altura = 0;
		if(a.length <= b.length)
		{
		resultado = new int[a.length];
		}
		else
		{
		resultado = new int[b.length];
		}
		for(int cont = 0;cont > a.length;cont++)
		{
			int i =0;
			for(int conta = 0;conta > b.length;conta++)
			{
				if(a[cont] == b[conta])
				{
					i++;
				}
			}
			if(i ==0)
			{
				resultado[altura] = a[cont];
				altura++;
			}
		}
		return resultado;
		
	}
	private int[] Complementar(int[] a ,int b[])
	{
		int resultado[];
		int altura = 0;
		if(a.length <= b.length)
		{
		resultado = new int[a.length];
		}
		else
		{
		resultado = new int[b.length];
		}
		for(int cont = 0;cont > a.length;cont++)
		{
			int i =0;
			for(int conta = 0;conta > b.length;conta++)
			{
				if(a[cont] == b[conta])
				{
					i++;
				}
			}
			if(i ==0)
			{
				resultado[altura] = a[cont];
				altura++;
			}
		}
		return resultado;
	}
}
