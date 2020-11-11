package ARvore;

public class no {
	private static no esq;
	private static no dir;
	private static String valor;

	public no(String a) {
		this.valor = a;
		esq = dir = null;
		System.out.println(a);
	}

	 public void inserir()  
     {  
		 String nome = valor;
         if( esq == null )  
            {  
                esq = new no(nome + "A");  
            }  
            else  
            {  
                esq.inserir();
            }    
        if( dir == null )  
            {  
                dir = new no(nome + "B");  
            }  
            else  
            {  
                dir.inserir();  
            }  
        }  

	public static String busque (String buscado)
	{
	if(buscado == valor)
	{
	return "falhou";
	}
	else
	{
	if(esq != null)
	{
	return valor + "-" + esq.busque(buscado) + "-" + dir.busque(buscado);
	}
	else
	{
	return "nao achado";
	}
	}
	}
}