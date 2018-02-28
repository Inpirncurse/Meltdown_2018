package Prototipo_1;

import java.awt.Color;
import java.awt.Graphics;

public class Villano {

	// Variables definidas para posicion
	private int x;
	private int y;

	// Constructor principal
	public Villano(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Asignar cambios en x
	public void setX(int n) {
		this.x += n;
	}

	// Asignar cambios en y
	public void setY(int n) {
		this.y += n;
	}

	// Obtener posicion en x
	public int getX() {
		return x;
	}

	// Obtener posicion en y
	public int getY() {
		return y;
	}

	// Funcion para realizar movimiento de personaje
	public void move() {
		if (getX() == 5) {
			setX(150);
		}
		if (getX() > 0 && getX() < 150) {
			setX(-5);
		}
	}

	// Funcion para dibujar personaje
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 30, 90);
	}

}
