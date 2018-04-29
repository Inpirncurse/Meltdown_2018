package Prototipo_1.Singleton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JProgressBar;
import javax.swing.Timer;

public class Hud {

	private static Hud instancia=null;
	private int vida=0;
	private int tiempo=0;
	private int nivel=1;
	private Timer reloj;
	private Font fuente;
	public Hud () {	
		
		//FUENTE DE UTILIZADA EN BARRA DE ESTADO
		fuente = new Font("Arial", 3, 18);
	//vida = 100;
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
		if(vida>0) {
			this.vida = vida;	
		}
		
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
		g.setColor(Color.white);
		g.setFont(fuente);
		g.drawString("La vida de un Estudiante", 400,15);
		g.drawString("Nivel: "+ nivel, 400, 35);
		g.drawString("Vida: ", 400, 60);
		g.drawString("Tiempo: "+tiempo, 400, 85);
		g.drawString(Integer.toString(vida)+" %", 750, 60);//Dibujar vida del personaje
		g.fillRect(530,43,200,20);//Dibuja cuadro blanco para barra de vida
		g.setColor(Color.red);
		g.fillRoundRect(530, 43, vida*2, 20, 10, 10); //Dibuja cuadro de vida
	
	}
	
	
}
