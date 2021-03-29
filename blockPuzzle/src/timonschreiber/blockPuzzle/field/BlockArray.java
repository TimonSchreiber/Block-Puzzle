package timonschreiber.blockPuzzle.field;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import timonschreiber.blockPuzzle.blocks.Block;
import timonschreiber.blockPuzzle.blocks.Position;

/**
 * Block Array Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 28
 */
public final class BlockArray implements Iterable<Block> {

	// =========================================================================
	// ATTRIBUTE
	// =========================================================================

	/** Block Array */
	private final List<Block> blocks;

	// =========================================================================
	// CONSTRUCTORS
	// =========================================================================
	
	/**
	 * Class constructor.
	 */
	public BlockArray() {
		this.blocks = new ArrayList<>();
	}
	
	/**
	 * Class constructor from another {@code BlockArray}.
	 * 
	 * @param blockArray		the {@code BlockArray}
	 */
	public BlockArray(BlockArray blockArray) {
		this.blocks = new ArrayList<>();
		
		for (Block block : blockArray) {
			this.blocks.add(new Block(block));
		}
	}

	// =========================================================================
	// GETTER - METHODS
	// =========================================================================

	/** TODO
	 * Checks if there is a Block in this {@code BlockArray} with the same
	 * x- and y-coordinates as one of its {@code Block}s.
	 * 
	 * @param position	the {@code Position}
	 * @return			{@code true} if there is one Block which has these 
	 * 					x- and y-coordinates; {@code false} otherwise
	 */
	public boolean isBlock(Position position) {
		for (Block blk : this.blocks) {
			if (blk.getPositions().contains(position)) {
				return true;
			}
		}
		return false;
	}

	/** TODO
	 * 
	 * @return
	 */
	public int getSize() {
		return this.blocks.size();
	}

	/** TODO
	 * 
	 * @param index
	 * @return
	 */
	public Block getBlock(int index) {
		return new Block(this.blocks.get(index));
	}


	/** TODO
	 * 
	 * @param blockName
	 * @return
	 */
	public Block getBlock(String blockName) {
		for (Block blk : this.blocks) {
			if (blk.getName().equals(blockName)) {
				return new Block(blk);
			}
		}
		return null;
	}
	
	/** TODO
	 * 
	 * @param position
	 * @return
	 */
	public Block getBlock(Position position) {
		for (Block blk : this.blocks) {
			if (blk.getPositions().contains(position)) {
				return new Block(blk);
			}
		}
		return null;
	}

	// =========================================================================
	// ADD-BLOCK - METHOD
	// =========================================================================

	/** TODO
	 * 
	 * @param block
	 */
	public void addBlock(Block block) {
		this.blocks.add(new Block(block));
		return;
	}
	
	// =========================================================================
	//  MOVE - METHOD
	// =========================================================================
	
	/** TODO
	 * 
	 * @param move
	 */
	public void move(Move move) {
		for (Block blk : this.blocks) {
			if (blk.getName().equals(move.getName())) {
				blk.moveTowards(move.getDirection());
			}
		}
		return;
	}
	
	// =========================================================================
	// IS-SIMILAR - METHOD
	// =========================================================================

	/** TODO
	 * 
	 * @param blocks
	 * @return
	 */
	public boolean isSimilar(BlockArray blocks) {
		for (Block blk : this.blocks) {
			if (blk.isEqualBlock(blocks)) {
			} else {
				return false;
			}
		}
		return true;
	}
	
	// =========================================================================
	// EQUALS AND HASH-CODE - METHODS
	// =========================================================================
	
	/** TODO
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (this.getClass() != obj.getClass())) {
			return false;
		}
		// Object must be BlockArray at this point
		BlockArray other = (BlockArray) obj;
		return (this.blocks == other.blocks)
				|| ((this.blocks != null) && this.blocks.equals(other.blocks));
	}
	
	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 7;
		hash = prime * hash + ((this.blocks == null) ? 0 : this.blocks.hashCode());
		return hash;
	}
	
	// =========================================================================
	// TO-STRING - METHOD
	// =========================================================================
	
	/** TODO
	 * 
	 */
	@Override
	public String toString() {
		return "BlockArray [blocks=" + this.blocks + "]";
	}

	// =========================================================================
	// INTERFACE - METHOD
	// =========================================================================
	
	// -------------------------------------------------------------------------
	// ITERABLE
	// -------------------------------------------------------------------------

	/**
	 * Returns an {@code Iterator} over all {@code Block}s.
	 */
	@Override
	public Iterator<Block> iterator() {
		return this.blocks.iterator();
	}

	// =========================================================================
	
}
