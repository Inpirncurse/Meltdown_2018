package characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entities.Entity;
import observer.KeyboardSubject;
import observer.Observer;
import observer.Subject;

public class MainCharacter extends Entity implements Observer{
	private int vida = 100;
	boolean bandera = false;
	private BufferedImage image;

	public MainCharacter () {
		KeyboardSubject.getInstance().subscribe(this);
		x = 100;
		y = 100;
	}
		
	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}


	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void collision() {

	}


	public void update() {}
	public void render(Graphics dbg) {}
	public void update(Subject subject) {
		if (subject == KeyboardSubject.getInstance()) {
			
			collision();
			
			if(KeyboardSubject.getInstance().getLastPressed() == "right") {
				if(x <= 1000)
					x += 25;
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "left") {
				if(x >= 50)
					x -= 25;
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "down") {
				if(y <= 455)
					y += 25;
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "up") {
				if(y >= 10)
				y -= 25;
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "attack") {
				
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "leave") {
				
			}
		}
	}
}
