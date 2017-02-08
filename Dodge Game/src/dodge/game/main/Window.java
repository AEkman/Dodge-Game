/*
 * 
 * This class contains all settings for the main JFrame the game runs in.
 * 
 * This class extends Canvas.
 */

package dodge.game.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
	// Serial number
	private static final long serialVersionUID = -6678979914535228363L;
	
	// Constructor that take in width, height, title and game class
	public Window (int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		
		// Start thread
		game.start();
	}
}
