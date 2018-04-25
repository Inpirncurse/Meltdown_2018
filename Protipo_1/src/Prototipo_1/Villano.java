package Prototipo_1;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Villano extends Personajes {

	// Constructor principal
	public Villano(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	abstract public void move();
	abstract public void seguirPersonaje(int y);
	abstract public int vida();
	abstract public void draw(Graphics g);
}
