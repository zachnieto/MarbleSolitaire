- Abstracted all methods from the MarbleSolitaireModelImpl to an abstract class
- Changed board type from char to the Marble enum for better restrictions
- In move() : changed setting board equal to Marble type instead of chars
	and calls getIllegalMoveMsg for the exact reason the move is invalid
- In getGameState() : simplified to work with any representation of a board with normal
	cartesian coordinate representation
- Added getIllegalMoveMsg to the abstract class to return a reason for the move being invalid
- Added helper method convertInputToNum(String in) in MarbleSolitaireControllerImpl that converts the given string to an int
- Added helper method checkGameQuit(MarbleSolitaireModel model) in MarbleSolitaireControllerImpl that checks 
	if the input is a "q" or "Q" to end the game
- Added helper method attemptMove(MarbleSolitaireModel molel) in MarbleSolitaireControllerImpl that tries to move using
	the inputs in the inputs[] array.
- Changed getGameState() in AbstractMarbleSolitaireModel to use .append instead of += for efficiency.
- Added field allowDiag in AbstractMarbleSolitaireModel that represents whether diagonal movements are allowed
- Changed constructor for MarbleSolitaireModelImpl and EuropeanSolitaireModelImpl to initialize allowDiag to false.
- Changed constructor for TriangleSolitaireModelImpl to initialize allowDiag to true.
- Changed isValidMove in AbstractMarbleSolitaireModel to only check diagonal move if allowDiag is false.
- Changed isMovable to check diagonal moves if allowDiag is true.
