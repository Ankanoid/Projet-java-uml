package model;

import junit.framework.TestCase;

/**
 * The Class FireBallTest
 *
 * @author Group 5
 */
public class FireBallTest extends TestCase {

    private FireBall fireball;

    public FireBallTest()
    {  super();
    }

    public void setUp() throws Exception {
        super.setUp();
        fireball = new FireBall(0, 0, true, true);

    }

    public void tearDown() throws Exception {

    }

    /**
     * Test method for {@link FireBall#SelectMoveFireBall()}.
     */
    public void testSelectMoveFireBall() {
        fireball.setMove("UP");
        fireball.SelectMoveFireBall();
        assertEquals("Bad move UPy", -1, fireball.getyToMove());
        assertEquals("Bad move UPx", 0, fireball.getxToMove());
        fireball.setMove("LEFT");
        fireball.SelectMoveFireBall();
        assertEquals("Bad move LEFTy", 0, fireball.getyToMove());
        assertEquals("Bad move LEFTx", -1, fireball.getxToMove());
        fireball.setMove("RIGHT");
        fireball.SelectMoveFireBall();
        assertEquals("Bad move RIGHTy", 0, fireball.getyToMove());
        assertEquals("Bad move RIGHTx", 1, fireball.getxToMove());
        fireball.setMove("DOWN");
        fireball.SelectMoveFireBall();
        assertEquals("Bad move DOWNy", 1, fireball.getyToMove());
        assertEquals("Bad move DOWNx", 0, fireball.getxToMove());
        fireball.setMove("LEFTUP");
        fireball.SelectMoveFireBall();
        assertEquals("Bad move DOWNy", -1, fireball.getyToMove());
        assertEquals("Bad move DOWNx", -1, fireball.getxToMove());
        fireball.setMove("RIGHTUP");
        fireball.SelectMoveFireBall();
        assertEquals("Bad move DOWNy", -1, fireball.getyToMove());
        assertEquals("Bad move DOWNx", 1, fireball.getxToMove());
        fireball.setMove("LEFTDOWN");
        fireball.SelectMoveFireBall();
        assertEquals("Bad move DOWNy", 1, fireball.getyToMove());
        assertEquals("Bad move DOWNx", -1, fireball.getxToMove());
        fireball.setMove("RIGHTDOWN");
        fireball.SelectMoveFireBall();
        assertEquals("Bad move DOWNy", 1, fireball.getyToMove());
        assertEquals("Bad move DOWNx", 1, fireball.getxToMove());
    }

    /**
     * Test method for {@link FireBall#SelectPosGenFireBall()}.
     */
    public void testSelectPosGenFireBall() {
        fireball.setPosGen(1);
        fireball.SelectPosGenFireBall();
        assertEquals("Bad Image 1", "fireball_2", fireball.getImage());
        fireball.setPosGen(2);
        fireball.SelectPosGenFireBall();
        assertEquals("Bad Image 2", "fireball_3", fireball.getImage());
        fireball.setPosGen(3);
        fireball.SelectPosGenFireBall();
        assertEquals("Bad Image 3", "fireball_5", fireball.getImage());
        fireball.setPosGen(4);
        fireball.SelectPosGenFireBall();
        assertEquals("Bad Image 4", "fireball_4", fireball.getImage());
        fireball.setPosGen(5);
        fireball.SelectPosGenFireBall();
        assertEquals("Bad Image 5", "fireball_1", fireball.getImage());
    }

    /**
     * Test method for {@link FireBall#toHero(int, int)}.
     */
    public void testToHero() {
        fireball.toHero(1,1);
        assertEquals("Bad yToMove", 1, fireball.getyToMove());
        assertEquals("Bad xToMove", 1, fireball.getxToMove());
        fireball.toHero(-1,-1);
        assertEquals("Bad yToMove", -1, fireball.getyToMove());
        assertEquals("Bad xToMove", -1, fireball.getxToMove());
        fireball.toHero(1,-1);
        assertEquals("Bad yToMove", 1, fireball.getyToMove());
        assertEquals("Bad xToMove", -1, fireball.getxToMove());
        fireball.toHero(-1,1);
        assertEquals("Bad yToMove", -1, fireball.getyToMove());
        assertEquals("Bad xToMove", 1, fireball.getxToMove());
        fireball.toHero(1,0);
        assertEquals("Bad yToMove", 1, fireball.getyToMove());
        assertEquals("Bad xToMove", 0, fireball.getxToMove());
        fireball.toHero(-1,0);
        assertEquals("Bad yToMove", -1, fireball.getyToMove());
        assertEquals("Bad xToMove", 0, fireball.getxToMove());
        fireball.toHero(0,1);
        assertEquals("Bad yToMove", 0, fireball.getyToMove());
        assertEquals("Bad xToMove", 1, fireball.getxToMove());
        fireball.toHero(0,-1);
        assertEquals("Bad yToMove", 0, fireball.getyToMove());
        assertEquals("Bad xToMove", -1, fireball.getxToMove());
    }
}