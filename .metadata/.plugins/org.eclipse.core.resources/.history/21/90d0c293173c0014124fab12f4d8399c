import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;


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
