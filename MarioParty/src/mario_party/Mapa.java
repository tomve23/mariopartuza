package mario_party;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mapa {
	private Casillero map[][];
	private int n;
	private int m;
	
	public Mapa(int n, int m){
		this.map= new Casillero[n][m];
	}
	//para utilizar en prueba hardcodeo el n,m
	public Mapa(){
		this.map = new Casillero[5][5];
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				this.map[i][j]= new Casillero();
		this.n=5;
		this.m=5;
	}
	
	
	public void seedMapa(File f) throws FileNotFoundException {
		//Levantar un archivo con seeds para diferentes mapas, randomiza
		Scanner pf = new Scanner(f);
		int value=0;
		int i=0,j=0;
		
		for(i=0;i<this.n;i++)
			
			for(j=0;j<this.m;j++) {
				
				for(int k=0;k<4;k++) {
				
					value=pf.nextInt();
					if(value==1) {
						if(k==0)
							this.map[i][j].setSwitch();
						else if(k==1)
							this.map[i][j].setDivide();
						else if (k==2)
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
