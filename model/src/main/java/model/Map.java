package model;

/**
 * The Class Map.
 * 
 * @author Group 5
  */
class Map extends Entity {

    /** The id. */
    private int id_map;

    /** The key. */
    private String	key;

    /** The map. */
    private String	map;

    /**
     * Instantiates a new hello world.
     *
     * @param id_map
     *          the id
     * @param key
     *          the key
     * @param map
     *          the map
     */
    public Map(final int id_map, final String key, final String map) {
        this.setId(id_map);
        this.setKey(key);
        this.setMap(map);
    }

    /**
     * Instantiates a new map.
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
     * @param id_map
     *          the new id
     */
    private void setId(final int id_map) {
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
    private void setKey(final String key) {
        this.key = key;
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    public String getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *          the new map
     */
    public void setMap(final String map) {
        this.map = map;
    }

}
