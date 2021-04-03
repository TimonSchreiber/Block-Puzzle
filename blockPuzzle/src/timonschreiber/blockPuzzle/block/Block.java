package timonschreiber.blockPuzzle.block;

import java.awt.Color;

import timonschreiber.blockPuzzle.field.Direction;

/** TODO
 * Block Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 13
 */
public final class Block {

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================
	
	/** static counter for different types of {@code Block}s */
	private static final int[] blockCounter = new int[BlockType.getSize()];
	
	// -------------------------------------------------------------------------

	/** String with the name of the {@code Block}*/
	private final String blockName;
	
	/** {@code Color} of the {@code Block} */
	private final Color color;
	
	/** {@code PositionSet} with every {@code Position} the {@code Block} */
	private final PositionSet positions;

	// =========================================================================
	// CONSTRUCTROS
	// =========================================================================
	
	/**
	 * Class constructor with size and {@code BlockName}.
	 * 
	 * @param position		the {@code Position}
	 * @param size			the length of the {@code PositionSet}
	 * @param direction		the {@code Direction}
	 */
	public Block(Position position, int size, Direction direction) {
		this.blockName = new String(BlockType.getPrefix(size)
				+ ++Block.blockCounter[size - 1]);

		this.color = this.createColor(size);
		
		this.positions = new PositionSet(position, size, direction);
	}

	/** TODO is needed?
	 * Copy constructor.
	 * 
	 * @param block		the {@code Block}
	 */
	public Block(Block block) {
		this.blockName = new String(block.blockName);
		this.color = new Color(block.color.getRGB());
		this.positions = new PositionSet(block.positions);
	}

	// =========================================================================
	// GETTER - METHODS
	// =========================================================================
	
	/**
	 * Gets the {@code Color} of this {@code Block}.
	 * 
	 * @return	the {@code Color}
	 */
	public Color getColor() {
		return new Color(this.color.getRGB());
	}

	/** TODO
	 * 
	 * @return
	 */
	public String getName() {
		return new String(this.blockName);
	}
	
	/** TODO
	 * 
	 * @return
	 */
	public PositionSet getPositions() {
		return new PositionSet(this.positions);
	}
	
	// =========================================================================
	// CREATE - METHOD
	// =========================================================================
	
	/**
	 * Creates the {@code Color} for the {@code Block} by repeatedly using
	 * {@link Color#darker()} for each {@code Block} of the same
	 * {@code BlockType} that was already created.
	 * 
	 * @param size	the size
	 * @return		a darker {@code Color}
	 */
	private Color createColor(int size) {
		Color tmpClr = BlockType.getColor(size);
		
		for (int i = 1; i < Block.blockCounter[size - 1]; i++) {
			tmpClr = tmpClr.darker();
		}
		
		return tmpClr;
	}

	// =========================================================================
	// MOVE - METHOD
	// =========================================================================

	/** TODO is void here OK? or do i need to return a new Block?
	 * 
	 * Moves this {@code Block} by changing every {@code Position}
	 * to an adjacent coordinate.
	 * 
	 * @param direction		the {@code Direction}
	 */
	public void moveTowards(Direction direction) {
		this.positions.moveTowards(direction);
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
		
		// Object must be Block at this point
		Block other = (Block) obj;
		
		return ((this.blockName == other.blockName)
				|| ((this.blockName != null) && this.blockName.equals(other.blockName)))
				&& ((this.color == other.color)
				|| ((this.color != null) && this.color.equals(other.color)))
				&& ((this.positions == other.positions)
				|| ((this.positions != null) && this.positions.equals(other.positions)));
	}
	
	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 7;
		
		hash = prime * hash + ((this.blockName == null) ? 0 : this.blockName.hashCode());
		hash = prime * hash + ((this.color == null) ? 0 : this.color.hashCode());
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
		return "Block [blockName=" + this.blockName + ", positions=" + this.positions + "]";
	}

	// =========================================================================

}
