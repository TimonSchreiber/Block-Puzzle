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
	private final String BLOCK_NAME;
	
	/** Direction */
	private final Direction DIRECTION;

	// =========================================================================
	// CONSTRUCTOR
	// =========================================================================

	/** Class constructor form a {@code BlockName} and {@code Direction}.
	 * 
	 * @param blockName		the {@code BlockName}
	 * @param direction		the {@code Direction}
	 */
	public Move(String blockName, Direction direction) {
		this.BLOCK_NAME = new String(blockName);
		this.DIRECTION = direction;
	}

	/**
	 * Copy constructor.
	 * 
	 * @param move	the {@code Move}
	 */
	public Move(Move move) {
		this.BLOCK_NAME = new String(move.BLOCK_NAME);
		this.DIRECTION = move.DIRECTION;
	}

	// =========================================================================
	// GETTER - METHODS
	// =========================================================================

	/** TODO
	 * 
	 * @return
	 */
	public String getName() {
		return new String(this.BLOCK_NAME);
	}

	/**
	 * Gets the {@code Direction}.
	 * 
	 * @return	the {@code Direction}
	 */
	public Direction getDirection() {
		return this.DIRECTION;
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
		return new Move(name, this.DIRECTION);
	}

	// =========================================================================
	// REVERSE - METHOD
	// =========================================================================

	/**
	 * Gets a new {@code Move} with the reversed {@code Direction} of
	 * this {@code Move}.
	 * 
	 * @return	the new {@code Move} with reversed {@code Direction}
	 */
	public Move reverse() {
		return new Move(this.BLOCK_NAME, this.DIRECTION.reverse());
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
		
		return ((this.BLOCK_NAME == other.BLOCK_NAME)
				|| ((this.BLOCK_NAME != null) && this.BLOCK_NAME.equals(other.BLOCK_NAME)))
				&& ((this.DIRECTION == other.DIRECTION)
				|| ((this.DIRECTION != null) && this.DIRECTION.equals(other.DIRECTION)));
	}
	
	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 7;
		
		hash = prime * hash + ((this.BLOCK_NAME == null) ? 0 : this.BLOCK_NAME.hashCode());
		hash = prime * hash + ((this.DIRECTION == null) ? 0 : this.DIRECTION.hashCode());
		
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
		return "Move [blockName=" + this.BLOCK_NAME + ", direction=" + this.DIRECTION + "]";
	}

	// =========================================================================

}
