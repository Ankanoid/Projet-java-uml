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
	
	Hero hero = new Hero(0, 0);
	
	public Hero getHero(){return this.hero;}
	
	int a = getHero().getX();

	public int rotat = 0;
	
	private int m1alive = 1;
	private int m2alive = 1;
	private int m3alive = 1;
	private int m4alive = 1;
	
	private int xmissile = 0;
	private int ymissile = 0;
	
	private int missilefired = 0;
	
	public void lastKey(String lastKey)
	{
		if(missilefired == 0)
			{
			if(lastKey == "RIGHT")
			{
				xmissile = 1;
				ymissile = 0;
			}
			
			if(lastKey == "LEFT")
			{
				xmissile = -1;
				ymissile = 0;
			}
			
			if(lastKey == "UP")
			{
				xmissile = 0;
				ymissile = -1;
			}
			
			if(lastKey == "DOWN")
			{
				xmissile = 0;
				ymissile = 1;
			}
		}
		
		else {}
	}
	
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
	private int t2 = 0;
	private int t3 = 0;
	private int t4 = 0;
	
	private int tm = 0;
	
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
	
	private int positionMonster2X;
	private int positionMonster2Y;
	
	private int positionMonster3X;
	private int positionMonster3Y;
	
	private int positionMonster4X;
	private int positionMonster4Y;
	
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
	
	public int getPositionMonster2X() {
		return positionMonster2X;
	}

	public void setPositionMonster2X(int positionMonster2X) {
		this.positionMonster2X = positionMonster2X;
	}

	public int getPositionMonster2Y() {
		return positionMonster2Y;
	}

	public void setPositionMonster2Y(int positionMonster2Y) {
		this.positionMonster2Y = positionMonster2Y;
	}

	public int getPositionMonster3X() {
		return positionMonster3X;
	}

	public void setPositionMonster3X(int positionMonster3X) {
		this.positionMonster3X = positionMonster3X;
	}

	public int getPositionMonster3Y() {
		return positionMonster3Y;
	}

	public void setPositionMonster3Y(int positionMonster3Y) {
		this.positionMonster3Y = positionMonster3Y;
	}

	public int getPositionMonster4X() {
		return positionMonster4X;
	}

	public void setPositionMonster4X(int positionMonster4X) {
		this.positionMonster4X = positionMonster4X;
	}

	public int getPositionMonster4Y() {
		return positionMonster4Y;
	}

	public void setPositionMonster4Y(int positionMonster4Y) {
		this.positionMonster4Y = positionMonster4Y;
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

	public void parseMap() {
		String[] tabmap = this.message.split("\n") ;
		d = 0;
		score = 0;
		activemissile = 0;
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
						m1alive = 1;
						setPositionMonster1Y(i);
						setPositionMonster1X(j);
						break;
					case '7':
						this.putInTabmap(i,j,'7');
						setPositionMonster2Y(i);
						setPositionMonster2X(j);
						break;
					case '8':
						this.putInTabmap(i,j,'8');
						setPositionMonster3Y(i);
						setPositionMonster3X(j);
						break;
					case '9':
						this.putInTabmap(i,j,'9');
						setPositionMonster4Y(i);
						setPositionMonster4X(j);
						break;
					case 'C':
						this.putInTabmap(i,j,'C');
						break;
					case 'E':
						this.putInTabmap(i,j,'E');
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
					case 'L':
						this.putInTabmap(i,j,'L');
						setPositionMissileY(i);
						setPositionMissileX(j);
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
			if(this.level != 6 && this.level != 7)
				return true;
			else
				return false;
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
			m1alive = 1;
			this.saveHighScore(this.score,"map"+this.level);
			this.loadMessage("m9");
			this.setLevel(9);
			return true;
		case '6':
			gameOverM();
			return true;
		case '7':
			gameOverM();
			return true;
		case '8':
			gameOverM();
			return true;
		case 'L':
			tabmap2d[positionMissileY][positionMissileX]='0';
			activemissile = 0;
			d = 0;
			return true;
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
			m1alive = 1;
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
		
		if(m1alive == 1)
		{
			if(this.t == 2){
				int min = -1, max = 1;
				
				Random r = new Random();
				
				if(positionHeroX < positionMonster1X)
					max = 0;
				else
					min = 0;
					
				int randX = r.nextInt((max - min) + 1) + min;
				
				min = -1;
				max = 1;
				
				if(positionHeroY < positionMonster1Y)
					max = 0;
				else
					min = 0;
				
				int randY = r.nextInt((max - min) + 1) + min;
				
				switch (tabmap2d[positionMonster1Y+randY][positionMonster1X+randX]) {
				case '0':
					tabmap2d[positionMonster1Y][positionMonster1X]='0';
					tabmap2d[positionMonster1Y+randY][positionMonster1X+randX]='6';
					setPositionMonster1X(positionMonster1X+randX);
					setPositionMonster1Y(positionMonster1Y+randY);
					this.t = 0;
					break;
				case 'P':
					gameOverM();
					break;
				case 'L':
					tabmap2d[positionMonster1Y][positionMonster1X]='0';
					tabmap2d[positionMonster1Y+randY][positionMonster1X+randX]='0';
					activemissile = 0;
					m1alive = 0;
					break;
				default:
					this.t = 0 ;
					break;
				}
			}
			
			else {}
		}
		
		else {}
	}

	public void moveM2() {
		this.t2++;
		
		if(this.m2alive == 1)
		{
			if(this.t2 == 2){
				int min = -1, max = 1;
				
				Random r = new Random();
				
				if(positionHeroX < positionMonster2X)
					max = 0;
				else
					min = 0;
					
				int randX = r.nextInt((max - min) + 1) + min;
				
				min = -1;
				max = 1;
				
				if(positionHeroY < positionMonster2Y)
					max = 0;
				else
					min = 0;
				
				int randY = r.nextInt((max - min) + 1) + min;
				
				switch (tabmap2d[positionMonster2Y+randY][positionMonster2X+randX]) {
				case '0':
					tabmap2d[positionMonster2Y][positionMonster2X]='0';
					tabmap2d[positionMonster2Y+randY][positionMonster2X+randX]='7';
					setPositionMonster2X(positionMonster2X+randX);
					setPositionMonster2Y(positionMonster2Y+randY);
					this.t2 = 0;
					break;
				case 'P':
					gameOverM();
					break;
				case 'L':
					tabmap2d[positionMonster2Y][positionMonster2X]='0';
					tabmap2d[positionMonster2Y+randY][positionMonster2X+randX]='0';
					this.m2alive = 0;
					this.activemissile = 0;
					break;
				default:
					this.t2 = 0 ;
					break;
				}
			}
			
			else {tabmap2d[positionMonster2Y][positionMonster2X]='7';}
		}
		
		else
			
		{ }
	}

	public void moveM3() {
		this.t3++;
		
		if(this.m3alive == 1)
		{
			if(this.t3 == 2){
				int min = -1, max = 1;
				
				Random r = new Random();
				
				if(positionHeroX < positionMonster3X)
					max = 0;
				else
					min = 0;
					
				int randX = r.nextInt((max - min) + 1) + min;
				
				min = -1;
				max = 1;
				
				if(positionHeroY < positionMonster3Y)
					max = 0;
				else
					min = 0;
				
				int randY = r.nextInt((max - min) + 1) + min;
				
				switch (tabmap2d[positionMonster3Y+randY][positionMonster3X+randX]) {
				case '0':
					tabmap2d[positionMonster3Y][positionMonster3X]='0';
					tabmap2d[positionMonster3Y+randY][positionMonster1X+randX]='8';
					setPositionMonster3X(positionMonster3X+randX);
					setPositionMonster3Y(positionMonster3Y+randY);
					this.t3 = 0;
					break;
				case 'P':
					gameOverM();
					break;
				case 'L':
					tabmap2d[positionMonster3Y][positionMonster3X]='0';
					tabmap2d[positionMonster3Y+randY][positionMonster3X+randX]='0';
					this.m2alive = 0;
					this.activemissile = 0;
					break;
				default:
					this.t3 = 0 ;
					break;
				}
			}
			
			else {tabmap2d[positionMonster3Y][positionMonster3X]='8';}
		}
		
		else
			
		{ }
	}

	public void moveM4() {
		this.t4++;
		
		if(this.m4alive == 1)
		{
			if(this.t4 == 2){
				int min = -1, max = 1;
				
				Random r = new Random();
				
				if(positionHeroX < positionMonster4X)
					max = 0;
				else
					min = 0;
					
				int randX = r.nextInt((max - min) + 1) + min;
				
				min = -1;
				max = 1;
				
				if(positionHeroY < positionMonster4Y)
					max = 0;
				else
					min = 0;
				
				int randY = r.nextInt((max - min) + 1) + min;
				
				switch (tabmap2d[positionMonster4Y+randY][positionMonster4X+randX]) {
				case '0':
					tabmap2d[positionMonster4Y][positionMonster4X]='0';
					tabmap2d[positionMonster4Y+randY][positionMonster4X+randX]='9';
					setPositionMonster4X(positionMonster4X+randX);
					setPositionMonster4Y(positionMonster4Y+randY);
					this.t4 = 0;
					break;
				case 'P':
					gameOverM();
					break;
				case 'L':
					tabmap2d[positionMonster4Y][positionMonster4X]='0';
					tabmap2d[positionMonster4Y+randY][positionMonster4X+randX]='0';
					this.m2alive = 0;
					this.activemissile = 0;
					break;
				default:
					this.t4 = 0 ;
					break;
				}
			}
			
			else {tabmap2d[positionMonster4Y][positionMonster4X]='9';}
		}
		
		else
			
		{ }
	}
	
	public void moveMissile()
	{
		this.tm++;
		
		if(this.activemissile == 1)
		{
			if(d == 0)
			{
				if(tabmap2d[positionHeroY+ymissile][positionHeroX+xmissile]!='0')
				{	
					d=0;
					activemissile=0;
				}
				
				else
				{
					tabmap2d[positionHeroY+ymissile][positionHeroX+xmissile]='L';
					setPositionMissileX(positionHeroX+xmissile);
					setPositionMissileY(positionHeroY+ymissile);
					d=1;
					missilefired = 1;
					tm = 0;
				}
			}
			
			if(d==1)
			{
				if(this.tm == 2){
					
					switch (tabmap2d[positionMissileY+ymissile][positionMissileX+xmissile]) {
					case '0':
						tabmap2d[positionMissileY][positionMissileX]='0';
						tabmap2d[positionMissileY+ymissile][positionMissileX+xmissile]='L';
						setPositionMissileX(positionMissileX+xmissile);
						setPositionMissileY(positionMissileY+ymissile);
						this.tm = 0;
						break;
					case 'P':
						tabmap2d[positionMissileY][positionMissileX]='0';
						activemissile = 0;
						d = 0;
						xmissile = -xmissile;
						ymissile = -ymissile;
						missilefired = 0;
						break;
					case '6':
						tabmap2d[positionMissileY][positionMissileX]='0';
						tabmap2d[positionMissileY+ymissile][positionMissileX+xmissile]='0';
						activemissile = 0;
						m1alive = 0;
						d = 0;
						missilefired=0;
						break;
					default:
						xmissile = -xmissile;
						ymissile = -ymissile;
						tabmap2d[positionMissileY][positionMissileX]='0';
						tabmap2d[positionMissileY+ymissile][positionMissileX+xmissile]='L';
						setPositionMissileX(positionMissileX+xmissile);
						setPositionMissileY(positionMissileY+ymissile);
						this.tm = 0;
						break;
					}
				}
				
				else {tabmap2d[positionMissileY][positionMissileX]='L';}
			}
		}
		
		else {}

		
	}

	public void setM1alive(int m1alive) {
		this.m1alive = m1alive;
	}

	public void setM2alive(int m2alive) {
		this.m2alive = m2alive;
	}

	public void setM3alive(int m3alive) {
		this.m3alive = m3alive;
	}

	public void setM4alive(int m4alive) {
		this.m4alive = m4alive;
	}
	
}
