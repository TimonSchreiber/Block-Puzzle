package timonschreiber.blockPuzzle.game;

import timonschreiber.blockPuzzle.field.BlockSet;
import timonschreiber.blockPuzzle.field.GameField;
import timonschreiber.blockPuzzle.field.Move;

/**
 * Short Cut Class
 * 
 * @author		Timon Schreiber
 * @version		1.0 2021 April 02
 */
public record ShortCut(BlockSet initialState, BlockSet oldState, Move move) {
	
	// =========================================================================
	// NEW-STATE - METHOD
	// =========================================================================
	
	/** TODO
	 * 
	 * @return
	 */
	public BlockSet newState() {
		BlockSet tmpBlkLst = new BlockSet(this.initialState);
		tmpBlkLst.move(this.move);
		return tmpBlkLst;
	}
	
	
	// =========================================================================
	// PRINT - METHOD
	// =========================================================================
	
	/**
	 * TODO delete?
	 */
	public void print() {
		
		(new GameField(this.initialState)).print();
		
		System.out.println("with: " + move);
		
		(new GameField(this.oldState)).print();
		
		return;
	}
	
	// =========================================================================
}
