import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Testing class for EuropeanSolitaireModelImpl.
 */
public class EuropeanSolitaireModelImplTest {

  @Test
  public void testNoArgConstructor() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", m.getGameState());
  }

  @Test
  public void testSingleArgConstructor() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(3);
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", m.getGameState());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSingleArgConstructorFail() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(0);
    fail();
  }

  @Test
  public void testTwoArgConstructor() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(3, 3);
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", m.getGameState());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testTwoArgConstructorFail() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(0, 10);
    fail();
  }

  @Test
  public void testThreeArgConstructor() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(3,3, 3);
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", m.getGameState());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testThreeArgConstructorFail() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(0, 3, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testThreeArgConstructorFail2() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl(4, 3, 23);
  }

  @Test
  public void testGameState() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", m.getGameState());
    MarbleSolitaireModel m2 = new EuropeanSolitaireModelImpl(5);
    assertEquals("        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O _ O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", m2.getGameState());
  }

  @Test
  public void testHashcode() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    MarbleSolitaireModel m1 = new EuropeanSolitaireModelImpl(3, 3, 3);
    assertEquals(m1.hashCode(), m.hashCode());
  }

  @Test
  public void testToString() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", m.toString());
  }

  @Test
  public void testEquals() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    MarbleSolitaireModel m1 = new EuropeanSolitaireModelImpl(3, 3, 3);
    MarbleSolitaireModel m2 = new EuropeanSolitaireModelImpl(5, 3, 3);
    assertEquals(m, m1);
    assertNotEquals(m1, m2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testToPositionInvalid() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(4, 3, 5, 33);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testToPositionInvalid2() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(3, 3, 15, 13);
    fail();
  }


  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionInvalid() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(0, 0, 3, 3);
    fail();
  }


  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionInvalid2() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(1, 3, 3, 3);
    m.move(1, 3, 3, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testDiagonalMove() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(5, 3, 3, 4);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testDiagonalMove2() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(2, 3, 4, 5);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPositionNot2Away() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(5, 3, 6, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPositionNot2Away2() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(5, 3, 6, 5);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testToPositionNotEmpty() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(6, 3, 4, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testToPositionNotEmpty2() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(2, 3, 4, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionEmpty() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(3, 3, 5, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionEmpty2() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(3, 3, 3, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPositionJumpedIsEmpty() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(4, 3, 2, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPositionJumpedIsEmpty2() {
    MarbleSolitaireModel m = new EuropeanSolitaireModelImpl();
    m.move(3, 2, 3, 4);
    fail();
  }

}