import javax.swing.JOptionPane;
import java.util.Random;
/**
 * Write a description of class Aplicativo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aplicativo
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Aplicativo
     */
    public static void main(String[] args)
        {
        // initialise instance variables
        boolean vivo = true;
        Composto comp = new Composto();
        Quimico jogador = new Quimico();
        while(vivo == true)
        {
        int acido = 10;
        int agua = Integer.parseInt(JOptionPane.showInputDialog("Com esta quantidade de acido " + acido + " Quanto de agua voce precisa para estabilizar?"));
        if(comp.estabilizou(acido,agua) == false)
        {
            if(jogador.morreu() == true)
            {
                System.out.println("=X");
                vivo = false;
            }
            else
            {
                 System.out.println("=(");
            }
        }
        else
        {
            System.out.println("=D");
        }
    }
    }
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    public static int GerarQuantidaDeAcido()
    { 
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        return randomInt;
    }
}
