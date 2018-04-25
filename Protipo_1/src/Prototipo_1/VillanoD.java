package Prototipo_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class VillanoD extends Villano{
	private  BufferedImage villanod;
	private final static String IMS_FILE = "imsInfo.txt";
	private ImagesLoader imageloader;
	private int life;
	public VillanoD(int x, int y) {
		super(x, y);
		life = 100;
		imageloader = new ImagesLoader(IMS_FILE);
		villanod = imageloader.getImage("vaso1");
		// TODO Auto-generated constructor stub
	}

	
	public void move(int x, int y) {
		// TODO Auto-generated method stub
	
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
			g.drawImage(villanod, x, y, 50, 70, null);
	}

	boolean bandera=true;
	@Override
	public void move() {
		// TODO Auto-generated method stub	
		if(x+80 >500) {
			x=400;
			bandera = false;
		}
		if(x<0) {
			x=0;
			bandera = true;
		}
		if(bandera) {
			x+=1;
		}else {
			x-=1;
		}
		
	}


	@Override
	public void seguirPersonaje(int liney) {
		// TODO Auto-generated method stub
		y=liney;
	}



	

}
