package singleton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	private static HUD hud;
	private int vida, nivel, tiempo;


	public static HUD getHUD(){
		if(hud == null){
			hud = new HUD();
		}
		return hud;
	}
	
	public void render(Graphics g){
		g.setColor(Color.white);
		g.setFont(new Font("Times New Roman", Font.BOLD, 25));
		g.drawString("La vida de un Estudiante", 400,15);
		g.drawString("Nivel: "+ nivel, 400, 35);
		g.drawString("Calificación: ", 400, 60);
		g.drawString("Tiempo: "+tiempo, 400, 85);
		g.drawString(Integer.toString(vida)+" %", 750, 60);//Dibujar vida del personaje
		g.fillRect(530,43,200,20);//Dibuja cuadro blanco para barra de vida
		g.setColor(Color.red);
		g.fillRoundRect(530, 43, vida*2, 20, 10, 10); //Dibuja cuadro de vida

	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	 
	 
	 
}
