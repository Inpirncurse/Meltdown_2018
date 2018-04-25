package Prototipo_1;

import java.awt.Graphics;

interface  GameState {
	public void end();
	public void pause();
	public void resume();
	
	public void render(Graphics g);
	public void update();
	public void teclas(int n);
}
