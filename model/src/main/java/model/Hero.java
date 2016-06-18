package model;

public class Hero {

	private int x, y, yToMove = 0, xToMove = 0, PosGen = 0;
	private String move, Image;
	private char position;
	private boolean isAlive = true;

	public Hero (int x, int y, boolean isAlive)
	{ 	
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
	}
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getX() {
		return x;
	}
	
	public int getPosGen() {
		return PosGen;
	}

	public void setPosGen(int posGen) {
		PosGen = posGen;
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
	

	public char getPosition() {
		return position;
	}

	public void setPosition(char position) {
		this.position = position;
	}

	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}
	
	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

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
			
		else
		{}
	}
	
	public void SelectPosGenHero()
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
