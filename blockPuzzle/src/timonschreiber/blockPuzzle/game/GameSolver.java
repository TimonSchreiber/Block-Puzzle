package timonschreiber.blockPuzzle.game;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import timonschreiber.blockPuzzle.block.Block;
import timonschreiber.blockPuzzle.field.BlockList;
import timonschreiber.blockPuzzle.field.Direction;
import timonschreiber.blockPuzzle.field.GameField;
import timonschreiber.blockPuzzle.field.Move;
import timonschreiber.blockPuzzle.field.MoveList;

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
	
	// -------------------------------------------------------------------------
	
	/** alternative for-loop variable to iterate over {@code BLOCK_NAMES} */
	private String str;

	/** List of {@code BlockList}s for the solution */
	private List<BlockList> solution;
	
	/** List of {@code ShortCut}s to shorten the solution */
	private List<ShortCut> shortCuts;

	/** {@code HashSet} of {@code GameState} to save every unique state */
	private Set<BlockList> states;

	/** {@code MoveList} to save every {@code Move} */
	private MoveList moves;

	/** {@code Game} */
	private Game game;

	// =========================================================================
	// CONSTRUCTOR
	// =========================================================================

	/**
	 * Creates a new {@code GameSolver} for the starting Position gameID
	 * 
	 * @param gameID	Starting Position
	 */
	public GameSolver(int gameID) {
		
		this.solution = new ArrayList<>();
		
		this.shortCuts = new ArrayList<>();
		
		this.states = new HashSet<>();
		
		this.moves = new MoveList();
		
		this.game = new Game(gameID);

		this.states.add(this.game.FIELD.getBlocks());
		
		// Block_Names
		this.BLOCK_NAMES = new ArrayList<>();
		
		for (Block blk : this.game.FIELD.getBlocks()) {
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
	 * 			{@code BlockList} is found; {@code false} otherwise
	 */
	private boolean isNewMove() {
		Move nextMove;
		GameField tmpFld = new GameField(this.game.FIELD.getBlocks());
		

		for (int i = 0; i < this.BLOCK_NAMES.size(); i++) {
			
			for (Direction dir : Direction.values()) {
				
				nextMove = new Move(str, dir);

				if (tmpFld.isValidMove(nextMove)) {
					
					if (this.states.contains(tmpFld.getBlocks())) {
						
						tmpFld.isValidMove(nextMove.reverse());
						
					} else {
						
						this.game.FIELD.isValidMove(nextMove);
						
						this.states.add(this.game.FIELD.getBlocks());
						this.moves.addMove(nextMove);
						
						this.game.FIELD.draw();
						return true;
						
					}
				}
			}
			this.str = this.next(str);
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
			// Check for game#field#isWon to become true
			while (!this.game.FIELD.isWon()) {
				
				// If GameSolver#isNewMove is false, the last Move will be reversed
				while (!this.isNewMove()) {
					
					if (this.moves.getSize() == 0) {
						System.out.println("Can't find a move.");
						return;
					} else if (this.game.FIELD.isValidMove(
							this.moves.getLastMove().reverse())) {
						this.moves.deleteLastMove();
					} else {
						System.out.println("Can't reverse last move.");
						return;
					}
				}
			}
		} finally {
			Duration d = Duration.between(t1, Instant.now());
			System.out.println("END\n");
			System.out.println("\nNumber of moves made:\n" + this.moves.getSize());
			System.out.println("\nNumber of states saved:\n" + this.states.size());
			System.out.println("\nTime to solve:\n"
								+ d.toMinutesPart() + " minutes, "
								+ d.toSecondsPart() + " seconds, "
								+ d.toMillisPart() + " milliseconds");
		}

		return;
	}

	// =========================================================================
	// CREATE-SOLUTION - METHOD
	// =========================================================================

	/** TODO
	 * Create the Array of Block Arrays with only the winning states while
	 * reversing from the final state to the start state
	 */
	private void createSolution() {
		System.out.println("\n\t#createSolution");	// XXX
		
		this.reverseGame();
		
		this.solution.add(this.game.FIELD.getBlocks());

		for (Move mv : this.moves) {
			if (this.game.FIELD.isValidMove(mv)) {
				this.solution.add(this.game.FIELD.getBlocks());
			} else {
				System.out.println("Can't create the solution form the moves list.");
				return;
			}
		}

		return;
	}
	
	// =========================================================================
	// REVERSE-GAME - METHOD
	// =========================================================================

	/** TODO
	 * Reverses all Moves
	 */
	private void reverseGame() {
		this.reverseGame(this.moves.getSize());
		return;
	}

	/** TODO used?
	 * Reverse Moves from the current State to the starting position
	 * 
	 * @param from	current State number
	 */
	private void reverseGame(int from) {
		System.out.println("\n\t#reverseGame from #" + from);	// XXX
		
		for (int i = (from - 1); i >= 0; i--) {
			this.game.FIELD.isValidMove(this.moves.getMove(i).reverse());
		}
		return;
	}

	// =========================================================================
	// SHOW-MOVES - METHODS
	// =========================================================================

	/** TODO separate findShortCut from showMoves (maybe createSOlution?)
	 * Shows the Moves from Start to End with a time delay between two moves.
	 * 
	 * @param delay		the time delay in milliseconds
	 */
	public void showMoves(int delay) {
		System.out.println("\n\t#showMoves");	// XXX
		
		BlockList tmpBlks = null;

		this.reverseGame();

		for (Move mv : this.moves) {
			this.game.FIELD.isValidMove(mv);
			this.game.FIELD.draw(delay);
		}
		
		// different method?
		this.createSolution();
		
		for (BlockList blks : this.solution) {
			if (this.solution.indexOf(blks)
					<= this.solution.indexOf(tmpBlks)) {
				continue;	// skips to the BlockList AFTER tmpBlks in solution
			}
			this.reverseGame(this.solution.indexOf(blks));
			tmpBlks = this.findShortCut(blks);
		}

		return;
	}

	/** TODO
	 * Shows the Moves from Start to End
	 */
	public void showMoves() {
		this.showMoves(0);
		return;
	}



	// =========================================================================
	// FIND-SHORTER-SOLUTION - METHOD
	// =========================================================================

	/** TODO
	 * Get a shorter solution by finding a short cut
	 */
	private BlockList findShortCut(BlockList blocks) {
		System.out.println("\n\t#findShortCut from state #"
						+ this.solution.indexOf(blocks));	// XXX
		
		int index = this.solution.indexOf(blocks);
		Move tmpMv;
		GameField tmpFld;

		for (Move mv : this.moves) {
			
			if (this.game.FIELD.getBlocks().equals(blocks)) {
				this.game.FIELD.print();	// XXX
			} else {
				System.out.println(mv);	// XXX
				this.game.FIELD.isValidMove(mv);
				continue;	// skips the rest until Game#field is equal to blocks
			}
			
			this.str = this.BLOCK_NAMES.get(0);

			for (int i = 0; i < this.BLOCK_NAMES.size(); i++) {
				
				for (Direction dir : Direction.values()) {
					
					tmpMv = new Move(this.str, dir);
					System.out.println("\nnew Move " + tmpMv);	// XXX
					if (tmpMv.equals(mv)) {
						System.out.println(" -> skipped");	// XXX
						continue; }		// skips known moves
					
					tmpFld = new GameField(this.game.FIELD.getBlocks());

					if (tmpFld.isValidMove(tmpMv)) {
						if (this.states.contains(tmpFld.getBlocks())) {
							continue;
						}

						for (int j = (this.solution.size() - 1); j > (index + 1); j--) {
							if (tmpFld.getBlocks().isSimilar(this.solution.get(j))) {
								
								System.out.println("\nShortCut from " + index + ":");
								(new GameField(this.solution.get(index))).print();
								
								System.out.println("to " + j + ":");
								(new GameField(this.solution.get(j))).print();
								
								System.out.println("with " + tmpMv + " instead of:");
								for (int k = index; k < j; k++) {
									System.out.println((k - index) + ": " + this.moves.getMove(k));
								}
								
								this.shortCuts.add(
										new ShortCut(
												this.solution.get(index),
												this.solution.get(j),
												tmpMv));
								
								return this.solution.get(j);
							}
						}
					}
				}
				this.str = this.next(this.str);
			}
		}
		return this.solution.get(index);
	}
	
	// =========================================================================
	// NEXT -METHOD
	// =========================================================================
	
	/**
	 * Returns the next {@code BlockName} in the {@code List}
	 * {@code BLOCK_NAMES}.
	 * 
	 * @param str	the current {@code String}
	 * @return		the next {@code BlockName}
	 */
	private String next(String str) {
		return this.BLOCK_NAMES.get(
				(this.BLOCK_NAMES.indexOf(str) + 1)
				% this.BLOCK_NAMES.size());
	}
	

	// =========================================================================

}
