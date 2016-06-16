package model;

import java.sql.SQLException;

import java.util.Observable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import contract.IModel;


/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	private int height = 12;
	private int width = 21;
	
	private int positionHeroX;
	private int positionHeroY;
	
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


	public void putInTabmap(int i, int j, char car) {
		this.tabmap2d[i][j] = car;
	}

	public void doTheThing() {
		String[] tabmap = this.message.split("\n") ;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	public void moveG(int x, int y) {
		if(isMovePossible(x, y) == true)
		{
			tabmap2d[positionHeroY+y][positionHeroX+x]='P';
			tabmap2d[positionHeroY][positionHeroX]='0';
			setPositionHeroX(positionHeroX+x);
			setPositionHeroY(positionHeroY+y);
		}
		
		else {}
	}
	
	public boolean isMovePossible(int x,  int y)
	{
		if(tabmap2d[positionHeroY+y][positionHeroX+x] == '0')
			return true;
		
		else 
			return false;
	}
	
}
