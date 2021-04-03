package timonschreiber.blockPuzzle.blocks;

import timonschreiber.blockPuzzle.field.Direction;

/**
 * Position Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 21
 */
public final class Position {

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================

	/** x- and y-coordinates */
	private final int x;
	private final int y;

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
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Copy constructor.
	 * 
	 * @param position	the {@code Position}
	 */
	public Position(Position position) {
		this.x = position.x;
		this.y = position.y;
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
		return this.x;
	}

	/**
	 * Gets the y-coordinate of this {@code Position}.
	 * 
	 * @return	the y-coordinate
	 */
	public int getY() {
		return this.y;
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
		int x = this.x;
		int y = this.y;
		
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
		return (this.x >= xMin) && (this.x < xMax)
				&& (this.y >= yMin) && (this.y < yMax);
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
		
		return (this.x == other.x) && (this.y == other.y);
	}
	
	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 7;
		
		hash = prime * hash + this.x;
		hash = prime * hash + this.y;
		
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
		return "Position [x=" + this.x + ", y=" + this.y + "]";
	}

	// =========================================================================

}
