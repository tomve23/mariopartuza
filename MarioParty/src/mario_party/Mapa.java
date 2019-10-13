package mario_party;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mapa {
	private Casillero map[][];
	private int n;
	private int m;

	public Mapa(int[][] map) {
		this.map = new Casillero[map.length][];

		for (int i = 0; i < map.length; i++) {
			this.map[i] = new Casillero[map[i].length];

			for (int j = 0; j < map[i].length; j++) {

				this.map[i][j] = new Casillero();
				switch (map[i][j]) {

				case 1: // camino
					this.map[i][j].setPath();
					break;
				case 2: // explosion
					this.map[i][j].setPath();
					this.map[i][j].setExplosion();
					break;
				case 3: // teletransporte
					this.map[i][j].setPath();
					this.map[i][j].setSwitch();
					break;
				case 0: // bloque
					break;

				}

			}
		}
	}

	public Mapa(int n, int m) {
		this.map = new Casillero[n][m];
	}

	// para utilizar en prueba hardcodeo el n,m
	public Mapa() {
		this.map = new Casillero[6][6];
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++)
				this.map[i][j] = new Casillero();
		this.n = map.length;
		this.m = map[0].length;
	}

	public void seedMapa(File f) throws FileNotFoundException {
		// Levantar un archivo con seeds para diferentes mapas, randomiza
		Scanner pf = new Scanner(f);
		int value = 0;
		int i = 0, j = 0;

		for (i = 0; i < this.n; i++)

			for (j = 0; j < this.m; j++) {

				for (int k = 0; k < 4; k++) {

					value = pf.nextInt();
					if (value == 1) {
						if (k == 0)
							this.map[i][j].setSwitch();
						else if (k == 1)
							this.map[i][j].setDivide();
						else if (k == 2)
							this.map[i][j].setExplosion();
						else
							this.map[i][j].setPath();
					}
				}

			}

		pf.close();

	}

	public Casillero[][] getMap() {
		return map;
	}

	public void setMap(Casillero[][] map) {
		this.map = map;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

}
