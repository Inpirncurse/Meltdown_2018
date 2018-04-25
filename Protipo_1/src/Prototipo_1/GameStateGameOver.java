package Prototipo_1;

import java.awt.Color;
import java.awt.Graphics;

public class GameStateGameOver implements GameState {
	GameContext gc;

	public GameStateGameOver(GameContext gc) {
		this.gc = gc;
	}

	public void end() {
		System.out.println("No se puede dar end en GameOver");
	}

	public void pause() {
		System.out.println("No se puede dar pause en GameOver");
	}

	public void resume() {
		System.out.println("No se puede dar resume en GameOver");
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Estoy terminado.-Adios", 20, 20);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teclas(int n) {
		// TODO Auto-generated method stub
		
	}
}
