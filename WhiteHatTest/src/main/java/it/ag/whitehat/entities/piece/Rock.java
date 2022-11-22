package it.ag.whitehat.entities.piece;

import it.ag.whitehat.entities.board.Board;
import it.ag.whitehat.entities.board.Cell;
import it.ag.whitehat.entities.utils.WrongMoveException;

/**
 * @author andrea
 *
 * Code completition:
 *  [X] Can move properly
 *  [X] Can eath
 */
public class Rock extends Piece {

    public Rock(String owner, char label, Cell currentPosition) {
        super(owner, label, currentPosition);
    }

    @Override
    public Board moveTo(Cell targetCell, Board currentBoard) throws WrongMoveException {

        // Check if it is a valid move [inside boundaries]
        if ( !super.isValidMove(targetCell) ) {
            throw new WrongMoveException("Rock cannot move outside the board");
        }

        int horizontalPathLengh = Math.abs(targetCell.getColumn() - super.getCurrentPosition().getColumn());
        int verticalPathLenght = Math.abs(targetCell.getRow() - super.getCurrentPosition().getRow());

        if ( horizontalPathLengh > 0 && verticalPathLenght > 0 ) {
            throw new WrongMoveException("Rock cannot move diagonally");
        }

        if ( super.isFreePathStraight(targetCell, currentBoard) ) {
            return super.moveTo(targetCell, currentBoard);
        } else {
            throw new WrongMoveException("Rock cannot move: path is not free");
        }

    }

}
