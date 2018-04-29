package Prototipo_1.Personajes_juego;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Prototipo_1.Lapiz;
import Prototipo_1.Objetos;
import Prototipo_1.Machine_State.Factory;
import Prototipo_1.Singleton.ImagesLoader;

public class Personaje_Principal extends Personajes {

	private BufferedImage personaje;
	private int life = 100;
	private Objetos objetolapiz;

	public Personaje_Principal() {
		load();
	}
	// Constructor principal
	public Personaje_Principal(int x, int y) {
		this.x = x;
		this.y = y;
		load();
	}
	public void load() {
		objetolapiz = Factory.getFactory().createObjects("lapiz");
		objetolapiz.setX(x);
		objetolapiz.setY(y);
		personaje = ImagesLoader.getInstancia().getImage("niña");
	}
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	// recibe las ubicaciones de movimiento y dependiendo de eso asigna nuevos
	// valores a x y y
	public void colision(int px, int py) {
		// Comparion
		// Si Enemigo==Personaje(Por atras, por delante) yy Revisando que eje Y este
		// dentro del rango de personaje
		if ((px == x + 60 || px + 50 == x) && ((py > y && py < y + 85) || (py + 60 > y && py + 60 < y + 85))) {
			life -= 10;
		}

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		objetolapiz.setX(x);
		objetolapiz.setY(y + 10);
	}

	public void move(int codigo) {
		//
		if (codigo == KeyEvent.VK_DOWN) {
			y += 10;// verificar si jala
			if (this.y + 80 >= 600) {
				y = 600 - 80;
				System.out.println("LLegue al limite y-");
			}
		}
		if (codigo == KeyEvent.VK_UP) {// colision en limite superior
			y -= 10;
			if (this.y <= 100) {// checar
				y = 100;
				System.out.println("Llegue al limite y+");
			}
		}
		if (codigo == KeyEvent.VK_RIGHT) {
			x += 10;
			if (this.x + 40 >= 1100) {
				x = 1100 - 40;
				System.out.println("Llegue al limite x+");
			}
		}
		if (codigo == KeyEvent.VK_LEFT) {
			x -= 10;
			if (this.x <= 100) {
				x = 100;
				System.out.println("Llegue al limite x-");
			}
		}
		if (codigo == KeyEvent.VK_ENTER) {
			move();// Manda coordenas X y Y objeto lapiz
			objetolapiz.inicar();// Inicia reloj dentro de objeto lapiz
			System.out.println("Disparar");
		}
	}

	public void update(Villano villa) {
		objetolapiz.colision(villa);
	}

	// Funcion para pintar personaje
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		objetolapiz.draw(g);
		g.drawImage(personaje, x, y, 85, 85, null);
	}

}
