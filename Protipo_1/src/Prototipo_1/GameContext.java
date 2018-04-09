package Prototipo_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class GameContext {
	private GameState run;
	private GameState pause;
	private GameState go;
	private GameState current;
	
	public GameContext() {
		run = new Factory().getFactory().createState("run", this);
		pause = new Factory().getFactory().createState("pause", this);
		go = new Factory().getFactory().createState("go", this);
		current = run;
	}
	
	public GameState getRun() {
		return run;
	}
	public GameState getPause() {
		return pause;
		
	}

	public GameState getGameOver() {
		return go;
	}
	public void setCurrent(GameState gs) {
		current = gs;
	}
	public void end() {
		current.end();
	}
	public void resume(){
		current.resume();
	}
	
	public void pause(){
		current.pause();
	}
	
	public void update(){
		current.update();
	}
	
	public void render(Graphics g){
		current.render(g);
	}

	public void teclas(int keyCode) {
		// TODO Auto-generated method stub
		current.teclas(keyCode);
	}

	
}
