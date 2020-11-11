package DesligaNoHorario;

import javax.swing.JOptionPane;

public class Desliga {

		    public static void main(String[] args) {
		      int alhora = 15;
		      int almin= 35;
		      Relogio relogio = new Relogio();
		      NewJFrame Ola = new NewJFrame(relogio);
		      Ola.setVisible(false);
		      relogio.start(Ola.jLabel2,alhora,almin);
		    }

	}

