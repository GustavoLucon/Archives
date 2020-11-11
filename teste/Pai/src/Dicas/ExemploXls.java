package Dicas;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExemploXls {

    public static void main(String[] args) 
    throws BiffException, IOException 
    {
        /**
        * Carrega a planilha
        */

        Workbook workbook = Workbook.getWorkbook(new File("c:\\exemplo.xls"));
      //  Workbook workbook = Workbook.getWorkbook(new File(Diretorio() + "\\exemplo.xls"));
        /**
        * Aqui é feito o controle de qual aba do xls 
        * será realiza a leitura dos dados
        */
        Sheet sheet = workbook.getSheet(0);

        /**
        * Numero de linhas com dados do xls
        */
        int linhas = sheet.getRows();
		
        for(int i = 0; i < linhas; i++  )
        {
            Cell celula1 = sheet.getCell(0, i);
            Cell celula2 = sheet.getCell(1, i);
            Cell celula3 = sheet.getCell(2, i);
			
            System.out.println("Conteúdo da célula 1: "+ celula1.getContents());
            System.out.println("Conteúdo da célula 2: "+ celula2.getContents());
            System.out.println("Conteúdo da célula 3: "+ celula3.getContents());
        }
    }
    
    // Pega o diretorio atual
    
        public static String Diretorio()
        		{
            File dir1 = new File (".");
            
            try 
            {
            return dir1.getCanonicalPath();
            }
            catch(Exception e) {
              e.printStackTrace();
              System.out.println("\nFalhou ao pegar o diretorio");
              return null;
              }
            }

}
