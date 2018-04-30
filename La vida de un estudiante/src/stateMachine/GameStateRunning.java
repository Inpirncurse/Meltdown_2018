package stateMachine;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import characters.MainCharacter;

import game.Pencil;
import game.Stage;
import observer.Actions;
import singleton.Cage;

import characters.StrongEnemy;
import characters.WeakEnemy;
import entities.Entity;
import singleton.Factory;
import singleton.ImageLoader;

public class GameStateRunning implements GameState{
	
	Stage nivel1 = new Stage();
	
	public void start() {}
	public void run() {}
	public void go() {}
	public void setContext(GameContext cont) {}
	public void clickMouse(MouseEvent e) {}
	public void processKey(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void draw(Graphics dbg) {
		dbg.drawImage(ImageLoader.getImageLoader().getImage(0), 0, 0, null);
		nivel1.draw(dbg);
	}
	public void update() {}
	
}
