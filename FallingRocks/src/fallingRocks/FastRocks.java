package fallingRocks;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class FastRocks extends Canvas  {

	public static ArrayList<Box> fastrocks;
	private int MAX_FASTROCKS_IN_GAME = 10;
	private static Random rand = new Random();
	
	public FastRocks() {
		int fastRocksLevel = 19;
		fastrocks = new ArrayList<Box>();
		fastrocks.add(new Box(rand.nextInt(fastRocksLevel), 0));
		fastRocksLevel--;
		if (fastRocksLevel == 7)
			fastRocksLevel = 19;
		
	}

	public void tick() {
		int rockCounter = fastrocks.size();
		
		// Create rocks if we have less than the Max amount of rocks.
		if (rockCounter != MAX_FASTROCKS_IN_GAME) {
			createRndRock();
		}
		
		// Move all rocks.
		
		for (int i = 0; i < fastrocks.size(); i++) {
			fastrocks.set(i, new Box(fastrocks.get(i).x, fastrocks.get(i).y + 1));
			
			if (fastrocks.get(i).y == Game.END_OF_FIELD) { // TODO: find out why 30 works ????
				fastrocks.remove(i);
				
				
				
			}
		}
	}
	
	public void createRndRock() {
		this.fastrocks.add(new Box(rand.nextInt(19), 0));
	}

	public void drawfastRocks(Graphics a) {
		for (Box box : fastrocks) {
			a.setColor(Color.RED);
			a.fillRect(box.x * Box.BOX_SIZE, box.y * Box.BOX_SIZE,
					Box.BOX_SIZE, Box.BOX_SIZE);
		}
	}
}
