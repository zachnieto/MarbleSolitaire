package cs3500.marblesolitaire.model.hw04;

/**
 * Implementation of a European Marble Solitaire Game. Moves can be made vertical or horizontal
 * as long as a marble is being jumped, and the desired position is valid.
 */
public class EuropeanSolitaireModelImpl extends AbstractMarbleSolitaireModel {

  private final int sideLength;

  /**
   * Constructs a EuropeanSolitaireModelImpl with default side lengths of 3, and the
   * empty position at the default 3,3.
   */
  public EuropeanSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Constructs a EuropeanSolitaireModelImpl with the given side length and the empty position
   * at the default 3,3.
   *
   * @param sideLength length of each side of the board
   */
  public EuropeanSolitaireModelImpl(int sideLength) {
    this(sideLength, 3, 3);
  }

  /**
   * Constructs a EuropeanSolitaireModelImpl with the default side length and the empty
   * position at the given row and column.
   *
   * @param row row of the empty position
   * @param col column of the empty position
   */
  public EuropeanSolitaireModelImpl(int row, int col) {
    this(3, row, col);
  }

  /**
   * Constructs a EuropeanSolitaireModelImpl with the given side length and the empty
   * position at the given row and column.
   *
   * @param sideLength length of each side of the board
   * @param row row of the empty position
   * @param col column of the empty position
   */
  public EuropeanSolitaireModelImpl(int sideLength, int row, int col) {

    this.sideLength = sideLength;
    this.boardLength = this.sideLength + 2 * (this.sideLength - 1);
    this.allowDiag = false;

    if (this.sideLength < 1) {
      throw new IllegalArgumentException("Side length must be positive");
    }
    else if (offBoard(row, col)) {
      throw new IllegalArgumentException("Position is off board");
    }


    this.board = new Marble[boardLength][boardLength];

    for (int r = 0; r < this.boardLength; r++) {
      for (int c = 0; c < this.boardLength; c++) {

        if (offBoard(r, c)) {
          this.board[r][c] = Marble.OOB;
        } else {
          this.board[r][c] = Marble.O;
        }

      }
    }
    this.board[row][col] = Marble.EMPTY;
  }


  /**
   * Determines if the given position is not a valid position.
   *
   * @param r row of the position
   * @param c column of the position
   * @return if the given position is off the board
   */
  private boolean offBoard(int r, int c) {
    if (c <= this.boardLength / 2) {
      if (r <= this.boardLength / 2) {
        return r + c < this.sideLength - 1;
      }
      else {
        return this.boardLength - 1 - r + c < this.sideLength - 1;
      }
    }
    else {
      if (r <= this.boardLength / 2) {
        return r + this.boardLength - 1 - c < this.sideLength - 1;
      }
      else {
        return this.boardLength - 1 - r + this.boardLength - 1 - c < this.sideLength - 1;
      }
    }
  }





}
