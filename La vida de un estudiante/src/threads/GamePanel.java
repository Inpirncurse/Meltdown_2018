package threads;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.*;
import javax.swing.*;

import observer.KeyboardSubject;
import stateMachine.GameContext;

public class GamePanel extends JPanel implements Runnable {

    private static final int PWIDTH = 1200;
    private static final int PHEIGHT = 700; //tamaño del panel

    private Thread animator; //controla la animación
    private volatile boolean end = false;
    private GameContext game;//maquina de estados


    public GamePanel(){
        setBackground(Color.white);
        setPreferredSize(new Dimension(PWIDTH,PHEIGHT));//dimensiones del panel
        setFocusable(true);
        requestFocus();
        

        game = new GameContext();
        
        addKeyListener(KeyboardSubject.getInstance());


    } //GamePanel()

    public void addNotify(){
        super.addNotify();
        startGame();
    }

    private void startGame(){//inicializa la animacion
        if(animator == null ){
            animator = new Thread(this);
            animator.start();
        }
    }

    public void run(){
    	
        while(end==false){
            gameUpdate();
            gameRender();
            paintScreen();
            
            try{
                Thread.sleep(10);
            }
            catch(InterruptedException ex){}
        }
        System.exit(0);
    }

    private void gameUpdate(){
        game.update();
    }

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
        dbg.setColor(Color.black);

        game.draw(dbg);

    }

    private void gameOverMessage(){//CHECAR
        Graphics g;
        g = this.getGraphics();
        g.drawString("GameOver",10,10);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(dbImage != null)
            g.drawImage(dbImage, 0, 0, null);
    }


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

    public static void main(String args[]){
    	
    	JFrame panel = new JFrame("Guest it!!!");
		panel.setContentPane(new GamePanel());
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setVisible(true);
		panel.setLayout(new BorderLayout());
		panel.setResizable(true);	
		panel.pack();	
		panel.setLocationRelativeTo(null);
    }
}
