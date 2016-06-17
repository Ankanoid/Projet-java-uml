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
	String getMessage();
	
	int getHighScore();

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMessage(String key);
	
	void loadHighScore(String key);

	void parseMap();

	void putInTabmap(int i, int j, char car);

	char[][] getTabmap2d();
	
	int getScore();
	
	void setLevel(int level);
	
	int getLevel();
	
	void gameOverM();
	
	void setRotat(int rotat);
	
	void moveH(int x, int y);
	
	void moveM1();
	void moveM2();
	void moveM3();
	void moveM4();
	
	void lastKey(String lastKey);
	
	void setM1alive(int m1alive);
	
	void moveMissile();
	
	void setActiveMissile(int activemissile);
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

}
