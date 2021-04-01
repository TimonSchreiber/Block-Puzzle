package timonschreiber.blockPuzzle.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import timonschreiber.blockPuzzle.blocks.Block;
import timonschreiber.blockPuzzle.blocks.Position;
import timonschreiber.blockPuzzle.field.Direction;
import timonschreiber.blockPuzzle.field.GameField;

/** TODO initialize {@link Game#startingPositions} not in a method
 * Game Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 25
 */
public class Game {

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================

	/** {@code Starting Positions} */
	private static final List<StartPosition> startingPositions = new ArrayList<>();
	
	// -------------------------------------------------------------------------

	/** {@code Game Field} */
	protected GameField field;

	// =========================================================================
	// CONSTRUCTOR
	// =========================================================================

	/**
	 * Class constructor with a gameID.
	 * 
	 * @param gameID	the gameID
	 */
	public Game(int gameID) {
		this.field = new GameField();
		Game.setUpStartingPositions();
		
		for (BlockInfo blkInf : Game.startingPositions.get(gameID)) {
			this.field.placeBlock(
					new Block(
							blkInf.position(),
							blkInf.size(),
							blkInf.direction()));
		}

		this.field.draw();
	}

	// =========================================================================
	// STARTING POSITIONS
	// =========================================================================

	/**
	 * Sets up the {@code startPosition}s for the games 0 to 13
	 */
	private static void setUpStartingPositions() {

		// Game 0 - 13 Moves
		
		Game.startingPositions.add(
				new StartPosition(
						new ArrayList<>(
								Arrays.asList(
										new BlockInfo(new Position(4, 2), 4, Direction.R),		// 1 Large Square
										new BlockInfo(new Position(0, 2), 3, Direction.R),		// 4 Elbows
										new BlockInfo(new Position(1, 0), 3, Direction.L),
										new BlockInfo(new Position(0, 4), 3, Direction.R),
										new BlockInfo(new Position(2, 3), 3, Direction.L),
										new BlockInfo(new Position(3, 3), 2, Direction.U),		// 3 Rectangles
										new BlockInfo(new Position(4, 3), 2, Direction.U),
										new BlockInfo(new Position(4, 0), 2, Direction.R),
										new BlockInfo(new Position(2, 0), 1, Direction.D),		// 6 Squares
										new BlockInfo(new Position(3, 0), 1, Direction.D),
										new BlockInfo(new Position(2, 1), 1, Direction.D),
										new BlockInfo(new Position(3, 1), 1, Direction.D),
										new BlockInfo(new Position(2, 2), 1, Direction.D),
										new BlockInfo(new Position(3, 2), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 1 - 43 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(0, 4), 4, Direction.R),		// 1 Large Square
				new BlockInfo(new Position(0, 1), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(2, 0), 3, Direction.L),
				new BlockInfo(new Position(3, 1), 3, Direction.R),
				new BlockInfo(new Position(5, 0), 3, Direction.L),
				new BlockInfo(new Position(4, 2), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(4, 3), 2, Direction.R),
				new BlockInfo(new Position(4, 4), 2, Direction.R),
				new BlockInfo(new Position(2, 2), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(3, 2), 1, Direction.D),
				new BlockInfo(new Position(2, 3), 1, Direction.D),
				new BlockInfo(new Position(3, 3), 1, Direction.D),
				new BlockInfo(new Position(2, 4), 1, Direction.D),
				new BlockInfo(new Position(3, 4), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 2 - 52 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(0, 4), 4, Direction.R),		// 1 Large Square
				new BlockInfo(new Position(0, 1), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(2, 0), 3, Direction.L),
				new BlockInfo(new Position(3, 1), 3, Direction.R),
				new BlockInfo(new Position(5, 0), 3, Direction.L),
				new BlockInfo(new Position(0, 2), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(2, 2), 2, Direction.R),
				new BlockInfo(new Position(4, 2), 2, Direction.R),
				new BlockInfo(new Position(2, 3), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(3, 3), 1, Direction.D),
				new BlockInfo(new Position(4, 3), 1, Direction.D),
				new BlockInfo(new Position(2, 4), 1, Direction.D),
				new BlockInfo(new Position(3, 4), 1, Direction.D),
				new BlockInfo(new Position(4, 4), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 3 - 58 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(0, 4), 4, Direction.R),		// 1 Large Square
				new BlockInfo(new Position(3, 2), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(5, 1), 3, Direction.L),
				new BlockInfo(new Position(3, 4), 3, Direction.R),
				new BlockInfo(new Position(5, 3), 3, Direction.L),
				new BlockInfo(new Position(0, 0), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(0, 1), 2, Direction.R),
				new BlockInfo(new Position(0, 2), 2, Direction.R),
				new BlockInfo(new Position(2, 0), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(2, 1), 1, Direction.D),
				new BlockInfo(new Position(2, 2), 1, Direction.D),
				new BlockInfo(new Position(2, 3), 1, Direction.D),
				new BlockInfo(new Position(2, 4), 1, Direction.D),
				new BlockInfo(new Position(3, 0), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 4 - 60 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(0, 4), 4, Direction.R),		// 1 Large Square
				new BlockInfo(new Position(0, 2), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(1, 0), 3, Direction.L),
				new BlockInfo(new Position(2, 4), 3, Direction.R),
				new BlockInfo(new Position(4, 3), 3, Direction.L),
				new BlockInfo(new Position(2, 0), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(2, 1), 2, Direction.R),
				new BlockInfo(new Position(2, 2), 2, Direction.R),
				new BlockInfo(new Position(4, 0), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(4, 1), 1, Direction.D),
				new BlockInfo(new Position(4, 2), 1, Direction.D),
				new BlockInfo(new Position(5, 2), 1, Direction.D),
				new BlockInfo(new Position(5, 3), 1, Direction.D),
				new BlockInfo(new Position(5, 4), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 5 - 64 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(0, 4), 4, Direction.R),		// 1 Large Square
				new BlockInfo(new Position(0, 1), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(2, 0), 3, Direction.L),
				new BlockInfo(new Position(3, 1), 3, Direction.R),
				new BlockInfo(new Position(5, 0), 3, Direction.L),
				new BlockInfo(new Position(2, 2), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(2, 3), 2, Direction.R),
				new BlockInfo(new Position(2, 4), 2, Direction.R),
				new BlockInfo(new Position(4, 2), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(4, 3), 1, Direction.D),
				new BlockInfo(new Position(4, 4), 1, Direction.D),
				new BlockInfo(new Position(5, 2), 1, Direction.D),
				new BlockInfo(new Position(5, 3), 1, Direction.D),
				new BlockInfo(new Position(5, 4), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 6 - 75 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(0, 4), 4, Direction.R),		// 1 Large Square
				new BlockInfo(new Position(2, 2), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(3, 0), 3, Direction.L),
				new BlockInfo(new Position(4, 2), 3, Direction.R),
				new BlockInfo(new Position(5, 0), 3, Direction.L),
				new BlockInfo(new Position(0, 0), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(0, 1), 2, Direction.R),
				new BlockInfo(new Position(0, 2), 2, Direction.R),
				new BlockInfo(new Position(2, 3), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(3, 3), 1, Direction.D),
				new BlockInfo(new Position(4, 3), 1, Direction.D),
				new BlockInfo(new Position(2, 4), 1, Direction.D),
				new BlockInfo(new Position(3, 4), 1, Direction.D),
				new BlockInfo(new Position(4, 4), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 7 - 76 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(0, 4), 4, Direction.R),		// 1 Large Square
				new BlockInfo(new Position(3, 1), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(5, 0), 3, Direction.L),
				new BlockInfo(new Position(3, 4), 3, Direction.R),
				new BlockInfo(new Position(5, 3), 3, Direction.L),
				new BlockInfo(new Position(0, 0), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(0, 1), 2, Direction.R),
				new BlockInfo(new Position(0, 2), 2, Direction.R),
				new BlockInfo(new Position(2, 0), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(2, 1), 1, Direction.D),
				new BlockInfo(new Position(2, 2), 1, Direction.D),
				new BlockInfo(new Position(2, 3), 1, Direction.D),
				new BlockInfo(new Position(2, 4), 1, Direction.D),
				new BlockInfo(new Position(3, 2), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 8 - 80 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(0, 4), 4, Direction.R),		// 1 Large Square
				new BlockInfo(new Position(3, 4), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(5, 3), 3, Direction.L),
				new BlockInfo(new Position(4, 2), 3, Direction.R),
				new BlockInfo(new Position(5, 0), 3, Direction.L),
				new BlockInfo(new Position(2, 0), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(2, 1), 2, Direction.R),
				new BlockInfo(new Position(2, 2), 2, Direction.R),
				new BlockInfo(new Position(0, 0), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(1, 0), 1, Direction.D),
				new BlockInfo(new Position(0, 1), 1, Direction.D),
				new BlockInfo(new Position(1, 1), 1, Direction.D),
				new BlockInfo(new Position(0, 2), 1, Direction.D),
				new BlockInfo(new Position(1, 2), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 9 - 99 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(0, 4), 4, Direction.R),		// 1 Large Square
				new BlockInfo(new Position(2, 1), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(4, 0), 3, Direction.L),
				new BlockInfo(new Position(2, 4), 3, Direction.R),
				new BlockInfo(new Position(3, 2), 3, Direction.L),
				new BlockInfo(new Position(0, 0), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(0, 1), 2, Direction.R),
				new BlockInfo(new Position(0, 2), 2, Direction.R),
				new BlockInfo(new Position(4, 2), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(5, 2), 1, Direction.D),
				new BlockInfo(new Position(4, 3), 1, Direction.D),
				new BlockInfo(new Position(5, 3), 1, Direction.D),
				new BlockInfo(new Position(4, 4), 1, Direction.D),
				new BlockInfo(new Position(5, 4), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 10 - 128 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(2, 1), 4, Direction.U),		// 1 Large Square
				new BlockInfo(new Position(3, 4), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(5, 3), 3, Direction.L),
				new BlockInfo(new Position(4, 2), 3, Direction.R),
				new BlockInfo(new Position(5, 0), 3, Direction.L),
				new BlockInfo(new Position(0, 0), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(0, 1), 2, Direction.R),
				new BlockInfo(new Position(2, 0), 2, Direction.R),
				new BlockInfo(new Position(0, 2), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(1, 2), 1, Direction.D),
				new BlockInfo(new Position(0, 3), 1, Direction.D),
				new BlockInfo(new Position(1, 3), 1, Direction.D),
				new BlockInfo(new Position(2, 3), 1, Direction.D),
				new BlockInfo(new Position(2, 4), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 11 - 132 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(0, 4), 4, Direction.R),		// 1 Large Square
				new BlockInfo(new Position(0, 1), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(2, 0), 3, Direction.L),
				new BlockInfo(new Position(3, 4), 3, Direction.R),
				new BlockInfo(new Position(5, 2), 3, Direction.L),
				new BlockInfo(new Position(0, 2), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(4, 0), 2, Direction.U),
				new BlockInfo(new Position(5, 0), 2, Direction.U),
				new BlockInfo(new Position(3, 0), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(3, 1), 1, Direction.D),
				new BlockInfo(new Position(2, 2), 1, Direction.D),
				new BlockInfo(new Position(3, 2), 1, Direction.D),
				new BlockInfo(new Position(4, 3), 1, Direction.D),
				new BlockInfo(new Position(5, 4), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		// Game 12 - 263 Moves

		Game.startingPositions.add(new StartPosition(new ArrayList<>(Arrays.asList(
				new BlockInfo(new Position(2, 1), 4, Direction.U),		// 1 Large Square
				new BlockInfo(new Position(1, 4), 3, Direction.R),		// 4 Elbows
				new BlockInfo(new Position(3, 3), 3, Direction.L),
				new BlockInfo(new Position(4, 4), 3, Direction.R),
				new BlockInfo(new Position(5, 0), 3, Direction.L),
				new BlockInfo(new Position(2, 0), 2, Direction.R),		// 3 Rectangles
				new BlockInfo(new Position(4, 1), 2, Direction.U),
				new BlockInfo(new Position(5, 2), 2, Direction.U),
				new BlockInfo(new Position(0, 0), 1, Direction.D),		// 6 Squares
				new BlockInfo(new Position(1, 0), 1, Direction.D),
				new BlockInfo(new Position(0, 1), 1, Direction.D),
				new BlockInfo(new Position(1, 1), 1, Direction.D),
				new BlockInfo(new Position(0, 2), 1, Direction.D),
				new BlockInfo(new Position(1, 2), 1, Direction.D)))));

		// ---------------------------------------------------------------------

		return;

	}

	// =========================================================================

}
