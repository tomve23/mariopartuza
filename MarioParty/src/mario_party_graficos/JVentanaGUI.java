package mario_party_graficos;

import mario_party.Coordenada;
import mario_party.Jugador;

public class JVentanaGUI extends Thread {

	JVentanaGrafica jVentana;
	JPanelGrafico jPanel;
	
	public JVentanaGUI(int [][]map,Jugador [] jugador,Coordenada posMouse) {

		jPanel=new JPanelGrafico(map, jugador, posMouse);
		jVentana=new JVentanaGrafica(jPanel);
		
	}
	
	public void run() {
		jVentana.setVisible(true);
		while(true) {
			jPanel.repaint();
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void dispose() {
		jVentana.dispose();
		stop();
	}
}
