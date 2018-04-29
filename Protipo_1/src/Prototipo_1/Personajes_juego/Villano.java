package Prototipo_1.Personajes_juego;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Villano extends Personajes {
	private int life;
	// Constructor principal
	public Villano() {
		
	}
	public Villano(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	abstract public void move();
	abstract public void move(int x,int y);
	abstract public int vida();
	abstract public void bajarvida();
	abstract public void draw(Graphics g);
}
