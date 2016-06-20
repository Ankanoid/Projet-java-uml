package model;
/**
 * 
 * FireBall Class
 * 
 * @author Group 5
 *
 */
public class FireBall {
	/**
	 * Coordinate x and y of the fireball
	 * Coordinate xToMove and yToMove containing the next move of the fireball
	 * PosGen contains a number between 1 and 5 and represent a sprite of the fireball, used to make it switch between the different sprite
	 */
	private int x, y, xToMove = 0, yToMove = 0, PosGen = 0;
	
	/**
	 * String Image contains the file name of the sprite of the fireball to display
	 * String move contains the move made by the user. Used to determine the first fireball move
	 */
	private String Image, move;

	/**
	 * Boolean isActive used to check if the fireball is on the move
	 * Boolean isFirstLaunch checked when the user press space. Determine if a new ball can be landed or not
	 * 
	 */
	boolean isActive, isFirstLaunch = true;
	
	/**
	 * Instantiate a new Fireball
	 * @param x
	 * 			x coordinate of the fireball
	 * @param y
	 * 			y coordinate of the fireball
	 * @param isActive
	 * 			the ball is active or not
	 * @param isFirstLaunch
	 * 			the ball can be launch or not
	 */
	public FireBall (int x, int y, boolean isActive, boolean isFirstLaunch)
	{ 	
		this.x = x;
		this.y = y;
		this.isActive = isActive;
		this.isFirstLaunch = isFirstLaunch;
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
	 * 		the current position
	 */
	public void setPosGen(int posGen) {
		PosGen = posGen;
	}

	/**
	 * Getter of the image file name
	 * @return Image
	 */
	public String getImage() {
		return Image;
	}

	/**
	 * Getter of isActive, return the state of the fireball, if she is active or not
	 * @return isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Setter of isActive, used to change the fireball state
	 * @param isActive
	 * 			the ball is active or not
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	 * Getter of xToMove, gets the next x move of the fireball
	 * @return xToMove
	 */
	public int getxToMove() {
		return xToMove;
	}

	/**
	 * Setter of xToMove, set the next x move of the fireball
	 * @param xToMove
	 * 			x coordinate for the next ball move
	 */
	public void setxToMove(int xToMove) {
		this.xToMove = xToMove;
	}

	/**
	 * Getter of yToMove, gets the next y move of the fireball
	 * @return yToMove
	 * 			y coordinate for the next ball move
	 */
	public int getyToMove() {
		return yToMove;
	}

	/**
	 * Setter of yToMove, set the next y move of the fireball
	 * @param yToMove
	 * 			y coordinate for the next ball move
	 */
	public void setyToMove(int yToMove) {
		this.yToMove = yToMove;
	}

	/**
	 * Setter of move, set the move performed by the hero, this one used to determines the first move of the fireball
	 * @param move
	 * 			the ball will move at this refresh or not
	 */
	public void setMove(String move) {
		this.move = move;
	}

	/**
	 * Getter of isFirstLaunch, gets the boolean to know if the fireball can be landed or not
	 * @return isFirstLaunch
	 */
	public boolean isFirstLaunch() {
		return isFirstLaunch;
	}

	/**
	 * Setter of isFirstLaunch, sets the state if the fireball can be landed or not
	 * @param isFirstLaunch
	 * 			it's the first launch of the ball or not
	 */
	public void setFirstLaunch(boolean isFirstLaunch) {
		this.isFirstLaunch = isFirstLaunch;
	}
	
	/**
	 * Sets yToMove (y coordinate the fireball will be moved) and xToMove (x coordinate the fireball will be moved) depending on the move String previously settled.
	 */
	public void SelectMoveFireBall()
	{
		if(move == "LEFT")
			{ yToMove = 0; xToMove = -1; }
		
		if(move == "RIGHT")
			{ yToMove = 0; xToMove = 1; }
		
		if(move == "UP")
			{ yToMove = -1; xToMove = 0; }
		
		if(move == "DOWN")
			{ yToMove = 1; xToMove = 0; }
		
		if(move == "LEFTUP")
			{ yToMove = -1; xToMove = -1; }
			
		if(move == "RIGHTUP")
			{ yToMove = -1; xToMove = 1; }
			
		if(move == "LEFTDOWN")
			{ yToMove = 1; xToMove = -1; }
			
		if(move == "RIGHTDOWN")
			{ yToMove = 1; xToMove = 1; }
			
		else
		{}
	}
	
	/**
	 * Background function which switch PosGen between 1, 2, 3, 4 and 5, and set a new Image each time. Function which allows to make the fireball switch between the sprites
	 */
	public void SelectPosGenFireBall()
	{
		if(PosGen == 1)
			Image="fireball_2";
		
		if(PosGen == 2)
			Image="fireball_3";
		
		if(PosGen == 3)
			Image="fireball_5";
		
		if(PosGen == 4)
			Image="fireball_4";
		
		if(PosGen == 5)
			{ Image="fireball_1"; PosGen = 0; }
	}
	
	/**
	 * When Space is pressed when the fireball is already on the land, this function is called and determine the new coordinate to move the fireball to the Hero
	 * @param HeroY
	 * 			y coordinate of the hero
	 * @param HeroX
	 * 			x coordinate of the hero
	 */
	public void toHero(int HeroY, int HeroX)
	{
		if(HeroY < y && HeroX > x)
		{ yToMove = -1; xToMove = 1; }
		
		if(HeroY > y && HeroX < x)
		{ yToMove = 1; xToMove = -1; }
		
		if(HeroY < y && HeroX < x)
		{ yToMove = -1; xToMove = -1; }
		
		if(HeroY > y && HeroX > x)
		{ yToMove = 1; xToMove = 1; }
		
		/*if(HeroY > y && HeroX == x)
		{ yToMove = 1; xToMove = 0; }
		
		if(HeroY < y && HeroX == x)
		{ yToMove = -1; xToMove = 0; }
		
		if(HeroY == y && HeroX < x)
		{ yToMove = 0; xToMove = -1; }
		
		if(HeroY == y && HeroX > x)
		{ yToMove = 0; xToMove = 1; }*/
	}

}
