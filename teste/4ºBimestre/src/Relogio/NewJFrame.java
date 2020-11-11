package Relogio;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Timer;

/**
 *
 * @author 35895842895
 */
public class NewJFrame extends javax.swing.JFrame {

    private Relogio relogio;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;


    public NewJFrame(Relogio relogio) {
        initComponents();
        this.relogio = relogio;
        relogio.setDisplay(jLabel2);
        Data();
    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Relogio");
        jLabel2.setText("ola");
        jLabel3.setText("Passe aki");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        Date d = new Date();
        String hora;

        GregorianCalendar datahora = new GregorianCalendar();
        TimeZone timezone = TimeZone.getTimeZone("GMT-03:00");
        TimeZone.setDefault(timezone);
        datahora.setTimeZone(timezone);

        d = datahora.getTime();
        hora  = d.getDay()+ "/" +d.getDate()+ "/"+ d.getYear() ;
        jLabel2.setText(hora);

        pack();
    }
    private void Data() {

   Date d = new Date();
   String hora;

    GregorianCalendar datahora = new GregorianCalendar();
    TimeZone timezone = TimeZone.getTimeZone("GMT-03:00");
    TimeZone.setDefault(timezone);
    datahora.setTimeZone(timezone);

    d = datahora.getTime();
    int i = d.getYear() +1900;
    hora  = d.getDay()+ "/" + d.getMonth() + "/" + i;
        jLabel3.setText(hora);
    }

}
