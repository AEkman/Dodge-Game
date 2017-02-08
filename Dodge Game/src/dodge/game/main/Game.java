/*
 * 
 * This is the Main class file where the program is started with "new Game();" in the main method.
 * 
 */

package dodge.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	// Serial number
	private static final long serialVersionUID = 431233066944957784L;

	// Static variables for the window size of the game
	public static final int WIDTH = 1000, HEIGHT = 600;

	// Initializing thread
	private Thread thread;
	// Set the run method to begin as false
	private boolean running = false;

	// Setting standard value of paused to false
	public static boolean paused = false;

	// Initializing objects
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;

	// Setup for different game states
	public enum STATE {
		Menu,
		Help,
		Shop,
		Game,
		End,
	};

	// Starting gamestate "Menu"
	public static STATE gameState = STATE.Menu;

	// Constructor
	public Game() {
		handler = new Handler();
		hud = new HUD();
		shop = new Shop(handler, hud);
		menu = new Menu(this, handler, hud, shop);
		this.addKeyListener(new KeyInput(handler, this));
		// Mouselistener for the menu
		this.addMouseListener(menu);
		// Mouselistener for the shop
		this.addMouseListener(shop);
		
		//Adding the audioplayer
		AudioPlayer.load();
		//Starts the background music and loops the file
		AudioPlayer.getMusic("music").loop();

		// Creating the game window and setting title to "Dodge Game"
		new Window(WIDTH, HEIGHT, "Dodge Game", this);

		// Creating a new spawner for adding enemies
		spawner = new Spawn(handler, hud);

		// Checks if the game is running else go to Menu
		if (gameState == STATE.Game) {
		} else if (gameState == STATE.Menu) {
			// Adding 4 graphical enemies for the menu area
			handler.addObject(new BasicEnemy(0, 100, ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(974, 100, ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(0, 500, ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(974, 500, ID.BasicEnemy, handler));
		}
	}

	// Starting thread "Start Method"
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	// Stopping thread and catches errors if they occur
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Run Method and "Game engine"
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0; // Used in conjunction with frames++ and a sysout further down to display fps
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			// Render Method if thread is running
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames); // Prints fps to console
				frames = 0;
			}
		}
		stop();
	}

	// Update actions
	private void tick() {
		// When game is running
		if (gameState == STATE.Game)
		{
			// When game is running and not paused
			if(!paused){
				hud.tick();
				spawner.tick();
				handler.tick();

				// If players loses all health game ends and clears enemies
				if (HUD.HEALTH <= 0) {
					// Reset player health
					HUD.HEALTH = 100;
					// Ends the game
					gameState = STATE.End;
					// Adding sound for when player dies
					AudioPlayer.getSound("death").play();
					// Clear enemies
					handler.clearEnemys();
				}
			}
		// Adds actions and graphic if game is not in "STATE" game
		} else if (gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Help) {
			menu.tick();
			handler.tick();
		}
	}

	// Graphical engine for the game
	private void render() {
		// Creating a buffer with 3 frames
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		// New graphic class object called "g"
		Graphics g = bs.getDrawGraphics();

		// Background color
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// Gui for when game is "paused"
		if(paused) {
			Font fnt = new Font("arial", 1, 50);
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Game Paused", 330, 210);
		}

		// Draw game state
		if (gameState == STATE.Game) {
			hud.render(g);
			handler.render(g);
		// Draw shop state
		} else if (gameState == STATE.Shop) {
			shop.render(g);
		// Draw menu help and end state
		} else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End) {
			menu.render(g);
			handler.render(g);
		}
		
		// End graphics class
		g.dispose();
		// Show buffered images
		bs.show();
	}


	// Setting boundaries for objects via clamp method
	public static float clamp(float var, float min, float max) {
		if(var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else {
			return var;
		}
	}

	// Main method
	public static void main(String[] args) {
		// Create and start the game
		new Game();
	}
}
