import javax.swing.JOptionPane;

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

public class Troca1 {
	public static void main (String args[])
	{
		int x , y , troca ;
		x = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o 1º numero"));
		y = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o 2º numero"));
		System.out.println("A ordem original é " + x + " é o primeiro e " + y + " é o segundo " );
		troca = x ;
		x = y ;
		y = troca ;
		System.out.println("Trocando a ordem é " + x + " é o primeiro e " + y + " é o segundo " );
	}
}
