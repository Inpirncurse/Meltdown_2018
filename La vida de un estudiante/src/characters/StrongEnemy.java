package characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entities.Entity;

public class StrongEnemy extends Entity {
	private int health = 100;
	protected BufferedImage image;
	private int addX = 5;
	private int addY = 5;
	private int radio = 60;
	private int limitX = 1100;
	private int limitY = 600;
	
	//public WeakEnemy() {}
	public StrongEnemy() {
		x = 200;
		y = 300;
	}
		
	public int getHealth() {
		return health;
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void update() {
		if((this.x + radio) >= limitX) {
			addX = -addX;
			x = (limitX-10) - radio;
		}
		if(x <= 0) {
			addX = -addX;
			x = 10;
		}
		if((this.y + radio) >= limitY) {
			addY = -addY;
			y = (limitY-10) - radio;
		}
		if(y <= 0) {
			addY = -addY;
			y = 10;
		}
		x += addX;
		y += addY;
	}
	public void render(Graphics dbg) {}
}
