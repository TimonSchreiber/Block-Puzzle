package timonschreiber.blockPuzzle.field;

import java.awt.Color;

import timonschreiber.auxiliaries.Zeichenblatt;
import timonschreiber.blockPuzzle.blocks.Block;
import timonschreiber.blockPuzzle.blocks.Position;
import timonschreiber.blockPuzzle.blocks.PositionArray;

/** TODO code-tags
 * Game Field Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 13
 */
public class GameField {

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================

	/** preset game values for height, width and max number of Blocks */
	public static final int HEIGHT = 5;
	public static final int WIDTH = 6;
	public static final int MAX_NUMBER_OF_BLOCKS = 14;

	/** Winning Positions */
	public static final PositionArray END_POSITIONS = new PositionArray(
			new Position(4, 0), new Position(4, 1),
			new Position(5, 0), new Position(5, 1) );
	
	// -------------------------------------------------------------------------
	
	/** Changes to True if the victory condition is met */
	private boolean isWon;
	
	/** BlockArray to keep track of every Block */
	private BlockArray blocks;

	/** Canvas to draw the GameField on */
	private Zeichenblatt gameField;

	// =========================================================================
	// CONSTRUCTORS
	// =========================================================================

	/**
	 * Class constructor.
	 */
	public GameField() {
		this.blocks = new BlockArray();
	}

	/**
	 * Class constructor from a {@code BlockArray}.
	 * 
	 * @param blockArray	the {@code BlockArray}
	 */
	public GameField(BlockArray blockArray) {
		this.blocks = new BlockArray();
		
		for (Block blk : blockArray) {
			this.placeBlock(new Block(blk));
		}
	}
	
	/** TODO is needed?
	 * Class constructor from a {@code GameField}.
	 * 
	 * @param gameField		the {@code GameField}
	 */
	public GameField(GameField gameField) {
		this.blocks = new BlockArray();
		
		for (Block blk : gameField.blocks) {
			this.placeBlock(new Block(blk));
		}
	}

	// =========================================================================
	// GETTER - METHODS
	// =========================================================================

	/** TODO
	 * Checks if the Game is won.
	 * 
	 * @return True if the MainBlock reached the winning Position
	 */
	public boolean isWon() {
		return this.isWon;
	}
	
	/** TODO
	 * 
	 * @param block
	 * @return
	 */
	private boolean isWon(Block block) {
		int counter = 0;
		for (Position pos : block.getPositions()) {
			if (GameField.END_POSITIONS.contains(pos)) {
				counter++;
			}
		}
		return counter == GameField.END_POSITIONS.getSize();
	}

	/** TODO
	 * Gets the BlockArray
	 * 
	 * @return	the BlockArray
	 */
	public BlockArray getBlocks() {
		return new BlockArray(this.blocks);
	}

	// =========================================================================
	// PLACE-BLOCK - METHOD
	// =========================================================================

	/** TODO
	 * 
	 * @param block
	 */
	public void placeBlock(Block block) {
		this.blocks.addBlock(new Block(block));
		return;
	}

	// =========================================================================
	// IS-COLLISION-FREE - METHOD
	// =========================================================================

	/** TODO
	 * 
	 * @param move
	 * @return
	 */
	private boolean isCollisionFree(Move move) {
		Position tmpPos;
		Block tmpBlk = new Block(this.blocks.getBlock(move.getName()));

		for (Position pos : tmpBlk.getPositions()) {
			tmpPos = new Position(pos.getX(), pos.getY());
			
			tmpPos = tmpPos.moveTowards(move.getDirection());
			
			if (tmpPos.isInInterval(0, GameField.WIDTH, 0, GameField.HEIGHT)) {
				if (this.blocks.isBlock(tmpPos)) {
					if (this.blocks.getBlock(tmpPos).getName().equals(tmpBlk.getName())) {
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}

	// =========================================================================
	// IS-VALID-MOVE - METHOD
	// =========================================================================

	/** TODO
	 * Moves the Block defined by the Move into the direction of the Move
	 * 
	 * @param move	Move
	 * @return		True if Move was made, otherwise False
	 */
	public boolean isValidMove(Move move) {
		if (this.isCollisionFree(move)) {
			this.blocks.move(move);
			this.isWon = this.isWon(this.getBlocks().getBlock(move.getName()));
			return true;
		}
		return false;
	}

	// =========================================================================
	// PRINT - METHOD
	// =========================================================================

	/** TODO
	 * Prints the Name of each Block for each Position on the Console
	 */
	public void print() {
		Position tmpPos;
		
		for (int i = (GameField.HEIGHT - 1); i >= 0; i--) {
			for (int j = 0; j < GameField.WIDTH; j++) {
				tmpPos = new Position(j, i);
				System.out.print(" ");
				if (this.blocks.isBlock(tmpPos)) {
					System.out.print(this.blocks.getBlock(tmpPos).getName());
				} else {
					System.out.print("__");
				}
				System.out.print(" ");
			}
			System.out.println("\n");
		}
		return;
	}

	// =========================================================================
	// DRAW - METHODS
	// =========================================================================

	/** TODO
	 * Draws the GameField onto a new Zeichenblatt.java.
	 * 
	 * @param size Size the GameField width and height are multiplied with
	 */
	public void draw(int delay) {
		int size = 64;
		
		// new Zeichenblatt.java
		if (this.gameField == null) {
			this.gameField = new Zeichenblatt((GameField.WIDTH + 1) * size,
					(GameField.HEIGHT + 1) * size);
			this.gameField.benutzerkoordinaten(0.0, 0.0,
					GameField.WIDTH + 1,
					GameField.HEIGHT + 1);
		} else {
			this.gameField.loeschen();
		}

		// draw light grey square (outline)
		this.gameField.setVordergrundFarbe(Color.lightGray);
		this.gameField.rechteck(GameField.WIDTH + 1, GameField.HEIGHT + 1);

		// draw red square in the bottom right corner (marks goal)
		this.gameField.setVordergrundFarbe(Color.red);
		for (Position pos : GameField.END_POSITIONS) {
			this.gameField.rechteck(pos.getX() + 0.5,
					pos.getY() + 0.5, 1.0, 1.0);
		}

		// draw white center square (the game field)
		this.gameField.setVordergrundFarbe(Color.white);
		this.gameField.rechteck(0.5, 0.5,
				GameField.WIDTH, GameField.HEIGHT);
		
		// draw each block
		for (Block blk : this.blocks) {
			for (Position pos : blk.getPositions()) {
				this.gameField.setVordergrundFarbe(blk.getColor());
				this.gameField.rechteck(pos.getX() + 0.5,
						pos.getY() + 0.5, 1.0, 1.0);
			}
		}
		
		// show
		this.gameField.anzeigen();
		if (delay > 0) {
			this.gameField.pause(delay);
		}
		
		return;
	}

	/** TODO
	 * Draw the GameField onto a new Zeichenblatt.java with the height and width
	 * multiplied by 64 (medium sized window)
	 */
	public void draw() {
		this.draw(0);
		return;
	}

	// =========================================================================

}
