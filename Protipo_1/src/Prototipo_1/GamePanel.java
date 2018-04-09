package Prototipo_1;

import java.awt.*;
import java.awt.event.*;

import javax.crypto.spec.GCMParameterSpec;
import javax.swing.*;


import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class GamePanel extends JPanel implements Runnable {
	
	private volatile boolean running = false;
	private volatile boolean end = false;
	private static final int PWIDTH = 500;
	private static final int PHEIGHT = 500; //tamaño del panel
	private GameContext juego;
	
	public GamePanel() {
		setPreferredSize(new Dimension(PWIDTH,PHEIGHT));
		setFocusable(true);
		requestFocus();
		readyForTermination();
		
		//pp = new Personaje_Principal(100, 50);
		juego = new GameContext();//creacion de gameContext
	
		addMouseListener( new MouseAdapter() { 
			public void mousePressed(MouseEvent e) { 
				testPress(e.getX(), e.getY()); }
		});
	
	}
	public void addNotify()
	{
		super.addNotify();
		startGame();
	}//addNotify
	
	private void startGame()
	{
		/*if(animator == null || !running){
			animator = new Thread(this);
			animator.start();
		}*/
		 ExecutorService application = Executors.newCachedThreadPool();
		 application.execute(this);
		 application.shutdown();
		
	}//startGame()
	public void run() {//inicio de ciclo de animacion
		// TODO Auto-generated method stub
		running = true;
	while(running) {
		gameUpdate();
		gameUpdate();
		gameRender();
		paintScreen();
		
		try{
			Thread.sleep(20);
		}catch(InterruptedException ex){}
		
	}	
		System.exit(0);
	}
	
	private void gameUpdate(){
		
	/*	if(!isPaused && !gameOver){
			circulo.move();
		}
		*/
	}//gameUpdate()
	private Graphics dbg;
	private Image dbImage = null;
	
	private void gameRender(){
		if(dbImage == null){
			dbImage = createImage(PWIDTH,PHEIGHT);
			if(dbImage == null){
				System.out.println("dbImage is null");
				return;
			}else{
				dbg = dbImage.getGraphics();
			}
		}	
			dbg.setColor(Color.white);
			dbg.fillRect(0,0,PWIDTH,PHEIGHT);
			juego.render(dbg);//pintado de gamecontext
	}//gameRender()
	private void paintScreen(){
		Graphics g;
		try{
			g = this.getGraphics();
			if((g != null) && (dbImage != null))
				g.drawImage(dbImage,0,0,null);
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
		}
		catch(Exception e){
			System.out.println("Graphics context error: "+e);
		}
	}
	
	private void readyForTermination() {
		addKeyListener( new KeyAdapter() { // listen for esc, q, end, ctrl-c
			public void keyPressed(KeyEvent e) { 
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_ESCAPE ) {
					juego.end();//Fin de juego con gameContext--Cambio de estado
				}
				if (keyCode == KeyEvent.VK_BACK_SPACE ) {
					juego.pause();//Pausa de juego con gameContext--Cambio de estado
				}
				juego.teclas(keyCode);
			} 	
			});
	} // end of readyForTermination()
	
	
	private void testPress(int x, int y)
	   
    {
      
	}

	public static void main(String[] args) {
			JFrame app = new JFrame("Meltdown");
	     app.getContentPane().add(new GamePanel(), BorderLayout.CENTER);
	     app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	     app.pack();
	     app.setResizable(true);  
	     app.setVisible(true);
	}
}
