package timonschreiber.blockPuzzle.game;

import timonschreiber.blockPuzzle.field.BlockArray;
import timonschreiber.blockPuzzle.field.Move;

/**
 * Short Cut Class
 * 
 * @author		Timon Schreiber
 * @version		1.0 2021 April 02
 */
public record ShortCut(BlockArray start, BlockArray end, Move altMove) {}
