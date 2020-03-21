package reproductorCadenaRes;

import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ReproductorWav extends Reproductor {

	@Override
	public void reproducir(int op) {
		if (op == 2) {
			//reproduccion de formatos wav
			try {
				Clip sonido = AudioSystem.getClip();
				File a = new File("src/musica/Believer [8 Bit Tribute to Imagine Dragons] - 8 Bit Universe.wav");
				sonido.open(AudioSystem.getAudioInputStream(a));
				sonido.start();
				//tiempo de reproduccion
				Thread.sleep(60000); 
				sonido.close();
			} catch (Exception tipoError) {
				System.out.println("" + tipoError);
			}

		}

		else
			siguiente.reproducir(op);

	}

}
