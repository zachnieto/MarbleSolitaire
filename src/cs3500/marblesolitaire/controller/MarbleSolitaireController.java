package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This interface manages the creation and running of a
 * marble solitaire game using a given marble solitaire model.
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game of Marble Solitaire using the provided model.
   *
   * @param model MarbleSolitaireModel to use
   * @throws IllegalArgumentException if the model is null, or if the controller is unable
   *                                  to receive input or transmit output
   * @throws IllegalStateException if the controller runs out of inputs mid-game or if the append
   *                                  fails on the output stream
   */
  void playGame(MarbleSolitaireModel model);

}
