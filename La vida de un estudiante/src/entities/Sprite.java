package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite extends Entity{
	
	private BufferedImage image;
	
	public void update() {}
	public void render(Graphics dbg) {}
	
	public Sprite(BufferedImage image) {
		this.image = image;
	}
	public BufferedImage crop(int x, int y, int width, int height ) {
		return image.getSubimage(x, y, width, height);
	}

}
