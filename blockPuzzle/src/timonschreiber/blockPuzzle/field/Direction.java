package timonschreiber.blockPuzzle.field;

/** TODO is #next() used?
 * Direction Class
 * 
 * @author Timon Schreiber
 * @version 1.1 2021 February 11
 */
public enum Direction {

	// =========================================================================
	// CONSTANTS
	// =========================================================================

	D, L, U, R;

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================

	/**
	 * Array of <code>Direction</code>s with the value of every
	 * <code>Direction</code> constant.
	 */
	private static Direction[] VALUES = Direction.values();

	// =========================================================================
	// GETTER - METHOD
	// =========================================================================

	/**
	 * Gets the number of <code>Direction</code> constants.
	 * 
	 * @return	the number of <code>Direction</code> constants
	 */
	public static int getSize() {
		return Direction.VALUES.length;
	}

	// =========================================================================
	// NEXT - METHOD
	// =========================================================================

	/**
	 * Returns the next <code>Direction</code> constant.
	 * 
	 * @return	the next <code>Direction</code> constant
	 */
	public Direction next() {
		return Direction.VALUES[(this.ordinal() + 1) % Direction.VALUES.length];
	}

	// =========================================================================
	// REVERSE - METHOD
	// =========================================================================

	/**
	 * Returns the opposite <code>Direction</code> constant.
	 * 
	 * @return	the opposite <code>Direction</code> constant
	 */
	public Direction reverse() {
		return Direction.VALUES[(this.ordinal() + 2) % Direction.VALUES.length];
	}

	// =========================================================================

}
