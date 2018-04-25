package Prototipo_1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class VillanoF extends Villano{
	private  BufferedImage villanof;
	private final static String IMS_FILE = "imsInfo.txt";
	private ImagesLoader imageloader;
	private int life;
	
	
	public VillanoF(int x, int y) {
		super(x, y);
		imageloader = new ImagesLoader(IMS_FILE);
		villanof = imageloader.getImage("emoji");
		// TODO Auto-generated constructor stub
	}
	private boolean bandera;
	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(x+50 >500) {
			x=400;
			bandera = false;
		}
		if(x<0) {
			x=0;
			bandera = true;
		}
		if(bandera) {
			x+=2;
		}else {
			x-=2;
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
		g.drawImage(villanof, x, y, 50, 50, null);
	}

	@Override
	public void seguirPersonaje(int liney) {
		// TODO Auto-generated method stub
		y=liney;
	}
	
}
