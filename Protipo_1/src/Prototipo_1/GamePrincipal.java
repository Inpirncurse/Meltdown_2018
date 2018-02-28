package Prototipo_1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class GamePrincipal extends JFrame {
	// Declaracion de pnael
	private GamePanel game;

	public GamePrincipal() {
		// Tamño de ventana principal
		setBounds(100, 100, 700, 600);

		Container c = getContentPane(); // default BorderLayout used
		game = new GamePanel();
		c.add(game);// agregar panel a ventana principal
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);
		// Define what happens when a user closes the game window:

	}

	public static void main(String[] args) {
		new GamePrincipal();// Llamar a ventana principal
	}
}
