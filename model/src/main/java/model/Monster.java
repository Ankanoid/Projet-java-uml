package model;

public class Monster {

	private int x, y, move = 0;
	boolean isAlive = false;
	
	public Monster (int x, int y, boolean isAlive)
	{ 	
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
	}

	public boolean getAlive() {
		return isAlive;
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
	
	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
}
