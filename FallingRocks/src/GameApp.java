import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


public class GameApp extends Applet{
	public Game game;
	InputHeandler iHeandler;
	
	public void init(){
;		
		game = new Game();
		game.setBackground(Color.gray);
		game.setPreferredSize(new Dimension(400,600));
		game.setVisible(true);
		game.setFocusable(true);
		this.add(game);
		this.setVisible(true);
		iHeandler = new InputHeandler(game);
	}
	
	public void paint(Graphics g){
		this.setSize(new Dimension(450,650));
	}
}
