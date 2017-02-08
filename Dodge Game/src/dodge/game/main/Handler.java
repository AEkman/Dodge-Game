/*
 * 
 * Class for storing objects as a list to be called throughout the program.
 * 
 */

package dodge.game.main;

import java.awt.Graphics;
import java.util.LinkedList;

// Updates the renderer by looping through all items in the game and update them
public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();

	// Setting up speed variable for player. This variable is affected by the shop speed upgrade
	public int speed = 5;
	
	// Looping through all game objects actions
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}

	// Render all game objects
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);

			tempObject.render(g);
		}
	}

	// Method for clearing enemies from screen, players is also removed but added again on the same spot
	public void clearEnemys () {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);

			// If player is removed, add him again on the same x and y coordinates
			if (tempObject.getId() == ID.Player) {
				object.clear();
				// If game has ended add player i start position
				if (Game.gameState != Game.STATE.End) {
					addObject(new Player((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
				}
			}
		}
	}

	// Adding object to list
	public void addObject(GameObject object) {
		this.object.add(object);
	}

	// Remove object from list
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
