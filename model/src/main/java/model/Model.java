package model;

import java.sql.SQLException;

import java.util.Observable;
import java.util.Random;

import contract.IModel;


/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	private Hero hero;
	private Monster monster1;
	private Monster monster2;
	private Monster monster3;
	private Monster monster4;
	private FireBall fireball;
	private Door door;

	public int getScore()
	{
		return Infos.getScore();
	}
	
	public String getImageHero()
	{
		return this.hero.getImage();
	}
	
	public String getImageFireBall()
	{
		return this.fireball.getImage();
	}
	
	public String getImageDoor()
	{
		return this.door.getImage();
	}
	
	public void setScore(int score)
	{
		Infos.setScore(score);
	}
	
	public int getLevel()
	{
		return Infos.getLevel();
	}
	
	public void setLevel(int level)
	{
		Infos.setLevel(level);
	}
	
	public int getDoorLevel()
	{
		return this.door.getToLevel();
	}
	
	public String lastKey;
	
	public boolean isNewKey = false;

	public String getLastKey() {
		return lastKey;
	}
	
	private int height = 12;
	private int width = 21;

	public int getHeight(){
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public char[][] tabmap2d = new char[this.getHeight()][this.getWidth()];

	/** The message. */
	private String map;
	
	private int highscore;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.hero = new Hero(0,0, false);
		this.monster1 = new Monster(0,0,false);
		this.monster2 = new Monster(0,0,false);
		this.monster3 = new Monster(0,0,false);
		this.monster4 = new Monster(0,0,false);
		this.fireball = new FireBall(0,0,false);
		this.door = new Door(0,0, false);
		this.map = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */

	public void getMapInChar() {

	}

	public String getMap() {
		return this.map;

	}
	
	public int getHighScore() {
		return this.highscore;

	}

	public void putInTabmap(int i, int j, char car) {
		this.tabmap2d[i][j] = car;
	}

	public void parseMap() {
		
		this.monster1 = new Monster(0,0,false);
		this.monster2 = new Monster(0,0,false);
		this.monster3 = new Monster(0,0,false);
		this.monster4 = new Monster(0,0,false);
		this.hero = new Hero(0,1,false);
		this.door = new Door (0,0, false);
		
		this.fireball.setFirstLaunch(true);
		this.setScore(0);
		this.fireball.setActive(false);
		
		String[] tabmap = this.map.split("\n") ;
		
		for(int i = 0; i<tabmap.length; i++)
		{
			for (int j =0; j<tabmap[i].length();j++)
			{
				switch (tabmap[i].charAt(j)) {
					case '0':
						this.putInTabmap(i,j,'0');
						break;
					case '1':
						this.putInTabmap(i,j,'1');
						break;
					case '2':
						this.putInTabmap(i,j,'2');
						break;
					case '3':
						this.putInTabmap(i,j,'3');
						break;
					case '6':
						this.putInTabmap(i,j,'6');
						this.monster1.setAlive(true);
						this.monster1.setMove(0);
						this.monster1.setY(i);
						this.monster1.setX(j);
						break;
					case '7':
						this.putInTabmap(i,j,'7');
						this.monster2.setAlive(true);
						this.monster2.setMove(0);
						this.monster2.setY(i);
						this.monster2.setX(j);
						break;
					case '8':
						this.putInTabmap(i,j,'8');
						this.monster4.setAlive(true);
						this.monster3.setMove(0);
						this.monster3.setY(i);
						this.monster3.setX(j);
						break;
					case '9':
						this.putInTabmap(i,j,'9');
						this.monster4.setAlive(true);
						this.monster4.setMove(0);
						this.monster4.setY(i);
						this.monster4.setX(j);
						break;
					case 'C':
						this.putInTabmap(i,j,'C');
						break;
					case 'E':
						this.putInTabmap(i,j,'E');
						break;
					case 'P':
						this.putInTabmap(i,j,'P');
						this.hero.setAlive(true);
						this.hero.setY(i);
						this.hero.setX(j);
						break;
					case 'S':
						this.putInTabmap(i,j,'S');
						this.door.setOpen(false);
						this.door.setY(i);
						this.door.setX(j);
						break;
					case 'A':
						this.putInTabmap(i,j,'A');
						break;
					case 'Z':
						this.putInTabmap(i,j,'Z');
						break;
					case 'G':
						this.putInTabmap(i,j,'G');
						break;
					default :
						this.putInTabmap(i,j,' ');
						break;
				}
			}
		}
	}
	
	public char[][] getTabmap2d() {
		return this.tabmap2d;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMap(final String map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}
	
	private void setHighScore(final int highscore) {
		this.highscore = highscore;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMap(final String key) {
		try {
			final DAOMap map = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMap(map.find(key).getMap());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void loadHighScore(final String key) {
		try {
			final DAOHighScore daoHighScore = new DAOHighScore(DBConnection.getInstance().getConnection());
			this.setHighScore(daoHighScore.find(key).getHighScore());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void saveHighScore(final int score, final String key) {
		try {
			final DAOHighScore daoHighScore = new DAOHighScore(DBConnection.getInstance().getConnection());
			daoHighScore.find(score,key);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	public void setLastKey(String lastKey) {
		this.lastKey = lastKey;
		this.isNewKey = true;
		this.hero.setMove(this.lastKey);
		this.hero.SelectPosHero();
		if(this.fireball.isFirstLaunch()==true)
		{
			this.fireball.setMove(this.lastKey);
			this.fireball.SelectMoveFireBall();
		}
	}
	

	public void setActiveMissile(boolean isActive) {
		if(this.fireball.isFirstLaunch()==true)
		this.fireball.setActive(isActive);
	}
	
	private boolean bourse = false;
	
	public void moveH() {
		this.hero.setPosGen(this.hero.getPosGen()+1);
		this.hero.SelectPosGenHero();
		if(isMovePossible() == true && this.isNewKey == true && this.hero.isAlive() == true)
		{
			this.hero.SelectPosHero();
			tabmap2d[this.hero.getY()][this.hero.getX()]='P';
			tabmap2d[this.hero.getY()-this.hero.getyToMove()][this.hero.getX()-this.hero.getxToMove()]='0';
			this.hero.setxToMove(0);
			this.hero.setyToMove(0);
			this.isNewKey = false;
		}
		
		if(isMovePossible() == false && this.hero.isAlive() == true)
		{
			tabmap2d[this.hero.getY()][this.hero.getX()]='P';
		}
		
		else {}
	}
	

	public boolean isMovePossible()
	{
		this.hero.setX(this.hero.getX()+this.hero.getxToMove());
		this.hero.setY(this.hero.getY()+this.hero.getyToMove());
		
		if(tabmap2d[this.hero.getY()][this.hero.getX()] == '0')
			return true;
		
		if(tabmap2d[this.hero.getY()][this.hero.getX()] == 'A')
		{
			if(this.door.getToLevel()>2)
			{
				this.door.setToLevel(this.door.getToLevel()-1); 
				this.hero.setX(this.hero.getX()-this.hero.getxToMove()); 
				this.hero.setY(this.hero.getY()-this.hero.getyToMove());
				this.hero.setxToMove(0);
				this.hero.setyToMove(0);
				return false; }
			else
			{
				this.hero.setX(this.hero.getX()-this.hero.getxToMove()); 
				this.hero.setY(this.hero.getY()-this.hero.getyToMove()); 
			}
			return false; 
		}
		
		if(tabmap2d[this.hero.getY()][this.hero.getX()] == 'Z')
		{
			if(this.door.getToLevel()<5)
			{
				this.door.setToLevel(this.door.getToLevel()+1); 
				this.hero.setX(this.hero.getX()-this.hero.getxToMove()); 
				this.hero.setY(this.hero.getY()-this.hero.getyToMove());
				this.hero.setxToMove(0);
				this.hero.setyToMove(0);
				return false; }
			else
			{
				this.hero.setX(this.hero.getX()-this.hero.getxToMove()); 
				this.hero.setY(this.hero.getY()-this.hero.getyToMove()); 
			}
			return false; 
		}
		
		if(tabmap2d[this.hero.getY()][this.hero.getX()] == 'G')
		{
			this.setLevel(this.door.getToLevel()); this.loadMap("m"+this.door.getToLevel()); return false;
		}
		
		if(tabmap2d[this.hero.getY()][this.hero.getX()] == 'E')
		{
			this.door.SelectPosDoor(this.getLevel());
			this.door.setOpen(true);
			return true;
		}
		
		if(this.hero.getY() == this.monster1.getY() && this.hero.getX() == this.monster1.getX())
		{ this.monster1 = new Monster(0,0,false); gameOver(); return false; }
		
		if(this.hero.getY() == this.door.getY() && this.hero.getX() == this.door.getX() && this.door.isOpen()==true)
		{ gameEnd(); return false; }
		
		if(tabmap2d[this.hero.getY()][this.hero.getX()] == 'C')
		{ this.setScore(this.getScore()+100); return true; }
		
		if(this.hero.getY() == this.fireball.getY() && this.hero.getX() == this.fireball.getX())
		{ 			
			this.fireball.setActive(false);
			this.fireball.setFirstLaunch(true);
			return true;
		}
		
		else
		{
			this.hero.setX(this.hero.getX()-this.hero.getxToMove()); this.hero.setY(this.hero.getY()-this.hero.getyToMove());
			return false; 
		}
	}
	
	public void gameOver()
	{
		this.saveHighScore(this.getScore(),"map"+this.getLevel());
		this.loadMap("m6");
		this.setLevel(6);
	}
	
	public void gameEnd()
	{
		this.saveHighScore(this.getScore(),"map"+this.getLevel());
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(this.getScore());
		System.out.println(this.getLevel());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		this.setLevel(this.door.getToLevel());
		this.loadMap("m"+this.door.getToLevel());
	}
	
	public void moveM1() {
		this.monster1.setMove(this.monster1.getMove()+1);
		
		if(this.monster1.getAlive() == true && this.monster1.getMove() == 2)
		{
				int min = -1, max = 1;
				
				Random r = new Random();
				
				if(this.hero.getX() < this.monster1.getX())
					max = 0;
				else
					min = 0;
					
				int randX = r.nextInt((max - min) + 1) + min;
				
				min = -1;
				max = 1;
				
				if(this.hero.getY() < this.monster1.getY())
					max = 0;
				else
					min = 0;
				
				int randY = r.nextInt((max - min) + 1) + min;
				
				switch (tabmap2d[this.monster1.getY()+randY][this.monster1.getX()+randX]) {
				case '0':
					tabmap2d[this.monster1.getY()][this.monster1.getX()]='0';
					tabmap2d[this.monster1.getY()+randY][this.monster1.getX()+randX]='6';
					this.monster1.setX(this.monster1.getX()+randX);
					this.monster1.setY(this.monster1.getY()+randY);
					this.monster1.setMove(0);
					break;
				case 'P':
					gameOver();
					break;
				case 'L':
					tabmap2d[this.monster1.getY()][this.monster1.getX()]='0';
					tabmap2d[this.monster1.getY()+randY][this.monster1.getX()+randX]='0';
					this.monster1 = new Monster(0,0,false);
					this.fireball.setActive(false);
					break;
				default:
					this.monster1.setMove(0);
					break;
				}
		}
		
		else {}
	}

	public void moveM2() {
		this.monster2.setMove(this.monster2.getMove()+1);
		
		if(this.monster2.getAlive() == true)
		{
			if(this.monster2.getMove() == 2){
				int min = -1, max = 1;
				
				Random r = new Random();
				
				if(this.hero.getX() < this.monster2.getX())
					max = 0;
				else
					min = 0;
					
				int randX = r.nextInt((max - min) + 1) + min;
				
				min = -1;
				max = 1;
				
				if(this.hero.getY() < this.monster2.getY())
					max = 0;
				else
					min = 0;
				
				int randY = r.nextInt((max - min) + 1) + min;
				
				switch (tabmap2d[this.monster2.getY()+randY][this.monster2.getX()+randX]) {
				case '0':
					tabmap2d[this.monster2.getY()][this.monster2.getX()]='0';
					tabmap2d[this.monster2.getY()+randY][this.monster2.getX()+randX]='7';
					this.monster2.setX(this.monster2.getX()+randX);
					this.monster2.setY(this.monster2.getY()+randY);
					this.monster2.setMove(0);
					break;
				case 'P':
					gameOver();
					break;
				case 'L':
					tabmap2d[this.monster2.getY()][this.monster2.getX()]='0';
					tabmap2d[this.monster2.getY()+randY][this.monster2.getX()+randX]='0';
					this.fireball.setActive(false);
					this.monster2 = new Monster(0,0,false);
					break;
				default:
					this.monster2.setMove(0);
					break;
				}
			}
			
			else {}
		}
		
		else {}
	}
	

	public void moveM3() {
		this.monster3.setMove(this.monster3.getMove()+1);
		
		if(this.monster3.getAlive() == true)
		{
			if(this.monster3.getMove() == 2){
				int min = -1, max = 1;
				
				Random r = new Random();
				
				if(this.hero.getX() < this.monster3.getX())
					max = 0;
				else
					min = 0;
					
				int randX = r.nextInt((max - min) + 1) + min;
				
				min = -1;
				max = 1;
				
				if(this.hero.getY() < this.monster3.getY())
					max = 0;
				else
					min = 0;
				
				int randY = r.nextInt((max - min) + 1) + min;
				
				switch (tabmap2d[this.monster3.getY()+randY][this.monster3.getX()+randX]) {
				case '0':
					tabmap2d[this.monster3.getY()][this.monster3.getX()]='0';
					tabmap2d[this.monster3.getY()+randY][this.monster3.getX()+randX]='8';
					this.monster3.setX(this.monster3.getX()+randX);
					this.monster3.setY(this.monster3.getY()+randY);
					this.monster3.setMove(0);
					break;
				case 'P':
					gameOver();
					break;
				case 'L':
					tabmap2d[this.monster3.getY()][this.monster3.getX()]='0';
					tabmap2d[this.monster3.getY()+randY][this.monster3.getX()+randX]='0';
					this.fireball.setActive(false);
					this.monster3 = new Monster(0,0,false);
					break;
				default:
					this.monster3.setMove(0);
					break;
				}
			}
			
			else {}
		}
		
		else {}
	}
	

	public void moveM4() {
		this.monster4.setMove(this.monster4.getMove()+1);
		
		if(this.monster4.getAlive() == true)
		{
			if(this.monster4.getMove() == 2){
				int min = -1, max = 1;
				
				Random r = new Random();
				
				if(this.hero.getX() < this.monster4.getX())
					max = 0;
				else
					min = 0;
					
				int randX = r.nextInt((max - min) + 1) + min;
				
				min = -1;
				max = 1;
				
				if(this.hero.getY() < this.monster4.getY())
					max = 0;
				else
					min = 0;
				
				int randY = r.nextInt((max - min) + 1) + min;
				
				switch (tabmap2d[this.monster4.getY()+randY][this.monster4.getX()+randX]) {
				case '0':
					tabmap2d[this.monster4.getY()][this.monster4.getX()]='0';
					tabmap2d[this.monster4.getY()+randY][this.monster4.getX()+randX]='9';
					this.monster4.setX(this.monster4.getX()+randX);
					this.monster4.setY(this.monster4.getY()+randY);
					this.monster4.setMove(0);
					break;
				case 'P':
					gameOver();
					break;
				case 'L':
					tabmap2d[this.monster4.getY()][this.monster4.getX()]='0';
					tabmap2d[this.monster4.getY()+randY][this.monster4.getX()+randX]='0';
					this.fireball.setActive(false);
					this.monster4 = new Monster(0,0,false);
					break;
				default:
					this.monster4.setMove(0);
					break;
				}
			}
			
			else {}
		}
		
		else {}
	}
	
	
	public void moveMissile()
	{
		this.fireball.setPosGen(this.fireball.getPosGen()+1);
		this.fireball.setCanMove(this.fireball.getCanMove()+1);
		this.fireball.SelectPosGenFireBall();
		
		if(this.fireball.isActive() == true)
		{
			if(this.fireball.isFirstLaunch() == true)
			{
				if(tabmap2d[this.hero.getY()+this.fireball.getyToMove()][this.hero.getX()+this.fireball.getxToMove()]!='0')
				{	
					this.fireball.setFirstLaunch(true);
					this.fireball.setActive(false);
					this.fireball.setCanMove(0);
				}
				
				else
				{
					tabmap2d[this.hero.getY()+this.fireball.getyToMove()][this.hero.getX()+this.fireball.getxToMove()]='L';
					this.fireball.setX(this.hero.getX()+this.fireball.getxToMove());
					this.fireball.setY(this.hero.getY()+this.fireball.getyToMove());
					this.fireball.setFirstLaunch(false);
					this.fireball.setCanMove(0);
				}
			}
			
			if(this.fireball.isFirstLaunch() == false)
			{
				if(this.fireball.getCanMove() == 1){
					switch (tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]) {
					case '0':
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
						tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='L';
						this.fireball.setX(this.fireball.getX()+this.fireball.getxToMove());
						this.fireball.setY(this.fireball.getY()+this.fireball.getyToMove());
						this.fireball.setCanMove(0);
						break;
					case 'P':
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
						this.fireball.setActive(false);
						this.fireball.setFirstLaunch(true);
						this.fireball.setxToMove(-this.fireball.getxToMove());
						this.fireball.setyToMove(-this.fireball.getyToMove());
						break;
					case '6':
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
						tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
						this.fireball.setActive(false);
						this.monster1 = new Monster(0,0,false);
						this.fireball.setFirstLaunch(true);
						break;
					case '7':
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
						tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
						this.fireball.setActive(false);
						this.monster2 = new Monster(0,0,false);
						this.fireball.setFirstLaunch(true);
						break;
					case '8':
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
						tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
						this.fireball.setActive(false);
						this.monster3 = new Monster(0,0,false);
						this.fireball.setFirstLaunch(true);
						break;
					case '9':
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
						tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
						this.fireball.setActive(false);
						this.monster4 = new Monster(0,0,false);
						this.fireball.setFirstLaunch(true);
						break;
					default:
						this.fireball.setxToMove(-this.fireball.getxToMove());
						this.fireball.setyToMove(-this.fireball.getyToMove());
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]=='0')
						{
							tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='L';
							this.fireball.setX(this.fireball.getX()+this.fireball.getxToMove());
							this.fireball.setY(this.fireball.getY()+this.fireball.getyToMove());
							this.fireball.setCanMove(0);
						}
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()] == 'P')
						{
							tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
							this.fireball.setActive(false);
							this.fireball.setFirstLaunch(true);
							this.fireball.setxToMove(-this.fireball.getxToMove());
							this.fireball.setyToMove(-this.fireball.getyToMove());
						}
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]=='6')
						{
							tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
							tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
							this.fireball.setActive(false);
							this.monster1 = new Monster(0,0,false);
							this.fireball.setFirstLaunch(true);
						}
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]=='7')
						{
							tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
							tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
							this.fireball.setActive(false);
							this.monster2 = new Monster(0,0,false);
							this.fireball.setFirstLaunch(true);
						}
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]=='8')
						{
							tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
							tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
							this.fireball.setActive(false);
							this.monster3 = new Monster(0,0,false);
							this.fireball.setFirstLaunch(true);
						}
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]=='9')
						{
							tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
							tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
							this.fireball.setActive(false);
							this.monster4 = new Monster(0,0,false);
							this.fireball.setFirstLaunch(true);
						}
						break;
					}
				}
				
				else {tabmap2d[this.fireball.getY()][this.fireball.getX()]='L';}
			}
		}
		
		else {}
		
	}
}
