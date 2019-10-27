package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import BlackJack.BlackJack;

class JFrameBJ {

	@Test
	void test() throws InterruptedException {
		ArrayList<String> nombres= new ArrayList<String>();
		nombres.add("Yahir");
		nombres.add("Ayrton");
		BlackJack b = new BlackJack();
		ArrayList<Integer> ganador =b.run(nombres);
		for (Integer i : ganador) {
			System.out.println(i);
		}
		
	
	}

}

