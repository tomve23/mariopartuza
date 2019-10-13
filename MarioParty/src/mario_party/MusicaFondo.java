package mario_party;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicaFondo extends Thread {

	public MusicaFondo(String msg) {
		super(msg);
	}

	public void run() {

		FileInputStream fis;
		Player player;
		try {
			
			
			while(true) {
				
				fis = new FileInputStream("src\\Archivos\\Super_Mario_Bros._DUBSTEP_REMIX.mp3");
				BufferedInputStream bis = new BufferedInputStream(fis);
				player = new Player(bis);
				player.play();
				player.close();
				bis.close();
				fis.close();
				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
