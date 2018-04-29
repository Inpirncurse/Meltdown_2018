package stateMachine;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import singleton.Factory;

public class GameContext {
	
	private GameState start;
	private GameState run;
	private GameState go;
	private GameState currentState;
	
	public GameContext() {
		start = Factory.getInstance().createState("start");
		run = Factory.getInstance().createState("run");
        go = Factory.getInstance().createState("go");
        
        start.setContext(this);
        run.setContext(this);
        go.setContext(this);
        
        currentState = run;
	}


	public GameState Go() {return go;}
	public void start() { currentState.start();}
	public void run() { currentState.run();}
	public void update() {currentState.update();}
	public void setState(GameState state) {currentState = state;}
	public void draw(Graphics dbg) {currentState.draw(dbg);}
	public void clickMouse(MouseEvent e) {currentState.clickMouse(e);}
	
}
