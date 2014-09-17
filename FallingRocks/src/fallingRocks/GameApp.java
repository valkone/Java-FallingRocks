package fallingRocks;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameApp extends Applet implements ActionListener {
	public Game game;
	InputHeandler iHeandler;
	Button newGame,bestResult,harder;
	boolean flag=false;
	public static Label levelTxt;
	public static final int GAME_HEIGHT = 600;
	
	public void init(){
		newGame = new Button("New Game");
		bestResult = new Button("Best Level");
		harder = new Button("Increase Difficulty");
		this.add(newGame);
		this.add(bestResult);
		newGame.addActionListener(this);
		bestResult.addActionListener(this);
		harder.addActionListener(this);
		levelTxt = new Label("Level 1");
		this.add(levelTxt);
		this.add(harder);
		
		game = new Game();
		game.setBackground(Color.gray);
		game.setLocation(10, 500);
		game.setPreferredSize(new Dimension(400,GAME_HEIGHT+25));
		game.setVisible(true);
		game.setFocusable(true);
		this.add(game);
		this.setVisible(true);
		iHeandler = new InputHeandler(game);
	}
	
	public void paint(Graphics g){
		this.setSize(new Dimension(500,700));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newGame){
			Game.gameRunning = true;
			Game.ship=new Ship();
			Game.rocks=new Rocks();
			Game.fastrocks=new FastRocks();
			Game.superfastrocks=new SuperFastRocks();
			Game.threadSpeed=10;
			Game.gameThread.resume();
			levelTxt.setText("Level 1");
		}
		if(e.getSource()==bestResult){
			if(bestResult.getLabel().contentEquals("Best Result")|| flag==false){
				flag=true;
				levelTxt.setText("Best Level: "+Integer.toString(HighScore.getScore()));
				bestResult.setLabel("Current Result");
			}
			else{
				levelTxt.setText("Level: "+Game.currentLevel);
				bestResult.setLabel("Best Result");
			}
		}
		if(e.getSource()==harder){
			if(Game.threadSpeed>0)
				Game.threadSpeed--;
		}
	}
	
}
