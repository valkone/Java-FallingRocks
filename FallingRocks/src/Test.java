import java.awt.Canvas;
import java.awt.Graphics;


public class Test extends Canvas implements Runnable{

	public Thread testThread;
	public Graphics testGraphics;
	public Rocks rocks;
	
	public void paint(Graphics g){
		testGraphics = g.create();
		g.fillRect(5, 5, 20, 20);
	}
	
	public Test(){
		if(testThread == null){
			testThread = new Thread(this);
			testThread.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void run(){
		while(true){
			paint(testGraphics);	
		}
	}
	
	public void draw(Graphics g){
		g.fillRect(5, 5, 20, 20);
	}
}
