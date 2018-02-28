package Prototipo_1;

import java.awt.Color;
import java.awt.Graphics;

public class Personaje_Principal {
	// Variables de posicion
	private int x;
	private int y;

	// Constructor principal
	public Personaje_Principal(int x, int y) {
		this.x = x;
		this.y = y;

	}

	// Asignar posicion en x
	public void setX(int n) {
		this.x += n;
	}

	// Asignar posicion en y
	public void setY(int n) {
		this.y += n;
	}

	public void move() {

	}

	// Funcion para pintar personaje
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 40, 80);
	}
}
