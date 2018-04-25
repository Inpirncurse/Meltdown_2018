package Prototipo_1;

import java.awt.Graphics;

public class Hud {

	private static Hud instancia=null;
	private int vida;
	private int tiempo;
	private int nivel;

	public Hud () {
		vida = 100;
	}
	
	public static Hud getInstancia() {
		if(instancia==null) {
			instancia = new Hud();
		}
		
		return instancia;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public void draw(Graphics g) {
		g.drawString("La vida de un Estudiante", 40,20);
		g.drawString("Nivel: "+ nivel, 40, 40);
		g.drawString("Vida: "+vida, 40, 80);
		g.drawRect(60,80,30,vida);
		g.drawString("Tiempo: "+tiempo, 50, 250);
		//g.drawRect(60, , width, height); Prueba de vida
	}
	
	
}
