import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Testing class for TriangleSolitaireModelImpl.
 */
public class TriangleSolitaireModelImplTest {

  @Test
  public void testNoArgConstructor() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", m.getGameState());
  }

  @Test
  public void testSingleArgConstructor() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(3);
    assertEquals("  _\n"
            + " O O\n"
            + "O O O", m.getGameState());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSingleArgConstructorFail() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(0);
    fail();
  }

  @Test
  public void testTwoArgConstructor() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(3, 3);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O _\n"
            + "O O O O O", m.getGameState());
    MarbleSolitaireModel m2 = new TriangleSolitaireModelImpl(3, 0);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " _ O O O\n"
            + "O O O O O", m2.getGameState());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testTwoArgConstructorFail() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(0, 10);
    fail();
  }

  @Test
  public void testThreeArgConstructor() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(5,3, 3);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O _\n"
            + "O O O O O", m.getGameState());
    MarbleSolitaireModel m2 = new TriangleSolitaireModelImpl(3,2, 2);
    assertEquals("  O\n"
            + " O O\n"
            + "O O _", m2.getGameState());

  }

  @Test (expected = IllegalArgumentException.class)
  public void testThreeArgConstructorFail() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(0, 3, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testThreeArgConstructorFail2() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(4, 3, 23);
    fail();
  }

  @Test
  public void testGameState() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", m.getGameState());
    m.move(2,2,0,0);
    assertEquals("    O\n"
            + "   O _\n"
            + "  O O _\n"
            + " O O O O\n"
            + "O O O O O", m.getGameState());
    m.move(4,4,2,2);
    assertEquals("    O\n"
            + "   O _\n"
            + "  O O O\n"
            + " O O O _\n"
            + "O O O O _", m.getGameState());
    MarbleSolitaireModel m2 = new TriangleSolitaireModelImpl(7, 2, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O _\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", m2.getGameState());
    MarbleSolitaireModel m3 = new TriangleSolitaireModelImpl(3, 2, 0);
    assertEquals("  O\n"
            + " O O\n"
            + "_ O O", m3.getGameState());
  }

  @Test
  public void testScore() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    assertEquals(14, m.getScore());
    m.move(2,2,0,0);
    assertEquals(13, m.getScore());
    m.move(4,4,2,2);
    assertEquals(12, m.getScore());
    m.move(3,1,3,3);
    assertEquals(11, m.getScore());
    m.move(3,3,1,1);
    assertEquals(10, m.getScore());
    m.move(4,2,4,4);
    assertEquals(9, m.getScore());
    m.move(4,0,4,2);
    assertEquals(8, m.getScore());
    m.move(0,0,2,2);
    assertEquals(7, m.getScore());
    m.move(1,0,3,2);
    assertEquals(6, m.getScore());
    m.move(2,0,4,0);
    assertEquals(5, m.getScore());
  }

  @Test
  public void testHashcode() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    MarbleSolitaireModel m1 = new TriangleSolitaireModelImpl(5, 0, 0);
    assertEquals(m1.hashCode(), m.hashCode());
  }

  @Test
  public void testToString() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", m.toString());
  }

  @Test
  public void testEquals() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    MarbleSolitaireModel m1 = new TriangleSolitaireModelImpl(5, 0, 0);
    MarbleSolitaireModel m2 = new TriangleSolitaireModelImpl(5, 1, 0);
    assertEquals(m, m1);
    assertNotEquals(m1, m2);
  }

  @Test
  public void testSingleMove() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl(3, 0);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " _ O O O\n"
            + "O O O O O", m.getGameState());
    m.move(3,2,3,0);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O _ _ O\n"
            + "O O O O O", m.getGameState());
  }

  @Test
  public void testDiagonalMove() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(2,2,0,0);
    assertEquals("    O\n"
            + "   O _\n"
            + "  O O _\n"
            + " O O O O\n"
            + "O O O O O", m.getGameState());
  }


  @Test
  public void testGameOver() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    assertFalse(m.isGameOver());
    m.move(2,2,0,0);
    m.move(4,4,2,2);
    assertFalse(m.isGameOver());
    m.move(3,1,3,3);
    assertFalse(m.isGameOver());
    m.move(3,3,1,1);
    assertFalse(m.isGameOver());
    m.move(4,2,4,4);
    m.move(4,0,4,2);
    assertFalse(m.isGameOver());
    m.move(0,0,2,2);
    m.move(1,0,3,2);
    assertFalse(m.isGameOver());
    m.move(2,0,4,0);
    assertTrue(m.isGameOver());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testToPositionInvalid() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(4, 3, 5, 33);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testToPositionInvalid2() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(3, 3, 15, 13);
    fail();
  }


  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionInvalid() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(0, 0, 3, 3);
    fail();
  }


  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionInvalid2() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(1, 3, 3, 3);
    fail();
  }


  @Test (expected = IllegalArgumentException.class)
  public void testPositionNot2Away() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(5, 3, 6, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPositionNot2Away2() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(5, 3, 6, 5);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testToPositionNotEmpty() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(6, 3, 4, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testToPositionNotEmpty2() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(2, 3, 4, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionEmpty() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(3, 3, 5, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionEmpty2() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(3, 3, 3, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPositionJumpedIsEmpty() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(4, 3, 2, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPositionJumpedIsEmpty2() {
    MarbleSolitaireModel m = new TriangleSolitaireModelImpl();
    m.move(3, 2, 3, 4);
    fail();
  }




}