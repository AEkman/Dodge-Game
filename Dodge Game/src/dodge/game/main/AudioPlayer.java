/*
 * 
 * This is AudioPlayer class. It creates an audioplayer and imports the sound for the game. It's initialized by the .load method.
 * 
 */

package dodge.game.main;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {

	// Creating hashmaps for storing sounds and music
	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();

	// Load method for initialize the audio files below throughout the project
	public static void load() {

		try {
			// Sound or buttons
			soundMap.put("sound", new Sound("/res/button.wav"));
			// Sound for when player is getting hit
			soundMap.put("grunt", new Sound("/res/grunt.wav"));
			// Sound for when player gets killed
			soundMap.put("death", new Sound("/res/death.wav"));
			// Background music for the game
			musicMap.put("music", new Music("/res/loop.wav"));
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	// Getters and setters
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}

	public static Sound getSound(String key) {
		return soundMap.get(key);
	}
}
