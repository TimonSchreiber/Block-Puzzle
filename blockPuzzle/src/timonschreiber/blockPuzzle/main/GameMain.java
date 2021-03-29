package timonschreiber.blockPuzzle.main;

import java.util.Scanner;

//import timonschreiber.blockPuzzle.field.Direction;
//import timonschreiber.blockPuzzle.game.Game;
import timonschreiber.blockPuzzle.game.GameSolver;

/**
 * Main Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 13
 */
public class GameMain {

	public static void main(String[] args) {

		int gameID = 0;
//		String gameType = new String();

		// New Scanner
		Scanner sc = new Scanner(System.in);

		// Enter GameMode
//		System.out.println("Choose your Game-Mode:\nPlay manually (m) or let the GameSolver find a solution (s)?");
//		if (sc.hasNext()) { gameType = sc.next(); }

		// Enter GameID
		System.out.println("Enter the Game-ID you want to play:");
//		try {
		gameID = sc.nextInt();
//		} catch (InputMismatchException e) {
//			System.out.println("Not a valid input for Game-ID!");
//			System.out.println("You now get a random Game-ID");
//			gameID = (int) (Math.random() * 12.0);
//		}

		try {
			// Call correct method
//		switch (String.valueOf(gameType.charAt(0))) {
//			case "m":
//				useManualMode(gameID, sc);
//				break;
//			case "s":
			useGameSolver(gameID, sc);
//				break;
//			default:
//				System.out.println("Not a valid input for Game-Mode!");
//				System.out.println("Play on your own");
//				useManualMode(gameID, sc);
//				return;
//			}
		} finally {

			// Close Scanner
			if (sc != null) {
				sc.close();
			}
		}
		return;
	}

	/**
	 * Calls the GameSolver Class and measures the time between start and end
	 * 
	 * @param gameID Number o Starting Position
	 * @param sc     Scanner
	 */
	public static void useGameSolver(int gameID, Scanner sc) {

		// GameSolver
		GameSolver solver = new GameSolver(gameID);

		// Solving the Game
		solver.solve();

		// Close Scanner
		if (sc != null) {
			sc.close();
		}

		// Output moves from Start to End with a time-delay of .5 seconds
//		solver.showMoves(1000);
		return;

	}

	/**
	 * Lets you play on your own
	 * 
	 * @param gameID Number of Starting Position
	 * @param sc     Scanner
	 */
//	public static void useManualMode(int gameID, Scanner sc) {
//
//		// Steps and move counter
//		int steps = 1;
//		int moves = 0;
//
//		// Direction, blockName, and buffer Strings
//		String buffer = new String();
//		String blockName = new String();
//		Direction direction = Direction.D;
//
//		// new Game
//		Game game = new Game();
//
//		// Set up the Game
//		game.play(gameID);
//
//		while (!game.getField().isWon()) {
//			// Change delimiter to (ENTER)
//			sc.useDelimiter(System.getProperty("line.separator"));
//
//			// Ask for input
//			System.out.println("Enter your move: ");
//
//			if (sc.hasNext()) {
//				// New Scanner for the String
//				Scanner str = new Scanner(sc.next());
//				while (str.hasNext()) {
//					if (str.hasNextInt()) {
//						// Save steps
//						steps = str.nextInt();
//					} else {
//						// Save String
//						buffer = str.next();
//
//						// Break if input is "x"
//						if (buffer.equalsIgnoreCase("x")) {
//							break;
//						}
//
//						switch (buffer.length()) {
//						case 1:
//							direction = Direction.valueOf(buffer.toUpperCase());
//							break;
//						case 2:
//							blockName = new String(buffer.toUpperCase());
//							break;
//						}
//					}
//				}
//				// Close Scanner for String
//				if (str != null) {
//					str.close();
//				}
//
//				System.out.println("Block Name " + blockName + ", Direction " + direction.name() + ", Steps "
//						+ steps + "\n");
//
//				// Make one or more moves
//				for (; steps >= 1; steps--) {
//					if (game.getField().isValidMove(blockName, direction)) {
//						moves++;
//					}
//				}
//				// Set steps back to 1
//				steps = 1;
//			}
//		}
//
//		// Victory message
//		if (game.getField().isWon()) {
//			System.out.println("*****YOU WON!!!*****");
//		}
//
//		// number of moves
//		System.out.println("Number of moves made: " + moves);
//
//		return;
//	}

}
