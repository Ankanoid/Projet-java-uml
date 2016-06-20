package model;

/**
 * The Class Hero.
 * 
 * @author Group 5
 *
 */
public class Hero {

	/**
	 * int x and y are the coordinate of the hero
	 * int yToMove and xToMove represent the coordinate of the next move
	 * int Posgen switch between numbers from 1 to 8 and determine the next sprite to display for the hero
	 */
	private int x, y, yToMove = 0, xToMove = 0, PosGen = 0;
	
	/**
	 * String Image contains the file name of the next sprite of the hero
	 * String move contains the move made by the user. Used to determine the next sprite of the hero 
	 */
	private String move, Image;
	/**
	 * boolean isAlive settled at true if the hero is alive, and false if he is not
	 */
	private boolean isAlive = true;

	/**
	 * Instantiate a new hero
	 * @param x
	 * 			x coordinate
	 * @param y
	 * 			y coordinate
	 * @param isAlive
	 *			boolean if he is dead (false) or alive (true)
	 */
	public Hero (int x, int y, boolean isAlive)
	{ 	
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
	}
	
	/**
	 * Getter of isAlive, gets the state of the hero (true if alive, false if dead)
	 * @return isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * Sets the next hero state (true if alive, false if dead)
	 * @param isAlive
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	/**
	 * Getter of PosGen
	 * @return PosGen
	 */
	public int getPosGen() {
		return PosGen;
	}

	/**
	 * Setter of PosGen
	 * @param posGen
	 */
	public void setPosGen(int posGen) {
		PosGen = posGen;
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
	 * Setter of move, depending on the last key pressed by the user
	 * @param move
	 */
	public void setMove(String move) {
		this.move = move;
	}
	
	/**
	 * Getter of Image, to know which sprite the view has to display
	 * @return String Image
	 */
	public String getImage() {
		return Image;
	}

	/**
	 * Function called when a key is pressed by the user, set a sprite depending on this key, also set the next move
	 */
	public void SelectPosHero()
	{
		if(move == "LEFT")
			{ Image="lorann_l"; yToMove = 0; xToMove = -1; }
		
		if(move == "RIGHT")
			{ Image="lorann_r"; yToMove = 0; xToMove = 1; }
		
		if(move == "UP")
			{ Image="lorann_u"; yToMove = -1; xToMove = 0; }
		
		if(move == "DOWN")
			{ Image="lorann_b"; yToMove = 1; xToMove = 0; }
		
		if(move == "LEFTUP")
			{ Image="lorann_ul"; yToMove = -1; xToMove = -1; }
			
		if(move == "RIGHTUP")
			{ Image="lorann_ur"; yToMove = -1; xToMove = 1; }
			
		if(move == "LEFTDOWN")
			{ Image="lorann_bl";; yToMove = 1; xToMove = -1; }
			
		if(move == "RIGHTDOWN")
			{ Image="lorann_br"; yToMove = 1; xToMove = 1; }
		
		if(move == "NOPE")
		{ yToMove = 0; xToMove = 0; }
			
		else
		{}
	}
	
	/**
	 * Function in background, which is automatically changed. Define a new sprite to display and make the hero turn on himself when there is no move
	 * @param level
	 */
	public void SelectPosGenHero(int level)
	{
		if(PosGen == 1)
			Image="lorann_u";
		
		if(PosGen == 2)
			Image="lorann_ur";
		
		if(PosGen == 3)
			Image="lorann_r";
		
		if(PosGen == 4)
			Image="lorann_br";
		
		if(PosGen == 5)
			Image="lorann_b";
			
		if(PosGen == 6)
			Image="lorann_bl";
			
		if(PosGen == 7)
			Image="lorann_l";
			
		if(PosGen == 8)
			{ Image="lorann_ul"; PosGen = 0; } 
		
		if(level == 102 || level == 103) // No display of the hero on the Win Screen and on the Loose Screen
			Image="no_image";
	}

	public int getyToMove() {
		return yToMove;
	}

	public void setyToMove(int yToMove) {
		this.yToMove = yToMove;
	}

	public int getxToMove() {
		return xToMove;
	}

	public void setxToMove(int xToMove) {
		this.xToMove = xToMove;
	}
}
