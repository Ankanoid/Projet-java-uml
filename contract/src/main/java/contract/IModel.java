package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 * 
 * @author Group 5
 */
public interface IModel {

	void setNewKey(boolean newKey);

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	String getMap();
	
	/**
	 * Gets highscores.
	 * 
	 *@return highscore
	 */
	
	int getHighScore();

	/**
	 * Load the map.
	 *
	 * @param key
	 *          the key
	 */
	void loadMap(String key);
	
	/**
	 * Load the highscore.
	 *
	 * @param key
	 *          the key
	 */
	void loadHighScore(String key);

	/**
	 * Parse the map.
	 *
	 */
	void parseMap();
	
	/**
	 * Gets the final map in an 2d tab.
	 *
	 * @return highscore
	 *         
	 */
	char[][] getTabmap2d();
	
	/**
	 * Gets the current score stored in Infos Class.
	 *
	 * @return score
	 *         
	 */
	int getScore();
	
	/**
	 * Gets the current global score stored in Infos Class.
	 *
	 * @return globalscore
	 *         
	 */
	int getGlobalScore();
	
	/**
	 * Sets a new Global Score
	 *
	 * @param globalscore
	 *          the updated globalscore (generally increased by 100 points)
	 */
	void setGlobalScore(int globalscore);
	
	/**
	 * Gets the current remaining life points stored in Infos Class.
	 *
	 * @return score
	 *         
	 */
	int getLife();
	
	/**
	 * Sets a new amount of life points (generally just decreased by one).
	 *
	 * @param life
	 *          the life points
	 */
	void setLife(int life);
	
	/**
	 * Launch the game over function.
	 *    
	 */
	void gameOver();
	
	/**
	 * Sets the new Level
	 *
	 * @param level
	 *          the level
	 */
	void setLevel(int level);
	
	/**
	 * Gets the current level
	 *
	 * @return level
	 *          the level
	 */
	int getLevel();

	/**
	 * Load the Hero Image Path stored in a String.
	 *
	 * @return HeroImage
	 *          the hero image path 
	 */
	String getImageHero();
	
	/**
	 * Load the Fireball Image Path stored in a String.
	 *
	 * @return FireBallImage
	 *          the fireball image path 
	 */
	String getImageFireBall();
	
	/**
	 * Load the Door Image Path stored in a String.
	 *
	 * @return DoorImage
	 *          the door image path 
	 */
	String getImageDoor();
	
	/**
	 * Return the next level (if door is passed by the player)
	 *
	 * @return level
	 *          the next level 
	 */
	int getDoorLevel();
	
	/**
	 * Launch the move function for the hero
	 *
	 * Set the new Hero position and the new Hero State
	 */
	void moveHero();
	
	/**
	 * Launch the move function for the first monster
	 *
	 * Set the new monster position
	 */
	void moveM1();
	
	/**
	 * Launch the move function for the second monster
	 *
	 * Set the new monster position
	 */
	void moveM2();
	
	/**
	 * Launch the move function for the third monster
	 *
	 * Set the new monster position
	 */
	void moveM3();
	
	/**
	 * Launch the move function for the fourth monster
	 *
	 * Set the new monster position
	 */
	void moveM4();
	
	/**
	 * Set a string depending on the last key pressed by the user
	 *
	 * @param lastKey
	 *          the last key pressed (use this function in the controller)
	 */
	void setLastKey(String lastKey);
	
	/**
	 * Launch the move function for the fireball
	 *
	 * Set the new fireball position
	 */
	void moveFireBall();
	
	/**
	 * Sets on the fireball by changing the boolean isActive
	 *
	 * @param boolean isActive
	 *          the boolean which will indicate to moveFireBall function that the fireball is appeared and will move
	 */
	void setActiveFireBall(boolean isActive);
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

}
