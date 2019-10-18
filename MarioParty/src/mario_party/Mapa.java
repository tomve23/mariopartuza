package mario_party;


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

	
	public Mapa(Mapa mapa) {

        this.map = mapa.getMap();

    }
	
	public Mapa(int n, int m) {
		this.map = new Casillero[n][m];
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
