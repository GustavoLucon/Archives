package Primeiros;
import javax.swing.JOptionPane;

public class recursividade4 {
	static int exibir (int num[])
	{
		int b;
		int a;
		int total = 0;
		a = 0;
		b = num.length-1;
      if(a == b)
      {
    	  return 0;
      }
      else
      {
    	  if((a/2)*2 == a)
    	  {
    	  total = a + exibir(num);
    	  }
         if(a == b)
        	{
        		System.out.println("A soma é " + total);
      	  }
    	  return total ;
      }
      }
	public static void main (String args[])
	{
		int recebido[] = new int[11] ;
		for(int a = 0; a  < 10 ; a++)
		{
		recebido[a] = Integer.parseInt(JOptionPane.showInputDialog (null ,"Digite o numero desejado"));	
		}
		exibir(recebido);	
			
	}
}
