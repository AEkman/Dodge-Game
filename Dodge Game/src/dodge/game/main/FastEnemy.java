/*
 * 
 * This is a fast enemy class, it contains everything that handles a basic enemy from looks to behavior.
 * 
 */

package dodge.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

	private Handler handler;
	
	public FastEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		// Movement speed 
		velX = 2;
		velY = 15;
	}

	// The look
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	// Actions
	public void tick() {
		// Starts movement
		x += velX;
		y += velY;
		
		// Makes sure the object is inside the gamefield
		if(y <= 0 || y >= Game.HEIGHT-50) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-25) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.YELLOW, 16, 16, 0.05f, handler));
	}

	// Drawing graphics
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int) x, (int) y, 16, 16);
	}
}
