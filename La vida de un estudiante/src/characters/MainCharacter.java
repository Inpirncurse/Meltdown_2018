package characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entities.Entity;
import observer.KeyboardSubject;
import observer.Observer;
import observer.Subject;

public class MainCharacter extends Entity implements Observer{
	private int vida = 100;
	private BufferedImage image;

	public MainCharacter () {
		KeyboardSubject.getInstance().subscribe(this);
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


	public void update() {}
	public void render(Graphics dbg) {}
	public void update(Subject subject) {
		if (subject == KeyboardSubject.getInstance()) {
			if(KeyboardSubject.getInstance().getLastPressed() == "right") {
				x -= 5;
				System.out.println("right2");
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "left") {
				x += 5;
				System.out.println("left2");
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "down") {
				y -= 5;
				System.out.println("down2");
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "up") {
				y += 5;
				System.out.println("up2");
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "attack") {
				
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "leave") {
				
			}
		}
	}
}
