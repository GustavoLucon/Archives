package Audio;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TocaAudio {
	private void TocaAudio(int seleciona){   
        try {   
            //audios que fazem parte do jogo   
        AudioInputStream stream1 = AudioSystem.getAudioInputStream(new File("F:/Games/Knight050/wave/atc0.wav"));   
        AudioInputStream stream2 = AudioSystem.getAudioInputStream(new File("F:/Games/Knight050/wave/chrg.wav"));   
        // definicao   
        AudioFormat format = stream1.getFormat();   
           
    if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {   
        format = new AudioFormat(   
                AudioFormat.Encoding.PCM_SIGNED,   
                format.getSampleRate(),   
                format.getSampleSizeInBits()*2,   
                format.getChannels(),   
                format.getFrameSize()*2,   
                format.getFrameRate(),   
                true);        // big endian   
        stream1 = AudioSystem.getAudioInputStream(format, stream1);   
        stream2 = AudioSystem.getAudioInputStream(format, stream2);   
    }   
        // Create the clip   
    DataLine.Info info = new DataLine.Info(   
        Clip.class, stream1.getFormat(), ((int)stream1.getFrameLength()*format.getFrameSize()));   
    Clip clip = (Clip) AudioSystem.getLine(info);   
   
    // This method does not return until the audio file is completely loaded   
    if (seleciona == 1){   
        clip.open(stream1);   
       
    } else if (seleciona == 2){   
        clip.open(stream2);   
           
    }   
       
   
    // Start playing   
    clip.start();   


  } catch (MalformedURLException e) {   
} catch (IOException e) {   
} catch (LineUnavailableException e) {   
} catch (UnsupportedAudioFileException e) {   
}   
}   
//aqui termina  

}
