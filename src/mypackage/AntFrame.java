package mypackage;
import java.awt.*;
import javax.swing.JFrame;
import static mypackage.Direction.*;

public class AntFrame extends JFrame {
	int width = 1000;
	int height = 1000;
	int base = 5;
	boolean[][] board = new boolean[width/base][height/base];
	int antX = (width/base)/2;
	int antY = (height/base)/2;
	Direction direction = FOREWARDS;
	private final Color BISQUE = new Color(0xcdb79e);
	
	public AntFrame () {
		init();
	}
	
	
	public void init() {
		setSize(width,height);
		setBackground(Color.BLACK);
		repaint();
	}
	
	
	public void paint(Graphics g) {
		refreshBoard(g);
		for (int i = 0; i < 10000; i++) {
			updatePosition();
			refreshBoard(g);
			
		}
	}
	

	public void refreshBoard(Graphics g) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == false) {
					g.setColor(Color.WHITE);
					g.fillRect(row*base, col*base, base, base);
				}
				if (board[row][col] == true) {
					g.setColor(Color.BLACK);
					g.fillRect(row*base, col*base, base, base);
				}
			}
		}
	}
	
	public void updatePosition() {
		if (board[antX][antY] == true) {
			board[antX][antY] = false;
			
			if (direction == FOREWARDS) {
				antX += 1;
				direction = RIGHT;
				return;
			}
			
			if (direction == BACKWARDS) {
				antX -= 1;
				direction = LEFT;
				return;
			}
			
			if (direction == RIGHT) {
				antY -= 1;
				direction = BACKWARDS;
				return;
			}
			
			if (direction == LEFT) {
				antY += 1;
				direction = FOREWARDS;
				return;
			}
		} else if (board[antX][antY] == false) {
			board[antX][antY] = true;
			
			if (direction == FOREWARDS) {
				antX -= 1;
				direction = LEFT;
				return;
			}
			
			if (direction == BACKWARDS) {
				antX += 1;
				direction = RIGHT;
				return;
			}
			
			if (direction == RIGHT) {
				antY += 1;
				direction = FOREWARDS;
				return;
			}
			
			if (direction == LEFT) {
				antY -= 1;
				direction = BACKWARDS;
				return;
			}
		}
		
		
	}

	

}