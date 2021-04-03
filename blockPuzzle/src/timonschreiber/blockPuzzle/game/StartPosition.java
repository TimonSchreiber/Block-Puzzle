package timonschreiber.blockPuzzle.game;

import java.util.Iterator;
import java.util.List;

import timonschreiber.blockPuzzle.block.BlockInfo;

/**
 * Start Position Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 March 22
 */
public record StartPosition(List<BlockInfo> blockInfos) implements Iterable<BlockInfo> {

	// =========================================================================
	// INTERFACE - METHODS
	// =========================================================================
	
	// -------------------------------------------------------------------------
	// ITERABLE
	// -------------------------------------------------------------------------
	
	/**
	 * Returns an {@code Iterator} over all {@code BlockInfo}s.
	 */
	@Override
	public Iterator<BlockInfo> iterator() {
		return this.blockInfos.iterator();
	}

}
