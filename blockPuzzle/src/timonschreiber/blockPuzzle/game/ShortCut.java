package timonschreiber.blockPuzzle.game;

import timonschreiber.blockPuzzle.field.BlockList;
import timonschreiber.blockPuzzle.field.GameField;
import timonschreiber.blockPuzzle.field.Move;

/**
 * Short Cut Class
 * 
 * @author		Timon Schreiber
 * @version		1.0 2021 April 02
 */
public record ShortCut(BlockList start, BlockList end, Move move) {
	
	
	
	
	// =========================================================================
	// PRINT - METHOD
	// =========================================================================
	
	public void print() {
		
		(new GameField(this.start)).print();
		
		System.out.println("with: " + move);
		
		(new GameField(this.end)).print();
		
		return;
	}
	
	// =========================================================================
}
