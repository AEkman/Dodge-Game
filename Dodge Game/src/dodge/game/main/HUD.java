/*
 * 
 * This is the "Heads Up Display" class where we create everything that has to do with HUD items and displaying them on screen.
 * 
 */

package dodge.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class HUD {
	// Extends health gui bar when health is upgraded via shop class
	public int bounds = 0; 

	// Starting health for player
	public static float HEALTH = 100; 

	// Greenvalue for the hud. When player takes damage the green value is lowered
	private int greenValue = 255;
	// Starting score
	private int score = 0; 
	//Starting highscore
	private int highScore = 0;
	// Starting level
	private int level = 1;
	// Keeps track of highest level
	private int highestLevel = 1;
	// Timer for the new record to be shown
	private int highScoreTimer = 1200;

	// Saving
	private String saveDataPath;
	private String fileName = "highscore.dat";

	public HUD () {
		try {
			// Setting save data path
			saveDataPath = HUD.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// Loading highscore from file
		loadHighScore();
	}

	// Check if there is savedata file, if not create new file
	public void createSaveData() {
		try {
			File file = new File(saveDataPath, fileName);

			FileWriter output = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write("" + 0);
			writer.newLine();
			writer.write("" + 0);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Load highscore method
	public void loadHighScore() {
		try {
			File f = new File(saveDataPath, fileName);
			if (!f.isFile()) {
				createSaveData();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				highScore = Integer.parseInt(reader.readLine());
				highestLevel = Integer.parseInt(reader.readLine());
				reader.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Saving new highscore to file method
	public void setHighScore() {
		FileWriter output = null;
		try {
			File f = new File(saveDataPath, fileName);
			output = new FileWriter(f);
			BufferedWriter writer = new BufferedWriter(output);

			writer.write("" + highScore);
			writer.newLine();
			writer.write("" + highestLevel);
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Actions
	public void tick() {
		// Updates healthbar
		HEALTH = (int) Game.clamp(HEALTH, 0, 100 + bounds/2);

		// Fades the life bar to red when loosing health
		greenValue = (int) (HEALTH * 2);
		// Makes sure the bar is inside the cointainer
		greenValue = (int) Game.clamp(greenValue, 0, 255);

		// Adding score to game
		score++;

		// Check if score is a new highscore
		if (score >= highScore) {
			highScore = score;
			setHighScore();
		}

		// Check if level is record level
		if (level >= highestLevel) {
			highestLevel = level;
			setHighScore();
		}
	}

	// Drawing graphics
	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 15);
		g.setFont(fnt);

		// Health bar
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(((Game.WIDTH - (bounds)) /2) - (int)HEALTH, 10, (int) HEALTH * 2 + bounds, 10);
		g.setColor(Color.WHITE);
		g.drawRect((Game.WIDTH - 200 - (bounds*2)) /2, 10, 200 + (bounds*2), 10);

		// HUD information
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score, 10, 20);
		g.drawString("Level: " + level, 10, 40);
		g.drawString("Space to enter Shop", 10, 60);

		// Draw wavenumber
		if (getLevel() != 0) {
			g.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			g.drawString("-  W A V E  " + getLevel() + "  -", 438, 40);
			}

		// New highest score
		if (score >= highScore) {
			if (highScoreTimer <= 0) {
			} else {
				g.drawString("New Point Highscore!", 408, 65);				
				highScoreTimer--;
			}
		}

		// New level record
		if (level >= highestLevel) {
			if (highScoreTimer <= 0) {
			} else {
				g.drawString("New Level Highscore!", 407, 90);				
				highScoreTimer--;
			}
		}
	}


	/* ******************* *
	 *                     *
	 * Getters and setters *
	 *                     *
	 * ******************* */
	// Set score
	public void setScore (int score) {
		this.score = score;
	}

	// Get score
	public int getScore() {
		return score;
	}

	// Get highscore
	public int getHighScore() {
		return highScore;
	}

	// Get highest level achieved
	public int getHighestLevel() {
		return highestLevel;
	}

	// Get level
	public int getLevel() {
		return level;
	}

	// Set level
	public void setLevel(int level) {
		this.level = level;
	}

	// Get bounds
	public int getBounds() {
		return bounds;
	}

	// Set bounds
	public void setBounds(int bounds) {
		this.bounds = bounds;
	}
}
