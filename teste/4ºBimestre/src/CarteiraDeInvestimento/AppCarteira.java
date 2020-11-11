package CarteiraDeInvestimento;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Timer;
import javax.swing.GroupLayout;
import javax.swing.JLabel;



public class AppCarteira extends javax.swing.JFrame {
	
    private JLabel l;
    private Date d = new Date();
    private GregorianCalendar datahora;
    private TimeZone timezone;
    private TelaAção tela1 = new TelaAção(d.getMonth(),d.getYear()+1900);
	private TelaFundo tela2 = new TelaFundo(d.getMonth(),d.getYear()+1900);
	private TelaAplicação tela3 = new TelaAplicação(d.getMonth(),d.getYear()+1900);
	  
	
    public AppCarteira() {
        initComponents();
        
    }

		    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jButton4 = new javax.swing.JButton();
	        jButton5 = new javax.swing.JButton();
	        jButton6 = new javax.swing.JButton();

	        jLabel1.setText("Carteira De Investimentos");

	        jButton1.setText("Nova Ação");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jButton2.setText("Novo Fundo");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setText("Nova Aplicação");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        jButton4.setText("Extrato");
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton4ActionPerformed(evt);
	            }
	        });

	        jButton5.setText("Saldo");
	        jButton5.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton5ActionPerformed(evt);
	            }
	        });

	        jButton6.setText("Sair");
	        jButton6.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton6ActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(32, 32, 32)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addContainerGap(21, Short.MAX_VALUE))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(22, Short.MAX_VALUE)
	                .addComponent(jLabel1)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1)
	                .addGap(15, 15, 15)
	                .addComponent(jButton1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jButton2)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jButton3)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jButton4)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jButton5)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jButton6)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	    }

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	      	tela1.setVisible(true);
	    }

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	       	tela2.setVisible(true);
	    }

	    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
	    	   System.exit(0);
	    }
	    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
	      double Soma = 0;
	      Soma = tela1.CalcularSaldo() + tela2.CalcularSaldo() +tela3.CalcularSaldo();
	    System.out.print("Seu saldo Total é : " + Soma);   
	    }

	        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
	          	tela3.setVisible(true);
	        }

	        private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
	        	System.out.println("\n Lista de Ações");
	        	tela1.Relatorio();
	        	System.out.println("Lista de Fundos");
	        	tela2.Relatorio();
	        	System.out.println("Lista de Aplicações");
	        	tela3.Relatorio();
	        }
	        public void inicio()
	        {
	    	datahora = new GregorianCalendar();
	    	timezone = TimeZone.getTimeZone("GMT-03:00");
	    	TimeZone.setDefault(timezone);
	        datahora.setTimeZone(timezone);
	        d = datahora.getTime();
	        }
	    /**
	    * @param args the command line arguments
	    */
	  
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton5;
	    private javax.swing.JButton jButton6;
	    private javax.swing.JLabel jLabel1;
	   

}
