package model;

/**
 * The Class Infos.
 * 
 * @author Group 5
 *
 */
public class Infos {

	/**
	 * int score contains the actual map score
	 * int globalscore contains the actual global score
	 * int level contains the actual level
	 * int life contains the number of life available
	 */
	private static int score = 0, level = 0, globalScore = 0, life = 3;
	
	/**
	 * Boolean Array which contains the state of the maps, if they are done or not (if done = true, if not = false)
	 */
	private static boolean[] maps = {false, false, false, false, false};

	/**
	 * Getter of level, gets the actual level
	 * @return level
	 */
	public static int getLevel() {
		return level;
	}

	/**
	 * Setter of level, set the new level entered as the actual level
	 * @param level
	 */
	public static void setLevel(int level) {
		Infos.level = level;
	}

	/**
	 * Getter of score, gets the actual score (for the map only)
	 * @return score
	 */
	public static int getScore() {
		return score;
	}

	/**
	 * Setter of score, set the new actual score (generally just increased by 100)
	 * @param score
	 */
	public static void setScore(int score) {
		Infos.score = score;
	}

	/**
	 * Getter of globalscore, gets the global score
	 * @return global score
	 */
	public static int getGlobalScore() {
		return globalScore;
	}

	/**
	 * Getter of life, gets the number of life available
	 * @return
	 */
	public static int getLife() {
		return life;
	}

	/**
	 * Setter of life, sets the new number of life (generally decreased by 1)
	 * @param life
	 */
	public static void setLife(int life) {
		Infos.life = life;
	}

	/**
	 * Setter of globalscore, sets the new actual global score (generally increased by 100)
	 * @param globalscore
	 */
	public static void setGlobalScore(int globalscore) {
		Infos.globalScore = globalscore;
	}

	/**
	 * Function which reset the actual score, the actual level, the globalscore, the number of life (settled at 3), and all the maps at false (undone)
	 */
	public static void resetScores()
	{
		score = 0;
		level = 0;
		globalScore = 0;
		life = 3;
		for(int i = 0; i<maps.length;i++)
		maps[i] = false;
	}
	
	/**
	 * Function which update the map when finished (enter true  as done instead of false)
	 */
	public static void updateMap()
	{
		maps[level-1] = true;
	}
	
	/**
	 * Function which return the state of a given map (to check if the level is already done or not)
	 * @param goLevel
	 * @return boolean - true if the map is done, false if not
	 */
	public static boolean returnMapState(int goLevel)
	{
		return maps[goLevel-1];
	}
	
	/**
	 * Function which check if all the level are done or not
	 * @return boolean - true if all maps are done, false if not
	 */
	public static boolean allLevelDone()
	{
		for(boolean b : maps) if(!b) return false;
	    return true;
	}
}
