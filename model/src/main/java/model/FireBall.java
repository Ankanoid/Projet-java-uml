package model;

public class FireBall {

	private int x, y, xToMove = 0, yToMove = 0, canMove = 0, PosGen = 0;
	private String Image, move;

	boolean isActive, isFirstLaunch = true;

	public FireBall (int x, int y, boolean isActive)
	{ 	
		this.x = x;
		this.y = y;
		this.isActive = isActive;
	}

	public int getPosGen() {
		return PosGen;
	}

	public void setPosGen(int posGen) {
		PosGen = posGen;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public int getCanMove() {
		return canMove;
	}

	public void setCanMove(int canMove) {
		this.canMove = canMove;
	}

	public boolean isActive() {
		return isActive;
	}

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
	
	public int getxToMove() {
		return xToMove;
	}

	public void setxToMove(int xToMove) {
		this.xToMove = xToMove;
	}

	public int getyToMove() {
		return yToMove;
	}

	public void setyToMove(int yToMove) {
		this.yToMove = yToMove;
	}
	
	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}

	public boolean isFirstLaunch() {
		return isFirstLaunch;
	}

	public void setFirstLaunch(boolean isFirstLaunch) {
		this.isFirstLaunch = isFirstLaunch;
	}
	
	public void SelectMoveFireBall()
	
	{
		if(this.move == "RIGHT" || this.move == "RIGHTUP" || this.move == "RIGHTDOWN")
		{
			xToMove = 1;
			yToMove = 0;
		}
		
		if(move == "LEFT" || this.move == "LEFTUP" || this.move == "LEFTDOWN")
		{
			xToMove = -1;
			yToMove = 0;
		}
		
		if(move == "UP")
		{
			xToMove = 0;
			yToMove = -1;
		}
		
		if(move == "DOWN")
		{
			xToMove = 0;
			yToMove = 1;
		}
	}
	
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

}
