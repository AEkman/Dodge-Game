/*
 * 
 * This is a boss class and it contains everything that handles a boss from movement looks.
 * 
 * The class extends GameObject
 */

package dodge.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {

	private Handler handler;
	Random r = new Random();
	
	// Timer for entering the playing field
	private int timer = 100;
	// Timer for a quick paus before the boss starts to move
	private int timer2 = 80; // Paus timer
	
	public EnemyBoss(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		// Movement speed
		velX = 0;
		velY = 2;
	}

	// Hitbox
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 120, 120);
	}

	// Actions
	public void tick() {
		// Starts movement
		y += velY;
		x += velX;
		
		// Moving boss down
		if (timer <= 0) velY = 0; 
		else timer--;
		
		// Pausing Boss
		if (timer <= 0) timer2--;
		
		// Starts Boss movement side to side
		if (timer2 <= 0) {
			if (velX == 0) velX = 5;
			
			// Speeds up the Boss everytime it hits a border
			if (velX > 0) {
				velX += 0.005f;
			} else if (velX < 0) {
				velX -= 0.005f;
			}
			
			// Setting max speed for boss via clamp
			velX = Game.clamp(velX, -10, 10);
			
			// Number of bullets beeing fired
			int spawn = r.nextInt(8);
			if (spawn == 0) handler.addObject(new EnemyBossBullet((int) x + 60, (int) y + 60, ID.BasicEnemy, handler));
		}
		
		// Side movement increase when hitting border
		if(x <= 0 || x >= Game.WIDTH-120) velX *= -1;
	}

	// Drawing graphics
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, 120, 120);
	}
}
