import org.junit.Test;

import java.io.StringReader;
import java.util.Arrays;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the MarbleSolitaireController.
 */
public class MarbleSolitaireControllerImplTest {


  @Test(expected = IllegalStateException.class)
  public void testNoInput() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    MarbleSolitaireController c =
            new MarbleSolitaireControllerImpl(new StringReader(""), new StringBuilder());
    c.playGame(m);
    fail();
  }

  @Test
  public void testCompleteGame() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c =
            new MarbleSolitaireControllerImpl(new StringReader("6 4 4 4 3 4 "
                    + "5 4 4 6 4 4 4 4 6 4 3 2 3 4 3 5 3 3 1 4 3 4 3 4 3 2 3 1 3"
                    + " 3 3 7 3 5 2 5 4 5 5 5 3 5 5 2 5 4 4 2 4 4 5 1 3 1 5 4 3"
                    + " 4 3 4 3 2 3 1 3 3 5 7 5 5 6 5 4 5 4 5 2 5 1 5 3 5 7 3 5"
                    + " 3 7 4 5 4 5 3 5 5 2 3 4 3"), gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(217, lines.length);
    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 9, lines.length));
    assertEquals("Game over!\n"
            + "    O _ _\n"
            + "    _ _ _\n"
            + "_ _ _ _ O _ _\n"
            + "_ _ O _ _ _ O\n"
            + "_ _ _ _ O _ _\n"
            + "    _ _ _\n"
            + "    _ _ O\n"
            + "Score: 6", lastMsg);
  }

  @Test
  public void testCompleteGameWithInvalidMoves() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c =
            new MarbleSolitaireControllerImpl(new StringReader("6 4 4 4 3 4 "
                    + "5 4 4 6 4 4 4 4 6 4 3 2 3 4 3 5 3 3 1 4 3 4 3 4 3 2 $@$ 3 1 3"
                    + " 3 3 7 3 5 2 5 gf 4 5 5 5 3 5 5 2 lol 5 4 4 2 4 4 5 1 3 1 5 4 3"
                    + " 4 3 4 3 2 3 1 3 3 5 test 7 5 5 6 5 4 5 4 5 2 5 1 foo 5 3 5 7 3 5"
                    + " 3 7 4 5 4 5 3 bar 5 5 2 3 4 3"), gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(223, lines.length);
    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 9, lines.length));
    assertEquals("Game over!\n"
            + "    O _ _\n"
            + "    _ _ _\n"
            + "_ _ _ _ O _ _\n"
            + "_ _ O _ _ _ O\n"
            + "_ _ _ _ O _ _\n"
            + "    _ _ _\n"
            + "    _ _ O\n"
            + "Score: 6", lastMsg);
  }

  @Test
  public void testSingleValidMove() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c =
            new MarbleSolitaireControllerImpl(new StringReader("6 4 4 4 q"), gameLog);
    c.playGame(m);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Game quit!\nState of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31", gameLog.toString());
  }

  @Test
  public void testValidInputsSplitByBogus() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("6 4 dog 4 $$SDf 4 #@#$ q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(21, lines.length);
    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 10, lines.length));
    assertEquals("Game quit!\nState of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31", lastMsg);
  }

  @Test
  public void testBogusInput() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("!#$ 2 5 q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(11, lines.length);
    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 10, lines.length));
    assertEquals("Game quit!\nState of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", lastMsg);
  }

  @Test
  public void testValidMoveAndBogusInput() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("6 4 4 4 l o g Q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(21, lines.length);
    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 10, lines.length));
    assertEquals("Game quit!\nState of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31", lastMsg);
  }

  @Test
  public void testSingleInvalidMove() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("1 2 3 4 Q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(11, lines.length);
    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 11, lines.length));
    assertEquals("Invalid move. Play Again. From position off board"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", lastMsg);
  }

  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    fail();
  }

  @Test(expected = IllegalStateException.class)
  public void testNoMoveRanOutOfInputs() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    MarbleSolitaireController c =
            new MarbleSolitaireControllerImpl(new StringReader("6 4 4"), new StringBuilder());
    c.playGame(m);
    fail();
  }

  @Test(expected = IllegalStateException.class)
  public void testSingleMoveRanOutOfInputs() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(
            new StringReader("6 4 4 4 3 2"), new StringBuilder());
    c.playGame(m);
    fail();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullReadable() {
    new MarbleSolitaireControllerImpl(null, new StringBuilder());
    fail();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullAppendable() {
    new MarbleSolitaireControllerImpl(new StringReader(""), null);
    fail();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    MarbleSolitaireModel m = null;
    MarbleSolitaireController c =
            new MarbleSolitaireControllerImpl(new StringReader(""), new StringBuilder());
    c.playGame(m);
    fail();
  }

}