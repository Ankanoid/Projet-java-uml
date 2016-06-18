package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 */
public interface IModel {

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	String getMap();
	
	int getHighScore();

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMap(String key);
	
	void loadHighScore(String key);

	void parseMap();

	char[][] getTabmap2d();
	
	int getScore();
	
	void setLevel(int level);
	
	int getLevel();
	
	void moveH();

	String getImageHero();
	String getImageFireBall();
	String getImageDoor();
	
	int getDoorLevel();
	
	void moveM1();
	void moveM2();
	void moveM3();
	void moveM4();
	
	void setLastKey(String lastKey);
	
	void moveMissile();
	
	void setActiveMissile(boolean isActive);
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

}
