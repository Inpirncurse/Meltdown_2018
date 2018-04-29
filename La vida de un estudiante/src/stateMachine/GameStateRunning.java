package stateMachine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import characters.MainCharacter;
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
	
	public void draw(Graphics dbg) {
		
		dbg.drawImage(ImageLoader.getImageLoader().getImage(0), 0, 0, null);
		girl.setImage(ImageLoader.getImageLoader().getImage(3));
		dbg.drawImage(girl.getImage(), girl.getX(), girl.getY(), null);

		
	}
	public void update() {

	}
	
}
