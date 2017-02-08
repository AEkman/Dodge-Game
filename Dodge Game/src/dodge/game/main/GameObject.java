/*
 * 
 * Abstract class for creating game objects. All in-game object are created from this class.
 * 
 */

package dodge.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;

// All in-game object are created from this class
public abstract class GameObject {

	// Instance variables
	protected ID id;
	protected float x, y;
	protected float velX, velY;

	// Constructor
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	/* ***************** *
	 *                   *
	 * Abstract methods  *
	 *                   *
	 * ***************** */
	// Method for updating actions
	public abstract void tick();
	// Method to draw graphics
	public abstract void render(Graphics g);
	// Using rectangles to handle collision
	public abstract Rectangle getBounds(); 

	
	/* ******************* *
	 *                     *
	 * Getters and setters *
	 *                     *
	 * ******************* */
	// Get X position
	public float getX() {
		return x;
	}

	// Set X position
	public void setX(float x) {
		this.x = x;
	}

	// Get Y position
	public float getY() {
		return y;
	}

	// Set Y position
	public void setY(float y) {
		this.y = y;
	}

	// Get ID
	public ID getId() {
		return id;
	}
	
	// Set ID
	public void setId(ID id) {
		this.id = id;
	}
	
	// Get X speed
	public float getVelX() {
		return velX;
	}

	// Set X speed
	public void setVelX(float velX) {
		this.velX = velX;
	}

	// Get Y speed
	public float getVelY() {
		return velY;
	}

	// Set Y speed
	public void setVelY(float velY) {
		this.velY = velY;
	}
}
