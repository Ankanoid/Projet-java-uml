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
	
    void saveHighScore(final int score, final String key);

	void doTheThing();

	void putInTabmap(int i, int j, char car);

	char[][] getTabmap2d();
	
	void setScore(int score);
	
	int getScore();
	
	void setLevel(int level);
	
	int getLevel();
	
	public int getPositionMonster1X();

	public void setPositionMonster1X(int positionMonster1X);

	public int getPositionMonster1Y();

	public void setPositionMonster1Y(int positionMonster1Y);
	
	void gameOverM();
	
	void moveH(int x, int y);
	
	void moveM1();
	
	void setRotat(int rotat);
	void moveMissile();
	
	int getActiveMissile();
	
	void setActiveMissile(int activemissile);
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

}
