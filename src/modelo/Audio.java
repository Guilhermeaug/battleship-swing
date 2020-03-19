package modelo;


//Java program to play an Audio 
//file using Clip Object 
import java.io.File; 

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 

public class Audio{ 

	public void tocarAudio(String diretorioAudio) {
		try {
			File localAudio = new File(diretorioAudio);
			
			if(localAudio.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(localAudio);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			}else {
				System.out.println("Nao foi possivel tocar o audio");
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}

} 
