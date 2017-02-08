/*
 * 
 * This is the Shop class where we create everything that you see in the shop menu:
 * "Upgrade Life"
 * "Upgrade Speed"
 * "Refill health"
 * 
 * The class extends MouseAdapter
 */

package dodge.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {

	Handler handler;
	HUD hud;
	
	// Upgrade life initial cost
	private int B1 = 1000;
	// Upgrade speed initial cost
	private int B2 = 1000;
	// Refill life initial cost
	private int B3 = 1000;

	// Constructor
	public Shop (Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	// Drawing graphics
	public void render (Graphics g) {
		// "Store" title
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", 0, 60));
		g.drawString("STORE", Game.WIDTH/2-100, 100);

		// Upgrade Health button
		g.setFont(new Font("arial", 0 , 12));
		g.drawString("Upgrade Health", 310, 220);
		g.drawString("Cost:" + B1 , 310, 240);
		g.drawRect(300, 200, 120, 80);

		// Upgrade Speed button
		g.setFont(new Font("arial", 0 , 12));
		g.drawString("Upgrade Speed", 450, 220);
		g.drawString("Cost:" + B2 , 450, 240);
		g.drawRect(440, 200, 120, 80);

		// Refill Health button
		g.setFont(new Font("arial", 0 , 12));
		g.drawString("Refill Health", 590, 220);
		g.drawString("Cost:" + B3 , 590, 240);
		g.drawRect(580, 200, 120, 80);

		// Show score
		g.setFont(new Font("arial", 0 , 20));
		g.drawString("SCORE: " + hud.getScore(), Game.WIDTH/2 - 58, 320);
		
		// Return to game
		g.drawString("Press space to go resume game!", Game.WIDTH/2 - 140, 450);
	}
	
	/* ******************** *
	 *                      *
	 * Mouse pressed events *
	 *                      *
	 * ******************** */
	public void mousePressed(MouseEvent e) {
		// Getting mouse coordinates
		int mx = e.getX();
		int my = e.getY();

		// Upgrade health action by altering the bounds and health values in hud class
		if(mx >= 300 && mx <= 420) {
			if (my >= 200 && my <= 280) {
				if (hud.getScore() >= B1) {
					hud.setScore(hud.getScore() - B1);
					B1 += 2500;
					hud.bounds += 20;
					hud.HEALTH = (100 + (hud.bounds/2));
				}
			}
		}
		
		// Upgrade speed action by altering the speed value in handler class
		if(mx >= 440 && mx <= 560) {
			if (my >= 200 && my <= 280) {
				if (hud.getScore() >= B2) {
					hud.setScore(hud.getScore() - B2);
					B2 += 2500;
					handler.speed++;
				}
			}
		}
		
		// Refill health action by altering the healthvalue in hud
		if(mx >= 580 && mx <= 700) {
			if (my >= 200 && my <= 280) {
				if (hud.getScore() >= B3) {
					hud.setScore(hud.getScore() - B3);
					B3 += 2500;
					hud.HEALTH = (100 + (hud.bounds/2));
				}
			}
		}
	}

	/* ******************* *
	 *                     *
	 * Getters and setters *
	 *                     *
	 * ******************* */
	// Set health upgrade cost
	public void setB1(int b1) {
		B1 = b1;
	}

	// Set speed upgrade cost
	public void setB2(int b2) {
		B2 = b2;
	}

	// Set refill health upgrade cost
	public void setB3(int b3) {
		B3 = b3;
	}
}
