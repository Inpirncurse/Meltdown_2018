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
				if (x <= 1000)
				x += 5;
				
			}
			if(KeyboardSubject.getInstance().getLastPressed() == "left") {
				if (x >= 50)
				x -= 5;

			}
			if(KeyboardSubject.getInstance().getLastPressed() == "down") {
				if (y <= 455)
				y += 5;

			}
			if(KeyboardSubject.getInstance().getLastPressed() == "up") {
				if (y >= 10)
				y -= 5;
			}
			
		
			
		}
	}


}
