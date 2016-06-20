package model;

import junit.framework.TestCase;

/**
 * Created by Thomas on 20/06/2016.
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

    public void testSelectMoveFireBall() throws Exception {
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

    public void testSelectPosGenFireBall() throws Exception {
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

}