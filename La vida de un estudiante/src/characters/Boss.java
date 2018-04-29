package characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import entities.Entity;

public class Boss extends Entity{
	private int life=100;
	private BufferedImage image;
	public Boss() {
		
	}
	
	
	
	public int getLife() {
		return life;
	}



	public void setLife(int life) {
		this.life = life;
	}



	public BufferedImage getImage() {
		return image;
	}



	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void listEnemigosA(ArrayList<VillanoD> enemigos) {
		Random aleatorio = new Random(System.currentTimeMillis());
		// Producir nuevo int aleatorio entre 0 y 99
		int posXAletorio = aleatorio.nextInt(900);
		int posYAletorio = aleatorio.nextInt(600);
		Iterator<VillanoD> cats = enemigos.iterator();
		while(cats.hasNext()){
			VillanoD v = cats.next();
			v.setX(posXAletorio);
			v.setY(posYAletorio);
		}
		//Podria Retornar lista de enemigos
	}
	public void listEnemigosB(ArrayList<VillanoF> enemigos) {
		Random aleatorio = new Random(System.currentTimeMillis());
		// Producir nuevo int aleatorio entre 0 y 99
		int posXAletorio = aleatorio.nextInt(900);
		int posYAletorio = aleatorio.nextInt(600);
		Iterator<VillanoF> cats = enemigos.iterator();
		while(cats.hasNext()){
			VillanoF v = cats.next();
			v.setX(posXAletorio);
			v.setY(posYAletorio);
		}
		//Podria Retornar lista de enemigos
	}
	
	public void move() {
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics dbg) {
		// TODO Auto-generated method stub
		
	}

	
	
}
