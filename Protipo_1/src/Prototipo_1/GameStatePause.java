package Prototipo_1;

import java.awt.Color;
import java.awt.Graphics;

public class GameStatePause implements GameState {
	GameContext gc;

	public GameStatePause(GameContext gc) {
		this.gc = gc;
	}

	public void end() {
		System.out.println("No se puede dar end en pausado");
	}

	public void pause() {
		System.out.println("Ya está pausado");
	}

	public void resume() {
		gc.setCurrent(gc.getRun());
	}

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(20, 20, 400, 300);
		g.setColor(Color.white);
		g.drawString("Estoy Pausado.- Att.-Meltdown", 250, 150);
	}

	public void update() {

	}

	@Override
	public void teclas(int n) {
		// TODO Auto-generated method stub

	}

}
