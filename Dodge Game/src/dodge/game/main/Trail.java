/*
 * 
 * Creating the traileffect
 * 
 */

package dodge.game.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {

	private float alpha = 1;
	private float life;
	
	private Handler handler;
	
	private Color color;
	private int width, height;

	// Constructor that take in handler, color, width, height and life
	public Trail(float x, float y, ID id, Color color, int width, int height, float life, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}

	// Actions
	public void tick() {
		// Checks if alpha is greater then life
		if (alpha > life) {
			// Decrease alhpa
			alpha -= (life - 0.001f);
		} else {
			// When life is 0 remove object
			handler.removeObject(this);
		}
	}

	// Drawing graphics
	public void render(Graphics g) {
		// G2D object called g
		Graphics2D g2d = (Graphics2D) g;
		// Transparent effect
		g2d.setComposite(makeTransparent(alpha));

		g.setColor(color);
		g.fillRect((int) x, (int) y, width, height);
		g2d.setComposite(makeTransparent(1));
	}

	// Transparent effect that takes in alpha value
	private AlphaComposite makeTransparent(float alpha) {
		// Paints the effect over target
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));
	}

	// Hitbox = doesnt exist
	public Rectangle getBounds() {
		return null;
	}
}
