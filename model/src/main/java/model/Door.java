package model;

public class Door {

	private int x, y, toLevel = 1;
	private boolean open = false;
	private String Image = "gate_closed";

	public Door (int x, int y, boolean open)
	{ 	
		this.x = x;
		this.y = y;
		this.open = open;
	}
	
	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public int getToLevel() {
		return toLevel;
	}

	public void setToLevel(int toLevel) {
		this.toLevel = toLevel;
	}

	public boolean isOpen() {
		return open;
	}

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
	
	public void SelectPosDoor(int level)
	{
			if(level >=1 && level <= 4)
			{
				Image="gate_open"; 
				toLevel = 9; 
			}
			
			if(level == 5)
			{
				Image="gate_open"; 
				toLevel = 7; 
			}
			
			else {}
	}
}
