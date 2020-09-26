import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Testing class for MarbleSolitaireModelImpl.
 */
public class MarbleSolitaireModelImplTest {

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  MarbleSolitaireModelImpl b1;
  MarbleSolitaireModelImpl b2;
  MarbleSolitaireModelImpl b3;
  MarbleSolitaireModelImpl b4;
  MarbleSolitaireModelImpl b5;

  private void initTests() {
    b1 = new MarbleSolitaireModelImpl();
    b2 = new MarbleSolitaireModelImpl(4, 4);
    b3 = new MarbleSolitaireModelImpl(5);
    b4 = new MarbleSolitaireModelImpl(5, 4, 4);
    b5 = new MarbleSolitaireModelImpl(3, 3, 3);
  }

  private void initMidGame() {
    initTests();
    b1.move(5, 3, 3, 3);
    b1.move(2, 3, 4, 3);
    b1.move(3, 5, 3, 3);
    b1.move(3, 3, 5, 3);
    b1.move(2, 1, 2, 3);
    b1.move(2, 4, 2, 2);
    b1.move(0, 3, 2, 3);
    b1.move(2, 3, 2, 1);
    b1.move(2, 0, 2, 2);
    b1.move(2, 6, 2, 4);
    b1.move(1, 4, 3, 4);
    b1.move(4, 4, 2, 4);
    b1.move(4, 1, 4, 3);
    b1.move(3, 1, 3, 3);
  }

  private void initEndGame() {
    initTests();
    b1.move(5, 3, 3, 3);
    b1.move(2, 3, 4, 3);
    b1.move(3, 5, 3, 3);
    b1.move(3, 3, 5, 3);
    b1.move(2, 1, 2, 3);
    b1.move(2, 4, 2, 2);
    b1.move(0, 3, 2, 3);
    b1.move(2, 3, 2, 1);
    b1.move(2, 0, 2, 2);
    b1.move(2, 6, 2, 4);
    b1.move(1, 4, 3, 4);
    b1.move(4, 4, 2, 4);
    b1.move(4, 1, 4, 3);
    b1.move(3, 1, 3, 3);
    b1.move(4,0,2,0);
    b1.move(4,3,2,3);
    b1.move(2,3,2,1);
    b1.move(2,0,2,2);
    b1.move(4,6,4,4);
    b1.move(5,4,3,4);
    b1.move(3,4,1,4);
    b1.move(0,4,2,4);
    b1.move(6,2,4,2);
    b1.move(6,3,4,3);
    b1.move(4,2,4,4);
    b1.move(1,2,3,2);
  }

  @Test
  public void testGetGameState() {
    initTests();
    assertEquals("    O O O\n"
               + "    O O O\n"
               + "O O O O O O O\n"
               + "O O O _ O O O\n"
               + "O O O O O O O\n"
               + "    O O O\n"
               + "    O O O", b1.getGameState());

    assertEquals("    O O O\n"
               + "    O O O\n"
               + "O O O O O O O\n"
               + "O O O O O O O\n"
               + "O O O O _ O O\n"
               + "    O O O\n"
               + "    O O O", b2.getGameState());

    assertEquals("        O O O O O\n"
               + "        O O O O O\n"
               + "        O O O O O\n"
               + "        O O O O O\n"
               + "O O O O O O O O O O O O O\n"
               + "O O O O O O O O O O O O O\n"
               + "O O O O O O _ O O O O O O\n"
               + "O O O O O O O O O O O O O\n"
               + "O O O O O O O O O O O O O\n"
               + "        O O O O O\n"
               + "        O O O O O\n"
               + "        O O O O O\n"
               + "        O O O O O",
            b3.getGameState());

    assertEquals("        O O O O O\n"
               + "        O O O O O\n"
               + "        O O O O O\n"
               + "        O O O O O\n"
               + "O O O O _ O O O O O O O O\n"
               + "O O O O O O O O O O O O O\n"
               + "O O O O O O O O O O O O O\n"
               + "O O O O O O O O O O O O O\n"
               + "O O O O O O O O O O O O O\n"
               + "        O O O O O\n"
               + "        O O O O O\n"
               + "        O O O O O\n"
               + "        O O O O O",
            b4.getGameState());

    assertEquals("    O O O\n"
               + "    O O O\n"
               + "O O O O O O O\n"
               + "O O O _ O O O\n"
               + "O O O O O O O\n"
               + "    O O O\n"
               + "    O O O", b5.getGameState());

    initEndGame();
    assertEquals(
              "    O _ _\n"
            + "    _ _ _\n"
            + "_ _ _ _ O _ _\n"
            + "_ _ O _ _ _ O\n"
            + "_ _ _ _ O _ _\n"
            + "    _ _ _\n"
            + "    _ _ O", b1.getGameState());
  }

  @Test
  public void testScore1() {
    initTests();
    assertEquals(32, b1.getScore());
    b1.move(5, 3, 3, 3);
    assertEquals(31, b1.getScore());
    b1.move(2, 3, 4, 3);
    assertEquals(30, b1.getScore());
    b1.move(3, 5, 3, 3);
    assertEquals(29, b1.getScore());
    b1.move(3, 3, 5, 3);
    assertEquals(28, b1.getScore());
    b1.move(2, 1, 2, 3);
    assertEquals(27, b1.getScore());
    b1.move(2, 4, 2, 2);
    assertEquals(26, b1.getScore());
    b1.move(0, 3, 2, 3);
    assertEquals(25, b1.getScore());
    b1.move(2, 3, 2, 1);
    assertEquals(24, b1.getScore());
    b1.move(2, 0, 2, 2);
    assertEquals(23, b1.getScore());
    b1.move(2, 6, 2, 4);
    assertEquals(22, b1.getScore());
    b1.move(1, 4, 3, 4);
    assertEquals(21, b1.getScore());
    b1.move(4, 4, 2, 4);
    assertEquals(20, b1.getScore());
    b1.move(4, 1, 4, 3);
    assertEquals(19, b1.getScore());
    b1.move(3, 1, 3, 3);
    assertEquals(18, b1.getScore());
  }

  @Test
  public void testGetScore2() {
    initTests();
    assertEquals(104, b3.getScore());
    b3.move(8,6,6,6);
    assertEquals(103, b3.getScore());
    b3.move(7,8,7,6);
    assertEquals(102, b3.getScore());
    b3.move(8,8,8,6);
    assertEquals(101, b3.getScore());
    b3.move(10,8,8,8);
    assertEquals(100, b3.getScore());
    b3.move(10,7,8,7);
    assertEquals(99, b3.getScore());
    b3.move(5,7,7,7);
    assertEquals(98, b3.getScore());
    b3.move(5,8,7,8);
    assertEquals(97, b3.getScore());
    b3.move(12,7,10,7);
    assertEquals(96, b3.getScore());
    b3.move(12,8,10,8);
    assertEquals(95, b3.getScore());
    b3.move(7,7,9,7);
    assertEquals(94, b3.getScore());
    b3.move(7,8,9,8);
    assertEquals(93, b3.getScore());
    b3.move(8,10,8,8);
    assertEquals(92, b3.getScore());
    b3.move(7,10,7,8);
    assertEquals(91, b3.getScore());

    initEndGame();
    assertEquals(6, b1.getScore());

  }


  @Test
  public void testHashcode() {
    initTests();
    assertEquals(b1.hashCode(), b5.hashCode());
    assertNotEquals(b1.hashCode(), b3.hashCode());
  }

  @Test
  public void testEquals() {
    initTests();
    assertEquals(b1, b5);
    assertNotEquals(b1, b3);
  }

  @Test
  public void testGameOver() {
    initTests();
    assertFalse(b1.isGameOver());
    initEndGame();
    assertTrue(b1.isGameOver());
  }

  @Test
  public void testValidMoves() {
    initTests();
    b1.move(5, 3, 3, 3);
    b1.move(2, 3, 4, 3);
    b1.move(3, 5, 3, 3);
    b1.move(3, 3, 5, 3);
    assertEquals(
              "    O O O\n"
            + "    O O O\n"
            + "O O O _ O O O\n"
            + "O O O _ _ _ O\n"
            + "O O O _ O O O\n"
            + "    O O O\n"
            + "    O O O", b1.getGameState());
    b1.move(2, 1, 2, 3);
    b1.move(2, 4, 2, 2);
    assertEquals(
                      "    O O O\n"
                    + "    O O O\n"
                    + "O _ O _ _ O O\n"
                    + "O O O _ _ _ O\n"
                    + "O O O _ O O O\n"
                    + "    O O O\n"
                    + "    O O O", b1.getGameState());
    b1.move(0, 3, 2, 3);
    b1.move(2, 3, 2, 1);
    assertEquals(
                      "    O _ O\n"
                    + "    O _ O\n"
                    + "O O _ _ _ O O\n"
                    + "O O O _ _ _ O\n"
                    + "O O O _ O O O\n"
                    + "    O O O\n"
                    + "    O O O", b1.getGameState());
    b1.move(2, 0, 2, 2);
    b1.move(2, 6, 2, 4);
    assertEquals(
                      "    O _ O\n"
                    + "    O _ O\n"
                    + "_ _ O _ O _ _\n"
                    + "O O O _ _ _ O\n"
                    + "O O O _ O O O\n"
                    + "    O O O\n"
                    + "    O O O", b1.getGameState());
    b1.move(1, 4, 3, 4);
    b1.move(4, 4, 2, 4);
    b1.move(4, 1, 4, 3);
    assertEquals(
                      "    O _ O\n"
                    + "    O _ _\n"
                    + "_ _ O _ O _ _\n"
                    + "O O O _ _ _ O\n"
                    + "O _ _ O _ O O\n"
                    + "    O O O\n"
                    + "    O O O", b1.getGameState());
    b1.move(3, 1, 3, 3);

  }


  @Test (expected = IllegalArgumentException.class)
  public void testToPositionInvalid() {
    initTests();
    b1.move(4, 3, 5, 33);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testToPositionInvalid2() {
    initTests();
    b1.move(3, 3, 15, 13);
    fail();
  }


  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionInvalid() {
    initTests();
    b1.move(0, 0, 3, 3);
    fail();
  }


  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionInvalid2() {
    initTests();
    b1.move(1, 3, 3, 3);
    assertEquals(
              "    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", b1.getGameState());
    b1.move(1, 3, 3, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testDiagonalMove() {
    initTests();
    b1.move(5, 3, 3, 4);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testDiagonalMove2() {
    initTests();
    b1.move(2, 3, 4, 5);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPositionNot2Away() {
    initTests();
    b1.move(5, 3, 6, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPositionNot2Away2() {
    initTests();
    b1.move(5, 3, 6, 5);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testToPositionNotEmpty() {
    initTests();
    b1.move(6, 3, 4, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testToPositionNotEmpty2() {
    initTests();
    b1.move(2, 3, 4, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionEmpty() {
    initTests();
    b1.move(3, 3, 5, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testFromPositionEmpty2() {
    initTests();
    b1.move(3, 3, 3, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPositionJumpedIsEmpty() {
    initTests();
    b1.move(4, 3, 2, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testPositionJumpedIsEmpty2() {
    initTests();
    b1.move(3, 2, 3, 4);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidEmptyCell() {
    new MarbleSolitaireModelImpl(0, 0);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidEmptyCell2() {
    new MarbleSolitaireModelImpl(3, 0, 0);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNegativeThickness() {
    new MarbleSolitaireModelImpl(-10);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNegativeThickness2() {
    new MarbleSolitaireModelImpl(-10, 3, 3);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEvenThickness() {
    new MarbleSolitaireModelImpl(2);
    fail();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEvenThickness2() {
    new MarbleSolitaireModelImpl(4);
    fail();
  }

}