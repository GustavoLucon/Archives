package Primeiros;
import javax.swing.JOptionPane;

class Registro {
		String nome ;
		double nota1 ;
		double nota2 ;
		double nota3 ;
		double nota4 ;
		Registro(String n , double n1,double n2,double n3,double n4)
		{
			nome = n ;
			nota1 = n1;
			nota2 = n2;
			nota3 = n3;
			nota4 = n4;
		}
	}
public class NotasAluno {
	public static void main (String args[]){
		{
			Registro aluno[] = new Registro[8];
			for(int cont = 0; cont < 8 ;cont++ )
			{
				aluno[cont] = new Registro("" , 0.0 ,0.0 , 0.0 ,0.0);
			}
		for(int cont = 0; cont < 8 ;cont++ )
		{
			aluno[cont].nome = JOptionPane.showInputDialog (null , "Digite o nome do aluno");			
		    aluno[cont].nota1 = Double.parseDouble(JOptionPane.showInputDialog (null , "Digite a nota do 1º bimestre"));
		    aluno[cont].nota2 = Double.parseDouble(JOptionPane.showInputDialog (null , "Digite a nota do 2º bimestre"));
		    aluno[cont].nota3 = Double.parseDouble(JOptionPane.showInputDialog (null , "Digite a nota do 3º bimestre"));
		    aluno[cont].nota4 = Double.parseDouble(JOptionPane.showInputDialog (null , "Digite a nota do 4º bimestre"));
		}
		for (int cont = 0; cont < 8 ;cont++ )
		{
			System.out.println ("O nome do aluno é " + aluno[cont].nome + "\n sua nota do primeiro é " + aluno[cont].nota1 + "\n sua nota do segundo é " + aluno[cont].nota2 + "\n sua nota do terceiro é " + aluno[cont].nota3 + "\n sua nota do quarto é " + aluno[cont].nota4 ) ;
		}
		System.exit(0);
		}
}
}
	
	
