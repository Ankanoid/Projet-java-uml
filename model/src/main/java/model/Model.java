package model;

import java.sql.SQLException;

import java.util.Observable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observer;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import contract.ControllerOrder;
import contract.IModel;
import contract.IController;


/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {
	
	public int rotat = 0;
	
	private int positionMissileX;
	private int positionMissileY;
	
	public int getPositionMissileX() {
		return positionMissileX;
	}

	public void setPositionMissileX(int positionMissileX) {
		this.positionMissileX = positionMissileX;
	}

	public int getPositionMissileY() {
		return positionMissileY;
	}

	public void setPositionMissileY(int positionMissileY) {
		this.positionMissileY = positionMissileY;
	}

	private int activemissile = 0;
	
	public int getActiveMissile() {
		return activemissile;
	}

	public void setActiveMissile(int activemissile) {
		this.activemissile = activemissile;
	}

	private int t = 0;
	
	private int d = 0;
	
	public void setRotat(int rotat) {
		this.rotat = rotat;
	}
	
	private int score = 0;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	private int level = 0;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	private int height = 12;
	private int width = 21;
	
	private int positionHeroX;
	private int positionHeroY;
	
	private int positionMonster1X;
	private int positionMonster1Y;
	
	public int getPositionMonster1X() {
		return positionMonster1X;
	}

	public void setPositionMonster1X(int positionMonster1X) {
		this.positionMonster1X = positionMonster1X;
	}

	public int getPositionMonster1Y() {
		return positionMonster1Y;
	}

	public void setPositionMonster1Y(int positionMonster1Y) {
		this.positionMonster1Y = positionMonster1Y;
	}

	private int positionDoorX;
	private int positionDoorY;
	
	public int getPositionDoorX() {
		return positionDoorX;
	}

	public void setPositionDoorX(int positionDoorX) {
		this.positionDoorX = positionDoorX;
	}

	public int getPositionDoorY() {
		return positionDoorY;
	}

	public void setPositionDoorY(int positionDoorY) {
		this.positionDoorY = positionDoorY;
	}

	public int getPositionHeroX() {
		return positionHeroX;
	}

	public void setPositionHeroX(int positionHeroX) {
		this.positionHeroX = positionHeroX;
	}

	public int getPositionHeroY() {
		return positionHeroY;
	}

	public void setPositionHeroY(int positionHeroY) {
		this.positionHeroY = positionHeroY;
	}

	public int getHeight(){
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public char[][] tabmap2d = new char[this.getHeight()][this.getWidth()];

	/** The message. */
	private String message;
	
	private int highscore;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */

	public void getMapInChar() {

	}

	public String getMessage() {
		return this.message;

	}
	
	public int getHighScore() {
		return this.highscore;

	}


	public void putInTabmap(int i, int j, char car) {
		this.tabmap2d[i][j] = car;
	}

	public void doTheThing() {
		String[] tabmap = this.message.split("\n") ;
		score = 0;
		for(int i =0; i<tabmap.length; i++)
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
						setPositionMonster1Y(i);
						setPositionMonster1X(j);
						break;
					case '7':
						this.putInTabmap(i,j,'7');
						break;
					case '8':
						this.putInTabmap(i,j,'8');
						break;
					case '9':
						this.putInTabmap(i,j,'9');
						break;
					case 'C':
						this.putInTabmap(i,j,'C');
						break;
					case 'E':
						this.putInTabmap(i,j,'E');
						break;
					case 'L':
						this.putInTabmap(i,j,'L');
						break;
					case 'P':
						this.putInTabmap(i,j,'P');
						setPositionHeroY(i);
						setPositionHeroX(j);	
						break;
					case 'S':
						this.putInTabmap(i,j,'S');
						setPositionDoorY(i);
						setPositionDoorX(j);
						break;
					case 'A':
						this.putInTabmap(i,j,'A');
						break;
					case 'Z':
						this.putInTabmap(i,j,'Z');
						break;
					case 'R':
						this.putInTabmap(i,j,'R');
						break;
					case 'T':
						this.putInTabmap(i,j,'T');
						break;
					case 'Y':
						this.putInTabmap(i,j,'Y');
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
	private void setMessage(final String message) {
		this.message = message;
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
	public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
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

	public void moveH(int x, int y) {
		if(isMovePossible(x, y) == true)
		{
			if(this.rotat == -1)
			tabmap2d[positionHeroY+y][positionHeroX+x]='Q';
			
			if(this.rotat == 1)
			tabmap2d[positionHeroY+y][positionHeroX+x]='F';
			
			if(this.rotat == 3)
			tabmap2d[positionHeroY+y][positionHeroX+x]='D';
			
			if(this.rotat == 2)
			tabmap2d[positionHeroY+y][positionHeroX+x]='I';
			
			if(this.rotat == 4)
			tabmap2d[positionHeroY+y][positionHeroX+x]='X';
			
			if(this.rotat == 5)
			tabmap2d[positionHeroY+y][positionHeroX+x]='V';
			
			if(this.rotat == 6)
			tabmap2d[positionHeroY+y][positionHeroX+x]='B';
			
			if(this.rotat == 7)
			tabmap2d[positionHeroY+y][positionHeroX+x]='M';
			
			if(this.rotat == 0)
			tabmap2d[positionHeroY+y][positionHeroX+x]='P';
			
			tabmap2d[positionHeroY][positionHeroX]='0';
			setPositionHeroX(positionHeroX+x);
			setPositionHeroY(positionHeroY+y);
		}

		
		else {}
	}
	
	public boolean isMovePossible(int x,  int y)
	{
		switch (tabmap2d[positionHeroY+y][positionHeroX+x]) {
		case '0':
			return true;
		case 'C':
			score += 100;
			return true;
		case 'E':
			if(this.level == 5)
			tabmap2d[positionDoorY][positionDoorX]='W';
			else
			tabmap2d[positionDoorY][positionDoorX]='O';
			return true;
		case 'O':
			this.saveHighScore(this.score,"map"+this.level);
			this.loadMessage("m9");
			this.setLevel(9);
			return true;
		case '6':
			gameOverM();
			return true;
		case '7':
			gameOverM();
		case '8':
			gameOverM();
		case 'A':
			this.loadMessage("m1");
			this.setLevel(1);
			return true;
		case 'Z':
			this.loadMessage("m2");
			this.setLevel(2);
			return true;
		case 'R':
			this.loadMessage("m3");
			this.setLevel(3);
			return true;
		case 'T':
			this.loadMessage("m4");
			this.setLevel(4);
			return true;
		case 'Y':
			this.loadMessage("m5");
			this.setLevel(5);
			return true;
		case 'W':
			this.saveHighScore(this.score,"map"+this.level);
			this.loadMessage("m7");
			this.setLevel(7);
			return true;
		default:
			return false;
	}
		
	}
	
	public void gameOverM()
	{
		this.saveHighScore(this.score,"map"+this.level);
		this.loadMessage("m6");
		this.setLevel(6);
	}
	
	public void moveM1() {
		this.t++;
		
		int randomNumX = -1 + (int)(Math.random() * ((1 - (-1)) + 1));
		int randomNumY = -1 + (int)(Math.random() * ((1 - (-1)) + 1));

		if(this.t == 1){
			
			switch (tabmap2d[positionMonster1Y][positionMonster1X+1]) {
			case '0':
				tabmap2d[positionMonster1Y][positionMonster1X]='0';
				tabmap2d[positionMonster1Y][positionMonster1X+1]='6';
				setPositionMonster1X(positionMonster1X+1);
				setPositionMonster1Y(positionMonster1Y);
				this.t = 0;
				break;
			case 'P':
				gameOverM();
			default:
				break;
			}
		}
		
		else {tabmap2d[positionMonster1Y][positionMonster1X]='6';}
	}

	public void moveMissile() {
		// TODO Auto-generated method stub
		
	}
	
	/*public void moveMissile()
	{
		if(activemissile != 0)
		{
			if(this.d == 0)
				{ 
					if(tabmap2d[positionHeroY][positionHeroX-1]=='0')
					tabmap2d[positionHeroY][positionHeroX-1]='L';
					setPositionMissileX(positionHeroX-1);
					setPositionMissileY(positionHeroY);
					d++; 
				}
			
			else
			{ 
				switch (tabmap2d[positionMissileY][positionMissileX-1]) {
				case '0':
					tabmap2d[positionMissileY][positionMissileX]='0';
					tabmap2d[positionMissileY][positionMissileX-1]='L';
					setPositionMissileX(positionMissileX-1);
					setPositionMissileY(positionMissileY);
					break;
				case 'E':
					gameOverM();
					break;
				default:
					break;
				}
				
			} 
		}
		
		else {}
	}*/
	

	
}
