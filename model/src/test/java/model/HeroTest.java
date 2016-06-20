package model;

import junit.framework.TestCase;

/**
 * Created by Thomas on 20/06/2016.
 */
public class HeroTest extends TestCase {

    private Hero hero;

    public HeroTest()
    {  super();
    }

    public void setUp() throws Exception {
        super.setUp();
        hero = new Hero(0, 0, true);

    }

    public void tearDown() throws Exception {

    }

   /* public void testSelectPosHero() throws Exception {
        hero.SelectPosDoor(1);
        assertEquals("Image is false", "gate_open", hero.getImage());
        assertEquals("Level is false", 104, hero.getToLevel());
    }*/

}