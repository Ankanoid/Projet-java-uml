package model;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * The Class DoorTest
 *
 * @author Group 5
 */
public class InfosTest extends TestCase {

    public InfosTest()
    {  super();
    }

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    /**
     * Test method for {@link Infos#resetScores()}.
     */
    public void testResetScores() {
        Infos.resetScores();
        Assert.assertEquals("Bad Score", 0, Infos.getScore());
        Assert.assertEquals("Bad level", 0, Infos.getLevel());
        Assert.assertEquals("Bad global score", 0, Infos.getGlobalScore());
        Assert.assertEquals("Bad life", 3, Infos.getLife());
    }

    /**
     * Test method for {@link Infos#allLevelDone()}.
     */
    public void testAllLevelDone() {
        Assert.assertEquals("Bad state", false, Infos.allLevelDone());
    }

}