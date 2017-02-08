/*
 * 
 * This class handles ID for all game objects. This is a enumeration class and can be called throughout the program.
 * 
 */

package dodge.game.main;

// Settings ID for all entities so we can differentiate enemies from player etc.
public enum ID {
	// Players id
	Player(),
	// Basic enemy id
	BasicEnemy(),
	// Fast enemy id
	FastEnemy(),
	// Superafst enemy id
	SuperFastEnemy(),
	// Smart enemy id
	SmartEnemy(),
	// Boss id
	EnemyBoss(),
	// Trail effect id
	Trail();
}
