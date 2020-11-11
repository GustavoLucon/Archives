package gerarArquivoTXT;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class GerarTxt {

	public void GerarArquivoTxt(String Texto) {

		
		String nome = JOptionPane.showInputDialog("Digite o nome do relatorio");
		
		while(nome.equals("")== true)
		{
			nome = JOptionPane.showInputDialog("O nome não pode ser em branco .\nDigite o nome do relatorio");
		}
		
		FileWriter arquivo;
		try {
			arquivo = new FileWriter(new File(nome + ".txt"));
			arquivo.write(Texto);
			arquivo.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao gerar o arquivo: \n"
					+ e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao gerar o arquivo: \n"
					+ e.getMessage());
		}
	}

}