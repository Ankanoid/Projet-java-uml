package model;

/**
 * The Class HighScore.
  */
class HighScore extends Entity {

    /** The id. */
    private int id;

    /** The key. */
    private String	key;

    /** The highscore. */
    private int highscore;

    /**
     * Instantiates a new hello world.
     *
     * @param id
     *          the id
     * @param key
     *          the key
     * @param highscore
     *          the highscore
     */
    public HighScore(final int id, final String map, final int highscore) {
        this.setId(id);
        this.setKey(key);
        this.setHighScore(highscore);
    }

    /**
     * Instantiates a new HighScore
     */
    public HighScore() {
        this(0, "", 0);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *          the new id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *          the new key
     */
    public void setKey(final String key) {
        this.key = key;
    }

    /**
     * Gets the highscore.
     *
     * @return the highscore
     */
    public int getHighScore() {
        return this.highscore;
    }

    /**
     * Sets the highscore.
     *
     * @param highscore
     *          the new highscore
     */
    public void setHighScore(final int highscore) {
        this.highscore = highscore;
    }

}
