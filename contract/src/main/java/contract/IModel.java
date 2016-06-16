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

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMessage(String key);

	void doTheThing();

	void putInTabmap(int i, int j, char car);

	char[][] getTabmap2d();
	
	int getPositionHeroX();
	
	void setPositionHeroX(int positionHeroX);
	
	int getPositionHeroY();
	
	void setPositionHeroY(int positionHeroY);
	
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();


	void moveG(int x, int y);
}
