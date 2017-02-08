/*
 * 
 * This is a smart enemy class and it contains everything that handles a basic enemy from looks to behavior.
 * 
 * The class extends GameObject
 */

package dodge.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		// Looping through gameobjects and searching for player ID
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
		}
	}

	// Hitbox
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}
	
	// Actions
	public void tick() {
		// Setting movement speed
		x += velX;
		y += velY;
		
		// Follow player
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt((x -  player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
		velX = (float) ((-1.0 / distance) * diffX);
		velY = (float) ((-1.0 / distance) * diffY);
		
		// Trail effect
		handler.addObject(new Trail(x, y, ID.Trail, Color.CYAN, 16, 16, 0.05f, handler));
	}

	// Drawing graphics
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, 16, 16);
	}
}
