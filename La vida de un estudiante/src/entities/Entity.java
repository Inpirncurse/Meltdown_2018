package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

import characters.WeakEnemy;

public abstract class Entity {
	protected int x = 0;
	protected int y = 0;
	protected int w = 0;
	protected int h = 0;
	protected int velocity = 0;
	protected double rotGrades = 0;
	protected Color color;
	protected Rectangle box = new Rectangle(x, y, w, h);
	
	public Entity() {}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
		box.setBounds(x,y,w,h);
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
		box.setBounds(x,y,w,h);
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
		box.setBounds(x,y,w,h);
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
		box.setBounds(x,y,w,h);
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract void update();
	public abstract void render(Graphics dbg);
	
	
}
