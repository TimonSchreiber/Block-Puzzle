package timonschreiber.blockPuzzle.blocks;

import java.awt.Color;

import timonschreiber.blockPuzzle.field.BlockArray;
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
	
	/** {@code Color} */
	private final Color color;
	
	/** {@code PositionArray} */
	private final PositionArray positions;

	// =========================================================================
	// CONSTRUCTROS
	// =========================================================================
	
	/**
	 * Class constructor with size and {@code BlockName}.
	 * 
	 * @param position		the {@code Position}
	 * @param size			the length of the {@code PositionArray}
	 * @param direction		the {@code Direction}
	 */
	public Block(Position position, int size, Direction direction) {
		this.blockName = BlockType.getPrefix(size)
				+ ++Block.blockCounter[size - 1];

		this.color = this.createColor(size);
		
		this.positions = this.createPositionArray(position, direction, size);
	}

	/** TODO is needed?
	 * Class constructor from a {@code Block}.
	 * 
	 * @param block		the {@code Block}
	 */
	public Block(Block block) {
		this.blockName = new String(block.blockName);
		this.color = new Color(block.color.getRGB());
		this.positions = new PositionArray(block.positions);
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
	public PositionArray getPositions() {
		return new PositionArray(this.positions);
	}
	
	// =========================================================================
	// CREATE - METHOD
	// =========================================================================

	/** TODO
	 * Defines the second, third and fourth {@code Position} for this
	 * {@code Block} with the given {@code Direction}.
	 * 
	 * @param direction		the {@code Direction}
	 * @param size			the size
	 */
	private PositionArray createPositionArray(Position position,
											Direction direction, int size) {
		Direction nextDir = direction.next();
		PositionArray tmpPA = new PositionArray(position);
		
		if (size >= 2) {
			tmpPA.addPosition(direction);
		}
		if (size >= 3) {
			tmpPA.addPosition(nextDir);
		}
		if (size >= 4) {
			tmpPA.addPosition(direction, nextDir);
		}

		return tmpPA;
	}
	
	/** TODO
	 * 
	 * @param size
	 * @return
	 */
	private Color createColor(int size) {
		Color tmpClr = BlockType.getColor(size);
		
		for (int i = 1; i < Block.blockCounter[size - 1]; i++) {
			tmpClr = tmpClr.darker();
		}
		
		return tmpClr;
	}

	// =========================================================================
	// IS-EQUAL - METHODS
	// =========================================================================

	/** TODO is needed?
	 * Checks if this {@code Block} has the same {@code Position}s
	 * as the second {@code Block}.
	 * 
	 * @param blocks	the {@code BlockArray}
	 * @return			{@code true} if this {@code Block} has the
	 * 					same {@code Position}s as one of the other
	 * 					{@code Block}s; {@code false} otherwise
	 */
	public boolean isEqualBlock(BlockArray blocks) {
		int counter;
		for (Block blk : blocks) {
			if (this.positions.getSize() == blk.getPositions().getSize()) {
				counter = 0;
				for (Position pos : this.positions) {
					if (blk.getPositions().contains(pos)) {
						counter++;
					}
				}
				if (counter == this.positions.getSize()) {
					return true;
				}
			}
		}
		return false;
	}

	// =========================================================================
	// MOVE - METHOD
	// =========================================================================

	/** TODO is void here OK? or do i need to return a new Block
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
