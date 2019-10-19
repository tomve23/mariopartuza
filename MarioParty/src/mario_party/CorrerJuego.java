package mario_party;




public class CorrerJuego {

	public static void main(String[] args) throws Exception {
//		C:\\Users\\Matias\\Downloads\\Super_Mario_Bros._DUBSTEP_REMIX.mp3
//		Media hit = new Media(new File(s).toURI().toString());
//		MediaPlayer mediaPlayer = new MediaPlayer(hit);
//		mediaPlayer.play();
		
		Jugador arrayPlayers[] = new Jugador[4];
			
		Personaje fito = new Personaje("Pepe", "El Conurbano Bonaerense", "Viudo", new PowerUp("Autodestruccion", 15, 3), "src\\Archivos\\test.png");
		
		
		
		arrayPlayers[0] = new Jugador(MapasDisponibles.Mapa4_inicio1, fito);
		arrayPlayers[0].setTag("Mati Crack");
		arrayPlayers[1] = new Jugador(MapasDisponibles.Mapa4_inicio2, fito);
		arrayPlayers[1].setTag("Yahir Crack");
		arrayPlayers[2] = new Jugador(MapasDisponibles.Mapa4_inicio3, fito);
		arrayPlayers[2].setTag("Lucho Crack");
		arrayPlayers[3] = new Jugador(MapasDisponibles.Mapa4_inicio4, fito);
		arrayPlayers[3].setTag("Rodri vago de mierda");
		
		int[][] map = MapasDisponibles.Mapa4;
		/*
		SI QUERES MUSICA DESCOMENTA ESTO
		Thread musica = new MusicaFondo("proceso musica");
		musica.start();
		*/
		Partida part = new Partida(arrayPlayers, 10, map);
		System.out.println(part.jugarPartida());
		
	}

}
