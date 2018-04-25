package Prototipo_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameStateRunning implements GameState{
	private GameContext gc;
	private Personaje_Principal ps;
	private VillanoD vd;
	private VillanoF vf;

	//Estado run--Constructor
	public GameStateRunning(GameContext gc){
		this.gc = gc;
		ps = new Personaje_Principal(50, 200);//creacion de personaje principal
		vd = new VillanoD(150, 200);
		vf = new VillanoF(150, 200);

	}
	
	public void end(){
		gc.setCurrent(gc.getGameOver());
	}
	
	public void pause(){
		gc.setCurrent(gc.getPause());
	}
	
	public void resume(){
		System.out.println("No se puede hacer resume en Play");
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.drawString("Estoy corriendo",20,20);
		ps.draw(g);
		vd.draw(g);

	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		vd.move();
		vd.seguirPersonaje(ps.getY());
		//vf.move();
		//vf.seguirPersonaje(ps.getY());
	}


	

	@Override
	public void teclas(int n) {
		// TODO Auto-generated method stub
		ps.move(n);
	}


}
