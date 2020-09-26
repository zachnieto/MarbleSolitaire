import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

/**
 * Do not modify this file. This file should compile correctly with your code!
 * You DO NOT need to submit this file.
 */
public class Hw04TypeChecks {

  /**
   * The contents of this method are meaningless.
   * They are only here to ensure that your code compiles properly.
   */
  public static void main(String[] args) {
    Readable rd = null;
    Appendable ap = null;
    helper(new MarbleSolitaireModelImpl(),
           new cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl(rd, ap));

    helper(new cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl(5),
           new cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl(rd, ap));

    helper(new cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl(3, 3),
           new cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl(rd, ap));
  }

  private void makeAllModels() {
    MarbleSolitaireModel m = null;
    m = new MarbleSolitaireModelImpl();
    m = new MarbleSolitaireModelImpl(3);
    m = new MarbleSolitaireModelImpl(2, 2);
    m = new MarbleSolitaireModelImpl(3, 2, 2);

    m = new cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl();
    m = new cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl(3);
    m = new cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl(2, 2);
    m = new cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl(3, 2, 2);

    m = new cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl();
    m = new cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl(3);
    m = new cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl(2, 2);
    m = new cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl(3, 2, 2);
  }
  
  private static void helper(
           MarbleSolitaireModel model,
           cs3500.marblesolitaire.controller.MarbleSolitaireController controller) {
    controller.playGame(model);
  }

}
