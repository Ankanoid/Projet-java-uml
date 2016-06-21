package model;

import junit.framework.TestCase;

/**
 * The Class DoorTest
 *
 * @author Group 5
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

    /**
     * Test method for {@link Hero#SelectPosGenHero()}.
     */
    public void testSelectPosHero() {
        hero.setMove("LEFT");
        hero.SelectPosHero();
        assertEquals("Image is false", "lorann_l", hero.getImage());
        assertEquals("yToMove is false", 0, hero.getyToMove());
        assertEquals("xToMove is false", -1, hero.getxToMove());
        hero.setMove("RIGHT");
        hero.SelectPosHero();
        assertEquals("Image is false", "lorann_r", hero.getImage());
        assertEquals("yToMove is false", 0, hero.getyToMove());
        assertEquals("xToMove is false", 1, hero.getxToMove());
        hero.setMove("UP");
        hero.SelectPosHero();
        assertEquals("Image is false", "lorann_u", hero.getImage());
        assertEquals("yToMove is false", -1, hero.getyToMove());
        assertEquals("xToMove is false", 0, hero.getxToMove());
        hero.setMove("DOWN");
        hero.SelectPosHero();
        assertEquals("Image is false", "lorann_b", hero.getImage());
        assertEquals("yToMove is false", 1, hero.getyToMove());
        assertEquals("xToMove is false", 0, hero.getxToMove());
        hero.setMove("LEFTUP");
        hero.SelectPosHero();
        assertEquals("Image is false", "lorann_ul", hero.getImage());
        assertEquals("yToMove is false", -1, hero.getyToMove());
        assertEquals("xToMove is false", -1, hero.getxToMove());
        hero.setMove("RIGHTUP");
        hero.SelectPosHero();
        assertEquals("Image is false", "lorann_ur", hero.getImage());
        assertEquals("yToMove is false", -1, hero.getyToMove());
        assertEquals("xToMove is false", 1, hero.getxToMove());
        hero.setMove("LEFTDOWN");
        hero.SelectPosHero();
        assertEquals("Image is false", "lorann_bl", hero.getImage());
        assertEquals("yToMove is false", 1, hero.getyToMove());
        assertEquals("xToMove is false", -1, hero.getxToMove());
        hero.setMove("RIGHTDOWN");
        hero.SelectPosHero();
        assertEquals("Image is false", "lorann_br", hero.getImage());
        assertEquals("yToMove is false", 1, hero.getyToMove());
        assertEquals("xToMove is false", 1, hero.getxToMove());
        hero.setMove("NOPE");
        hero.SelectPosHero();
        assertEquals("yToMove is false", 0, hero.getyToMove());
        assertEquals("xToMove is false", 0, hero.getxToMove());
    }

    /**
     * Test method for {@link Hero#SelectPosGenHero()}.
     */
    public void testSelectPosGenHero() {
        hero.setPosGen(1);
        hero.SelectPosGenHero();
        assertEquals("Image String is false", "lorann_u", hero.getImage());
        hero.setPosGen(2);
        hero.SelectPosGenHero();
        assertEquals("Image String is false", "lorann_ur", hero.getImage());
        hero.setPosGen(3);
        hero.SelectPosGenHero();
        assertEquals("Image String is false", "lorann_r", hero.getImage());
        hero.setPosGen(4);
        hero.SelectPosGenHero();
        assertEquals("Image String is false", "lorann_br", hero.getImage());
        hero.setPosGen(5);
        hero.SelectPosGenHero();
        assertEquals("Image String is false", "lorann_b", hero.getImage());
        hero.setPosGen(6);
        hero.SelectPosGenHero();
        assertEquals("Image String is false", "lorann_bl", hero.getImage());
        hero.setPosGen(7);
        hero.SelectPosGenHero();
        assertEquals("Image String is false", "lorann_l", hero.getImage());
        hero.setPosGen(8);
        hero.SelectPosGenHero();
        assertEquals("Image String is false", "lorann_ul", hero.getImage());
        hero.setPosGen(0);
        hero.SelectPosGenHero();
        assertEquals("Image String is false", "lorann_ul", hero.getImage());

    }

}