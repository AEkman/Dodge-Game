/*
 * 
 * This is the class that handles the boss bullets. It contains everything that handles a basic enemy from looks to behavior.
 * 
 * The class extends GameObject
 */

package dodge.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {

	private Handler handler;
	Random r = new Random();
	
	public EnemyBossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		// Speed of "projectiles" bullets
		velX = (r.nextInt(4 - -4) - 4);
		velY = 5;
	}

	// Hitbox
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	// Actions
	public void tick() {
		// Starts movement
		x += velX;
		y += velY;
		
		// Removing enemy from game when it leaves the border
		if (y >= Game.HEIGHT) handler.removeObject(this);
		
		// Adding trail effect to bullets
		handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 16, 16, 0.05f, handler));
	}

	// Drawing graphics
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, 16, 16);
	}
}
