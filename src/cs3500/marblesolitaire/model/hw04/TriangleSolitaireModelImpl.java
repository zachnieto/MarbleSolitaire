package cs3500.marblesolitaire.model.hw04;

/**
 * Implementation of a Triangular Marble Solitaire Game. The board has position 0,0 at the top
 * of the triangle, and moves can be made over diagonals or along the row.
 */
public class TriangleSolitaireModelImpl extends AbstractMarbleSolitaireModel {

  /**
   * Constructs a TriangleSolitaireModelImpl with default dimensions of 5, with the empty marble
   * position at 0,0.
   */
  public TriangleSolitaireModelImpl() {
    this(5, 0, 0);
  }

  /**
   * Constructs a TriangleSolitaireModelImpl with specified dimensions.
   *
   * @param dimensions number of dimensions of the model
   */
  public TriangleSolitaireModelImpl(int dimensions) {
    this(dimensions, 0, 0);
  }

  /**
   * Constructs a TriangleSolitaireModelImpl with an empty marble at the given row and column pair.
   *
   * @param row row of the empty position
   * @param col column of the empty position
   */
  public TriangleSolitaireModelImpl(int row, int col) {
    this(5, row, col);
  }

  /**
   * Constructs a TriangleSolitaireModelImpl with specified dimensions, with the empty marble at the
   * given row and column pair.
   *
   * @param dimensions number of dimensions of the model
   * @param row        row of the empty position
   * @param col        column of the empty position
   */
  public TriangleSolitaireModelImpl(int dimensions, int row, int col) {

    this.boardLength = dimensions;
    this.allowDiag = true;

    if (dimensions < 1) {
      throw new IllegalArgumentException("Dimensions must be a positive number");
    } else if (col > row) {
      throw new IllegalArgumentException("Position given is invalid");
    }

    this.board = new Marble[boardLength][boardLength];

    for (int r = 0; r < this.boardLength; r++) {
      for (int c = 0; c < this.boardLength; c++) {

        if (c > r) {
          this.board[r][c] = Marble.OOB;
        } else {
          this.board[r][c] = Marble.O;
        }

      }
    }

    this.board[row][col] = Marble.EMPTY;
  }


  @Override
  public String getGameState() {
    StringBuilder display = new StringBuilder();

    for (int r = 0; r < this.boardLength; r++) {

      display.append(" ".repeat(this.boardLength - r - 1));

      for (int c = 0; c < this.boardLength; c++) {

        display.append(this.board[r][c]);


        if (c + 1 > this.boardLength - 1 || this.board[r][c + 1] == Marble.OOB) {
          if (r < this.boardLength - 1) {
            display.append("\n");
          }
          break;
        } else {
          display.append(" ");
        }

      }
    }
    return display.toString();
  }

}
