package timonschreiber.blockPuzzle.field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import timonschreiber.blockPuzzle.block.Block;

/**
 * Move Array Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 11
 */
public final class MoveList implements Iterable<Move> {

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================

	/** List with {@code Move}s */
	private final List<Move> MOVES;

	// =========================================================================
	// CONSTRUCTOR
	// =========================================================================

	/**
	 * Class constructor.
	 */
	public MoveList() {
		this.MOVES = new ArrayList<>();
	}

	// =========================================================================
	// GETTER - METHODS
	// =========================================================================

	/**
	 * Gets the number of {@code Move}s in this {@code MoveList}.
	 * 
	 * @return	the size of this {@code MoveList}
	 */
	public int getSize() {
		return this.MOVES.size();
	}

	/**
	 * Gets a specific {@code Move} from this {@code MoveList}.
	 * 
	 * @param index		the index of the {@code Move}
	 * @return			the {@code Move} at the specified index
	 */
	public Move getMove(int index) {
		return new Move(this.MOVES.get(index));
	}
	
	/**
	 * Gets the last {@code Move} in this {@code MoveList}.
	 * 
	 * @return		the last {@code Move}
	 */
	public Move getLastMove() {
		return this.getMove(this.MOVES.size() - 1);
	}

	// =========================================================================
	// ADD/DELETE-MOVE - METHOD
	// =========================================================================

	/**
	 * Adds a new {@code Move} to the end of this {@code MoveList}.
	 * 
	 * @param move	the {@code Move} which gets added to the end of
	 * 				this {@code MoveList}
	 */
	public void addMove(Move move) {
		this.MOVES.add(new Move(move));
		return;
	}

	/**
	 * Deletes the last {@code Move} in this {@code MoveList}.
	 */
	public void deleteLastMove() {
		this.MOVES.remove(this.getSize() - 1);
		return;
	}

	// =========================================================================
	// CUT - METHOD
	// =========================================================================

	/**
	 * Cuts the {@code Move}s between start and end in this
	 * {@code MoveList} away.
	 * 
	 * @param start		the index for the first removed {@code Move}
	 * @param end		the index after the last removed {@code Move}
	 */
	public int cut(int start, int end) {
		int counter = 0;
		
		for (int i = start; i < end; i++) {
			this.MOVES.remove(i);
			counter++;
		}

		return counter;
	}

	// =========================================================================
	// CHANGE - METHOD
	// =========================================================================

	/**
	 * TODO
	 * 
	 * Changes every {@code Move} after changeIndex of the {@code MoveList} to
	 * the new {@code Move} defined by the {@code BlockSet} newState.
	 * 
	 * @param oldState			the old {@code BlockSet}
	 * @param newState			the new {@code BlockSet}
	 * @param changeIndex		the index at which the changes in this
	 * 							{@code MoveList} starts
	 */
	public void change(BlockSet oldState, BlockSet newState, int changeIndex) {
		
		Map<String, String> nameChanges = new HashMap<>();
		ListIterator<Move> listIter = this.MOVES.listIterator(changeIndex);
		
		for (Block blk : oldState) {
			nameChanges.put(blk.getName(),
					newState.getBlock(blk.getPositions().getFirst()).getName());
		}
		
		listIter.forEachRemaining(
				mv -> mv.changeName(nameChanges.get(mv.getName())));
		
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
		
		// Object must be MoveList at this point
		MoveList other = (MoveList) obj;
		
		return (this.MOVES == other.MOVES)
					|| ((this.MOVES != null)
						&& this.MOVES.equals(other.MOVES));
	}

	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int hash = 7;
		
		hash = PRIME * hash + ((this.MOVES == null)
									? 0
									: this.MOVES.hashCode());
		
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
		return "MoveList [moves=" + this.MOVES + "]";
	}
	
	// -------------------------------------------------------------------------
	// ITERABLE
	// -------------------------------------------------------------------------

	/**
	 * Returns an {@code Iterator} over all {@code Move}s.
	 */
	@Override
	public Iterator<Move> iterator() {
		return this.MOVES.iterator();
	}

	// =========================================================================

}
