package Primeiros;
public class Prova1 {
	public static int exibir(int a ,int b ,int cont)
	{
		int c;
		if(cont == 7)
		{
			return 1;
		}
		else
		{
		cont++;
		b = a;
		a = exibir(a,b,cont);
		c = a + b;
		a= c - cont;
		System.out.println(c);
		return a;
		}
		
	}
	public static void main (String args[])
	{
	int fib= 1;
	int fib2 = 0;
	int cont = 0;
	exibir(fib , fib2 , cont);
	}
}
