package timonschreiber.blockPuzzle.blocks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import timonschreiber.blockPuzzle.field.Direction;
import timonschreiber.blockPuzzle.field.GameField;

/**
 * Position Array Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 24
 */
public final class PositionSet implements Iterable<Position> {
	
	// =========================================================================
	// ATTRIBUTES
	// =========================================================================

	/** Position List */
	private final Position firstPosition;
	private final Set<Position> positions;
	
	// =========================================================================
	// CONSTRUCTORS
	// =========================================================================
	
	/**
	 * Class constructor from {@code Position} values.
	 * 
	 * @param position	the {@code Position} values
	 */
	public PositionSet(Position... positions) {
		this.firstPosition = new Position(positions[0].getX(), positions[0].getY());
		this.positions = new HashSet<>();
		
		for (Position pos : positions) {
			this.positions.add(new Position(pos.getX(), pos.getY()));
		}
	}
	
	/**
	 * Copy constructor.
	 * 
	 * @param positions
	 */
	public PositionSet(PositionSet positions) {
		this.firstPosition = positions.getMinPosition();
		this.positions = new HashSet<>();
		
		for (Position pos : positions) {
			this.positions.add(new Position(pos));
		} 
		
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
	public Position getMinPosition() {
		int x = GameField.WIDTH;
		int y = GameField.HEIGHT;

		for (Position pos: this.positions) {
			if ((pos.getX() + pos.getY()) < (x + y)) {
				x = pos.getX();
				y = pos.getY();
			}
		}

		return new Position(x, y);
	}

	// =========================================================================
	// ADD - METHOD
	// =========================================================================
	
	/** TODO
	 * 
	 * @param directions
	 */
	public void addPosition(Direction... directions) {
		this.positions.add(this.firstPosition.moveTowards(directions));
		
		return;
	}
	
	// =========================================================================
	// MOVE-TOWARDS - METHOD
	// =========================================================================
	
	/** TODO is this the best way and (or even) efficient?
	 * 
	 * @param directions
	 */
	public void moveTowards(Direction... directions) {
		List<Position> tmpList = new ArrayList<>();
		
		this.positions.forEach(pos -> tmpList.add(pos.moveTowards(directions)));
		
		this.positions.clear();
		
		tmpList.forEach(pos -> this.positions.add(pos));
		
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
