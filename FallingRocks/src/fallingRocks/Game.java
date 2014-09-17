package fallingRocks;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;

public class Game extends Canvas implements Runnable{
	
	public static int END_OF_FIELD = 30,currentLevel;
	public static Ship ship;
	public static Rocks rocks;
	public static FastRocks fastrocks;
	public static SuperFastRocks superfastrocks;
	public static Graphics globalGraphics;
	public static Thread gameThread;
	public static boolean gameRunning = false;
	public static int threadSpeed = 10;
	public static int score = 0;
	public static byte attempts = 3;
	public static LocalTime timeplayed = LocalTime.of(0, 0);
	
	public Game(){
		ship = new Ship();
		rocks = new Rocks();
		fastrocks = new FastRocks();
		superfastrocks = new SuperFastRocks();
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
		int rockLevels = 35;
		int i = 0;
		currentLevel = 1;
		System.out.println("Level 1");
		while(gameRunning) {
			rockCreationDelay++;
			ship.tick();
			
			if(rockCreationDelay > rockLevels) {
				rocks.tick();
				fastrocks.tick();
				superfastrocks.tick();
				superfastrocks.tick();
				
				if (currentLevel > 10) {
					fastrocks.tick();
					superfastrocks.tick();
				}				
				rockCreationDelay = 0;
				i++;
				if (i == 50) {
					rockLevels--;
					currentLevel++;
					System.out.println("Level up " + currentLevel);
					GameApp.levelTxt.setText("Level " + currentLevel);
					HighScore.saveScore();
					superfastrocks.tick();
					i = 0;
				}	
				
				score+=2;
				
				if (score % 2 == 0) {
					timeplayed = timeplayed.plusSeconds(1);
				}
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
		fastrocks.drawfastRocks(globalGraphics);
		superfastrocks.drawSuperfastRocks(globalGraphics);
		
		g.setColor(Color.black);
		g.fillRect(0, GameApp.GAME_HEIGHT, 400, 25);
		g.setColor(Color.white);
		g.drawString("Score: " + score +" Points", 10, GameApp.GAME_HEIGHT+15);
		g.drawString("Attempts: " +attempts, 310, GameApp.GAME_HEIGHT+15);
		g.drawString(String.format("Time Played: %s min %s sec", 
				timeplayed.getMinute(), timeplayed.getSecond()),
				120, GameApp.GAME_HEIGHT+15);
		g.setColor(Color.black);
		g.fillRect(0, 0, 400, 25);
		g.setColor(Color.white);
		g.drawString("CHINESE ROSE | CHINESE ROSE | CHINESE ROSE | "
				+ "CHINESE ROSE | CHINESE ROSE"
				, 5, 15);
	}
}
