package Primeiros;
import javax.swing.JOptionPane;

public class fila5numeros {
public static void main(String arg [])
{
fila numeros = new fila(5);
int aux , entrada = 0;
int i , j ;
boolean ok;
for (i = 1 ; i < 5  ; i++)
{
	ok = true;
	entrada = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o numero desejado"));	
	if (numeros.Filavazia())
	{
		numeros.Enfileirar(entrada);
	}
	else
	{
		int total = numeros.total ;
	for (j = 1 ; j <= total ; j++)
	{
		aux = numeros.Desenfileirar(); 
	if(entrada < aux && ok)
	{
		numeros.Enfileirar(entrada);
		ok = false;
		}
		numeros.Enfileirar(aux);
	}
	if(ok)
	{
		numeros.Enfileirar(entrada);
	}
}
}
numeros.Mostrador();
System.exit(0);
}
}

