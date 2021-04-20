package timonschreiber.blockPuzzle.block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import timonschreiber.blockPuzzle.field.Direction;

/** TODO firstPosition needed? Find a better way!
 * Position Array Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 24
 */
public final class PositionList implements Iterable<Position>, Comparable<PositionList> {
	
	// =========================================================================
	// ATTRIBUTES
	// =========================================================================
	
	/** SortedSet of {@code Position}s */
	private final List<Position> POSITIONS;
	
	// =========================================================================
	// CONSTRUCTORS
	// =========================================================================
	
	/** TODO
	 * Class constructor form a {@code BlockInfo}.
	 * 
	 * @param blockInfo
	 */
	public PositionList(BlockInfo blockInfo) {
		this.POSITIONS = new ArrayList<>();
		
		switch (blockInfo.size()) {
		case 4:
			this.POSITIONS.add(
					blockInfo.position().moveTowards(
							blockInfo.direction(),
							blockInfo.direction().next()));
			/* falls through */
		case 3:
			this.POSITIONS.add(
					blockInfo.position().moveTowards(
							blockInfo.direction().next()));
			/* falls through */
		case 2:
			this.POSITIONS.add(
					blockInfo.position().moveTowards(
							blockInfo.direction()));
			/* falls through */
		default:
			this.POSITIONS.add(
					blockInfo.position());
			break;
		}

		Collections.sort(this.POSITIONS);
	}
	
	/**
	 * Copy constructor.
	 * 
	 * @param positions
	 */
	public PositionList(PositionList positions) {
		this.POSITIONS = new ArrayList<>();
		
		for (Position pos : positions) {
			this.POSITIONS.add(new Position(pos));
		} 

		Collections.sort(this.POSITIONS);
	}
	
	// =========================================================================
	// GETTER - METHODS
	// =========================================================================
	
	/** TODO
	 * 
	 * @param position
	 * @return
	 */
	public boolean contains(Position position) {
		return this.POSITIONS.contains(position);
	}
	
	/** TODO
	 * 
	 * @return
	 */
	public int getSize() {
		return this.POSITIONS.size();
	}
	
	/** TODO
	 * Gets the lowest {@code Position} value of this {@code PositionList}.
	 * 
	 * @return	the lowest {@code Position}
	 */
	public Position getFirst() {
		return this.POSITIONS.get(0);
	}
	
	// =========================================================================
	// MOVE-TOWARDS - METHOD
	// =========================================================================
	
	/** TODO
	 * 
	 * @param directions
	 */
	public void moveTowards(Direction... directions) {
		this.POSITIONS.replaceAll(pos -> pos.moveTowards(directions));
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
		
		// Object must be PositionList at this point
		PositionList other = (PositionList) obj;
		
		return (this.POSITIONS == other.POSITIONS)
					|| ((this.POSITIONS != null)
						&& (this.POSITIONS.equals(other.POSITIONS)));
	}
	
	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int hash = 7;
		
		hash = PRIME * hash + ((this.POSITIONS == null)
									? 0
									: this.POSITIONS.hashCode());
		
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
		return "PositionList [positions=" + this.POSITIONS + "]";
	}
	
	// =========================================================================
	// INTERFACE - METHODS
	// =========================================================================
	
	// -------------------------------------------------------------------------
	// ITERABLE
	// -------------------------------------------------------------------------

	/**
	 * Returns an {@code Iterator} over all {@code Position}s.
	 */
	@Override
	public Iterator<Position> iterator() {
		return this.POSITIONS.iterator();
	}
	
	// -------------------------------------------------------------------------
	// COMPARABLE
	// -------------------------------------------------------------------------

	/** TODO
	 * 
	 */
	@Override
	public int compareTo(PositionList o) {
		return (this.getSize() != o.getSize())
					? Integer.compare(o.getSize(), this.getSize())	// larger Blocks before smaller Blocks
					: this.getFirst().compareTo(o.getFirst());
	}
	
	// =========================================================================
	
}
