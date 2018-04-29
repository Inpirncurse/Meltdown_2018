package Prototipo_1.Machine_State;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import Prototipo_1.Personajes_juego.Personaje_Principal;
import Prototipo_1.Personajes_juego.Personajes;
import Prototipo_1.Personajes_juego.Villano;
import Prototipo_1.Personajes_juego.VillanoD;
import Prototipo_1.Personajes_juego.VillanoF;
import Prototipo_1.Singleton.Hud;
import Prototipo_1.Singleton.ImagesLoader;
import Prototipo_1.Strategy.GameNivel;

public class GameStateRunning implements GameState {
	private GameContext gc;
	private Hud barraestado;
	private GameNivel n1;
	private boolean banderav1 = true, banderav2 = true, banderav3 = true;
	private BufferedImage fondo;

	// Personaje y Villanos
	private Personajes ps;
	private Villano vd, vd2, vd3; 
	// Constructor Default
	public GameStateRunning() {
		load();
	}

	public GameStateRunning(GameContext gc) {
		this.gc = gc;
		load();
	}

	public void load() {
		// Instancia desde Singleton HUD
		barraestado = Hud.getInstancia();
		n1 = Factory.getFactory().createNiveles("nivel1");
		fondo = ImagesLoader.getInstancia().getImage("background");

		ps = Factory.getFactory().createPersonaje("Personajeprincipal");// creacion de personaje principal
		ps.setX(300);
		ps.setY(400);
		
		vd = Factory.getFactory().createVillanos("VillanoDebil");
		vd.setX(1000);
		vd.setY(400);
		vd2 = Factory.getFactory().createVillanos("VillanoDebil");
		vd2.setX(300);
		vd2.setY(250);
		
		vd3 = Factory.getFactory().createVillanos("VillanoFuerte");
		vd3.setX(450);
		vd3.setY(100);
		
		
	}

	public void end() {
		gc.setCurrent(gc.getGameOver());
	}

	public void pause() {
		gc.setCurrent(gc.getPause());
	}

	public void resume() {
		System.out.println("No se puede hacer resume en Play");
	}

	public void teclas(int n) {
		// TODO Auto-generated method stub
		ps.move(n);
	}

	@Override
	public void update() {
		
		
		//las banderas son para usar los metodos de cada  villano, mientras este vivo
		if (banderav1) {

			vd.move(ps.getX(), ps.getY());
			vd.move();
			ps.colision(vd.getX(), vd.getY());
			ps.update(vd);
		}
		if (banderav2) {

			vd2.move(ps.getX(), ps.getY());
			vd2.move();
			ps.colision(vd2.getX(), vd2.getY());
			ps.update(vd2);
		}
		if (banderav3) {

			vd3.move(ps.getX(), ps.getY());
			vd3.move();
			ps.colision(vd3.getX(), vd3.getY());
			ps.update(vd3);
		}
		
		//Enviando a barrado de esta vida
		barraestado.setVida(ps.getLife());
		if(!banderav1 && !banderav2 && !banderav3) {
			if (n1.eliminarEnimigos(3)) {
			barraestado.setNivel(2);
			System.out.println("Cambio de nivel");
			// gc.setStrategy(strategy);
		}
		}
		}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawImage(fondo, 0, 0, null);
		g.drawString("Estoy corriendo", 20, 20);
		ps.draw(g);

		if (vd.getLife() > 0) {
			vd.draw(g);// Dibujar villano
		} else {
			banderav1 = false;
		}
		if (vd2.getLife() > 0) {
			vd2.draw(g);// Dibujar villano
		} else {
			banderav2 = false;
		}
		if (vd3.getLife() > 0) {
			vd3.draw(g);// Dibujar villano
		} else {
			banderav3 = false;
		}
		barraestado.draw(g);
	}

}
