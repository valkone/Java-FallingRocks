import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Rocks extends Canvas  {

	public ArrayList<Box> rocks;
	public int rockCounter = 0;
	private static Random rand = new Random();

	public Rocks() {
		rocks = new ArrayList<Box>();
	}

	public void tick() {
		int counter = 0;
		this.rockCounter++;
		if (this.rockCounter > 0) {
			int n = rand.nextInt(19);
			rocks.add(new Box(n, 0));
			this.rockCounter = 0;
		}
		
		for (Box box : rocks) {
			rocks.set(counter, new Box(box.x, box.y + 1));
			counter++;
		}
	}

	public void drawRocks(Graphics a) {
		for (Box box : rocks) {
			a.setColor(Color.black);
			a.fillRect(box.x * Box.BOX_SIZE, box.y * Box.BOX_SIZE,
					Box.BOX_SIZE, Box.BOX_SIZE);
		}
	}
}
