package fallingRocks;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class SuperFastRocks extends Canvas  {

	public static ArrayList<Box> superfastrocks;
	private int MAX_SUPERFASTROCKS_IN_GAME = 3;
	private static Random rand = new Random();
	
	public SuperFastRocks() {
		int superfastRocksLevel = 10;
		superfastrocks = new ArrayList<Box>();
		superfastrocks.add(new Box(rand.nextInt(superfastRocksLevel), 0));
		
		
	}

	public void tick() {
		int rockCounter = superfastrocks.size();
		
		// Create rocks if we have less than the Max amount of rocks.
		if (rockCounter != MAX_SUPERFASTROCKS_IN_GAME) {
			
			createRndRock();
		}
		
		// Move all rocks.
		
		for (int i = 0; i < superfastrocks.size(); i++) {
			superfastrocks.set(i, new Box(superfastrocks.get(i).x, superfastrocks.get(i).y + 1));
			
			if (superfastrocks.get(i).y == Game.END_OF_FIELD) { // TODO: find out why 30 works ????
				superfastrocks.remove(i);
				
				
				
			}
		}
	}
	
	public void createRndRock() {
		this.superfastrocks.add(new Box(rand.nextInt(19), 0));
	}

	public void drawSuperfastRocks(Graphics a) {
		for (Box box : superfastrocks) {
			a.setColor(Color.GREEN);
			a.fillRect(box.x * Box.BOX_SIZE, box.y * Box.BOX_SIZE,
					Box.BOX_SIZE, Box.BOX_SIZE);
		}
	}
}
