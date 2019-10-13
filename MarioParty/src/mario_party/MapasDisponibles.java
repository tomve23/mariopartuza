package mario_party;

public class MapasDisponibles {

	//0 para una celda con bloque los bordes de la matriz siempre tiene que ser 0 eje ariiba de un 1 no puede no haber nada
	//1 para una celda de camino sin juego
	//2 para una celda de explosion, tambien es camino.
	//3 para una celda de teletransportacion, tambien es camino.
	//asignar diferentes numeros dependiendo sea el juego
	
	
	public final static int[][] Mapa1= {//8x8
					{0,0,0,0,0,0,0,0},
					{0,1,1,1,1,1,1,0},
					{0,1,0,1,0,0,1,0},
					{0,1,1,1,1,1,1,0},
					{0,1,0,0,1,0,1,0},
					{0,1,0,0,1,0,1,0},
					{0,1,1,1,1,1,1,0},
					{0,0,0,0,0,0,0,0},
			};
	
	public final static Coordenada Mapa1_inicio1=new Coordenada(1,1);
	public final static Coordenada Mapa1_inicio2=new Coordenada(1,6);
	public final static Coordenada Mapa1_inicio3=new Coordenada(1,1);
	public final static Coordenada Mapa1_inicio4=new Coordenada(6,6);
	
	public final static int[][] Mapa2= {//mapa iregular
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,1,1,1,1,0},
			{0,1,1,1,1,0,0,1,0},
			{0,1,0,0,1,0,0,1,0,0},
			{0,1,1,1,1,1,1,1,0},
			{0,1,0,0,1,0,0,0},
			{0,1,1,1,1,0},
			{0,1,0,0,1,0},
			{0,1,1,1,1,0},
			{0,0,0,0,0},
	};
	
	public final static Coordenada Mapa2_inicio1=new Coordenada(1,4);
	public final static Coordenada Mapa2_inicio2=new Coordenada(2,1);
	public final static Coordenada Mapa2_inicio3=new Coordenada(1,7);
	public final static Coordenada Mapa2_inicio4=new Coordenada(8,4);
	
	public final static int[][] Mapa3= {
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,0,0,0,1,0,1,0,0,1,0},
			{0,1,0,0,0,1,0,1,1,1,1,0},
			{0,1,1,1,1,1,0,0,1,0,1,0},
			{0,1,0,1,0,1,1,1,1,1,1,0},
			{0,1,1,1,0,1,0,0,0,0,0,0},
			{0,1,0,0,1,1,0},
			{0,1,0,0,1,0},
			{0,1,1,1,1,0},
			{0,1,0,0,1,0},
			{0,1,1,1,1,0},
			{0,0,0,0,0,0},
	};
	
	public final static Coordenada Mapa3_inicio=new Coordenada(1,1);
	
	public final static int[][] Mapa4= {//10x13
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,0,1,0,0,1,0,1,0,0,0,1,0},
			{0,1,1,1,1,1,1,1,1,0,0,0,2,0},
			{0,2,0,0,1,0,1,0,0,0,1,1,1,0},
			{0,1,0,0,1,1,1,0,0,0,1,0,1,0},
			{0,1,1,1,1,0,1,0,0,0,1,0,1,0},
			{0,1,0,0,1,0,1,1,1,1,1,0,1,0},
			{0,1,0,0,1,0,3,0,0,0,1,0,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	};

	public final static Coordenada Mapa4_inicio1=new Coordenada(1,1);
	public final static Coordenada Mapa4_inicio2=new Coordenada(1,12);
	public final static Coordenada Mapa4_inicio3=new Coordenada(9,1);
	public final static Coordenada Mapa4_inicio4=new Coordenada(9,12);
}
