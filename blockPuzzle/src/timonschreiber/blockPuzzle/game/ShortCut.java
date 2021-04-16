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
public record ShortCut(BlockList from, BlockList to, Move move) {
	
	// =========================================================================
	// NEW-STATE - METHOD
	// =========================================================================
	
	/**
	 * 
	 * @return
	 */
	public BlockList newState() {
		BlockList tmpBlkLst = new BlockList(this.from);
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
		
		(new GameField(this.from)).print();
		
		System.out.println("with: " + move);
		
		(new GameField(this.to)).print();
		
		return;
	}
	
	// =========================================================================
}
