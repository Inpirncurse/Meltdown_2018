package observer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class KeyboardSubject implements Subject, KeyListener {

	private List<Observer> observers = new ArrayList<>();
	private String lastPressed;
	private static KeyboardSubject keyboardSubject;
	
	public static KeyboardSubject getInstance() {
		if (keyboardSubject == null) {
			keyboardSubject = new KeyboardSubject();
		}
		return keyboardSubject;
	}
	
	public void notifyObserver() {//notifico que se presiono una tecla
		for (Observer aux : observers) {
				aux.update(this);
		}
	}
	
	public void subscribe(Observer observer) {
		observers.add(observer);
	}
	
	public void keyPressed(KeyEvent key) {
		if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
			lastPressed = "right";
			notifyObserver();
			
			System.out.println("right");
		}
		if (key.getKeyCode() == KeyEvent.VK_LEFT) {
			lastPressed = "left";
			notifyObserver();
			
			System.out.println("left");
		}
		if (key.getKeyCode() == KeyEvent.VK_DOWN) {
			lastPressed = "down";
			notifyObserver();
			
			System.out.println("down");
		}
		if (key.getKeyCode() == KeyEvent.VK_UP) {
			lastPressed = "up";
			notifyObserver();
			
			System.out.println("up");
		}
		if (key.getKeyCode() == KeyEvent.VK_SPACE) {
			
			lastPressed = "attack";
			notifyObserver();
		}
		if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {

			lastPressed = "exit";
			notifyObserver();
			
		}
	}
	
	public String getLastPressed() {
		return lastPressed;
	}

	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	
	


}
