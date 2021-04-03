package timonschreiber.blockPuzzle.field;

import java.awt.Color;

import timonschreiber.auxiliaries.Zeichenblatt;
import timonschreiber.blockPuzzle.block.Block;
import timonschreiber.blockPuzzle.block.Position;
import timonschreiber.blockPuzzle.block.PositionList;

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

	/** preset game values for height */
	public static final int HEIGHT = 5;
	
	/** preset game values for width */
	public static final int WIDTH = 6;
	
	/** preset game values for max number of {@code Block}s */
	public static final int MAX_NUMBER_OF_BLOCKS = 14;

	/** Winning Positions {@code PositionList}*/
	public static final PositionList END_POSITIONS = new PositionList(
			new Position(4, 0),
			new Position(4, 1),
			new Position(5, 0),
			new Position(5, 1));
	
	// -------------------------------------------------------------------------
	
	/** Changes to {@code true} if the victory condition is met */
	private boolean isWon;
	
	/** {@code BlockArray} to keep track of every {@code Block} */
	private BlockArray blocks;

	/** Canvas to draw the {@code GameField} on */
	private Zeichenblatt canvas;

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

	// =========================================================================
	// GETTER - METHODS
	// =========================================================================

	/** TODO
	 * Checks if the {@code Game} is won.
	 * 
	 * @return	{@code true} if the {@code LargeBlock} reached the winning
	 * Position defined by {@link END_Positions}, {@code false} otherwise.
	 */
	public boolean isWon() {
		return this.isWon;
	}
	
	/** Checks if the {@code Block} satisfies the winning condition.
	 * 
	 * @param block		the {@code Block}
	 * @return			{@code true} if the {@code Block} occupies all
	 * 					{@code Position}s defined by {@link END_POSITION},
	 * 					{@code false} otherwise.
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

	/**
	 * Gets the {@code BlockArray}.
	 * 
	 * @return	the {@code BlockArray}
	 */
	public BlockArray getBlocks() {
		return new BlockArray(this.blocks);
	}

	// =========================================================================
	// PLACE-BLOCK - METHOD
	// =========================================================================

	/**
	 * Places a {@code Block} onto this {@code GameField}.
	 * 
	 * @param block		the {@code Block}
	 */
	public void placeBlock(Block block) {
		this.blocks.addBlock(new Block(block));
		return;
	}

	// =========================================================================
	// IS-COLLISION-FREE - METHOD
	// =========================================================================

	/**
	 * Checks if the {@code Move} can be performed or if this will result in an
	 * illegal {@code GameField} by overlapping two (or more) {@code Block}s, or
	 * by leaving the boundaries of this {@code GameField}.
	 * 
	 * @param move	the {@code Move}
	 * @return		{@code true} if this {@code Move} can be made, {@code false}
	 * 				otherwise.
	 */
	private boolean isCollisionFree(Move move) {
		Position tmpPos;
		Block tmpBlk = new Block(this.blocks.getBlock(move.getName()));

		for (Position pos : tmpBlk.getPositions()) {
			tmpPos = (new Position(pos.getX(), pos.getY())).
					moveTowards(move.getDirection());
			
			// Checks if the new Position is inside the GameField
			if (tmpPos.isInInterval(0, GameField.WIDTH, 0, GameField.HEIGHT)) {
				
				// Checks if there is already a Block at this Positions
				if (this.blocks.isBlock(tmpPos)) {
					
					// Checks if it is the same Block as the one about to be moved
					if (this.blocks.getBlock(tmpPos).getName().equals(
							tmpBlk.getName())) {
						
					} else {
						return false;	// not the same Block
					}
				}
			} else {
				return false;	// outside GameField
			}
		}
		return true;	// inside GameField and no collision
	}

	// =========================================================================
	// IS-VALID-MOVE - METHOD
	// =========================================================================

	/**
	 * Checks if the {@code Block} defined by the {@code Move} can be moved into
	 * the {@code Direction} of the {@code Move}.
	 * 
	 * @param move	the {@code Move}
	 * @return		{@code true} if the {@code Move} was successful,
	 * 				{@code false} otherwise.
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

	/**
	 * Prints the Name of each {@code Block} for each {@code Position} on the
	 * Console and "__" if there is no {@code Block}.
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

	/**
	 * Draws the {@code GameField} onto a {@code Zeichenblatt.java} with a
	 * time-delay.
	 * 
	 * @param delay		the time delay between two {@code Move}s.
	 */
	public void draw(int delay) {
		final int size = 64;
		
		final double one = 1.0;
		final double shift = 0.5;
		
		// new Zeichenblatt.java
		if (this.canvas == null) {
			this.canvas = new Zeichenblatt(
					(int) ((GameField.WIDTH + one) * size),
					(int) ((GameField.HEIGHT + one) * size));
			this.canvas.benutzerkoordinaten(0.0, 0.0,
					GameField.WIDTH + one,
					GameField.HEIGHT + one);
		} else {
			this.canvas.loeschen();
		}

		// draw light grey square (outline)
		this.canvas.setVordergrundFarbe(Color.lightGray);
		this.canvas.rechteck(GameField.WIDTH + one, GameField.HEIGHT + one);

		// draw red square in the bottom right corner (marks goal)
		this.canvas.setVordergrundFarbe(Color.red);

		for (Position pos : GameField.END_POSITIONS) {
			this.canvas.rechteck(pos.getX() + one,
					pos.getY(), one, one);
		}

		// draw white center square (the game field)
		this.canvas.setVordergrundFarbe(Color.white);
		this.canvas.rechteck(shift, shift,
				GameField.WIDTH, GameField.HEIGHT);
		
		// draw each {@code Block}
		for (Block blk : this.blocks) {
			for (Position pos : blk.getPositions()) {
				this.canvas.setVordergrundFarbe(blk.getColor());
				this.canvas.rechteck(pos.getX() + shift,
						pos.getY() + shift, one, one);
			}
		}
		
		// show
		this.canvas.anzeigen();
		if (delay > 0) {
			this.canvas.pause(delay);
		}
		
		return;
	}

	/**
	 * Draws the {@code GameField} onto a {@code Zeichenblatt.java}.
	 */
	public void draw() {
		this.draw(0);
		return;
	}

	// =========================================================================

}
