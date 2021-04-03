package timonschreiber.blockPuzzle.block;

import timonschreiber.blockPuzzle.field.Direction;

/**
 * Position Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 21
 */
public final class Position implements Comparable<Position> {

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================

	/** x- and y-coordinates */
	private final int X;
	private final int Y;

	// =========================================================================
	// CONSTRUCTORS
	// =========================================================================

	/**
	 * Class constructor from a pair of x- and y-coordinates.
	 * 
	 * @param x		the x-coordinate
	 * @param y		the y-coordinate
	 */
	public Position(int x, int y) {
		this.X = x;
		this.Y = y;
	}
	
	/**
	 * Copy constructor.
	 * 
	 * @param position	the {@code Position}
	 */
	public Position(Position position) {
		this.X = position.X;
		this.Y = position.Y;
	}

	// =========================================================================
	// GETTER - METHODS
	// =========================================================================

	/**
	 * Gets the x-coordinate of this {@code Position}.
	 * 
	 * @return	the x-coordinate
	 */
	public int getX() {
		return this.X;
	}

	/**
	 * Gets the y-coordinate of this {@code Position}.
	 * 
	 * @return	the y-coordinate
	 */
	public int getY() {
		return this.Y;
	}

	// =========================================================================
	// MOVE - METHODS
	// =========================================================================

	/** TODO
	 * 
	 * @param directions
	 * @return
	 */
	public Position moveTowards(Direction... directions) {
		int x = this.X;
		int y = this.Y;
		
		for (Direction dir : directions) {
			switch (dir) {
			case D: y--; break;
			case L: x--; break;
			case R: x++; break;
			case U: y++; break;
			}
		}
		
		return new Position(x, y);
	}
	
	// =========================================================================
	// IN-INTERVAL - METHODS
	// =========================================================================
	
	/** TODO
	 * 
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
	 * @return
	 */
	public boolean isInInterval(int xMin, int xMax, int yMin, int yMax) {
		return (this.X >= xMin) && (this.X < xMax)
				&& (this.Y >= yMin) && (this.Y < yMax);
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
		
		// Object must be Position at this point
		Position other = (Position) obj;
		
		return (this.X == other.X) && (this.Y == other.Y);
	}
	
	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 7;
		
		hash = prime * hash + this.X;
		hash = prime * hash + this.Y;
		
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
		return "Position [x=" + this.X + ", y=" + this.Y + "]";
	}
	
	// =========================================================================
	// INTERFACE - METHOD
	// =========================================================================
	
	// -------------------------------------------------------------------------
	// COMPARABLE
	// -------------------------------------------------------------------------

	@Override
	public int compareTo(Position other) {
		return (this.X != other.X) ? Integer.compare(this.X, other.X)
				: Integer.compare(this.Y, other.Y);
	}

	// =========================================================================

}
