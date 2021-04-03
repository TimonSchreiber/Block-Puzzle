package timonschreiber.blockPuzzle.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import timonschreiber.blockPuzzle.block.Position;
import timonschreiber.blockPuzzle.game.GameSolver;

/**
 * Main Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 13
 */
public class GameMain {

	public static void main(String[] args) {
		
		SortedSet<Position> s1 = new TreeSet<>();
		SortedSet<Position> s2 = new TreeSet<>();
		List<Position> l1 = new ArrayList<>();
		
		
		s1.add(new Position(0, 0));
		s1.add(new Position(0, 1));
		s1.add(new Position(1, 0));
		s1.add(new Position(1, 1));
		
		System.out.println("\ns1: " + s1.hashCode() + "\n" + s1);
		for (Position str : s1) {
			System.out.println(str + " hashCode: " + str.hashCode());
		}

		s2.add(new Position(1, 1));
		s2.add(new Position(0, 0));
		s2.add(new Position(0, 1));
		s2.add(new Position(1, 0));
		System.out.println("\ns2[0]: " + s2.first());
		
		System.out.println("\ns2: " + s2.hashCode() + "\n" + s2);
		for (Position str : s2) {
			System.out.println(str + " hashCode: " + str.hashCode());
		}
		
		l1.addAll(s1);
		System.out.println("\nl1: " + l1.hashCode() + "\n" + l1);
		for (Position str : l1) {
			System.out.println(str + " hashCode: " + str.hashCode());
		}

		
//		// System variables
//		// New Scanner
//		Scanner sc = new Scanner(System.in);
//
//		// Enter GameID
//		System.out.println("Enter the Game-ID you want to play:");
//
//		// Game variable
//		GameSolver solver = new GameSolver(sc.nextInt());
//
//		// solve
//		try {
//			solver.solve();
//		} finally {
//			// Close Scanner
//			if (sc != null) {
//				sc.close();
//			}
//		}
//		
//		solver.showMoves(500);
		
		return;
	}

}
