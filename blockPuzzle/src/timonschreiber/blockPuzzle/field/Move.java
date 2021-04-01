package timonschreiber.blockPuzzle.field;

/**
 * Move Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 22
 */
public final class Move {

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================

	/** String with blockName */
	private final String blockName;
	
	/** Direction */
	private final Direction direction;

	// =========================================================================
	// CONSTRUCTOR
	// =========================================================================

	/** Class constructor form a {@code BlockName} and {@code Direction}.
	 * 
	 * @param blockName		the {@code BlockName}
	 * @param direction		the {@code Direction}
	 */
	public Move(String blockName, Direction direction) {
		this.blockName = new String(blockName);
		this.direction = direction;
	}

	/**
	 * Class constructor from a {@code Move}.
	 * 
	 * @param move	the {@code Move}
	 */
	public Move(Move move) {
		this.blockName = new String(move.blockName);
		this.direction = move.direction;
	}

	// =========================================================================
	// GETTER - METHODS
	// =========================================================================

	/** TODO
	 * 
	 * @return
	 */
	public String getName() {
		return new String(this.blockName);
	}

	/**
	 * Gets the {@code Direction}.
	 * 
	 * @return	the {@code Direction}
	 */
	public Direction getDirection() {
		return this.direction;
	}
	
	// =========================================================================
	// CHANGE-NAME - METHOD
	// =========================================================================
	
	/** TODO
	 * 
	 * @param name
	 * @return
	 */
	public Move changeName(String name) {
		return new Move(name, this.direction);
	}

	// =========================================================================
	// REVERSE - METHOD
	// =========================================================================

	/**
	 * Gets a new {@code Move} with the reversed {@code Direction} of
	 * this {@code Move}:
	 * 
	 * <ul>
	 * <li>UP		-> DOWN
	 * <li>LEFT		-> RIGHT
	 * <li>RIGHT	-> LEFT
	 * <li>DOWN		-> UP
	 * </ul>
	 * 
	 * @return	the new {@code Move} with reversed {@code Direction}
	 */
	public Move reverse() {
		return new Move(this.blockName, this.direction.reverse());
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
		// Object must be Move at this point
		Move other = (Move) obj;
		return ((this.blockName == other.blockName)
				|| ((this.blockName != null) && this.blockName.equals(other.blockName)))
				&& ((this.direction == other.direction)
				|| ((this.direction != null) && this.direction.equals(other.direction)));
	}
	
	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 7;
		hash = prime * hash + ((this.blockName == null) ? 0 : this.blockName.hashCode());
		hash = prime * hash + ((this.direction == null) ? 0 : this.direction.hashCode());
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
		return "Move [blockName=" + this.blockName + ", direction=" + this.direction + "]";
	}

	// =========================================================================

}
