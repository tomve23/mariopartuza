package mario_party_graficos;



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
			JPanelGrafico.increpersonaje++;
			
			if(JPanelGrafico.increpersonaje > 3)
				JPanelGrafico.increpersonaje=0;
			
		}
	}
}
