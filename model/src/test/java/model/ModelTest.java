/**
 *
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class ModelTest.
 *
 * @author Group 5
 */
public class ModelTest {

	private Model model;
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
		this.model = new Model();
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
	 * Test method for {@link model.Model#getMap()}.
	 */
	@Test
	public void testGetMap() {
		Assert.assertEquals("", this.model.getMap());
	}

	/**
	 * Test method for {@link model.Model#loadMap(java.lang.String)}.
	 */
	@Test
	public void testGetMapString() {
		this.model.loadMap("m104");
		Assert.assertEquals("Bad Map 104", "122222221G1222222221\n" +
				"30000000303000000003\n" +
				"30000000301221000003\n" +
				"30121212100001100003\n" +
				"3E303Z10000000300003\n" +
				"12121000000000300003\n" +
				"31113000000000121003\n" +
				"12121000000000003003\n" +
				"3C303A10000000P03003\n" +
				"30121210000000003673\n" +
				"3C0C0C30000000003893\n" +
				"12222212222222221221", this.model.getMap());
		this.model.loadMap("m103");
		Assert.assertEquals("Bad Map 103", "00000000000000000000\n" +
				"00012100100101012100\n" +
				"00030001610313030000\n" +
				"00039003030313012000\n" +
				"00030301210303030000\n" +
				"00012103030101012100\n" +
				"00000000000000000000\n" +
				"00012101010121012100\n" +
				"00030303030380030300\n" +
				"00037303030120012100\n" +
				"00030301010300031000\n" +
				"00012100100121010100", this.model.getMap());
		this.model.loadMap("m102");
		Assert.assertEquals("Bad Map 102", "CC2222222222222222CC\n" +
				"C000101012103030000C\n" +
				"30003030303030300003\n" +
				"30001110303030300003\n" +
				"30000300303030300003\n" +
				"30000100121012100003\n" +
				"30000000000000000003\n" +
				"30100010101001003003\n" +
				"30303030003103003003\n" +
				"30113110303013000003\n" +
				"C001010030100100100C\n" +
				"CC2222222222222222CC", this.model.getMap());
		this.model.loadMap("m5");
		Assert.assertEquals("Bad Map 5", "12222222222222222221\n" +
				"30000000000000000003\n" +
				"30000P00011000S00003\n" +
				"12100100033000100121\n" +
				"00110301211210301100\n" +
				"00010301211210301000\n" +
				"00110300033000301100\n" +
				"011CC3C1C33C1C3CC110\n" +
				"11000100033000100011\n" +
				"37000E00011000C00093\n" +
				"38000000000000000063\n" +
				"12222222222222222221", this.model.getMap());
		this.model.loadMap("m4");
		Assert.assertEquals("Bad Map 4", "00122122222222222100\n" +
				"01100100000000000110\n" +
				"11000001C1C1C1C10C11\n" +
				"30011101212121211003\n" +
				"30013300000000030003\n" +
				"30003121012221031003\n" +
				"30013310012100030003\n" +
				"300011P0012100S31003\n" +
				"30012222122222211003\n" +
				"11001C1C1C1C1C118E11\n" +
				"01100000090060070110\n" +
				"00122222222222222100", this.model.getMap());
		this.model.loadMap("m3");
		Assert.assertEquals("Bad Map 3", "12222212222222212211\n" +
				"30000010C0C0C0110031\n" +
				"30P00011000001100031\n" +
				"30000001100601000031\n" +
				"30001100110011000031\n" +
				"30111000010110000031\n" +
				"111000701E1080011C31\n" +
				"300C0001010000000111\n" +
				"30C00111009001100111\n" +
				"3C001100000000110001\n" +
				"122212222222222110S1\n" +
				"11111111111111111111", this.model.getMap());
		this.model.loadMap("m2");
		Assert.assertEquals("Bad Map 2", "00112222222222222221\n" +
				"01100000000000000003\n" +
				"11000000000000000P03\n" +
				"10S0122222221C101221\n" +
				"30003000060000300003\n" +
				"30003012222222122103\n" +
				"3000300007000C300003\n" +
				"30001222222210301221\n" +
				"3000300008000C300003\n" +
				"11103012222221122103\n" +
				"3E0030000900C3C0C003\n" +
				"12221222222221222221", this.model.getMap());
		this.model.loadMap("m1");
		Assert.assertEquals("Bad Map 1", "00000012122222222210\n" +
				"0001221C300000000011\n" +
				"00030C00300000000003\n" +
				"122100003000C0000003\n" +
				"30C01222122222100001\n" +
				"3C00C6000000E0000P0S\n" +
				"30C01222122222100001\n" +
				"122100003000C0000003\n" +
				"00030C00300000000003\n" +
				"0001221C300000000011\n" +
				"00000012122222222210\n" +
				"00000000000000000000", this.model.getMap());
	}

	/**
	 * Test method for {@link model.Model#getScore()}.
	 */
	@Test
	public void testGetScore() {
		Infos.setScore(1);
		Assert.assertEquals("Bad Score", 1, this.model.getScore());
	}

	/**
	 * Test method for {@link model.Model#setScore(int score)}.
	 */
	@Test
	public void testSetScore() {
		this.model.setScore(1);
		Assert.assertEquals("Bad Score", 1, Infos.getScore());
	}

	/**
	 * Test method for {@link model.Model#setLife(int life)}.
	 */
	@Test
	public void testSetLife() {
		this.model.setLife(3);
		Assert.assertEquals("Bad Life", 3, Infos.getLife());
	}

	/**
	 * Test method for {@link model.Model#getLife()}.
	 */
	@Test
	public void testGetLife() {
		Infos.setLife(3);
		Assert.assertEquals("Bad Life", 3, this.model.getLife());
	}

	/**
	 * Test method for {@link model.Model#setGlobalScore(int globalscore)}.
	 */
	@Test
	public void testSetGlobalScore() {
		this.model.setGlobalScore(1000);
		Assert.assertEquals("Bad Global Score", 1000, Infos.getGlobalScore());
	}

	/**
	 * Test method for {@link model.Model#getGlobalScore()}.
	 */
	@Test
	public void testGetGlobalScore() {
		Infos.setGlobalScore(1000);
		Assert.assertEquals("Bad Global Score", 1000, this.model.getGlobalScore());
	}

	/**
	 * Test method for {@link model.Model#setLevel(int level)}.
	 */
	@Test
	public void testSetLevel() {
		this.model.setLevel(1);
		Assert.assertEquals("Bad Level", 1, Infos.getLevel());
	}

	/**
	 * Test method for {@link Model#getDoorLevel()}.
	 */
	@Test
	public void testGetDoorLevel() {
		Infos.setLevel(1);
		Assert.assertEquals("Bad Level", 1, this.model.getLevel());
	}

	/**
	 * Test method for {@link Model#getHighScore()}.
	 */
	@Test
	public void testGetHighScore() {
		this.model.loadHighScore("mapG");
		Assert.assertEquals("Bad Highscore", 600, this.model.getHighScore());
	}

	/**
	 * Test method for {@link Model#putInTabmap(int, int, char)}.
	 */
	@Test
	public void testputInTabmap() {
		this.model.putInTabmap(0, 0, 'T');
		Assert.assertEquals("Bad Char", 'T', this.model.tabmap2d[0][0]);
	}

	/**
	 * Test method for {@link Model#setLastKey(String)}.
	 */
	@Test
	public void testSetLastKey() {
		this.model.setLastKey("UP");
		Assert.assertEquals("Bad String", "UP", this.model.getLastKey());
	}

	/**
	 * There is no argument here, and no move since no key pressed, so it should return false
	 * Test method for {@link Model#isMovePossible()} .
	 */
	@Test
	public void testIsMovePossible() {

		Assert.assertEquals("Bad Boolean", false, this.model.isMovePossible());
	}

	/**
	 * This should decrease the amount of Infos.life and load a map and set a new level
	 * Test method for {@link Model#gameOver()}.
	 */
	@Test
	public void testGameOver() {
		this.model.gameOver();
		Assert.assertEquals("Bad Life", 2, this.model.getLife());
		Assert.assertEquals("Bad Map", "122222221G1222222221\n" +
				"30000000303000000003\n" +
				"30000000301221000003\n" +
				"30121212100001100003\n" +
				"3E303Z10000000300003\n" +
				"12121000000000300003\n" +
				"31113000000000121003\n" +
				"12121000000000003003\n" +
				"3C303A10000000P03003\n" +
				"30121210000000003673\n" +
				"3C0C0C30000000003893\n" +
				"12222212222222221221", this.model.getMap());
		Assert.assertEquals("Bad Level", 104, this.model.getLevel());
	}


	/**
	 * This should update the map state and load a map
	 * Test method for {@link Model#gameOver()}.
	 */
	@Test
	public void testGameEnd() {
		Infos.setLevel(1);
		this.model.gameEnd();
		Assert.assertEquals("Bad MapState", true, Infos.returnMapState(1));
		Assert.assertEquals("Bad Level", 1, this.model.getLevel());
		Assert.assertEquals("Bad Map", "00000012122222222210\n" +
				"0001221C300000000011\n" +
				"00030C00300000000003\n" +
				"122100003000C0000003\n" +
				"30C01222122222100001\n" +
				"3C00C6000000E0000P0S\n" +
				"30C01222122222100001\n" +
				"122100003000C0000003\n" +
				"00030C00300000000003\n" +
				"0001221C300000000011\n" +
				"00000012122222222210\n" +
				"00000000000000000000", this.model.getMap());
	}

	/**
	 * This should return gate_closed, since it's the default Image file
	 * Test method for {@link Model#getImageDoor()}.
	 */
	@Test
	public void testGetImageDoor() {
		Assert.assertEquals("Bad Image String", "gate_closed", this.model.getImageDoor());
	}

	/**
	 * This should return null, since it's there is no default Image file
	 * Test method for {@link Model#getImageHero()}.
	 */
	@Test
	public void testGetImageHero() {
		Assert.assertEquals("Bad Image String", null, this.model.getImageHero());
	}

	/**
	 * Test method for {@link Model#getImageFireBall()}.
	 */
	@Test
	public void testGetImageFireBall() {
		Assert.assertEquals("Bad Image String", null, this.model.getImageFireBall());
	}

}
