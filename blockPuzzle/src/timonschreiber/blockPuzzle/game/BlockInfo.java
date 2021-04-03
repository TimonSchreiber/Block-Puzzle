package timonschreiber.blockPuzzle.game;

import timonschreiber.blockPuzzle.block.Position;
import timonschreiber.blockPuzzle.field.Direction;

/**
 * Block Info Class
 * 
 * @author		Timon Schreiber
 * @version		1.1 2021 March 26
 */
public record BlockInfo(Position position, int size, Direction direction) {}
