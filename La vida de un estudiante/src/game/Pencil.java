package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entities.Entity;
import observer.KeyboardSubject;
import observer.Observer;
import observer.Subject;
import singleton.Cage;



public class Pencil extends Entity implements Observer{
	
	boolean flag = false; 
	BufferedImage image;
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public boolean getBandera() {
		return flag;
	}
	
	public void setBandera(boolean bandera) {
		this.flag = bandera;
	}
	public Pencil() {
		KeyboardSubject.getInstance().subscribe(this);
		x = Cage.getInstance().getGirl().getX();
		y = Cage.getInstance().getGirl().getY();

	}
	
	public void update() {}
	public void render(Graphics dbg) {}
	public void update(Subject subject) {
		if (subject == KeyboardSubject.getInstance()) {
			if(KeyboardSubject.getInstance().getLastPressed() == "attack") {
				if (x <= 1000 && flag)
				flag = false;
				else {
					flag = true;
					x = Cage.getInstance().getGirl().getX() + 35;
					y = Cage.getInstance().getGirl().getY() + 35;
				}

			}
		}
	}
	
	public void move() {
		x++;
	}

	

}
