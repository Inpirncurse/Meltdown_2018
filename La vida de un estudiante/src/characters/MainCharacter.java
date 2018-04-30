package characters;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.Entity;
import game.Pencil;
import observer.KeyboardSubject;
import observer.Observer;
import observer.Subject;


public class MainCharacter extends Entity implements Observer{
	private int vida = 100;
	boolean bandera = false;
	public Pencil pencil;
	//private  ArrayList<Pencil> pencil = new ArrayList<>();

	
	public MainCharacter () {
		KeyboardSubject.getInstance().subscribe(this);
		x = 100;
		y = 100;
      
	}
		
	

	public Pencil getPencil() {
		return pencil;
	}



	public void setPencil(Pencil pencil) {
		this.pencil = pencil;
	}



	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	
	public void update() {}
	public void render(Graphics dbg) {}
	public void update(Subject subject) {
		if (subject == KeyboardSubject.getInstance()) {
			if(KeyboardSubject.getInstance().getLastPressed() == "right") {
				x += 20;
				System.out.println("right2");
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "left") {
				x -= 20;
				System.out.println("left2");
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "down") {
				y += 20;
				System.out.println("down2");
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "up") {
				y -= 20;
				System.out.println("up2");
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "attack") {
				
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "leave") {
				
			}
			
		
			
		}
	}


}
