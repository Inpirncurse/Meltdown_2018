package stateMachine;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface GameState {

	public void start();
	public void run();
	public void go();//game over
	public void update();
	
	public void setContext(GameContext context);

	public void clickMouse(MouseEvent e);
	public void processKey(KeyEvent e);
	public void keyReleased(KeyEvent e);
	public void draw(Graphics dbg);

}
