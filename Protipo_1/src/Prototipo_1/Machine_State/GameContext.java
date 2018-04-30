package Prototipo_1.Machine_State;

import java.awt.*;

import Prototipo_1.Strategy.GameNivel;


public class GameContext {
	private GameState run;
	private GameState pause;
	private GameState go;
	private GameNivel n1,n2;
	private GameState current;
	private GameNivel strategy;// estretegia de juego
	
	public GameContext() {
		n1 = Factory.getFactory().createNiveles("nivel1");
		n2 = Factory.getFactory().createNiveles("Nivel");
		run = Factory.getFactory().createState("run");
		pause = Factory.getFactory().createState("pause");
		go = Factory.getFactory().createState("go");
	//	strategy = n1;
		current = run;
	}
	
	//n1.setContext(this);
	
	public GameState getRun() {return run;}
	public GameState getPause() {return pause;}
	public GameState getGameOver() {return go;}
	public void setCurrent(GameState gs) {current = gs;}
	public void end() {current.end();}
	public void resume(){current.resume();}
	public void pause(){current.pause();}
	public void update(){current.update();}
	public void render(Graphics g){current.render(g);}
	public void teclas(int keyCode) {current.teclas(keyCode);}
	public void setStrategy(GameNivel strategy) {this.strategy = strategy;}
	public boolean pasarnivel1(int i) {
		if(strategy.eliminarEnimigos(i)){
		return true;
		}else {
			return false;
		}
	}
	
}
