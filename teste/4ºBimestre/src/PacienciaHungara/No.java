package PacienciaHungara;


public class No {
public int i[];
public No filhos;
public int local;
 public void Dividir(int vezes)
 {
	 i = new int[vezes];
 }
 public int Tamanho()
 {
	 int numero = 0;
	 if(filhos != null)
	 {
		 numero = 1 + filhos.Tamanho(); 
		 return numero;
	 }
	 else
	{
		 return numero;
	 }
 }
 public void Valores(int valor, int local)
 {
	i[local] = valor;
 }
 public void NovoNo()
 {
	 if(filhos == null)
	 {
		 int tamanho= i.length;
		 int ond = local + 1;
	 filhos = new No(ond);
	 filhos.Dividir(tamanho+1);
	 int soma = 0;
	 for (int j = 0 ; j < tamanho ; j++)
		{
		 if(i[j] > 0)
		 {
		 filhos.Valores(i[j]-1, j);
		 soma++;
		 }
	 }
	 filhos.Valores(soma, tamanho);
	 }
	 else
	 {
		 filhos.NovoNo();
	 }
 }
 
 public String resultado()
 {
	 int soma = 0;
		 if(filhos != null)
		 {
		 return this.filhos.resultado();
		 }
		 else
		 {
			 String resultado = "";
			 for (int j = 0 ; j < i.length ; j++)
			{
			 if(i[j] > 0)
			 {
				 soma++;
				 int h = i[j]-1;
				 if(h > 0)
				 resultado =  resultado + "," + h;
			 }
		}
			 resultado = resultado  + "," + soma;
		 return resultado;
		 }

 }
 public String GetVetor(int local)
 {
	 if(this.local == local)
	 {
	 String a = new String();
	 int b ;
	 for(int g = 0;g< i.length ; g++)
	 {
		if(i[g] != 0)
		{
		b = i[g];
		a = a + "," + b;
		}
	 }
	 return a;
	 }
	 else
	 {
		 return filhos.GetVetor(local);
	 }
 }
 public No(int local)
 {
	 this.local = local;
 }
 public void SetFilho(No filho)
 {
	 this.filhos = filho;
 }
 public void Mostrar(int onde)
 {
	 if(local == onde)
	 {
	for (int j = 0 ; j < i.length ; j++)
	{
		if(i[j] > 0 )
		{
		System.out.print(i[j]+ ",");
		}
		}
	System.out.println();
	 }
	 else
	 {
		if(filhos != null)
		{
		filhos.Mostrar(onde);	
		}
		else
		{
		System.out.print("Não foi encotrado");
		}
	 }
 }
 
 
}
