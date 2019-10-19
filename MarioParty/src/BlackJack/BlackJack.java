package BlackJack;

import java.util.ArrayList;

public class BlackJack  extends Thread{
	
	private JFrameBJ gui;
	private String ganador;
	
	
	public ArrayList<Integer> run(ArrayList <String> p) throws InterruptedException {
		gui = new JFrameBJ(p);
		while(gui.banGanador==0) 
			 {
				gui.repaint();
		}
			gui.repaint();
			Thread.sleep(5000);
			gui.dispose();
		
		return gui.ganadorIndex;
	}
	public String getGanador() {
		return ganador;
	}

	
}
