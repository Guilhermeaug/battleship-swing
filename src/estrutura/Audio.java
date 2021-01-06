package estrutura;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio{
	public static int travaAudio = 0;

	public void tocarAudio(String diretorioAudio) {
		try {
			File localAudio = new File(diretorioAudio);
			
			if(localAudio.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(localAudio);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				if(diretorioAudio.equals("src/Audio/MissaoImpossivel.wav")){
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					Audio.travaAudio = 1;
				}
				clip.start();

			}else {
				System.out.println("Nao foi possivel tocar o audio");
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}

} 
