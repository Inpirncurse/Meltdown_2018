package stateMachine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import characters.MainCharacter;
import characters.StrongEnemy;
import characters.WeakEnemy;
import entities.Entity;
import singleton.Factory;
import singleton.ImageLoader;

public class GameStateRunning implements GameState{
	
	public void start() {}
	public void run() {}
	public void go() {}
	public void setContext(GameContext cont) {}
	public void clickMouse(MouseEvent e) {}
	public void processKey(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	private MainCharacter girl = (MainCharacter) Factory.getInstance().getEntity("girl");//esto no va aquí
	private WeakEnemy wGato =  (WeakEnemy) Factory.getInstance().getEntity("wGato");//esto no va aquí
	private StrongEnemy sGato =  (StrongEnemy) Factory.getInstance().getEntity("sGato");//esto no va aquí
	
	public void draw(Graphics dbg) {
		
		dbg.drawImage(ImageLoader.getImageLoader().getImage(0), 0, 0, null);
		
		girl.setImage(ImageLoader.getImageLoader().getImage(3));
		dbg.drawImage(girl.getImage(), girl.getX(), girl.getY(), null);
		
		wGato.setImage(ImageLoader.getImageLoader().getImage(1));
		wGato.update();
		dbg.drawImage(wGato.getImage(), wGato.getX(), wGato.getY(), null);
		
		sGato.setImage(ImageLoader.getImageLoader().getImage(2));
		sGato.update();
		dbg.drawImage(sGato.getImage(), sGato.getX(), sGato.getY(), null);
		
		

	}
	
	public void update() {

	}
	
}
