package mario_party;

import mario_party_graficos.JPanelGrafico;

public class AnimacionPersonaje extends Thread{

	
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JPanelGrafico.incremento++;
			
			if(JPanelGrafico.incremento > 3)
				JPanelGrafico.incremento=0;
			
		}
	}
}
