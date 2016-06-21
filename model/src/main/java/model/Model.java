package model;

import java.sql.SQLException;

import java.util.Observable;
import java.util.Random;

import contract.IModel;


/**
 * The Class Model.
 *
 * @author Group 5
 */
public class Model extends Observable implements IModel {

	/** The Hero. */
	private Hero hero;
	/** First Monster. */
	private Monster monster1;
	/** Second Monster. */
	private Monster monster2;
	/** Third Monster. */
	private Monster monster3;
	/** Fourth Monster. */
	private Monster monster4;
	/** The Fireball. */
	private FireBall fireball;
	/** The Door. */
	private Door door;
	/** String lastKey contains a String describing the last key pressed by the user */
	private String lastKey;
	/** boolean isNewKey false by default. Turn at true when a user press a key, turn at false again when all the new moves are settled */
	private boolean isNewKey = false;
	/** height of the table (of the map also) */
	private int height = 12;
	/** width of the table (of the map also) */
	private int width = 21;
	/** char 2d tabmap2d contains the map */
	public char[][] tabmap2d = new char[this.getHeight()][this.getWidth()];
	/** The map. */
	private String map;
	/** Highscore */
	private int highscore;
	/** current level */
	private int currentlevel=1;

	/**
	 * Gets the actual score in the Infos Class
	 */
	public int getScore()
	{ return Infos.getScore(); }
	
	/**
	 * Gets the actual Global Score in the Infos Class
	 */
	public int getGlobalScore()
	{ return Infos.getGlobalScore(); }
	
	/**
	 * Gets the actual number of life
	 */
	public int getLife()
	{ return Infos.getLife(); }
	
	/**
	 * Sets a new number of life
	 */
	public void setLife(int life)
	{ Infos.setLife(life); }
	
	/**
	 * Sets a new Global Score
	 */
	public void setGlobalScore(int globalscore)
	{ Infos.setGlobalScore(globalscore); }
	
	/**
	 * Gets the Hero Image String containing the file name of the next hero sprite to display
	 */
	public String getImageHero()
	{ return this.hero.getImage(); }
	
	/**
	 * Gets the Fireball Image String containing the file name of the next fireball sprite to display
	 */
	public String getImageFireBall()
	{ return this.fireball.getImage(); }
	
	/**
	 * Gets the Door Image String containing the file name of the next door sprite to display
	 */
	public String getImageDoor()
	{ return this.door.getImage(); }
	
	/**
	 * Sets a new actual score
	 * @param score
	 * 			current score
	 */
	public void setScore(int score)
	{ Infos.setScore(score); }
	
	/**
	 * Gets the actual level
	 */
	public int getLevel()
	{ return Infos.getLevel(); }
	
	/**
	 * Sets the actual level
	 */
	public void setLevel(int level)
	{ Infos.setLevel(level); }
	
	/**
	 * Gets the level reached if the door is touched by the hero
	 */
	public int getDoorLevel()
	{ return this.door.getToLevel(); }

	/**
	 * Get the lastKey String containing the description of the last key pressed by the user
	 * @return lastKey
	 */
	public String getLastKey() 
	{ return lastKey; }

	/**
	 * Get the table Height (map height)
	 * @return height
	 */
	private int getHeight()
	{ return this.height; }

	/**
	 * Get the table Width (map width)
	 * @return width
	 */
	private int getWidth()
	{ return this.width; }
	
	/**
	 * 
	 */
	public void setNewKey(boolean newKey)
	{
		this.isNewKey = newKey;
	}

	/**
	 * Instantiates a new model.
	 * Contains the hero, the fireball, the door, and the four monsters
	 */
	public Model() {
		this.hero = new Hero(0,0, false);
		this.monster1 = new Monster(0,0,false);
		this.monster2 = new Monster(0,0,false);
		this.monster3 = new Monster(0,0,false);
		this.monster4 = new Monster(0,0,false);
		this.fireball = new FireBall(0,0,false, true);
		this.door = new Door(0,0, false);
		this.map = "";
		
		Thread playWave=new SoundClip("C:/Users/Thomas/git/Projet-java-uml/sprite/loop.wav");
		playWave.start();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */

	public void getMapInChar() {

	}
	/**
	 * Gets the map
	 */
	public String getMap() {
		return this.map;

	}
	
	/**
	 * Gets the highscore
	 */
	public int getHighScore() {
		return this.highscore;

	}

	/**
	 * Function called when the map is generated. Put the character in the table 2d
	 * @param i
	 * 			i position in the table
	 * @param j
	 * 			j position in the table
	 * @param c
	 * 			character to display
	 */
	public void putInTabmap(int i, int j, char c) {
		this.tabmap2d[i][j] = c;
	}

	/**
	 * Function called at each map switch. Gets the map simple String, split it, put each character at the right place and sets the coordinate of all the instance of the monsters, the hero, the door
	 */
	public void parseMap() {
		this.hero = new Hero(0,1,false); // Reset the instances
		this.door = new Door (0,0, false);
		this.monster1 = new Monster(0,0,false);
		this.monster2 = new Monster(0,0,false);
		this.monster3 = new Monster(0,0,false);
		this.monster4 = new Monster(0,0,false);
		this.fireball.setFirstLaunch(true); // Reset the fireball first launch
		this.setScore(0); // Reset the Score
		this.fireball.setActive(false); // Set the fireball inactive
		
		String[] tabmap = this.map.split("\n") ; // Split the map
		
		for(int i = 0; i<tabmap.length; i++) // Enter the characters at the right position i, j
		{
			for (int j =0; j<tabmap[i].length();j++)
			{
				switch (tabmap[i].charAt(j)) {
					case '0':
						this.putInTabmap(i,j,'0'); // Nothing
						break;
					case '1':
						this.putInTabmap(i,j,'1'); // Bone
						break;
					case '2':
						this.putInTabmap(i,j,'2'); // Horizontal
						break;
					case '3':
						this.putInTabmap(i,j,'3'); // Vertical
						break;
					case '6':
						this.putInTabmap(i,j,'6'); // First Monster
						this.monster1.setAlive(true); // Set is alive
						this.monster1.setMove(0); // Reset the move
						this.monster1.setY(i); // Sets positions
						this.monster1.setX(j);
						break;
					case '7':
						this.putInTabmap(i,j,'7'); // Second monster
						this.monster2.setAlive(true); // Set it alive
						this.monster2.setMove(0); // Reset the move
						this.monster2.setY(i); // Sets positions
						this.monster2.setX(j);
						break;
					case '8':
						this.putInTabmap(i,j,'8'); // Third monster
						this.monster3.setAlive(true); // Set it alive
						this.monster3.setMove(0); // Reset the move
						this.monster3.setY(i); // Sets positions
						this.monster3.setX(j);
						break;
					case '9':
						this.putInTabmap(i,j,'9'); // Fourth monster
						this.monster4.setAlive(true); // Set it alive
						this.monster4.setMove(0); // Reset the move
						this.monster4.setY(i); // Sets positions
						this.monster4.setX(j);
						break;
					case 'C':
						this.putInTabmap(i,j,'C'); // Coins
						break;
					case 'E':
						this.putInTabmap(i,j,'E'); // Energy ball
						break;
					case 'P':
						this.putInTabmap(i,j,'P'); // Player
						this.hero.setAlive(true); // Set it alive
						this.hero.setY(i); // Sets positions
						this.hero.setX(j);
						break;
					case 'S':
						this.putInTabmap(i,j,'S'); // Door
						this.door.setOpen(false); // set it close
						this.door.setY(i); // Sets positions
						this.door.setX(j);
						break;
					case 'A':
						this.putInTabmap(i,j,'A'); // Minus Sprite at home map
						break;
					case 'Z':
						this.putInTabmap(i,j,'Z'); // Plus Sprite at home map
						break;
					case 'G':
						this.putInTabmap(i,j,'G'); // Door at home map
						this.door.setToLevel(currentlevel);
						break;
					default :
						this.putInTabmap(i,j,' '); // If Nothing, shouldn't happen
						break;
				}
			}
		}
	}
	
	public char[][] getTabmap2d() {
		return this.tabmap2d;
	}

	/**
	 * Sets the map.
	 *
	 * @param map
	 *          the new map
	 */
	private void setMap(final String map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Sets the highscore.
	 *
	 * @param highscore
	 *          the new highscore
	 */
	private void setHighScore(final int highscore) {
		this.highscore = highscore;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Load the map
	 * 
	 * @param key
	 * 		key of the map
	 */
	public void loadMap(final String key) {
		try {
			final DAOMap map = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMap(map.find(key).getMap());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Load a highscore
	 * 
	 * @param key
	 * 		key of the map
	 */
	public void loadHighScore(final String key) {
		try {
			final DAOHighScore daoHighScore = new DAOHighScore(DBConnection.getInstance().getConnection());
			this.setHighScore(daoHighScore.find(key).getHighScore());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Save the highscore
	 * 
	 * @param score
	 * 		score of the map or global
	 * @param key
	 * 		key of the map
	 */
	private void saveHighScore(final int score, final String key) {
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

	/**
	 * Set last Key String, also set isNewKey at true, and then set the move for the hero, and select the position (image) to display
	 * Finally set the move for the fireball and select it, if isFirstLaunch is true
	 * 
	 * @param lastKey
	 * 		String contains the description of the last key pressed
	 */
	public void setLastKey(String lastKey) {
		this.lastKey = lastKey;
		this.hero.setMove(this.lastKey);
		this.hero.SelectPosHero();
		if(this.fireball.isFirstLaunch())
		{
			this.fireball.setMove(this.lastKey);
			this.fireball.SelectMoveFireBall();
		}
	}

	/**
	 * Set the fireball active if isFirstLaunch true
	 * If it's not true, that means the ball is still active but key has been pressed again, then make the fireball move to the hero
	 */
	public void setActiveFireBall(boolean isActive) {
		if(this.fireball.isFirstLaunch())
		this.fireball.setActive(isActive);
		
		else
			this.fireball.toHero(this.hero.getY(),this.hero.getX());
	}
	
	/**
	 * Function called at each refresh, make it move to the given position (depending on the key pressed) or just change his sprite if there is no key pressed
	 */
	public void moveHero() {
		this.hero.setPosGen(this.hero.getPosGen()+1); // Increment the PosGen of the hero
		this.hero.SelectPosGenHero();	 // Select the new Sprite to display
		if(isMovePossible() && this.hero.isAlive())
		{
			this.hero.SelectPosHero(); // If a key is pressed and the move is possible and the hero is alive, select the new sprite to display depending on the key
			tabmap2d[this.hero.getY()][this.hero.getX()]='0';
			tabmap2d[this.hero.getY()+this.hero.getyToMove()][this.hero.getX()+this.hero.getxToMove()]='P'; // Move the hero
			this.hero.setX(this.hero.getX()+this.hero.getxToMove()); // Set position to the next move
			this.hero.setY(this.hero.getY()+this.hero.getyToMove());
			if(!this.isNewKey)
			{
				this.hero.setxToMove(0);
				this.hero.setyToMove(0);
			}
		}
	}
	
	/**
	 * Function which return true or false to moveHero function
	 * Check if the move asked by the user (by pressing a key) is possible or not
	 * Also handle all the collision with monsters, fireball, and events when an energy ball or coins are touched
	 * @return true if move is possible, false if not
	 */
	public boolean isMovePossible()
	{
		
		if(tabmap2d[this.hero.getY()+this.hero.getyToMove()][this.hero.getX()+this.hero.getxToMove()] == '0' && this.isNewKey) // If this one contains nothing, move the player character to the new position
		{
			return !(this.getLevel() == 103 || this.getLevel() == 102);
		}

		if(tabmap2d[this.hero.getY()+this.hero.getyToMove()][this.hero.getX()+this.hero.getxToMove()] == 'A' && this.door.getToLevel()>1 && this.isNewKey) // if the new positions is an 'A' (on the home map)
		{
			SoundClip.playThis("P_M_LEVEL"); // Play the song plus or minus level 
			this.door.setToLevel(this.door.getToLevel()-1);  // set the new level for the door
			this.hero.setxToMove(0); // Reset the hero move, so he won't move alone when refreshing
			this.hero.setyToMove(0);
			
			return false; // return false because we can't go on this
		}
		
		if(tabmap2d[this.hero.getY()+this.hero.getyToMove()][this.hero.getX()+this.hero.getxToMove()] == 'Z' && this.door.getToLevel()<5 && this.isNewKey == true) // if the new positions is an 'Z' (on the home map)
		{
			SoundClip.playThis("P_M_LEVEL"); // Play the song plus or minus level 
			this.door.setToLevel(this.door.getToLevel()+1);  // set the new level for the door
			this.hero.setxToMove(0);
			this.hero.setyToMove(0); // Reset the hero move, so he won't move alone when refreshing
			
			return false; // return false because we can't go on this
		}
		
		if(tabmap2d[this.hero.getY()+this.hero.getyToMove()][this.hero.getX()+this.hero.getxToMove()] == 'G' && !Infos.returnMapState(this.door.getToLevel()) && this.isNewKey) // if the new positions is an 'G' (on the home map)
		{
			SoundClip.playThis("DOOR"); // Play the song when we walk through a door
			this.setLevel(this.door.getToLevel());  // set the actual level
			this.loadMap("m"+this.door.getToLevel());  // load the level
			
			return false; // return false because we can't go on this
		}
		
		if(tabmap2d[this.hero.getY()+this.hero.getyToMove()][this.hero.getX()+this.hero.getxToMove()] == 'E' && this.isNewKey) // if next position is an energy ball
		{
			SoundClip.playThis("ENERGY"); // Play the sound of that energy ball
			this.door.SelectPosDoor(this.getLevel()); // Select the next level when we will walk through the door and change the sprite
			this.door.setOpen(true); // Set the door open
			
			return true; // return true because we can go on this and suppress it
		}
		
		if(this.hero.getY()+this.hero.getyToMove() == this.monster1.getY() && this.hero.getX()+this.hero.getxToMove() == this.monster1.getX()  && this.isNewKey) // if next position is the monster 1
		{ SoundClip.playThis("DEATH_PLAYER"); this.monster1 = new Monster(0,0,false); gameOver(); return false; } // Play the sound of player death, reset the monster, launch the gameover function, return false because we won't change the position to the monster position
		
		if(this.hero.getY()+this.hero.getyToMove() == this.monster2.getY() && this.hero.getX()+this.hero.getxToMove() == this.monster2.getX()  && this.isNewKey) // if next position is the monster 2
		{ SoundClip.playThis("DEATH_PLAYER"); this.monster2 = new Monster(0,0,false); gameOver(); return false; } // Play the sound of player death, reset the monster, launch the gameover function, return false because we won't change the position to the monster position
		
		if(this.hero.getY()+this.hero.getyToMove() == this.monster3.getY() && this.hero.getX()+this.hero.getxToMove() == this.monster3.getX()  && this.isNewKey) // if next position is the monster 3
		{ SoundClip.playThis("DEATH_PLAYER"); this.monster3 = new Monster(0,0,false); gameOver(); return false; } // Play the sound of player death, reset the monster, launch the gameover function, return false because we won't change the position to the monster position
		
		if(this.hero.getY()+this.hero.getyToMove() == this.monster4.getY() && this.hero.getX()+this.hero.getxToMove() == this.monster4.getX()  && this.isNewKey) // if next position is the monster 4
		{ SoundClip.playThis("DEATH_PLAYER"); this.monster4 = new Monster(0,0,false); gameOver(); return false; } // Play the sound of player death, reset the monster, launch the gameover function, return false because we won't change the position to the monster position
		
		if(this.hero.getY()+this.hero.getyToMove() == this.door.getY() && this.hero.getX()+this.hero.getxToMove() == this.door.getX() && this.door.isOpen()  && this.isNewKey) // if next position is the door and this one is open
		{ SoundClip.playThis("DOOR"); gameEnd(); return false; } // play the sound when a door is walked through, launch the function gameEnd, return false because we can't go on the door and suppress it
		
		if(this.hero.getY()+this.hero.getyToMove() == this.door.getY() && this.hero.getX()+this.hero.getxToMove() == this.door.getX() && !this.door.isOpen()  && this.isNewKey) // if next position is the door and this one is open
		{ SoundClip.playThis("DEATH_PLAYER"); gameOver(); return false; } // play the sound when a door is walked through, launch the function gameEnd, return false because we can't go on the door and suppress it
		
		if(tabmap2d[this.hero.getY()+this.hero.getyToMove()][this.hero.getX()+this.hero.getxToMove()] == 'C' && this.isNewKey) // if next position is coins
		{ SoundClip.playThis("COINS"); this.setScore(this.getScore()+100); Infos.setGlobalScore(this.getGlobalScore()+100); this.getGlobalScore(); return true; } // play the sound of coins, update the current score by adding 100 points, also update the same way the global score, then return true because we can suppress it
		
		if(this.hero.getY()+this.hero.getyToMove() == this.fireball.getY() && this.hero.getX()+this.hero.getxToMove() == this.fireball.getX()  && this.isNewKey) // if next position is the fireball
		{
			SoundClip.playThis("FIREBALL_B"); // play the sound of the fireball coming back to the hero
			this.fireball.setX(0); // reset positions of the fireball
			this.fireball.setY(0);
			this.fireball.setActive(false); // set it inactive
			this.fireball.setFirstLaunch(true); // set his launch to a new one
			return true; // suppress it
		}
		
		else
		{
			return false;
		}
	}
	
	/**
	 * Function gameOver, called each time the player dies
	 * Decrease the life by 1, save the score of the map or the globalscore and load the lose map if there is no more life
	 */
	public void gameOver()
	{
		Infos.setLife(Infos.getLife()-1); // decrease the life amount
		currentlevel = this.getLevel();
		this.saveHighScore(this.getScore(),"map"+this.getLevel()); // save the current map score
		if(Infos.getLife()==0) // if there is no more life
		{
			this.saveHighScore(this.getGlobalScore(),"mapG"); // save the global score aswell
			Infos.resetScores(); // reset all the scores
			this.currentlevel = 1;
			this.loadMap("m103"); // load the lose map
			this.setLevel(103);
		}
		
		else // if there is still life
		{
			hero = new Hero(0,0,false);
			Infos.setGlobalScore(Infos.getGlobalScore()-this.getScore()); // update the globalscore
			this.loadMap("m104"); // load the home map
			this.setLevel(104);
		}
	}
	
	/**
	 * Function gameEnd, called every time a door is walked through, update the map state, save the score of the map, set the new level, if all the maps are done, save the global score as well, reset them, and load the win screen, if not, just load the home map
	 */
	public void gameEnd()
	{
		Infos.updateMap(); // update the map
		currentlevel = this.getLevel();
		this.saveHighScore(this.getScore(),"map"+this.getLevel()); // save the map score
		this.setLevel(this.door.getToLevel()); // set the new level
		if(Infos.allLevelDone()) // if all maps are done
		{
			this.saveHighScore(this.getGlobalScore(),"mapG"); // save the global score 
			Infos.resetScores(); // reset scores
			this.setLevel(102); // set the level to the win map
		}

		this.loadMap("m"+this.getLevel()); // load the map
	}

	/**
	 * Function which calculate the next move of the monster 1 depending of the hero position
	 */
	public void moveM1() {
		this.monster1.setMove(this.monster1.getMove()+1); // Increment the int move so that the monster can move
		
		if(this.monster1.getAlive() && this.monster1.getMove() == 3) // if the int move == 3 and the monster is alive
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
				
				int randY = r.nextInt((max - min) + 1) + min; // calculate coordinate 
				
				switch (tabmap2d[this.monster1.getY()+randY][this.monster1.getX()+randX]) { // if the next position is ...
				case '0': // nothing, then move the monster
					tabmap2d[this.monster1.getY()][this.monster1.getX()]='0';
					tabmap2d[this.monster1.getY()+randY][this.monster1.getX()+randX]='6';
					this.monster1.setX(this.monster1.getX()+randX); // set new position
					this.monster1.setY(this.monster1.getY()+randY);
					this.monster1.setMove(0); // reset int move
					break;
				case 'P': // if it's the player
					SoundClip.playThis("DEATH_PLAYER"); // play the death player sound
					gameOver(); // call the gameOver function
					break;
				case 'L': // if it's the fireball
					SoundClip.playThis("DEATH_MONSTER"); // play the death monster sound
					tabmap2d[this.monster1.getY()][this.monster1.getX()]='0'; // kill the monster
					tabmap2d[this.monster1.getY()+randY][this.monster1.getX()+randX]='0';
					this.monster1 = new Monster(0,0,false); // reset it, and make it dead (false)
					this.fireball.setActive(false); // set the fireball inactive
					this.fireball.setFirstLaunch(true); // set her first launch
					break;
				default:
					this.monster1.setMove(0); // else, the monster can't move, so we reset the move
					break;
				}
		}
		
		else {}
	}

	/**
	 * Function which calculate the next move of the monster 2 depending of the hero position
	 */
	public void moveM2() { // same as the previous monster, we can modify their behavior by making them slower (just increase the move needed to enter the condition), or we can change their random and so on
		this.monster2.setMove(this.monster2.getMove()+1);
		
		if(this.monster2.getAlive() && this.monster2.getMove() == 2)
		{
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
					SoundClip.playThis("DEATH_PLAYER");
					gameOver();
					break;
				case 'L':
					SoundClip.playThis("DEATH_MONSTER");
					tabmap2d[this.monster2.getY()][this.monster2.getX()]='0';
					tabmap2d[this.monster2.getY()+randY][this.monster2.getX()+randX]='0';
					this.monster2 = new Monster(0,0,false);
					this.fireball.setActive(false); // set the fireball inactive
					this.fireball.setFirstLaunch(true); // set her first launch
					break;
				default:
					this.monster2.setMove(0);
					break;
				}
		}
		
		else {}
	}
	
	/**
	 * Function which calculate the next move of the monster 3 depending of the hero position
	 */
	public void moveM3() {
		this.monster3.setMove(this.monster3.getMove()+1);
		
		if(this.monster3.getAlive() && this.monster3.getMove() == 1)
		{
				int x = 0, y = 0;


			if(this.hero.getX() < this.monster3.getX())
				x = 1;
			else if (this.hero.getX() == this.monster3.getX())
				x = 0;
			else
				x = -1;

			if(this.hero.getY() < this.monster3.getY())
				x = 1;
			else if (this.hero.getX() == this.monster3.getX())
				x = 0;
			else
				x = -1;
				
				switch (tabmap2d[this.monster3.getY()+y][this.monster3.getX()+x]) {
				case '0':
					tabmap2d[this.monster3.getY()][this.monster3.getX()]='0';
					tabmap2d[this.monster3.getY()+y][this.monster3.getX()+x]='8';
					this.monster3.setX(this.monster3.getX()+x);
					this.monster3.setY(this.monster3.getY()+y);
					this.monster3.setMove(0);
					break;
				case 'P':
					SoundClip.playThis("DEATH_PLAYER");
					gameOver();
					break;
				case 'L':
					SoundClip.playThis("DEATH_MONSTER");
					tabmap2d[this.monster3.getY()][this.monster3.getX()]='0';
					tabmap2d[this.monster3.getY()+y][this.monster3.getX()+x]='0';
					this.monster3 = new Monster(0,0,false);
					this.fireball.setActive(false); // set the fireball inactive
					this.fireball.setFirstLaunch(true); // set her first launch
					break;
				default:
					this.monster3.setMove(0);
					break;
				}
		}
		
		else {}
	}

	/**
	 * Function which calculate the next move of the monster 4 depending of the hero position
	 */
	public void moveM4() {
		this.monster4.setMove(this.monster4.getMove()+1);
		
		if(this.monster4.getAlive() && this.monster4.getMove() == 1)
		{
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
					SoundClip.playThis("DEATH_PLAYER");
					gameOver();
					break;
				case 'L':
					SoundClip.playThis("DEATH_MONSTER");
					tabmap2d[this.monster4.getY()][this.monster4.getX()]='0';
					tabmap2d[this.monster4.getY()+randY][this.monster4.getX()+randX]='0';
					this.monster4 = new Monster(0,0,false);
					this.fireball.setActive(false); // set the fireball inactive
					this.fireball.setFirstLaunch(true); // set her first launch
					break;
				default:
					this.monster4.setMove(0);
					break;
				}
		}
		
		else {}
	}
	
	/**
	 * Function which calculate the next move of the fireball, if that move is possible, and all the events of that fireball
	 */
	public void moveFireBall()
	{
		this.fireball.setPosGen(this.fireball.getPosGen()+1); // set next sprite to fireball
		this.fireball.SelectPosGenFireBall(); // apply it
		
		if(this.fireball.isActive()) // if the fireball is active, enter, else, do nothing
		{
			if(this.fireball.isFirstLaunch()) // if she isn't present and it's the first launch, check the next position
			{
				if(tabmap2d[this.hero.getY()+this.fireball.getyToMove()][this.hero.getX()+this.fireball.getxToMove()]!='0') // if it's not nothing, set it again to inactive and first launch, because she can't spawn
				{	
					this.fireball.setFirstLaunch(true);
					this.fireball.setActive(false);
				}
				
				else // if it's nothing, she can spawn
				{
					SoundClip.playThis("FIREBALL_O"); // play the fireball out sound
					this.fireball.setX(this.hero.getX()+this.fireball.getxToMove()); // set positions
					this.fireball.setY(this.hero.getY()+this.fireball.getyToMove());
					tabmap2d[this.fireball.getY()][this.fireball.getX()]='L'; // spawn the fireball
					this.fireball.setFirstLaunch(false); // the fireball is spawn so it's no more a first launch
				}
			}
			
			else if(!this.fireball.isFirstLaunch()) // if the fireball is already on the land, so it's not a first launch
			{
					switch (tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]) {
					case '0': // if next position is nothing
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0'; // make the fireball move
						tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='L';
						this.fireball.setX(this.fireball.getX()+this.fireball.getxToMove()); // set the new positions
						this.fireball.setY(this.fireball.getY()+this.fireball.getyToMove());
						break;
					case 'P': // if it's the player
						SoundClip.playThis("FIREBALL_B"); // play the fireball back to hero sound
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0'; // suppress the fireball
						this.fireball.setX(0); // reset positions
						this.fireball.setY(0);
						this.fireball.setActive(false); // set her inactive
						this.fireball.setFirstLaunch(true); // set her first launch
						this.fireball.setxToMove(-this.fireball.getxToMove()); // reset coordinate to move of the fireball
						this.fireball.setyToMove(-this.fireball.getyToMove());
						break;
					case '6': // if it's a monster
						SoundClip.playThis("DEATH_MONSTER"); // play the death monster sound
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0'; // suppress fireball and monster
						tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
						this.fireball.setActive(false); // set her inactive
						this.monster1 = new Monster(0,0,false); // reset the monster1
						this.fireball.setFirstLaunch(true); // set her first launch
						break;
					case '7': // same
						SoundClip.playThis("DEATH_MONSTER");
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
						tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
						this.fireball.setActive(false);
						this.monster2 = new Monster(0,0,false);
						this.fireball.setFirstLaunch(true);
						break;
					case '8': // same
						SoundClip.playThis("DEATH_MONSTER");
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
						tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
						this.fireball.setActive(false);
						this.monster3 = new Monster(0,0,false);
						this.fireball.setFirstLaunch(true);
						break;
					case '9': // same
						SoundClip.playThis("DEATH_MONSTER");
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
						tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
						this.fireball.setActive(false);
						this.monster4 = new Monster(0,0,false);
						this.fireball.setFirstLaunch(true);
						break;
					default: // everything else, she has to bounce
						this.fireball.setxToMove(-this.fireball.getxToMove()); // invert the coordinate to move to go the other way
						this.fireball.setyToMove(-this.fireball.getyToMove());
						tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]=='0') // if next position is nothing
						{
							tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='L'; // move the fireball
							this.fireball.setX(this.fireball.getX()+this.fireball.getxToMove()); // set new positions
							this.fireball.setY(this.fireball.getY()+this.fireball.getyToMove());
						}
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()] == 'P') // if it's the player
						{
							SoundClip.playThis("FIREBALL_B"); // play the sound fireball back to hero
							tabmap2d[this.fireball.getY()][this.fireball.getX()]='0'; // suppress the fireball
							this.fireball.setActive(false); // set her inactive
							this.fireball.setFirstLaunch(true); // set her first launch again
							this.fireball.setxToMove(-this.fireball.getxToMove()); // invert the coordinate to get back to the normal one
							this.fireball.setyToMove(-this.fireball.getyToMove());
						}
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]=='6') // if it's the monster 1
						{
							tabmap2d[this.fireball.getY()][this.fireball.getX()]='0'; // suppress the fireball and the monster
							tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
							this.fireball.setActive(false); // set the fireball inactive
							this.fireball.setFirstLaunch(true); // set her first launch
							this.monster1 = new Monster(0,0,false); // reset the monster 1
						}
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]=='7') // same as before
						{
							tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
							tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
							this.fireball.setActive(false);
							this.monster2 = new Monster(0,0,false);
							this.fireball.setFirstLaunch(true);
						}
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]=='8') // same as before
						{
							tabmap2d[this.fireball.getY()][this.fireball.getX()]='0';
							tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]='0';
							this.fireball.setActive(false);
							this.monster3 = new Monster(0,0,false);
							this.fireball.setFirstLaunch(true);
						}
						if(tabmap2d[this.fireball.getY()+this.fireball.getyToMove()][this.fireball.getX()+this.fireball.getxToMove()]=='9') // same as before
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
		}
		
		else {}
		
	}
}
