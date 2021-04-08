package timonschreiber.blockPuzzle.main;

import java.util.Scanner;

import timonschreiber.blockPuzzle.game.GameSolver;

/**
 * Main Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 13
 */
public class GameMain {

	public static void main(String[] args) {
		
		// System variables
		// New Scanner
		Scanner sc = new Scanner(System.in);

		// Enter GameID
		System.out.println("Enter the Game-ID you want to play:");

		// Game variable
		GameSolver solver = new GameSolver(sc.nextInt());

		// solve
		try {
			solver.solve();
		} finally {
			// Close Scanner
			if (sc != null) {
				sc.close();
			}
		}
		
		solver.showSolution(500);
		
		return;
	}

}
