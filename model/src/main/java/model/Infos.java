package model;

public class Infos {

	private static int score = 0, level = 0;

	public static int getLevel() {
		return level;
	}

	public static void setLevel(int level) {
		Infos.level = level;
	}

	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		Infos.score = score;
	}
	
}
