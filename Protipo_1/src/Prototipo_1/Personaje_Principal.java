package Prototipo_1;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Personaje_Principal extends Personajes {
	
	private ImagesLoader img;
	// Constructor principal
	public Personaje_Principal(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//recibe las techas de movimiento y dependiendo de eso asigna nuevos valores a x y y

	public void move(int codigo) {
		
		if(codigo==KeyEvent.VK_DOWN) {
			y+=5;//verificar si jala
			if(this.y+80 >= 500) {
				y = 500-80;
				System.out.println("LLegue al limite y-");
			} 
		}
		if(codigo==KeyEvent.VK_UP) {//colision en limite superior
			y-=5;
			if(this.y <= 0) {//checar
				y = 0;
				System.out.println("Llegue al limite y+");
			}
		}
		if(codigo==KeyEvent.VK_RIGHT) {
			x +=5;
			if(this.x+40 >= 500) {
				x = 500 - 40;
				System.out.println("Llegue al limite x+");
			}
		}
		if(codigo==KeyEvent.VK_LEFT) {
			x -=5;
			if(this.x <= 0) {
				x = 0;
				System.out.println("Llegue al limite x-");
			}
		}
	}

	// Funcion para pintar personaje
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 40, 80);
		//img =imageloader.getinstante().getimage("nombre",nombre);
	}
	

	public int vida(int contadorVida){
		return contadorVida;
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int vida() {
		// TODO Auto-generated method stub
		return 0;
	}


}

