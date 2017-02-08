/*
 * 
 * This is the class for the main Menu of the game that gives us options to:
 * "Play" the game
 * "Help" to get help about the game
 * "Quit" to exit the program.
 * 
 * The class extends MouseAdapter
 */

package dodge.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.plaf.synth.SynthScrollBarUI;

import dodge.game.main.Game.STATE;

public class Menu extends MouseAdapter {

	private Game game;
	private Handler handler;
	private HUD hud;
	private Shop shop;
	private Random r = new Random();

	// Constructor that takes in game, hander, hud and shop class
	public Menu (Game game, Handler handler, HUD hud, Shop shop) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		this.shop = shop;
	}

	/* ******************** *
	 *                      *
	 * Mouse pressed events *
	 *                      *
	 * ******************** */
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		// When in menustate
		if (game.gameState == STATE.Menu) {

			// "Play"-button = starts the game
			if (mouseOver(mx, my, 350, 200, 300, 70)) {
				// Setting  the state of Game
				game.gameState = STATE.Game;
				// Add player
				handler.addObject(new Player(game.WIDTH/2 - 16, game.HEIGHT/2 - 16, ID.Player, handler));
				// Clear all enemies
				handler.clearEnemys();
				// Adding a basic enemie
				handler.addObject(new BasicEnemy(500, 100, ID.BasicEnemy, handler));
				// Adding click sound to button
				AudioPlayer.getSound("sound").play();
			}

			// "Help"-button = gives us help and information about the game
			if (mouseOver(mx, my, 350, 300, 300, 70)) {
				// Setting state of Help
				game.gameState = STATE.Help;

				// Adding click sound to button
				AudioPlayer.getSound("sound").play();
			}

			// "Quit"-button = Terminates the program
			if (mouseOver(mx, my, 350, 470, 300, 70)) {
				System.exit(1);
			}
		}

		// "Back"-button = returns to menu
		if (game.gameState == STATE.Help) {
			if (mouseOver(mx, my, 350, 470, 300, 70)) {
				// Setting state of Menu
				game.gameState = STATE.Menu;
				// Adding click sound to button
				AudioPlayer.getSound("sound").play();
				
				return;
			}
		}

		// "Try Again"-button = restarts the game and resets the level and score
		if (game.gameState == STATE.End) {
			if (mouseOver(mx, my, 350, 470, 300, 70)) {
				// Setting state of Game
				game.gameState = STATE.Game;
				// Setting start level to 1
				hud.setLevel(1);
				// Reset score to 0
				hud.setScore(0);
				// Reset player healthbar
				hud.setBounds(0);
				// Reset player speed
				handler.speed = 5 ;
				// Reset health upgrade cost
				shop.setB1(1000);
				// Reset speed upgrade cost
				shop.setB2(1000);
				// Reset refill health upgrade cost
				shop.setB3(1000);

				// Adding click sound to button
				AudioPlayer.getSound("sound").play();

				// Adding player
				handler.addObject(new Player(game.WIDTH/2 - 16, game.HEIGHT/2 - 16, ID.Player, handler));
				// Clear enemies
				handler.clearEnemys();
				// Adding starting enemy
				handler.addObject(new BasicEnemy(500, 100, ID.BasicEnemy, handler));
			}

			// "Back to menu"-button
			if (mouseOver(mx, my, 350, 370, 300, 70)) {
				game.gameState = STATE.Menu;
				// Adding click sound to button
				AudioPlayer.getSound("sound").play();
			}
		}
	}

	/* ********************* *
	 *                       *
	 * Mouse released events *
	 *                       *
	 * ********************* */
	public void mouseReleased(MouseEvent e) {

	}

	// Checks if mouse is over a designated box method
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else return false;
		} else return false;
	}

	// Actions
	public void tick() {

	}

	// Drawing graphics
	public void render(Graphics g) {
		// Menu graphics
		if (game.gameState == STATE.Menu) {

			Font fnt = new Font("arial", 1, 70);
			Font fnt2 = new Font("arial", 1, 40);

			// "Dodge Game" menu title
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Dodge Game", 280, 120);

			// Play button
			g.setFont(fnt2);
			g.drawRect(350, 200, 300, 70);
			g.drawString("Play", 460, 250);

			// Help button
			g.drawRect(350, 300, 300, 70);
			g.drawString("Help", 460, 350);

			// Quit button
			g.drawRect(350, 470, 300, 70);
			g.drawString("Quit", 460, 520);
			
		// Help menu
		} else if (game.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1, 60);
			Font fnt2 = new Font("arial", 1, 40);
			Font fnt3 = new Font("arial", 1, 25);

			// "Help" Title
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Help", 445, 100);

			// Explanations how to play the game
			g.setFont(fnt3);
			g.drawString("Use arrow-keys to move arround", 250, 200);
			g.drawString("Pres 'P' to pause the game", 250, 230);
			g.drawString("Avoid enemies or they will hunt you down!", 250, 260);
			g.drawString("Don't worry about the trails, they won't hurt you!", 250, 290);

			// Explain normal enemy
			g.setColor(Color.RED);
			g.fillRect(250, 310, 16, 16);
			g.drawString(" - This is a normal enemy", 269, 326);

			// Explain fast enemy
			g.setColor(Color.YELLOW);
			g.fillRect(250, 340, 16, 16);
			g.drawString(" - This is a fast enemy", 269, 356);

			// Explain super fast enemy
			g.setColor(Color.ORANGE);
			g.fillRect(250, 370, 16, 16);
			g.drawString(" - This is a super fast enemy", 269, 386);	

			// Explain smart enemy
			g.setColor(Color.CYAN);
			g.fillRect(250, 400, 16, 16);
			g.drawString(" - This is a smart enemy", 269, 416);

			// Back button
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawRect(350, 470, 300, 70);
			g.drawString("Back", 455, 520);
			
		// Game over
		} else if (game.gameState == STATE.End) {
			Font fnt = new Font("arial", 1, 60);
			Font fnt2 = new Font("arial", 1, 40);
			Font fnt3 = new Font("arial", 1, 25);

			// "Game Over" title
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Game Over", 345, 100);

			// Scores for last game
			g.setFont(fnt3);
			g.drawString("You reached level " + hud.getLevel() + " with a score of " + hud.getScore(), 255, 220);
			g.setColor(Color.RED);
			// Highscore
			g.drawString("Highest Score: " + hud.getHighScore(), 380, 300);
			// Highest Level
			g.drawString("Highest Level: " + hud.getHighestLevel(), 380, 330);

			// Back to menu button
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawRect(350, 370, 300, 70);
			g.drawString("Back to menu", 374, 420);

			// Try again button
			g.setColor(Color.WHITE);
			g.drawRect(350, 470, 300, 70);
			g.drawString("Try again", 415, 520);
		}
	}
}
