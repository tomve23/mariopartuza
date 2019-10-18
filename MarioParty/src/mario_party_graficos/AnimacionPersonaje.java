package mario_party_graficos;

import mario_party.Jugador;

public class AnimacionPersonaje extends Thread{

	static int i;
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
