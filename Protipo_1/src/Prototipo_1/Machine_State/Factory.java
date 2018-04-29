package Prototipo_1.Machine_State;

import Prototipo_1.Lapiz;
import Prototipo_1.Objetos;
import Prototipo_1.Personajes_juego.Personaje_Principal;
import Prototipo_1.Personajes_juego.Personajes;
import Prototipo_1.Personajes_juego.Villano;
import Prototipo_1.Personajes_juego.VillanoD;
import Prototipo_1.Personajes_juego.VillanoF;
import Prototipo_1.Strategy.GNivel1;
import Prototipo_1.Strategy.GameNivel;

public class Factory {
	// Factory principal
	private static Factory factory;

	public Factory() {}

	// Metodo retornable del mismo factory
	public static Factory getFactory() {
		if (factory == null) {

			factory = new Factory();
		}
		return factory;
	}

	// metodo para maquina de estados
	public GameState createState(String tag) {
		if (tag.equalsIgnoreCase("inicio")) {
			return new GameStateStart();
		}
		if (tag.equalsIgnoreCase("run")) {// estado run
			return new GameStateRunning();
		}
		if (tag.equalsIgnoreCase("pause")) {// estado pause
			return new GameStatePause();
		}
		if (tag.equalsIgnoreCase("go")) {
			return new GameStateGameOver();// estado fin
		}
		return null;
	}

	public GameNivel createNiveles(String tag) {
		if (tag.equalsIgnoreCase("nivel1")) {
			return new GNivel1();
		}

		return null;
	}
	
	public Personajes createPersonaje(String tag) {
		if(tag.equalsIgnoreCase("Personajeprincipal")) {
			return new Personaje_Principal();
		}
		
		return null;
	}
	public Villano createVillanos(String tag) {
		if(tag.equalsIgnoreCase("VillanoDebil")) {
			return new VillanoD();
		}
		if(tag.equalsIgnoreCase("VillanoFuerte")) {
			return new VillanoF();
		}
		return null;
	}
	public Objetos createObjects(String tag) {
		if(tag.equalsIgnoreCase("lapiz")) {
			return new Lapiz();
		}
		return null;
	}

}
