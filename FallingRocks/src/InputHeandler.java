import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHeandler implements KeyListener{

	public InputHeandler(Game game) {
		game.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP){
			if(Game.ship.getTopY()!=0){
				Game.ship.setTopY(Game.ship.getTopY()-1);
				Game.ship.setBottomY(Game.ship.getBottomY()-1);
			}
		}else if(key == KeyEvent.VK_DOWN){
			if(Game.ship.getTopY()!=28){
				Game.ship.setTopY(Game.ship.getTopY()+1);
				Game.ship.setBottomY(Game.ship.getBottomY()+1);
			}
		}else if(key == KeyEvent.VK_LEFT){
			if(Game.ship.getTopX()!=0){
				Game.ship.setTopX(Game.ship.getTopX()-1);
				Game.ship.setBottomX(Game.ship.getBottomX()-1);
			}
		}else if(key == KeyEvent.VK_RIGHT){
			if(Game.ship.getTopX()!=19){
				Game.ship.setTopX(Game.ship.getTopX()+1);
				Game.ship.setBottomX(Game.ship.getBottomX()+1);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
