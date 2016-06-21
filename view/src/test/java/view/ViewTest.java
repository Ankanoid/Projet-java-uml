package view;

import contract.ControllerOrder;
import junit.framework.TestCase;
import org.junit.*;

import java.awt.event.KeyEvent;

/**
 * The Class ViewTest.
 *
 * @author Group 5
 */
public class ViewTest extends TestCase {

    private View view;

    /**
     * Sets the up before class.
     *
     * @throws Exception
     *           the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * Tear down after class.
     *
     * @throws Exception
     *           the exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * Sets the up.
     *
     * @throws Exception
     *           the exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Tear down.
     *
     * @throws Exception
     *           the exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link view.View#keyCodeToControllerOrder(int)}.
        */
    @Test
    public void testKeyCodeToControllerOrder() {

        assertEquals("Bad order", ControllerOrder.MoveLeftUp, view.keyCodeToControllerOrder(1406));
        assertEquals("Bad order", ControllerOrder.MoveRightUp, view.keyCodeToControllerOrder(1482));
        assertEquals("Bad order", ControllerOrder.MoveLeftDown, view.keyCodeToControllerOrder(1480));
        assertEquals("Bad order", ControllerOrder.MoveRightDown, view.keyCodeToControllerOrder(1560));
        assertEquals("Bad order", ControllerOrder.HomeMap, view.keyCodeToControllerOrder(KeyEvent.VK_ENTER));
        assertEquals("Bad order", ControllerOrder.Fireball, view.keyCodeToControllerOrder(KeyEvent.VK_SPACE));
        assertEquals("Bad order", ControllerOrder.DisplayHighscores, view.keyCodeToControllerOrder(KeyEvent.VK_H));
        assertEquals("Bad order", ControllerOrder.MoveLeft, view.keyCodeToControllerOrder(KeyEvent.VK_LEFT));
        assertEquals("Bad order", ControllerOrder.MoveRight, view.keyCodeToControllerOrder(KeyEvent.VK_RIGHT));
        assertEquals("Bad order", ControllerOrder.MoveUp, view.keyCodeToControllerOrder(KeyEvent.VK_UP));
        assertEquals("Bad order", ControllerOrder.MoveDown, view.keyCodeToControllerOrder(KeyEvent.VK_DOWN));
    }
}