/*
 * 
 * This is the player class and it everything from from looks to behavior.
 * 
 * The class extends GameObject
 */

package dodge.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		}

	// Hitbox
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
	// Actions
	public void tick() {
		// Starts movement
		x += velX;
		y += velY;
		
		// Makes sure the player is inside the gamefield
		x = Game.clamp((int)x, 0, Game.WIDTH -38);
		y = Game.clamp((int)y, 0, Game.HEIGHT -60);
		
		// Adding trail effect
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.05f, handler));
		
		// Checking collision
		collision();
		}
	
	//Adding collision method
	private void collision() {
		// Looping through game objects
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			// Collision code for basic enemy, fast enemy, smart nemy and superfast enemy
			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.SuperFastEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					
					// This loop make sure the sound is being finished before starting again
					if (AudioPlayer.getSound("grunt").playing()) {
					} else {
						// Adding sound for when player is getting hit
						AudioPlayer.getSound("grunt").play();
					}
					
					// Collision code = removes 2 hp per hit
					HUD.HEALTH -= 2;
				}
			}
			// Collision with BOSS = loose much health
			if (tempObject.getId() == ID.EnemyBoss) {
				if (getBounds().intersects(tempObject.getBounds())) {
					
					// This loop make sures the sound is being finished before starting again
					if (AudioPlayer.getSound("grunt").playing()) {
					} else {
						// Adding sound for when player is getting hit
						AudioPlayer.getSound("grunt").play();
					}
					
					// Collision code = removes 4 hp per hit
					HUD.HEALTH -= 4;
				}
			}
		}
	}

	// Drawing graphics
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, 32, 32);
	}
}
