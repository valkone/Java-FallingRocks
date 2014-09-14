import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Rocks extends Canvas  {

	public ArrayList<Box> rocks;
	private int MAX_ROCKS_IN_GAME = 25;
	private static Random rand = new Random();

	public Rocks() {
		rocks = new ArrayList<Box>();
		rocks.add(new Box(rand.nextInt(19), 0));
	}

	public void tick() {
		int rockCounter = rocks.size();
		
		// Create rocks if we have less than the Max amount of rocks.
		if (rockCounter != MAX_ROCKS_IN_GAME) {
			createRndRock();
		}
		
		// Move all rocks.
		for (int i = 0; i < rocks.size(); i++) {
			rocks.set(i, new Box(rocks.get(i).x, rocks.get(i).y + 1));
			
			if (rocks.get(i).y == 30) { // TODO: find out why 30 works ????
				rocks.remove(i);
			}
		}
	}
	
	public void createRndRock() {
		this.rocks.add(new Box(rand.nextInt(19), 0));
	}

	public void drawRocks(Graphics a) {
		for (Box box : rocks) {
			a.setColor(Color.black);
			a.fillRect(box.x * Box.BOX_SIZE, box.y * Box.BOX_SIZE,
					Box.BOX_SIZE, Box.BOX_SIZE);
		}
	}
}
