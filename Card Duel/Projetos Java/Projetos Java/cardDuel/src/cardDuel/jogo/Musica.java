package cardDuel.jogo;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;

public class Musica {
	public Musica() {
		 try {   
			
		   File soundFile = new File("Musica.wav");   
           AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);   
	       DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());   
           Clip clip = (Clip) AudioSystem.getLine(info);   
           clip.open(sound);   
           clip.start();   
           clip.loop(clip.LOOP_CONTINUOUSLY);

			        } catch (Exception e) {   

			          JOptionPane.showMessageDialog(null, e);  
			          System.out.println(e);

			    }  

		
	}
}
