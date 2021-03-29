package timonschreiber.blockPuzzle.blocks;

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
	
	// TODO
	private final String namePrefix;
	private final Color color;
	
	private BlockType(String namePrefix, Color color) {
		this.namePrefix = namePrefix;
		this.color = color;
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
		return BlockType.VALUES[area - 1].namePrefix;
	}
	
	/** TODO
	 * 
	 * @param size
	 * @return
	 */
	public static Color getColor(int area) {
		return BlockType.VALUES[area - 1].color;
	}
	
	// =========================================================================
	
}
