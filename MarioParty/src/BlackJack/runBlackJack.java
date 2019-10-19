package BlackJack;

import java.io.IOException;




public class runBlackJack implements Runnable {

	GUI gui = new GUI();
	public static void main(String args[]) throws IOException {
		Deck deck = new Deck();
		new Thread(new runBlackJack()).start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
}
