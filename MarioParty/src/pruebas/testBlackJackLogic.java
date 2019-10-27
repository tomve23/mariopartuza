package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import BlackJack.BlackJackLogic;

class testBlackJackLogic {

	@Test
	void test() {
		ArrayList<String> nombres= new ArrayList<String>();
		nombres.add("Yahir");
		nombres.add("Ayrton");
		BlackJackLogic b = new BlackJackLogic(nombres);
		
		
	}

}
