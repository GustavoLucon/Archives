package Relogio;

import java.awt.Toolkit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.swing.JLabel;

public class Relogio extends Thread{
    private JLabel l;
    private Date d = new Date();
    private String hora;
    private GregorianCalendar datahora;
    private TimeZone timezone;

    public void start(JLabel l ,int alhora ,int almin){
    	while(true)
    	{
    	datahora = new GregorianCalendar();
    	timezone = TimeZone.getTimeZone("GMT-03:00");
    	TimeZone.setDefault(timezone);
        datahora.setTimeZone(timezone);
        d = datahora.getTime();
        hora  = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
        if(alhora == d.getHours() && almin == d.getMinutes()&& 0 == d.getSeconds()){
        	System.out.print("Hora da prova");
        	Toolkit.getDefaultToolkit().beep();
        }
        
        
        l.setText(hora);
        try{Thread.sleep(1000);}catch(Exception e){}
       }
    }
    public void setDisplay(JLabel l){
            this.l = l;
    }
}
