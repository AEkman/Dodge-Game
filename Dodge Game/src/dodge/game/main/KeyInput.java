/*
 * 
 * This class handles all Key inputs and controllers for the game. It extends KeyAdapter.
 * 
 * 
 * The class extends KeyAdapter
 */

package dodge.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import dodge.game.main.Game.STATE;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	// Creating boolean states for movement keys
	private boolean[] keyDown = new boolean[4];

	Game game;

	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;

		// Setting movement keys to false
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}

	/* ******************* *
	 *                     *
	 * Key pressed events  *
	 *                     *
	 * ******************* */
	public void keyPressed(KeyEvent e) {
		// Getting keycode
		int key = e.getKeyCode();

		// Looping through objects
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			// Player keys
			if (tempObject.getId() == ID.Player) {
				
				// Up movement
				if (key == KeyEvent.VK_UP) { tempObject.setVelY(-handler.speed); keyDown[0] = true; }
				// Down movement
				if (key == KeyEvent.VK_DOWN) { tempObject.setVelY(handler.speed); keyDown[1] = true; }
				// Right movement
				if (key == KeyEvent.VK_RIGHT) { tempObject.setVelX(handler.speed); keyDown[2] = true; }
				// Left movement
				if (key == KeyEvent.VK_LEFT) { tempObject.setVelX(-handler.speed); keyDown[3] = true; }
			}
		}

		// Paus event bound to the key 'P'
		if(key == KeyEvent.VK_P) {
			// as long as the game is running the pause function is available
			if(game.gameState == STATE.Game) {
				// Unpaus the game if button 'p' is pressed and the game is currently paused
				if(Game.paused) Game.paused = false;
				// Pauses the game if button 'p' is pressed when the game is not paused
				else Game.paused = true;
			}
		}

		// Close program if 'escape' is pressed
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);

		// Enter shop if 'space' is pressed
		if(key == KeyEvent.VK_SPACE) {
			// Checks if game is running
			if (game.gameState == STATE.Game) {
				// Enter the shop
				Game.gameState = STATE.Shop;
				// When in shop
			} else if (Game.gameState == STATE.Shop){
				// Return to game
				Game.gameState = STATE.Game;
			}
		}
	}

	/* ******************* *
	 *                     *
	 * Key released events *
	 *                     *
	 * ******************* */
	public void keyReleased(KeyEvent e) {
		// Getting keycode
		int key = e.getKeyCode();

		// Looping through objects
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			// Player keys
			if (tempObject.getId() == ID.Player) {

				// Up movement
				if (key == KeyEvent.VK_UP) keyDown[0] = false;
				// Down movement
				if (key == KeyEvent.VK_DOWN) keyDown[1] = false;
				// Right movement
				if (key == KeyEvent.VK_RIGHT) keyDown[2] = false;
				// Left movement
				if (key == KeyEvent.VK_LEFT) keyDown[3] = false;

				// Vertical movement stops when no key is released
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				// Horizontal movement movement stops when no key is released
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
		}
	}
}
