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
	private String blockName;

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

		this.states.add(this.game.field.getBlocks());
		
		// Block_Names
		this.BLOCK_NAMES = new ArrayList<>();
		
		for (Block blk : this.game.field.getBlocks()) {
			this.BLOCK_NAMES.add(blk.getName());
		}
		
		this.blockName = this.BLOCK_NAMES.get(0);
	
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
		GameField tmpFld = new GameField(this.game.field.getBlocks());
		

		for (int i = 0; i < this.BLOCK_NAMES.size(); i++) {
			
			for (Direction dir : Direction.values()) {
				
				nextMove = new Move(blockName, dir);

				if (tmpFld.isValidMove(nextMove)) {
					
					if (this.states.contains(tmpFld.getBlocks())) {
						
						tmpFld.isValidMove(nextMove.reverse());
						
					} else {
						
						this.game.field.isValidMove(nextMove);
						
						this.states.add(this.game.field.getBlocks());
						this.moves.addMove(nextMove);
						
						this.game.field.draw();
						return true;
					}
				}
			}
			this.nextBlockName();
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
			while (!this.game.field.isWon()) {
				
				// If GameSolver#isNewMove is false, the last Move will be reversed
				while (!this.isNewMove()) {
					
					if (this.moves.getSize() == 0) {
						System.out.println("Can't find a move.");
						return;
					} else if (this.game.field.isValidMove(
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
		
//		this.reverseGame();
//		
//		this.createSolution();
//		
//		System.out.println("\nshow first solution");
//		this.showSolution(200);		// FIXME time delay
//		this.reverseGame();
//		
//		this.findShortCuts();
//		this.shortenSolution();
//		
//		System.out.println("\nNew Move Number: " + this.moves.getSize());
//		
//		System.out.println("\nshow faster solution");
//		this.showSolution(200);		// FIXME time delay
//		this.reverseGame();
		
		

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
		GameField tmpFld = new GameField(this.game.field.getBlocks());
		
		this.solution.add(tmpFld.getBlocks());

		for (Move mv : this.moves) {
			if (tmpFld.isValidMove(mv)) {
				this.solution.add(tmpFld.getBlocks());
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

	/** TODO used?
	 * Reverse Moves from the current State to the starting position
	 * 
	 * @param from	current State number
	 */
	private void reverseGame(int from) {
		
		for (int i = (from - 1); i >= 0; i--) {
			this.game.field.isValidMove(this.moves.getMove(i).reverse());
		}
		return;
	}

	/** TODO
	 * Reverses all Moves
	 */
	private void reverseGame() {
		this.reverseGame(this.moves.getSize());
		return;
	}

	// =========================================================================
	// SHOW-MOVES - METHODS
	// =========================================================================

	/** TODO separate findShortCut from showMoves (maybe createSOlution?)
	 * Shows the Solution from Start to End with a time delay between two
	 * {@code Move}s.
	 * 
	 * @param delay		the time delay in milliseconds
	 */
	public void showSolution(int delay) {
		for (Move mv : this.moves) {
			this.game.field.isValidMove(mv);
			this.game.field.draw(delay);
		}
		
		return;
	}

	/** TODO
	 * Shows the Solution from Start to End
	 */
	public void showSolution() {
		this.showSolution(0);
		return;
	}

	// =========================================================================
	// FIND-SHORT-CUT - METHOD
	// =========================================================================

	/** TODO
	 * Get a shorter solution by finding a short cut
	 */
	private void findShortCuts() {
		
//		int counter = 0; // shortCut counter delete?? XXX
		int start = 0;
		int next = -1;
		
		Move tmpMv;
		GameField tmpFld;

	SEARCH:
		for (; start < this.solution.size(); start++) {
			
			if (start <= next) {
				start = next + 1;
			}
			
			for (String blkNm : this.BLOCK_NAMES) {
				
				for (Direction dir : Direction.values()) {
					
					tmpMv = new Move(blkNm, dir);
//					System.out.println("tmpMv " + tmpMv);	// XXX
					
					// FIXME
//					if (tmpMv.equals(this.moves.getMove(start))) {
////						System.out.println(" -> skipped");	// XXX
//						continue; }		// skips known moves
					
					tmpFld = new GameField(this.solution.get(start));
					tmpFld.isValidMove(tmpMv);

					
					for (int i = (this.solution.size() - 1); i > (start + 1); i--) {
						
						if (tmpFld.getBlocks().isSimilar(this.solution.get(i))) {
							
							next = i;
							
							this.shortCuts.add(
								new ShortCut(
									new BlockList(this.solution.get(start)),
									new BlockList(this.solution.get(next)),
									new Move(tmpMv)));
							
//							FIXME delete below?
//							System.out.println("\nShortCut # " + counter + " from " + start + " to " + next);
//							this.shortCuts.get(counter++).print();
							
							continue SEARCH;
						}
					}
				}
			}
		}
		return;
	}

	// =========================================================================
	// SHORTEN-SOLUTION - METHOD
	// =========================================================================
	
	private void shortenSolution() {
		System.out.println("\n#shortenSolution\n");
		
		int start;
		int end;
		
		int adjustment = 0;
		
		for (ShortCut shrtCt : this.shortCuts) {
			start = this.solution.indexOf(shrtCt.initialState());
			end   = this.solution.indexOf(shrtCt.oldState());
			
			System.out.println("start: " + start + " ,end: " + end);
			
			// change moves
			this.moves.change(shrtCt.oldState(), shrtCt.newState(), start);
		}
		
		System.out.println("MoveList length: " + this.moves.getSize());
		
		for (ShortCut shrtCt : this.shortCuts) {
			start = this.solution.indexOf(shrtCt.initialState()) - adjustment;
			end = this.solution.indexOf(shrtCt.oldState()) - adjustment;
			
			// Cut out unnecessary moves
			adjustment = this.moves.cut(start, end);
		}
		
		System.out.println("MoveList length: " + this.moves.getSize());
		
		// Create the new solution
//		this.solution.clear();
//		this.createSolution();
		
		return;
	}
	
	
	// =========================================================================
	// NEXT -METHOD
	// =========================================================================
	
	/**
	 * Sets this String {@code blockName} to the next {@code BLOCK_NAME}.
	 */
	private void nextBlockName() {
		this.blockName = this.BLOCK_NAMES.get(
				(this.BLOCK_NAMES.indexOf(this.blockName) + 1)
				% this.BLOCK_NAMES.size());
	}
	

	// =========================================================================

}
