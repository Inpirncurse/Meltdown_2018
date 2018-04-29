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
			notifyObserver();
			lastPressed = "right";
			System.out.println("right");
		}
		if (key.getKeyCode() == KeyEvent.VK_LEFT) {
			notifyObserver();
			lastPressed = "left";
			System.out.println("left");
		}
		if (key.getKeyCode() == KeyEvent.VK_DOWN) {
			notifyObserver();
			lastPressed = "down";
			System.out.println("down");
		}
		if (key.getKeyCode() == KeyEvent.VK_UP) {
			notifyObserver();
			lastPressed = "up";
			System.out.println("up");
		}
		if (key.getKeyCode() == KeyEvent.VK_SPACE) {
			notifyObserver();
			lastPressed = "attack";
		}
		if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {
			notifyObserver();
			lastPressed = "leave";
		}
	}
	
	public String getLastPressed() {
		return lastPressed;
	}

	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	
	


}
