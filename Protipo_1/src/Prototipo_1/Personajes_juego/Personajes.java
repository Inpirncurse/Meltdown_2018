package Prototipo_1.Personajes_juego;

import java.awt.Graphics;

public abstract class Personajes {//Clase madre de Villano y Personaje_principal
	protected int x;//variables de posición 
	protected int y;
	protected int pos, neg, total;
	protected int contadorVida;
	protected int life;
	public Personajes() {
		
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getX(){//Obtiene la posición en x
		return x;
	}
	
	public int getY(){//Obtiene la posicion de y
		return y;
	}
	
	// Asignar posicion en x
	public void setX(int n) {
		this.x += n;
	}

	// Asignar posicion en y
	public void setY(int n) {
		this.y += n;
	}
	
	

	public int vida(int contadorVida) {
		// TODO Auto-generated method stub
		return 0;
	}

	abstract public void draw(Graphics g);
	abstract public void move();
	abstract public void move(int n);
	abstract public void colision(int x,int y);
	abstract public void update(Villano n);
}
