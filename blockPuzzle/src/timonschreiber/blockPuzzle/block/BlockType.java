package timonschreiber.blockPuzzle.block;

import java.awt.Color;

/**
 * Block Type Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 27
 */
public enum BlockType {
	
	// =========================================================================
	// CONSTANTS
	// =========================================================================
	
	SQUARE			("G", Color.green),
	RECTANGLE		("B", Color.blue),
	ELBOW			("Y", Color.yellow),
	LARGE_SQUARE	("R", Color.red);
	
	// =========================================================================
	// ATTRIBUTES
	// =========================================================================
	
	/** A {@code String} with the first letter of the {@code Color} */
	private final String NAME_PREFIX;
	
	/** the {@code Color} */
	private final Color COLOR;
	
	// =========================================================================
	// CONSTRUCTOR
	// =========================================================================
	
	/**
	 * Class constructor.
	 * 
	 * @param NAME_PREFIX	the NAME_PREFIX
	 * @param COLOR			the COLOR
	 */
	private BlockType(String NAME_PREFIX, Color COLOR) {
		this.NAME_PREFIX = NAME_PREFIX;
		this.COLOR = COLOR;
	}
	
	// =========================================================================
	// ATTRBUTES
	// =========================================================================

	/**
	 * Array of {@code BlockType}s with the value of every {@code BlockType}
	 * constant.
	 */
	private static BlockType[] VALUES = BlockType.values();
	
	// =========================================================================
	// GETTER - METHOD
	// =========================================================================

	/**
	 * Gets the number of {@code BlockType} constants.
	 * 
	 * @return	the number of {@code BlockType} constants
	 */
	public static int getSize() {
		return BlockType.VALUES.length;
	}
	
	/** TODO
	 * 
	 * @param index
	 * @return
	 */
	public static String getPrefix(int area) {
		return BlockType.VALUES[area - 1].NAME_PREFIX;
	}
	
	/** TODO
	 * 
	 * @param size
	 * @return
	 */
	public static Color getColor(int area) {
		return BlockType.VALUES[area - 1].COLOR;
	}
	
	// =========================================================================
	
}
