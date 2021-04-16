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
	private static final int[] BLOCK_COUNTER = new int[BlockType.getSize() + 1];
	
	// -------------------------------------------------------------------------

	/** String with the name of the {@code Block}*/
	private final String BLOCK_NAME;
	
	/** {@code Color} of the {@code Block} */
	private final Color COLOR;
	
	/** {@code PositionList} with every {@code Position} the {@code Block} */
	private final PositionList POSITIONS;

	// =========================================================================
	// CONSTRUCTROS
	// =========================================================================
	
	/**
	 * Class constructor with size and {@code BlockName}.
	 * 
	 * @param position		the {@code Position}
	 * @param size			the length of the {@code PositionList}
	 * @param direction		the {@code Direction}
	 */
	public Block(BlockInfo blockInfo) {
		this.BLOCK_NAME = BlockType.getPrefix(blockInfo.size())
				+ ++Block.BLOCK_COUNTER[blockInfo.size()];

		this.COLOR = Block.createColor(blockInfo.size());
		
		this.POSITIONS = new PositionList(blockInfo);
	}

	/** TODO is needed?
	 * Copy constructor.
	 * 
	 * @param block		the {@code Block}
	 */
	public Block(Block block) {
		this.BLOCK_NAME = new String(block.BLOCK_NAME);
		this.COLOR = new Color(block.COLOR.getRGB());
		this.POSITIONS = new PositionList(block.POSITIONS);
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
		return new Color(this.COLOR.getRGB());
	}

	/** TODO
	 * 
	 * @return
	 */
	public String getName() {
		return new String(this.BLOCK_NAME);
	}
	
	/** TODO
	 * 
	 * @return
	 */
	public PositionList getPositions() {
		return new PositionList(this.POSITIONS);
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
	private static Color createColor(int size) {
		Color tmpClr = BlockType.getColor(size);
		
		for (int i = 1; i < Block.BLOCK_COUNTER[size]; i++) {
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
		this.POSITIONS.moveTowards(direction);
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
		
		return (this.POSITIONS.getSize() == other.POSITIONS.getSize())	// XXX
//				((this.BLOCK_NAME == other.BLOCK_NAME)
//					|| ((this.BLOCK_NAME != null)
//						&& this.BLOCK_NAME.equals(other.BLOCK_NAME)))
//				&& ((this.COLOR == other.COLOR)
//						|| ((this.COLOR != null)
//							&& this.COLOR.equals(other.COLOR)))
				&& ((this.POSITIONS == other.POSITIONS)
						|| ((this.POSITIONS != null)
							&& this.POSITIONS.equals(other.POSITIONS)));
	}
	
	/** TODO
	 * 
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int hash = 7;
		
		hash = PRIME * hash + this.POSITIONS.getSize();	// XXX
//		hash = prime * hash + ((this.BLOCK_NAME == null)
//									? 0
//									: this.BLOCK_NAME.hashCode());
//		hash = prime * hash + ((this.COLOR == null)
//									? 0
//									: this.COLOR.hashCode());
		hash = PRIME * hash + ((this.POSITIONS == null)
									? 0
									: this.POSITIONS.hashCode());
		
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
		return "Block [blockName=" + this.BLOCK_NAME + ", positions=" + this.POSITIONS + "]";
	}

	// =========================================================================

}
