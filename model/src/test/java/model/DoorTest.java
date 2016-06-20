package model;

import junit.framework.TestCase;

/**
 * Created by Thomas on 20/06/2016.
 */
public class DoorTest extends TestCase {

    private Door door;

    public DoorTest()
    {  super();
    }

    public void setUp() throws Exception {
        super.setUp();
        door = new Door(0, 0, true);

    }

    public void tearDown() throws Exception {

    }

    /**
     * Test method for {@link Door#SelectPosDoor(int level)}.
     */
    public void testSelectPosDoor() {
        door.SelectPosDoor(1);
        assertEquals("Image is false", "gate_open", door.getImage());
        assertEquals("Level is false", 104, door.getToLevel());
    }

}