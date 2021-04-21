package timonschreiber.blockPuzzle.field;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import timonschreiber.blockPuzzle.block.Block;
import timonschreiber.blockPuzzle.block.Position;

/**
 * Block Array Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 28
 */
public final class BlockSet implements Iterable<Block> {

	// =========================================================================
	// ATTRIBUTE
	// =========================================================================

	/** {@code Block Array} */
	private final Set<Block> BLOCKS;

	// =========================================================================
	// CONSTRUCTORS
	// =========================================================================
	
	/**
	 * Class constructor.
	 */
	public BlockSet() {
		this.BLOCKS = new TreeSet<>();
	}
	
	/**
	 * Copy constructor.
	 * 
	 * @param blockSet	the {@code BlockSet}
	 */
	public BlockSet(BlockSet blockSet) {
		this.BLOCKS = new TreeSet<>();
		
		for (Block block : blockSet) {
			this.BLOCKS.add(new Block(block));
		}
	}

	// =========================================================================
	// GETTER - METHODS
	// =========================================================================

	/** TODO
	 * Checks if there is a Block in this {@code BlockSet} with the same
	 * x- and y-coordinates as one of its {@code Block}s.
	 * 
	 * @param position	the {@code Position}
	 * @return			{@code true} if there is one Block which has these 
	 * 					x- and y-coordinates; {@code false} otherwise
	 */
	public boolean isBlock(Position position) {
		for (Block blk : this.BLOCKS) {
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
		return this.BLOCKS.size();
	}
	
	/** TODO replace ever this.BLOCKS.getBlock(position).getName() with this
	 * 
	 * @param position
	 * @return
	 */
	public String getBlockName(Position position) {
		for (Block blk : this.BLOCKS) {
			if (blk.getPositions().contains(position)) {
				return blk.getName();
			}
		}
		return null;
	}

	/** TODO
	 * 
	 * @param blockName
	 * @return
	 */
	public Block getBlock(String blockName) {
		for (Block blk : this.BLOCKS) {
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
		for (Block blk : this.BLOCKS) {
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
		this.BLOCKS.add(new Block(block));
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
		for (Block blk : this.BLOCKS) {
			if (blk.getName().equals(move.getName())) {
				blk.moveTowards(move.getDirection());
				return;
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
	public boolean isSimilar(BlockSet blocks) {
		int counter = 0;
		
		for (Block blk1 : this.BLOCKS) {
			for (Block blk2 : blocks) {
				if (blk1.getPositions().equals(blk2.getPositions())) {
					counter++;
				}
			}
		}
		
		return (counter == this.getSize());
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
		
		// Object must be BlockSet at this point
		BlockSet other = (BlockSet) obj;
		
		return (this.BLOCKS == other.BLOCKS)
					|| ((this.BLOCKS != null)
						&& this.BLOCKS.equals(other.BLOCKS));
	}
	
	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int hash = 7;
		
		hash = PRIME * hash + ((this.BLOCKS == null)
									? 0
									: this.BLOCKS.hashCode());
		
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
		return "BlockSet [blocks=" + this.BLOCKS + "]";
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
		return this.BLOCKS.iterator();
	}

	// =========================================================================
	
}
