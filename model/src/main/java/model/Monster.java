package model;

/**
 * The Class Monster.
 * 
 * @author Group 5
 *
 */
public class Monster {

	/**
	 * int x and y, coordinate of the monster
	 * int move = speed of the monster, if move = 1 (in Model.java), the monster will move every refresh. Move is incremented every refresh
	 */
	private int x, y, move = 0;
	
	/**
	 * boolean isAlive contains the state of the monster, true if alive, false if dead
	 */
	private boolean isAlive = false;
	
	/**
	 * Instantiate a new monster
	 * @param x
	 * 			x coordinate of the monster
	 * @param y
	 * 			y coordinate of the monster
	 * @param isAlive
	 * 			boolean containing the state of the monster, true if alive, false if dead
	 */
	public Monster (int x, int y, boolean isAlive)
	{ 	
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
	}

	/**
	 * Getter of isAlive, gets if the monster is alive or not
	 * @return isAlive
	 */
	public boolean getAlive() {
		return isAlive;
	}
	
	/**
	 * Setter of isAlive, sets if the monster is alive or not
	 * @param isAlive
	 * 				monster is alive or not
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Getter of move, gets if the monster can move or not 
	 * @return move
	 */
	public int getMove() {
		return move;
	}

	/**
	 * Setter of move, incremented each refresh
	 * @param move
	 * 			incremented variable which define if the monster will move at this refresh or not
	 */
	public void setMove(int move) {
		this.move = move;
	}
}
