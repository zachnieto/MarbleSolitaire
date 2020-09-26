package cs3500.marblesolitaire.model.hw02;


import cs3500.marblesolitaire.model.hw04.AbstractMarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.Marble;

/**
 * An implementation of a MarbleSolitaireModel.
 */
public class MarbleSolitaireModelImpl extends AbstractMarbleSolitaireModel {

  /**
   * Constructs a MarbleSolitaireModelImpl using the default settings of 3 armThickness, and the
   * center position empty.
   */
  public MarbleSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Constructs a MarbleSolitaireModelImpl using the default armThickness of 3, with the empty
   * position at the given Row and Column.
   *
   * @param sRow row of empty position
   * @param sCol column of empty position
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Constructs a MarbleSolitaireModelImpl using the default empty position and the given
   * armThickness.
   *
   * @param armThickness thickness of each arm
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    this(armThickness, armThickness + 1, armThickness + 1);
  }

  /**
   * Constructs a MarbleSoliatireModelImpl using the given armThickness with the empty position at
   * the given row and column.
   *
   * @param armThickness thickness of each arm
   * @param sRow         row of empty position
   * @param sCol         column of empty position
   * @throws IllegalArgumentException {@code armThickness} is non-positive or even
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) {

    this.boardLength = (3 * armThickness) - 2;
    this.allowDiag = false;

    if (armThickness % 2 == 0 || armThickness < 1) {
      throw new IllegalArgumentException("Thickness must be an odd number");
    } else if (((sRow < armThickness - 1 || sRow >= (this.boardLength - armThickness + 1))
            && (sCol < armThickness - 1 || sCol >= (this.boardLength - armThickness + 1)))
            || (sRow < 0 || sRow >= this.boardLength || sCol < 0 || sCol >= this.boardLength)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }

    this.board = new Marble[boardLength][boardLength];

    for (int r = 0; r < this.boardLength; r++) {
      for (int c = 0; c < this.boardLength; c++) {

        if (((r < armThickness - 1 || r >= (this.boardLength - armThickness + 1))
                && (c < armThickness - 1 || c >= (this.boardLength - armThickness + 1)))) {
          this.board[r][c] = Marble.OOB;
        } else {
          this.board[r][c] = Marble.O;
        }
      }
    }
    this.board[sRow][sCol] = Marble.EMPTY;
  }

}
