package fallingRocks;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Game extends Canvas implements Runnable{
	
	public static Ship ship;
	public static Rocks rocks;
	public Test test;
	public static Graphics globalGraphics;
	private Thread gameThread;
	public static boolean gameRunning = 	false;
	public static int threadSpeed = 10;
	
	public Game(){
		ship = new Ship();
		rocks = new Rocks();
	}
	
	public void paint(Graphics g){
		globalGraphics = g.create();
		
		if(gameThread == null){
			gameThread = new Thread(this);
			gameThread.start();
			gameRunning = true;
		}
	}
	
	public void run() {
		int rockCreationDelay = 0;
		while(gameRunning) {
			rockCreationDelay++;
			ship.tick();
			
			if(rockCreationDelay > 20) {
				rocks.tick();
				rockCreationDelay = 0;
			}
			
			render(globalGraphics);

			try {
				Thread.sleep(this.threadSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void render(Graphics g){
		g.clearRect(0, 0, 400, 600);
		ship.drawShip(globalGraphics);
		rocks.drawRocks(globalGraphics);
	}
	
	public static void setRunning(boolean bool){
		gameRunning = bool;
	}
}
