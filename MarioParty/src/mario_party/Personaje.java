package mario_party;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Personaje {
	private String nombre;
	private String origen;
	private String estadoCivil;
	private PowerUp powerUp;
	private Image Img;
	
	
	public Personaje(String nombre, String origen, String estado, PowerUp pu, String img){
		this.nombre= nombre;
		this.origen= origen;
		this.estadoCivil = estado;
		this.powerUp = new PowerUp(pu.getNombrePowerUp(),pu.getAlcanceCasilleros(),pu.getTurnosCoolDown()); //Realmente pienso que podriamos igualarlo. Sino estas creando una nueva instancia al pedo. Revisar
		Toolkit herramienta= Toolkit.getDefaultToolkit();
		this.Img = herramienta.getImage(img);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public PowerUp getPowerUp() {
		return powerUp;
	}

	public void setPowerUp(PowerUp powerUp) {
		this.powerUp = powerUp;
	}

	public Image getImg() {
		return Img;
	}

	public void setImg(Image img) {
		Img = img;
	}
	
	
}
