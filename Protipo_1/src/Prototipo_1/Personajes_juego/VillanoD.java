package Prototipo_1.Personajes_juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import Prototipo_1.Singleton.ImagesLoader;

public class VillanoD extends Villano {
	private BufferedImage villanod;

	boolean izq = false, der = true;

	public VillanoD () {
		load();
	}

	public VillanoD(int x, int y) {
		super(x, y);
		load();
		// TODO Auto-generated constructor stub
	}

	public void load() {
		setLife(100);
		villanod = ImagesLoader.getInstancia().getImage("gato");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (x + 80 > 1100) {
			x = 1000;
			izq = true;
			der = false;
		}
		if (x < 100) {
			x = 110;
			der = true;
			izq = false;
			// bandera = true;
		}

	}

	public void move(int px, int py) {
		// TODO Auto-generated method stub
		if (der) {
			x++;
		}
		if (izq) {
			x--;
		}
		if (x == px + 60 && ((y > py && y < py + 85) || (y + 50 > py && y + 50 < py + 60))) {
			der = true;
			izq = false;
		}
		if (x + 50 == px && ((y > py && y < py + 85) || (y + 50 > py && y + 50 < py + 60))) {
			izq = true;
			der = false;
		}

	}

	public void bajarvida() {

		if (getLife() > 0) {
			setLife(getLife()-1);
		}
	}

	@Override
	public int vida() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.drawImage(villanod, x, y, 70, 70, null);
		g.drawString(Integer.toString(getLife()), x, y - 10);
	}

	@Override
	public void move(int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colision(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Villano n) {
		// TODO Auto-generated method stub
		
	}

}
