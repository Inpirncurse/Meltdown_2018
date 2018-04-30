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
	private Pencil pencil = new Pencil();//esto no va aquí
	//private ArrayList <Pencil> pencils = new Pencil<>();
		//int x, y;
		boolean flag = true;
	int x;

	public void draw(Graphics dbg) {
		
		dbg.drawImage(ImageLoader.getImageLoader().getImage(0), 0, 0, null);
		
		
		pencil.setImage(ImageLoader.getImageLoader().getImage(5));
		if (pencil.getBandera()) {
			if (flag) {
				pencil.setX(Cage.getInstance().getGirl().getX()); 
				flag = false;
			}
			pencil.setX(pencil.getX()+10);
			dbg.drawImage(pencil.getImage(), pencil.getX(), pencil.getY(), null);
		}
		girl.setImage(ImageLoader.getImageLoader().getImage(3));
		dbg.drawImage(girl.getImage(), girl.getX(), girl.getY(), null);
		

		
		
		
	}
	public void update() {
		

	}
	
}
