package timonschreiber.blockPuzzle.game;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import timonschreiber.blockPuzzle.blocks.Block;
import timonschreiber.blockPuzzle.field.BlockArray;
import timonschreiber.blockPuzzle.field.Direction;
import timonschreiber.blockPuzzle.field.GameField;
import timonschreiber.blockPuzzle.field.Move;
import timonschreiber.blockPuzzle.field.MoveArray;

/** TODO solution array not used
 * Game Solver Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 February 13
 */
public class GameSolver {

	// =========================================================================
	// ATTRIBUTES
	// =========================================================================
	
	/** List of all {@code BlockNames} */
	private final List<String> BLOCK_NAMES;

	/** {@code MoveArray} to save every {@code Move} */
	private MoveArray moveArray;

	/** BlockArray Array for the solution */
//	private List<BlockArray> solution;

	/** {@code HashSet} of {@code GameState} to save every unique state */
	private Set<BlockArray> states;

	/** {@code Game} */
	private Game game;
	
	// alternative for-loop variable instead of for-each
	private String str;

	// =========================================================================
	// CONSTRUCTOR
	// =========================================================================

	/**
	 * Creates a new {@code GameSolver} for the starting Position gameID
	 * 
	 * @param gameID	Starting Position
	 */
	public GameSolver(int gameID) {
		
		this.moveArray = new MoveArray();
		
		this.states = new HashSet<>();
		
		this.game = new Game(gameID);

		this.states.add(this.game.field.getBlocks());
		
//		this.solution = new ArrayList<>();
		
		// Block names
		
		this.BLOCK_NAMES = new ArrayList<>();
		
		for (Block blk : this.game.field.getBlocks()) {
			this.BLOCK_NAMES.add(blk.getName());
		}
		
		this.str = this.BLOCK_NAMES.get(0);
	
	}

	// =========================================================================
	// IS-NEW-MOVE - METHOD
	// =========================================================================

	/**
	 * Makes a {@code Move} by going through every possible {@code BlockName}
	 * and {@code Direction}.
	 * 
	 * @return	{@code true} if a new {@code Move}, leading to a new
	 * 			{@code BlockArray} is found; {@code false} otherwise
	 */
	private boolean isNewMove() {
		Move nextMove;
		GameField tmpFld = new GameField(this.game.field.getBlocks());
		

		for (int i = 0; i < this.BLOCK_NAMES.size(); i++) {
//		for (String str : this.BLOCK_NAMES) {
			
			for (Direction dir : Direction.values()) {
				
				nextMove = new Move(str, dir);

				if (tmpFld.isValidMove(nextMove)) {
					
					if (this.states.contains(tmpFld.getBlocks())) {
						
						tmpFld.isValidMove(nextMove.reverse());
						
					} else {
						
						this.game.field.isValidMove(nextMove);
						
						this.states.add(this.game.field.getBlocks());
						this.moveArray.addMove(nextMove);
						
//						this.game.field.draw(500); XXX
						return true;
						
					}
				}
			}
			this.str = this.BLOCK_NAMES.get((this.BLOCK_NAMES.indexOf(this.str) + 1) % this.BLOCK_NAMES.size());
		}
		return false;
	}

	// =========================================================================
	// SOLVE - METHOD
	// =========================================================================

	/**
	 * Tries to solve the {@code BlockPuzzle}.
	 */
	public void solve() {
		
		System.out.println("START\n");
		Instant t1 = Instant.now();

		try {
			// Check for game.field#isWon to become true
			while (!this.game.field.isWon()) {
				
				// if GameSolver#isNewMove is false, the last Move will be reversed
				while (!this.isNewMove()) {
					
					if (this.moveArray.getSize() == 0) {
						System.out.println("Can't find a move.");
						return;
					} else if (this.game.field.isValidMove(
							this.moveArray.getLastMove().reverse())) {
						this.moveArray.deleteLastMove();
					} else {
						System.out.println("Can't reverse last move.");
						return;
					}
				}
			}
		} finally {
			Duration d = Duration.between(t1, Instant.now());
			System.out.println("END\n");
			System.out.println("\nNumber of moves made:\n" + this.moveArray.getSize());
			System.out.println("\nNumber of states saved:\n" + this.states.size());
			System.out.println("\nTime to solve:\n"
								+ d.toMinutesPart() + " minutes, "
								+ d.toSecondsPart() + " seconds, "
								+ d.toMillisPart() + " milliseconds");
		}

		return;
	}

	// =========================================================================
	// SHOW-MOVES - METHODS
	// =========================================================================

//	/**
//	 * Shows the Moves from Start to End with a time delay between two moves
//	 * 
//	 * @param delay Time delay in milliseconds
//	 */
//	public void showMoves(int delay) {
//		this.createSolution();
//
//		for (int i = 0; i < this.moveArray.getSize(); i++) {
//			System.out.println("State " + i + ": ");
//			this.game.field.print();
//			this.game.isValidMove(this.moveArray.getMove(i), delay);
//		}
//
//		this.reverseMoves();
//
//		for (int i = 0; i < this.solution.length; i++) {
//			System.out.println("finfShortCut() with i = " + i);
//			i = this.findShortCut(i);
//		}
//
//		this.reverseMoves();
//
//		for (int i = 0; i < this.moveArray.getSize(); i++) {
//			System.out.println("State " + i + ": ");
//			this.game.field.print();
//			this.game.isValidMove(this.moveArray.getMove(i), delay);
//		}
//
//		return;
//	}
//
//	/**
//	 * Shows the Moves from Start to End
//	 */
//	public void showMoves() {
//		this.showMoves(0);
//		return;
//	}
//
//	// =========================================================================
//	// REVERSE-MOVES - METHOD
//	// =========================================================================
//
//	/**
//	 * Reverses all Moves
//	 */
//	private void reverseMoves() {
//		this.reverseMoves(this.moveArray.getSize());
//		return;
//	}
//
//	/**
//	 * Reverse Moves from the current State to the starting position
//	 * 
//	 * @param from current State number
//	 */
//	private void reverseMoves(int from) {
//		for (int i = (from - 1); i >= 0; i--) {
//			this.game.isValidMove(new Move(this.moveArray.getMove(i).reverse()));
//		}
//		return;
//	}
//
//	// =========================================================================
//	// CREATE-SOLUTION-ARRAY - METHOD
//	// =========================================================================
//
//	/**
//	 * Create the Array of Block Arrays with only the winning states while
//	 * reversing from the final state to the start state
//	 */
//	private void createSolution() {
//		this.solution = new BlockArray[this.moveArray.getSize() + 1];
//
//		for (int i = (this.solution.length - 1); i >= 0; i--) {
//			this.solution[i] = new BlockArray(this.game.field.getState());
//			if (i == 0) {
//				break;
//			}
//			this.game.isValidMove(this.moveArray.getMove(i - 1).reverse());
//		}
//
//		return;
//	}
//
//	// =========================================================================
//	// FIND SHORTER SOLUTION - METHOD
//	// =========================================================================
//
//	/**
//	 * Get a shorter solution by finding a short cut
//	 */
//	private int findShortCut(int index) {
//		Move nextMove;
//		GameField field;
//
//		for (; index < this.moveArray.getSize(); index++) {
//			this.blockName = BlockName.R1;
//			this.direction = Direction.D;
//
//			for (int j = 0; j < BlockName.getSize(); j++) {
//				for (int k = 0; k < Direction.getSize(); k++) {
//					nextMove = new Move(this.blockName, this.direction);
//					field = new GameField(this.game.field.getState());
//
//					if (field.moveBlock(nextMove)) {
//						// der zweite durchlauf von solution[] laeuft dem ersten //						// entgegen um
//						// die groesstmoegliche abkuerzung zu finden
//						// (i + 1): da ich weder mit dem i-ten, noch dem zustand //						// danach vergleichen
//						// moechte
//						for (int l = (this.solution.length - 1); l > (index + 1); l--) {
//							if (field.getState().isEqualState(this.solution[l])) {
//								System.out.println("\nShortCut from " + index + ":");
//								(new GameField(this.solution[index])).print();
//								System.out.println("to " + l + ":");
//								(new GameField(this.solution[l])).print();
//								System.out.println("with " + nextMove + " instead of:");
//								for (int m = index; m < l; m++) {
//									int n = 0;
//									System.out.println(++n + ": " + this.moveArray.getMove(m));
//								}
//
////								this.trimMoves(index, l, nextMove);
////								this.trimSolution(index, l, nextMove);
//
//								return index;
//							}
//						}
//					}
//					this.direction = this.direction.next();
//				}
//				this.blockName = this.blockName.next();
//			}
//			this.game.isValidMove(new Move(this.moveArray.getMove(index)));
//		}
//		return this.solution.length;
//	}
//
//	// =========================================================================
//	// TRIM - METHODS
//	// =========================================================================

//
//	/**
//	 * 
//	 * @param start
//	 * @param end
//	 * @param newMove
//	 */
//	@SuppressWarnings("unused")
//	private void trimSolution(int start, int end, Move newMove) {
//		System.out.println("\ntrimSolution()");
//		System.out.println("start: " + start + ", end: " + end + ", newMove: " + newMove);
//
//		GameField tmpFld = new GameField(this.game.field.getState());
//		BlockArray[] tmpBlkSts = new BlockArray[this.solution.length - (end - start)];
//
//		for (int i = 0; i <= start; i++) {
//			tmpBlkSts[i] = new BlockArray(this.solution[i]);
//		}
//
//		tmpFld.moveBlock(newMove);
//		this.changeMoves(tmpFld.getState(), start, end);
//
//		for (int i = ++start; i < tmpBlkSts.length; i++) {
//			tmpBlkSts[i] = new BlockArray(tmpFld.getState());
//			if (i == this.moveArray.getSize()) {
//				break;
//			}
//			tmpFld.moveBlock(this.moveArray.getMove(i));
//		}
//
//		solution = new BlockArray[tmpBlkSts.length];
//		for (int i = 0; i < this.solution.length; i++) {
//			solution[i] = new BlockArray(tmpBlkSts[i]);
//		}
//
//		return;
//	}

	// =========================================================================

}
