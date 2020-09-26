package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents an implementation of a MarbleSolitaireController. The controller is created using
 * a given input and output stream, and uses them to read inputs and display them to the player.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final Appendable out;
  private final Readable scan;
  private int[] inputs = new int[4];
  private int validMoves = 0;
  private String in = "";

  /**
   * Constructs a MarbleSolitaireControllerImpl.
   *
   * @param rd The input stream
   * @param ap The output stream
   * @throws IllegalArgumentException when either stream is null
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {

    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Argument cannot be null");
    }

    this.scan = rd;
    this.out = ap;

  }

  // moved most of the code to helper methods
  @Override
  public void playGame(MarbleSolitaireModel model) throws IllegalStateException,
          IllegalArgumentException {

    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }

    Scanner sc = new Scanner(scan);

    while (!model.isGameOver()) {

      if (sc.hasNext()) {
        in = sc.next();

        if (this.checkGameQuit(model)) {
          return;
        }
        this.convertInputToNum(in);

      } else {
        throw new IllegalStateException("Ran out of inputs");
      }


      if (validMoves == 4) {
        this.attemptMove(model);
      }
    }

    try {
      out.append("Game over!\n" + model.getGameState() + "\nScore: " + model.getScore() + "\n");
    } catch (IOException ioe) {
      throw new IllegalStateException("Append failed", ioe);
    }
  }

  // added to make code cleaner
  /**
   * Converts the given string to an Integer.
   *
   * @param in String to be converted
   * @throws NumberFormatException if the String cannot be represented as an int
   * @throws IllegalStateException if the append fails
   */
  private void convertInputToNum(String in) throws NumberFormatException, IllegalStateException {

    int num = 0;

    try {
      num = Integer.parseInt(in);
      inputs[validMoves] = num - 1;
      validMoves++;
    } catch (NumberFormatException nfe) {
      try {
        out.append("Invalid input, please re-enter: \n");
      } catch (IOException ioe) {
        throw new IllegalStateException("Append failed", ioe);
      }
    }

  }

  // added to make code cleaner
  /**
   * Checks if the input string is "q" or "Q" and ends the game.
   *
   * @param model the MarbleSolitaireModel of the game
   * @return if the game should be quit
   * @throws IllegalStateException if the append fails
   */
  private boolean checkGameQuit(MarbleSolitaireModel model) throws IllegalStateException {
    if (in.equalsIgnoreCase("q")) {
      try {
        out.append("Game quit!\nState of game when quit:\n"
                + model.getGameState() + "\nScore: " + model.getScore());
        return true;
      } catch (IOException ioe) {
        throw new IllegalStateException("Append failed", ioe);
      }
    }
    return false;
  }

  // added to make code cleaner
  /**
   * Tries to move using the inputs.
   *
   * @param model the MarbleSolitaireModel of the game
   * @throws IllegalStateException if the append fails
   * @throws IllegalArgumentException if the move is invalid
   */
  private void attemptMove(MarbleSolitaireModel model) throws IllegalStateException,
          IllegalArgumentException {
    try {
      model.move(inputs[0], inputs[1], inputs[2], inputs[3]);
      try {
        out.append(model.getGameState() + "\nScore: " + model.getScore() + "\n");
      } catch (IOException ioe) {
        throw new IllegalStateException("Append failed", ioe);
      }
    } catch (IllegalArgumentException e) {
      try {
        out.append("Invalid move. Play Again. " + e.getMessage() + "\n");
      } catch (IOException ioe) {
        throw new IllegalStateException("Append failed", ioe);
      }
    }

    validMoves = 0;
  }

}