package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract implementation of a MarbleSolitaireModel. The class handles all movements for a
 * board with normal cartesian coordinates.
 */
public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {

  protected int boardLength;
  protected Marble[][] board; // changed from type char to type Marble
  protected boolean allowDiag;

  @Override
  public int hashCode() {
    return this.getGameState().hashCode();
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }

    if (!(that instanceof MarbleSolitaireModel)) {
      return false;
    }

    return ((MarbleSolitaireModel) that).getGameState().equals(this.getGameState());
  }

  @Override
  public String toString() {
    return this.getGameState();
  }



  // changed setting board equal to Marble type instead of chars
  // and calls getIllegalMoveMsg for the exact reason the move is invalid
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    if (isValidMove(fromRow, fromCol, toRow, toCol)) {
      this.board[fromRow][fromCol] = Marble.EMPTY;
      this.board[toRow][toCol] = Marble.O;
      this.board[(toRow + fromRow) / 2][(toCol + fromCol) / 2] = Marble.EMPTY;
    } else {
      throw new IllegalArgumentException(getIllegalMoveMsg(toRow, toCol, fromRow, fromCol));
    }
  }

  // simplified to work with any representation of a board with normal
  // cartesian coordinate representation
  @Override
  public String getGameState() {
    StringBuilder display = new StringBuilder();

    for (int r = 0; r < this.boardLength; r++) {
      for (int c = 0; c < this.boardLength; c++) {

        display.append(this.board[r][c]);

        if (c + 1 > this.boardLength - 1
                || (c > this.boardLength / 2 && this.board[r][c + 1] == Marble.OOB)) {
          if (r < this.boardLength - 1) {
            display.append("\n");
          }
          break;
        }
        else {
          display.append(" ");
        }

      }
    }
    return display.toString();
  }


  /**
   * Determines if the move from the given position to the desired position is valid.
   *
   * @param fromRow row of marble to move
   * @param fromCol column of marble to move
   * @param toRow   row of desired position
   * @param toCol   column of desired position
   * @return whether the move is valid or not
   */
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return !(positionOffBoard(toRow, toCol) // to off board
            || positionOffBoard(fromRow, fromCol) // from off board
            || ((Math.abs(toRow - fromRow) != 2 && Math.abs(toRow - fromRow) != 0)
            || (Math.abs(toCol - fromCol) != 2 && Math.abs(toCol - fromCol) != 0)) // not 2 away
            || this.board[fromRow][fromCol] != Marble.O // from isnt marble
            || this.board[toRow][toCol] != Marble.EMPTY // to isnt empty
            || this.board[(toRow + fromRow) / 2][(toCol + fromCol) / 2] != Marble.O // mid empty
            || (!allowDiag && toRow != fromRow && toCol != fromCol));

  }

  /**
   * Determines if a given position has a position it can move to.
   *
   * @param row row of given position
   * @param col column of given position
   * @return whether the position can move
   */
  private boolean isMovable(int row, int col) {
    return this.isValidMove(row, col, row + 2, col)
            || this.isValidMove(row, col, row - 2, col)
            || this.isValidMove(row, col, row, col + 2)
            || this.isValidMove(row, col, row, col - 2)
            || allowDiag && this.isValidMove(row, col, row - 2, col - 1)
            || allowDiag && this.isValidMove(row, col, row - 2, col + 1)
            || allowDiag && this.isValidMove(row, col, row + 2, col - 1)
            || allowDiag && this.isValidMove(row, col, row + 2, col + 1);
  }

  // added method to return the reason the move is invalid
  /**
   * Gives a detailed reason as to why the move was a failure.
   *
   * @param toRow row of desired position
   * @param toCol column of desired position
   * @param fromRow row of from position
   * @param fromCol column of from position
   * @return the reason the move was invalid
   */
  protected String getIllegalMoveMsg(int toRow, int toCol, int fromRow, int fromCol) {
    if (positionOffBoard(toRow, toCol)) {
      return "To position off board";
    }
    else if (positionOffBoard(fromRow, fromCol)) {
      return "From position off board";
    }
    else if ((Math.abs(toRow - fromRow) != 2 && Math.abs(toRow - fromRow) != 0)
            || (Math.abs(toCol - fromCol) != 2 && Math.abs(toCol - fromCol) != 0))  {
      return "Positon not 2 away";
    }
    else if (this.board[fromRow][fromCol] != Marble.O) {
      return "From position isnt a marble";
    }
    else if (this.board[toRow][toCol] != Marble.EMPTY) {
      return "To position isnt empty";
    }
    else if (this.board[(toRow + fromRow) / 2][(toCol + fromCol) / 2] != Marble.O) {
      return "Mid position isnt a marble";
    }
    else if (toRow != fromRow && toCol != fromCol) {
      return "Cannot move diagonal"; // will never be ran when used with TriangleSolitaireModels
    }
    else {
      throw new IllegalArgumentException("Move was legal");
    }
  }


  /**
   * Determines if the given row and column position is valid or not.
   *
   * @param row row of position
   * @param col column of position
   * @return whether the given position is valid
   */
  protected boolean positionOffBoard(int row, int col) {
    return (row < 0 || row >= this.boardLength || col < 0 || col >= this.boardLength)
            || this.board[row][col] == Marble.OOB;
  }

  @Override
  public boolean isGameOver() {
    for (int r = 0; r < this.boardLength; r++) {
      for (int c = 0; c < this.boardLength; c++) {
        if (this.isMovable(r, c)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int getScore() {
    int score = 0;

    for (Marble[] col : this.board) {
      for (Marble elem : col) {
        if (elem == Marble.O) {
          score++;
        }
      }
    }
    return score;
  }
}
