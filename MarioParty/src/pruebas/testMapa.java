package pruebas;

import java.io.File;
import java.io.FileNotFoundException;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import mario_party.Mapa;

@SuppressWarnings("deprecation")
class testMapa {

	@Test
	void testBifurcación() throws FileNotFoundException {
		
		Mapa map = new Mapa();
		File pf = new File ("C:\\Users\\laboratorios\\Desktop\\MarioParty\\src\\Archivos\\seedsMapa.txt");
		map.seedMapa(pf);
		Assert.assertTrue(map.getMap()[1][1].isDivideFlag());
		
	}
	@Test
	void testCasilleroSwitch() throws FileNotFoundException {
		
		Mapa map = new Mapa();
		File pf = new File ("C:\\Users\\laboratorios\\Desktop\\MarioParty\\src\\Archivos\\seedsMapa.txt");
		map.seedMapa(pf);
	    Assert.assertTrue(map.getMap()[2][1].isSwitchFlag());
		
	}
	@Test
	void testCasilleroExplosion() throws FileNotFoundException {
		
		Mapa map = new Mapa();
		File pf = new File ("C:\\Users\\laboratorios\\Desktop\\MarioParty\\src\\Archivos\\seedsMapa.txt");
		map.seedMapa(pf);
	    Assert.assertTrue(map.getMap()[1][3].isExplosionFlag());
		
	}

}
