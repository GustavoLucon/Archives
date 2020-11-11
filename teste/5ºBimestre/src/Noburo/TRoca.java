package Noburo;

import javax.swing.JOptionPane;

public class TRoca {
	public static int x;
	public static int potenciax;
	public static int y;
	public static int potenciay;
	public static int simbolox;
	public static int simboloy;
	public static int inicial;
	public static void main(String[] args){
	
		Recebe();
		Calcula();
	}

	private static void Calcula() {
		int maior = 0;
		int form1 = 0;
		int form2 = 0;
		int troco = 0;
		int mudou = 0;
		for(int i = inicial;i < inicial+100;i++)
		{
			if(simbolox == 1)
			{
				form1 = (int) (x + Math.pow(i,potenciax));
			}
			if(simbolox == 2)
			{
				form1 = (int) (x - Math.pow(i,potenciax));
			}
			if(simbolox == 3)
			{
				form1 = (int) (x * Math.pow(i,potenciax));
			}
			if(simbolox == 4)
			{
				form1 = (int) (x / Math.pow(i,potenciax));
			}
			
			
			
			if(simboloy == 1)
			{
				form2 = (int) (y + Math.pow(i,potenciay));
			}
			if(simboloy == 2)
			{
				form2 = (int) (y - Math.pow(i,potenciay));
			}
			if(simboloy == 3)
			{
				form2 = (int) (y * Math.pow(i,potenciay));
			}
			if(simboloy == 4)
			{
				form2 = (int) (y / Math.pow(i,potenciay));
			}
			if(form1 > form2)
			{
				maior = 1;
			}
			else
			{
				maior = 2;
			}
			if(maior == 1 && troco != maior)
			{
				if(troco != 0)
				{
				JOptionPane.showMessageDialog(null, "Troca quando valor é " + i);
				mudou++;
				}
				troco = maior;

			}
			else if(maior == 2 && troco != maior)
			{
				if(troco != 0)
				{
				JOptionPane.showMessageDialog(null, "Troca quando valor é " + i);
				mudou++;
				}
				troco = maior;
			}
		}
		if(mudou == 0)
		{
			JOptionPane.showMessageDialog(null, "Nunca troca de Valor(Espaço de teste de 100 apos o inicial)");
		}
		
	}

	private static void Recebe() {
		simbolox = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para somar 2 para subtrair 3 para multiplicar 4 para dividir"));
		potenciax = Integer.parseInt(JOptionPane.showInputDialog("Digite a potencia da variaver"));
		if(simbolox == 1)
		{
			x = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a somar"));
			System.out.println("Formula 1 :" + x + " + X^" + potenciax );
		}
		else if(simbolox == 2)
		{
			x = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a subtrair"));
			System.out.println("Formula 1 :" + x + " - X^" + potenciax );
		}
		else if(simbolox == 3)
		{
			x = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a multiplicar"));
			System.out.println("Formula 1 :" + x + " * X^" + potenciax );
		}
		else if(simbolox == 4)
		{
			x = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a dividir"));
			System.out.println("Formula 1 :" + x + " / X^" + potenciax );
		}
		else
		{
			System.out.println("Numero nao incluso");
			System.exit(0);
		}
		
//Y aqui
		
		
		simboloy = Integer.parseInt(JOptionPane.showInputDialog("Agora no segundo digite 1 para somar 2 para subtrair 3 para multiplicar 4 para dividir"));
		potenciay = Integer.parseInt(JOptionPane.showInputDialog("Digite a potencia da variaver"));
		if(simboloy == 1)
		{
			y = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a somar"));
			System.out.println("Formula 2 :" + y + " + X^" + potenciay );
		}
		else if(simboloy == 2)
		{
			y = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a subtrair"));
			System.out.println("Formula 2 :" + y + " - X^" + potenciay );
		}
		else if(simboloy == 3)
		{
			y = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a multiplicar"));
			System.out.println("Formula 2 :" + y + " * X^" + potenciay );
		}
		else if(simboloy == 4)
		{
			y = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a dividir"));
			System.out.println("Formula 2 :" + y + " / X^" + potenciay );
		}
		else
		{
			System.out.println("Numero nao incluso");
		}
		
		inicial = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero a começar a formula"));
		
		
	}
}
