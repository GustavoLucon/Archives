package ARvore;

import javax.swing.JOptionPane;

public class chegada {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Digite a altura dele"));
		String buscar = JOptionPane.showInputDialog("Digite a busca");
		arvore arv = new arvore();
		
		for(int i =0;i < altura;i++)
		{	
		arv.insertNode();
		}
		
		
		
	//	System.out.println(inicial.busque(buscar));


	}

}
