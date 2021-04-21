package timonschreiber.blockPuzzle.main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import timonschreiber.blockPuzzle.block.Block;
import timonschreiber.blockPuzzle.block.BlockInfo;
import timonschreiber.blockPuzzle.block.Position;
import timonschreiber.blockPuzzle.field.BlockSet;
import timonschreiber.blockPuzzle.field.Direction;
import timonschreiber.blockPuzzle.field.GameField;
import timonschreiber.blockPuzzle.field.Move;
import timonschreiber.blockPuzzle.game.GameSolver;

/**
 * Main Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 13
 */
public class GameMain {

	public static void main(String[] args) {
		
//		Set<BlockSet> set = new HashSet<>();
//		
//		BlockSet blkLst1 = new BlockSet();
//		blkLst1.addBlock(new Block(new BlockInfo(new Position(0, 0), 1, Direction.R)));
//		blkLst1.addBlock(new Block(new BlockInfo(new Position(1, 1), 2, Direction.R)));
//		blkLst1.addBlock(new Block(new BlockInfo(new Position(2, 0), 1, Direction.R)));
//
//		
//		BlockSet blkLst2 = new BlockSet();
//		blkLst2.addBlock(new Block(new BlockInfo(new Position(2, 0), 1, Direction.R)));
//		blkLst2.addBlock(new Block(new BlockInfo(new Position(1, 1), 2, Direction.R)));
//		blkLst2.addBlock(new Block(new BlockInfo(new Position(0, 0), 1, Direction.R)));
//		
//		System.out.println("BlockSet 1: " + blkLst1.hashCode());
//		System.out.println(blkLst1);
//		(new GameField(blkLst1)).print();
//		
//		System.out.println("\nBLockList 2: " + blkLst2.hashCode());
//		System.out.println(blkLst2);
//		(new GameField(blkLst2)).print();
//		
//		System.out.println("\nBlockList 1 equal BlockSet 2?\n" + blkLst1.equals(blkLst2));
//		
//		set.add(blkLst1);
//		set.add(blkLst2);
//		blkLst2.move(new Move("G4", Direction.R));
//		
//		System.out.println("set size: " + set.size());
		
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
		
		return;
	}

}
