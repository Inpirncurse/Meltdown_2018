package stateMachine;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameStateStart implements GameState{
	
	GameContext context;
	
	public GameStateStart() {}
	
	public void start() {}
	public void run() {}
	public void go() {}
	public void update() {}
	public void setContext(GameContext context) { this.context = context;}
	public void clickMouse(MouseEvent e) {}
	public void processKey(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void draw(Graphics dbg) {}
	
}
