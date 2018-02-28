package Prototipo_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class GamePanel extends JPanel implements Runnable {
	// Variables para definir tamaño de panel
	private static final int PW = 500;
	private static final int PH = 400;
	// -----------------------------------------------------------
	private Thread animator;

	private volatile boolean running = false;
	private volatile boolean gameOver = false;
	private volatile boolean isPaused = false;

	// Declaracion de personajes en juego
	private Personaje_Principal persona;
	private Villano v;

	// Constructor de GamePanel
	public GamePanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(PW, PH));
		readyForTermination();
		// setBounds(0, 0, 800, 600);
		setFocusable(true);
		// setVisible(true);
		requestFocus();

		// Instanciar personajes en constructor
		persona = new Personaje_Principal(40, 300);
		v = new Villano(200, 300);

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				testPress(e.getX(), e.getY());
			}

		});

	}

	public void addNotify() {
		// TODO Auto-generated method stub
		super.addNotify();
		startGame();
	}

	// funcion para iniciar el juego
	private void startGame() {
		if (animator == null || !running) {
			animator = new Thread(this);
			animator.start();
		}
	}

	// funcion para detener el juego
	public void stopGame() {
		running = false;
	}

	// Metodo para ejecucion de ciclo de juego
	public void run() {
		// TODO Auto-generated method stub
		running = true;
		while (running) {
			gameUpdate();
			gameUpdate();
			gameRender();
			paintScreen();
			try {
				// Tiempo
				Thread.sleep(20);
			} catch (InterruptedException ex) {
			}
		}
		System.exit(0);
	}

	// Funcion para actualizar
	private void gameUpdate() {
		if (!isPaused && !gameOver) {

		}
	}

	private Graphics dbg;
	private Image dbImage = null;

	// Funcion para pintar dentro del panel
	private void gameRender() {
		if (dbImage == null) {
			dbImage = createImage(PW, PH);
			if (dbImage == null) {
				System.out.println("dbImage is null");
				return;
			} else {
				dbg = dbImage.getGraphics();
			}
		}

		// Creando cuadro blanco dentro de panel
		dbg.setColor(Color.WHITE);
		dbg.fillRect(0, 0, PW, PH);

		// Dibujando personajes dentro de panel
		persona.draw(dbg);
		v.draw(dbg);
	}

	private void gameOverMessage() {
		Graphics g;
		g = this.getGraphics();
		g.drawString("GameOVER", 10, 10);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (dbImage != null) {
			g.drawImage(dbImage, 0, 0, null);
		}
	}

	private void readyForTermination() {
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				// Lectura de Teelado
				int keyCode = e.getKeyCode();

				if ((keyCode == KeyEvent.VK_ESCAPE) || (keyCode == KeyEvent.VK_Q) || (keyCode == KeyEvent.VK_END)
						|| ((keyCode == KeyEvent.VK_C) && e.isControlDown())) {
					running = false;
				}

				// Comparacion de teclado derecha, izquierda, arriba y abajo
				if (keyCode == KeyEvent.VK_RIGHT) {
					persona.setX(5);
				}
				if (keyCode == KeyEvent.VK_LEFT) {
					persona.setX(-5);
				}
				if (keyCode == KeyEvent.VK_UP) {
					persona.setY(-5);

				}
				if (keyCode == KeyEvent.VK_DOWN) {
					persona.setY(5);
				}
			}

		});
	}

	private void testPress(int x, int y) {
		if (!gameOver && !isPaused) {

		}
	}

	private void paintScreen() {
		Graphics g;
		try {
			g = this.getGraphics();
			if ((g != null) && (dbImage != null)) {
				g.drawImage(dbImage, 0, 0, null);
				Toolkit.getDefaultToolkit().sync();
				g.dispose();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Graphics error: " + e);
		}
	}

}
