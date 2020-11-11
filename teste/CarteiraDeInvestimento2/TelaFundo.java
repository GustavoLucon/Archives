package CarteiraDeInvestimento2;

import javax.swing.JOptionPane;

public class TelaFundo extends javax.swing.JFrame {

    /** Creates new form TelaAcao */
    public TelaFundo() {
        initComponents();
    }
    private Instrumento fundo[] = new Instrumento[99999];
    private int altura = 0;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        

        jScrollPane1 = new javax.swing.JScrollPane();
        caixa2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        caixa2.setColumns(20);
        caixa2.setRows(5);
        caixa2.setEnabled(false);

        jScrollPane1.setViewportView(caixa2);

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 48)); // NOI18N
        jLabel1.setText("Fundos");

        jLabel2.setText("Lista De Fundos");

        jButton1.setText("Inserir Fundos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar Fundos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exibir Fundos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Excluir Fundos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Voltar a Pagina Principal");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jButton5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    String nome = JOptionPane.showInputDialog("Digite o nome da ação");
    double saldo =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da ação"));
    int mes =Integer.parseInt(JOptionPane.showInputDialog("Digite o mes de criação da ação"));
    int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de criação da ação"));
    fundo[altura]= new Fundo(saldo,mes,ano);
    fundo[altura].setDescricao(nome);
    altura++;    
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    String busca = JOptionPane.showInputDialog("Digite o nome do fundo");
    for(int b=0; b < altura;b++){
    	if(fundo[b].getDescricao().equals(busca))
    	{
    		caixa2.setText("Nome : " + fundo[b].getDescricao() + " Saldo: " + fundo[b].valor());
    	}
    }
    	
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	for(int b=0; b < altura;b++){
    		caixa2.setText(caixa2.getText() + "\n"  + fundo[b].getDescricao()); 
    }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    	String deletar = JOptionPane.showInputDialog("Digite o nome da acao que voce quer Deletar"); 
    	for(int a = 0 ;a < altura;a++)
	        {
    		 if(fundo[a].getDescricao().equals(deletar))
    			 caixa2.setText(caixa2.getText() + "\n"  + fundo[a].getDescricao()); 
    		 int digite = Integer.parseInt(JOptionPane.showInputDialog("Digite 1829"));
    		 if(digite == 1829)
    		 {
    		 int b;
    		 	for(b = a ;b < altura;b++)
    		 	{
    		 		if(fundo[b+1]!= null)
    		 		{
    		 			fundo[b] = fundo[b+1];
    		 		}
    		 		else
    		 		{
    		 			fundo[b] = null;
    		 		}
 	        	}
    		 	altura--;
    		 	caixa2.setText("");
	        }
	        }

    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    	this.setVisible(false);
    }

    /**
    * @param args the command line arguments
    */
    /*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFundo(Data, Ano).setVisible(true);
            }
        });
    }*/
    public String Relatorio() {
    	String juntos = "";
    	for(int b=0; b < altura;b++){
    		juntos = juntos + "\nNome : " +  fundo[b].getDescricao() + " Saldo: " + fundo[b].valor();	
    	}
    	return juntos;
   	    }
    public double CalcularTotal()
    {
    	double total=0;
    	for(int i = 0 ; i < altura;i++)
    	{
    	total = total + fundo[i].valor(); 	
    	}
    	return total;
    }
    // Variables declaration - do not modify
    private javax.swing.JTextArea caixa2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration

}
