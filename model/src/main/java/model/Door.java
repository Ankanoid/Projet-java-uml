package model;

/**
 * The Class Door.
 *
 * @author Group 5
 */

public class Door {

	/**
	 * coordinate x, y
	 * 			Coordinate of the door on the 2d map
	 * 
	 * toLevel 
	 * 			contains the level where the door leads
	 */
	private int x, y, toLevel = 1;
	
	/**
	 * boolean open
	 * 			sets if the door is open or not, false by default
	 */
	private boolean open = false;
	
	/**
	 * Image String
	 * 			Contains the file name of the door image
	 */
	private String Image = "gate_closed";
	
	/**
	 * Instantiate a new Door.
	 * @param x
	 * @param y
	 * @param open
	 * Instantiate a new door with his coordinates x, y and the boolean if she is open or not
	 */
	public Door (int x, int y, boolean open)
	{ 	
		this.x = x;
		this.y = y;
		this.open = open;
	}
	
	/**
	 * Getter of Door Image
	 * @return Image
	 */
	public String getImage() {
		return Image;
	}
	
	/**
	 * Getter of the next level if door is touched
	 * @return toLevel
	 */
	public int getToLevel() {
		return toLevel;
	}
	
	/**
	 * Setter of the next level if door is touched
	 * @param toLevel
	 */
	public void setToLevel(int toLevel) {
		this.toLevel = toLevel;
	}
	
	/**
	 * Getter of the boolean open
	 * @return open
	 */
	public boolean isOpen() {
		return open;
	}

	/** 
	 * Setter of the boolean open
	 * @param open
	*/
	public void setOpen(boolean open) {
		this.open = open;
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
	 * Sets the new toLevel of the door depending on the level
	 * Can be useful if we want to move from one level to the next
	 * Also sets the new Image
	 * 
	 * This function is called when the player touch the energy ball
	 * 
	 * @param level
	 */
	public void SelectPosDoor(int level)
	{
		Image="gate_open"; 
		toLevel = 104;
	}
}
