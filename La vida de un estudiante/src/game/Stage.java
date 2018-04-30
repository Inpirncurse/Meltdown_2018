package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import characters.MainCharacter;
import characters.StrongEnemy;
import characters.WeakEnemy;
import entities.Entity;
import singleton.Cage;
import singleton.Factory;
import singleton.ImageLoader;
import stateMachine.GameContext;
import stateMachine.GameState;

public class Stage implements GameState {
	
	public void start() {}
	public void run() {}
	public void go() {}
	public void update() {}
	public void setContext(GameContext context) {}
	public void clickMouse(MouseEvent e) {}
	public void processKey(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	boolean flag = true;
	int x;
	
	public Stage() {}
	
	private MainCharacter girl = (MainCharacter) Factory.getInstance().getEntity("girl");
	private Pencil pencil = new Pencil();
	private WeakEnemy wGato =  (WeakEnemy) Factory.getInstance().getEntity("wGato");
	private StrongEnemy sGato =  (StrongEnemy) Factory.getInstance().getEntity("sGato");

	public void draw(Graphics dbg) {
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
		
		wGato.setImage(ImageLoader.getImageLoader().getImage(1));
		wGato.update();
		dbg.drawImage(wGato.getImage(), wGato.getX(), wGato.getY(), null);
		
		sGato.setImage(ImageLoader.getImageLoader().getImage(2));
		sGato.update();
		dbg.drawImage(sGato.getImage(), sGato.getX(), sGato.getY(), null);
		
	}

}
