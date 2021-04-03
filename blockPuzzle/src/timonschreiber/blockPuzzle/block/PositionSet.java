package timonschreiber.blockPuzzle.block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import timonschreiber.blockPuzzle.field.Direction;

/** TODO firstPosition needed? Find a better way!
 * Position Array Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 24
 */
public final class PositionSet implements Iterable<Position> {
	
	// =========================================================================
	// ATTRIBUTES
	// =========================================================================
	
	/** SortedSet of {@code Position}s */
	private final List<Position> positions;
	
	// =========================================================================
	// CONSTRUCTORS
	// =========================================================================
	
	/** TODO
	 * Class constructor form a {@code Position} with additional information
	 * in the form of size and direction.
	 * 
	 * @param position		the {@code Position}
	 * @param size			the {@code size}
	 * @param direction		the {@code Direction}
	 */
	public PositionSet(Position position, int size, Direction direction) {
		this.positions = new ArrayList<>();
		
		switch (size) {
		case 4:
			this.positions.add(position.moveTowards(direction));
			/* falls through */
		case 3:
			this.positions.add(position.moveTowards(direction.reverse()));
			/* falls through */
		case 2:
			this.positions.add(position.moveTowards(direction, direction.reverse()));
			break;
		default:
			break;
		}
		
		this.positions.sort(null);
	}
	
	/**
	 * Class constructor from {@code Position} values.
	 * 
	 * @param position	the {@code Position} values
	 */
	public PositionSet(Position... positions) {
		this.positions = new ArrayList<>();
		
		for (Position pos : positions) {
			this.positions.add(new Position(pos));
		}
		
		this.positions.sort(null);
	}
	
	/**
	 * Copy constructor.
	 * 
	 * @param positions
	 */
	public PositionSet(PositionSet positions) {
		this.positions = new ArrayList<>();
		
		for (Position pos : positions) {
			this.positions.add(new Position(pos));
		} 

		this.positions.sort(null);
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
		return this.positions.contains(position);
	}
	
	/** TODO
	 * 
	 * @return
	 */
	public int getSize() {
		return this.positions.size();
	}
	
	/** TODO
	 * Gets the lowest {@code Position} value of this {@code PositionSet}.
	 * 
	 * @return	the lowest {@code Position}
	 */
	public Position getFirst() {
		return this.positions.get(0);
	}
	
	// =========================================================================
	// MOVE-TOWARDS - METHOD
	// =========================================================================
	
	/** TODO is this the best way and (/or even) efficient? (new ArrayList)
	 * 
	 * @param directions
	 */
	public void moveTowards(Direction... directions) {
		this.positions.replaceAll(p -> p.moveTowards(directions));
		
		return;
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
		
		// Object must be PositionSet at this point
		PositionSet other = (PositionSet) obj;
		
		return (this.positions == other.positions)
				|| ((this.positions != null) && (this.positions.equals(other.positions)));
	}
	
	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 7;
		
		hash = prime * hash + ((this.positions == null) ? 0 : this.positions.hashCode());
		
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
		return "PositionSet [positions=" + this.positions + "]";
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
		return this.positions.iterator();
	}
	
	// =========================================================================
	
}
