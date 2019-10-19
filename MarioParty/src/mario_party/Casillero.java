package mario_party;

import java.awt.Image;
import java.awt.Toolkit;

public class Casillero {
	private boolean switchFlag;
	private boolean divideFlag;
	private boolean explosionFlag;
	private boolean pathFlag;
	private boolean star;
	private Image[] imagenes;

	public Casillero() {
		this.switchFlag = false;
		this.explosionFlag = false;
		this.divideFlag = false;
		this.pathFlag = false;
		this.star = false;
		
		imagenes = new Image[5];
		
		Toolkit herramienta = Toolkit.getDefaultToolkit();
		//for (int i = 0; i < this.imagenes.length; i++) {
			
		this.imagenes[4] = herramienta.getImage("src\\Archivos\\Casilleros\\30903040-estrella-monedas-de-rotación-removebg-preview.png");
		//}
	}

	public Image[] getImagenes() {
		return imagenes;
	}

	public void setImagenes(Image[] imagenes) {
		this.imagenes = imagenes;
	}

	public boolean isStar() {
		return star;
	}

	public void setStar(boolean star) {
		this.star = star;
	}

	public Casillero(Casillero c) {
		this.switchFlag = c.switchFlag;
		this.explosionFlag = c.explosionFlag;
		this.divideFlag = c.divideFlag;
		this.pathFlag = c.pathFlag;
	}

	public void setSwitch() {
		this.switchFlag = true;
	}

	public void setDivide() {
		this.divideFlag = true;
	}

	public void setExplosion() {
		this.explosionFlag = true;
	}

	public void setPath() {
		this.pathFlag = true;
	}

	public boolean isSwitchFlag() {
		return switchFlag;
	}

	public boolean isDivideFlag() {
		return divideFlag;
	}

	public boolean isExplosionFlag() {
		return explosionFlag;
	}

	public boolean isPathFlag() {
		return pathFlag;
	}

}
