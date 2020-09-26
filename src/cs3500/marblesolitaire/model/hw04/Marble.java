package cs3500.marblesolitaire.model.hw04;

/**
 * Represents a space on the board.
 */
public enum Marble {
  O("O"), OOB(" "), EMPTY("_");

  private final String disp;

  Marble(String disp) {
    this.disp = disp;
  }

  @Override
  public String toString() {
    return disp;
  }

}
