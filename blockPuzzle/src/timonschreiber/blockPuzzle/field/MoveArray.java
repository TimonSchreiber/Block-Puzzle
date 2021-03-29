package timonschreiber.blockPuzzle.field;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import timonschreiber.blockPuzzle.blocks.Block;

/**
 * Move Array Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 11
 */
public final class MoveArray implements Iterable<Move> {

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================

	/** Move Array */
	private final List<Move> moves;

	// =========================================================================
	// CONSTRUCTOR
	// =========================================================================

	/**
	 * Class constructor.
	 */
	public MoveArray() {
		this.moves = new ArrayList<>();
	}

	// =========================================================================
	// GETTER - METHODS
	// =========================================================================

	/**
	 * Gets the number of {@code Move}s in this {@code MoveArray}.
	 * 
	 * @return	the size of this {@code MoveArray}
	 */
	public int getSize() {
		return this.moves.size();
	}

	/**
	 * Gets a specific {@code Move} from this {@code MoveArray}.
	 * 
	 * @param index		the index of the {@code Move}
	 * @return			the {@code Move} at the specified index
	 */
	public Move getMove(int index) {
		return new Move(this.moves.get(index));
	}
	
	/** TODO
	 * Gets the last {@code Move} in this {@code MoveArray}.
	 * 
	 * @return		the last {@code Move}
	 */
	public Move getLastMove() {
		return this.moves.get(this.moves.size() - 1);
	}

	// =========================================================================
	// ADD/DELETE-MOVE - METHOD
	// =========================================================================

	/**
	 * Adds a new {@code Move} to the end of this {@code MoveArray}.
	 * 
	 * @param move	the {@code Move} which gets added to the end of
	 * 				this {@code MoveArray}
	 */
	public void addMove(Move move) {
		this.moves.add(new Move(move));
		
		return;
	}

	/**
	 * Deletes the last {@code Move} in this {@code MoveArray}.
	 */
	public void deleteLastMove() {
		this.moves.remove(this.getSize() - 1);
		return;
	}

	// =========================================================================
	// TRIM - METHOD
	// =========================================================================

	/**
	 * Cuts the {@code Move}s between start and end in this
	 * {@code MoveArray} away.
	 * 
	 * @param start		the index for the first removed {@code Move}
	 * @param end		the index after the last removed {@code Move}
	 */
	public void cut(int start, int end) {
		for (int i = start; i < end; i++) {
			this.moves.remove(i);
		}

		return;
	}

	// =========================================================================
	// CHANGE-MOVES-ARRAY - METHOD
	// =========================================================================

	/**
	 * TODO
	 * 
	 * Changes every {@code Move} after changeIndex this
	 * {@code MoveArray} to the a new {@code Move} defined by the
	 * {@code BlockArray} newState.
	 * 
	 * @param oldState			the old {@code BlockArray}
	 * @param newState			the new {@code BlockArray}
	 * @param changeIndex		the index at which the changes in this
	 * 							{@code MoveArray} occurs
	 */
	public void change(BlockArray oldState, BlockArray newState, int changeIndex) {
		List<String[]> blockChanges = new ArrayList<>();
		
		for (Block blk : oldState) {
			blockChanges.add(new String[] {blk.getName(),
					newState.getBlock(blk.getPositions().getMinPosition()).getName()});
		}
		
		for (String[] str : blockChanges) {
			if (str[0].equals(str[1])) {
				blockChanges.remove(str);
			}
		}
		
		for (int i = changeIndex; i < this.getSize(); i++) {
			for (String[] str : blockChanges) {
				if (str[0].equals(this.moves.get(i).getName())) {
					this.moves.set(i, new Move(str[1], this.moves.get(i).getDirection()));
				}
			}
		}
		
		return;
	}
	
	// =========================================================================
	// EQUALS AND HASH-CODE - METHODS
	// =========================================================================

	/**TODO
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
		// Object must be MoveArray at this point
		MoveArray other = (MoveArray) obj;
		return (this.moves == other.moves)
				|| ((this.moves != null) && this.moves.equals(other.moves));
	}

	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 7;
		hash = prime * hash + ((this.moves == null) ? 0 : this.moves.hashCode());
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
		return "MoveArray [moves=" + this.moves + "]";
	}
	
	// -------------------------------------------------------------------------
	// ITERABLE
	// -------------------------------------------------------------------------

	/**
	 * Returns an {@code Iterator} over all {@code Move}s.
	 */
	@Override
	public Iterator<Move> iterator() {
		return this.moves.iterator();
	}

	// =========================================================================

}
