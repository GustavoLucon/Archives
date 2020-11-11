package Relogio;

import java.util.Calendar;

import javax.swing.JOptionPane;

/**
 *
 * @author 35895842895
 */
public class main {

    public static void main(String[] args) {
      int alhora = Integer.parseInt(JOptionPane.showInputDialog("Digite as horas pra alertar"));
      int almin= Integer.parseInt(JOptionPane.showInputDialog("Digite os minutos pra alertar"));;
      Relogio relogio = new Relogio();
      NewJFrame Ola = new NewJFrame(relogio);
      Ola.setVisible(true);
      relogio.start(Ola.jLabel2,alhora,almin);
    }

}
