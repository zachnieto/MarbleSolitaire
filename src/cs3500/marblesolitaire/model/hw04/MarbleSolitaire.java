package cs3500.marblesolitaire.model.hw04;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

/**
 * Runs a game of Marble Solitaire.
 */
public final class MarbleSolitaire {
  /**
   * Runs a game of marble solitaire using the given arguments. The board can be either
   * "european", "triangular", or "english". The size is given as "-size N" and the hole is
   * given as "-hole R C".
   *
   * @param args the board type, size of the board, and position of the hole
   */
  public static void main(String[] args) {

    int row = -1;
    int col = -1;
    int size = -1;
    String model = "";
    MarbleSolitaireModel m;

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "english":
          model = "eng";
          break;
        case "european":
          model = "eur";
          break;
        case "triangular":
          model = "tri";
          break;
        case "-size":
          size = Integer.parseInt(args[i + 1]);
          i++;
          break;
        case "-hole":
          row = Integer.parseInt(args[i + 1]) - 1;
          col = Integer.parseInt(args[i + 2]) - 1;
          i += 2;
          break;
        default: break;
      }
    }

    switch (model) {
      case "eng":
        if (size == -1) {
          size = 3;
        }
        if (row == -1) {
          row = 3;
        }
        if (col == -1) {
          col = 3;
        }
        m = new MarbleSolitaireModelImpl(size, row, col);
        break;
      case "eur":
        if (size == -1) {
          size = 3;
        }
        if (row == -1) {
          row = 3;
        }
        if (col == -1) {
          col = 3;
        }
        m = new EuropeanSolitaireModelImpl(size, row, col);
        break;
      case "tri":
        if (size == -1) {
          size = 5;
        }
        if (row == -1) {
          row = 0;
        }
        if (col == -1) {
          col = 0;
        }
        m = new TriangleSolitaireModelImpl(size, row, col);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + model);
    }
    System.out.println(m.getGameState());
    new MarbleSolitaireControllerImpl(new InputStreamReader(System.in),
            System.out).playGame(m);



  }
}
