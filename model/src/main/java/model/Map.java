package model;

/**
 * The Class HelloWorld.
  */
class Map extends Entity {

    /** The id. */
    private int id_map;

    /** The key. */
    private String	key;

    /** The message. */
    private String	map;

    /**
     * Instantiates a new hello world.
     *
     * @param id
     *          the id
     * @param key
     *          the key
     * @param message
     *          the message
     */
    public Map(final int id_map, final String key, final String map) {
        this.setId(id_map);
        this.setKey(key);
        this.setMap(map);
    }

    /**
     * Instantiates a new hello world.
     */
    public Map() {
        this(0, "", "");
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id_map;
    }

    /**
     * Sets the id.
     *
     * @param id
     *          the new id
     */
    public void setId(final int id_map) {
        this.id_map = id_map;
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
     * Gets the message.
     *
     * @return the message
     */
    public String getMap() {
        return this.map;
    }

    /**
     * Sets the message.
     *
     * @param message
     *          the new message
     */
    public void setMap(final String map) {
        this.map = map;
    }

}
