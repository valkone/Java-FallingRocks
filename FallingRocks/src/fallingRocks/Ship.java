package fallingRocks;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class Ship {
	public LinkedList<Box> body;
	
	private int topX,topY,bottomX,bottomY;
	
	public Ship(){
		body = new LinkedList<>();
		this.topX = 9;
		this.topY = 24;
		this.bottomX = 9;
		this.bottomY = 25;
		Collections.addAll(body, 
				new Box(this.topX,this.topY),
				new Box(this.bottomX,this.bottomY)
				);
	}
	
	public void drawShip(Graphics g){
		for (Box box : body) {
			g.setColor(Color.blue);
			g.fillRect(box.x*Box.BOX_SIZE, box.y*Box.BOX_SIZE,
					Box.BOX_SIZE, Box.BOX_SIZE);
		}
	}
	
	public void tick(){
		for (Box a : Game.rocks.rocks) {
			if((a.x == Game.ship.getTopX() && a.y == Game.ship.getTopY()) ||
				(a.x == Game.ship.getBottomX() && a.y == Game.ship.getBottomY())){
				//Game.threadSpeed = 123123;
				 JOptionPane.showMessageDialog(null, "GameOver");
				 Game.setRunning(false);
				 
			}
		}
		
		body.set(0, new Box(this.topX, this.topY));
		body.set(1, new Box(this.bottomX, this.bottomY));
	}

	public int getTopX() {
		return topX;
	}

	public void setTopX(int topX) {
		this.topX = topX;
	}

	public int getTopY() {
		return topY;
	}

	public void setTopY(int topY) {
		this.topY = topY;
	}

	public int getBottomX() {
		return bottomX;
	}

	public void setBottomX(int bottomX) {
		this.bottomX = bottomX;
	}

	public int getBottomY() {
		return bottomY;
	}

	public void setBottomY(int bottomY) {
		this.bottomY = bottomY;
	}
	
}