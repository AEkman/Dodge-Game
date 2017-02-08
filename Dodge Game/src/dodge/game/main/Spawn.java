/*
 * 
 * In the spawner class we handle all the level progress and how enemies are added to the game via a level system.
 * 
 */

package dodge.game.main;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private Random r = new Random();

	// Tracking the score
	private int scoreKeep = 0;

	public Spawn (Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	// Actions
	public void tick() {
		// Progressing scorekeep
		scoreKeep++;
		
		// When score reaches 700
		if (scoreKeep >= 700) {
			// Reset scorekeep
			scoreKeep = 0;
			// Progress level
			hud.setLevel(hud.getLevel() + 1);

			// Check level and add enemies accordingly
			if (hud.getLevel() == 2) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}  else if (hud.getLevel() == 4) {
				handler.clearEnemys();
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			} else if (hud.getLevel() == 5) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			} else if (hud.getLevel() == 6) {
				handler.clearEnemys();
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			} else if (hud.getLevel() == 7) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			} else if (hud.getLevel() == 8) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			} else if (hud.getLevel() == 9) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			} else if (hud.getLevel() == 10) {
				handler.clearEnemys();
				handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 60, -120, ID.EnemyBoss, handler));
			} else if (hud.getLevel() == 13) {
				handler.clearEnemys();
				handler.addObject(new FastEnemy(50, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(100, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(150, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(200, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(250, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(300, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(350, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(400, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(450, 10, ID.FastEnemy, handler));
			} else if (hud.getLevel() == 14) {
				handler.clearEnemys();
				handler.addObject(new SuperFastEnemy(20, 100, ID.SuperFastEnemy, handler));
				handler.addObject(new SuperFastEnemy(20, 200, ID.SuperFastEnemy, handler));
			} else if (hud.getLevel() == 15) {
				handler.addObject(new SuperFastEnemy(20, 100, ID.SuperFastEnemy, handler));
				handler.addObject(new SuperFastEnemy(20, 200, ID.SuperFastEnemy, handler));
			} else if (hud.getLevel() == 16) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -484), r.nextInt(Game.HEIGHT -236), ID.SmartEnemy, handler));
			} else if (hud.getLevel() == 17) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 18) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 20) {
				handler.clearEnemys();
				handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 60, -120, ID.EnemyBoss, handler));
				handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 60, -200, ID.EnemyBoss, handler));
			} else if (hud.getLevel() == 23) {
				handler.clearEnemys();
				handler.addObject(new FastEnemy(50, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(100, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(150, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(200, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(300, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(350, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(400, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(450, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(500, 10, ID.FastEnemy, handler));
			} else if (hud.getLevel() == 26) {
				handler.clearEnemys();
				handler.addObject(new FastEnemy(50, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(100, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(150, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(850, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(900, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(950, 10, ID.FastEnemy, handler));
				handler.addObject(new SmartEnemy(0, 0, ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(984, 0, ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(0, 560, ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(984, 560, ID.SmartEnemy, handler));
			} else if (hud.getLevel() == 28) {
				handler.clearEnemys();
				handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 60, -120, ID.EnemyBoss, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 30) {
				handler.clearEnemys();
				handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 60, -120, ID.EnemyBoss, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			} else if (hud.getLevel() == 33) {
				handler.addObject(new SuperFastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SuperFastEnemy, handler));
				handler.addObject(new SuperFastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SuperFastEnemy, handler));
			} else if (hud.getLevel() == 34) {
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(0, 100, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(974, 100, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(0, 500, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(974, 500, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(0, 200, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(974, 200, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(0, 400, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(974, 400, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(0, 300, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(974, 300, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(0, 300, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(974, 300, ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 36) {
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(10, 20, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 80, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 140, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 200, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 260, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 320, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 380, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 420, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 480, ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 37) {
				handler.addObject(new BasicEnemy(10, 20, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 80, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 140, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 200, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 260, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 320, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 380, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 420, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 480, ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 38) {
				handler.addObject(new BasicEnemy(10, 20, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 80, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 140, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 200, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 260, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 320, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 380, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 420, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 480, ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 40) {
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(10, 20, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 80, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 140, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 200, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 260, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 20, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 80, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 140, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 200, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 260, ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 41) {
				handler.addObject(new BasicEnemy(10, 20, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 80, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 140, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 200, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 260, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 20, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 80, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 140, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 200, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 260, ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 42) {
				handler.addObject(new BasicEnemy(10, 20, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 80, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 140, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 200, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(10, 260, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 20, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 80, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 140, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 200, ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(884, 260, ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 45) {
				handler.clearEnemys();
				handler.addObject(new FastEnemy(50, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(100, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(150, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(850, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(900, 10, ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(950, 10, ID.FastEnemy, handler));
				handler.addObject(new SmartEnemy(0, 0, ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(984, 0, ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(0, 560, ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(984, 560, ID.SmartEnemy, handler));
			}
		}
	}
}
