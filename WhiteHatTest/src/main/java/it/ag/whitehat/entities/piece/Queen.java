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
public class Queen extends Piece {

    public Queen(String owner, char label, Cell initialPosition) {
        super(owner, label, initialPosition);

    }

    @Override
    public Board moveTo(Cell targetCell, Board currentBoard) throws WrongMoveException {

        // Check if it is a valid move [inside boundaries]
        if ( !super.isValidMove(targetCell) ) {
            throw new WrongMoveException("King cannot move outside the board");
        }

        int horizontalPathLengh = Math.abs(targetCell.getColumn() - super.getCurrentPosition().getColumn());
        int verticalPathLenght = Math.abs(targetCell.getRow() - super.getCurrentPosition().getRow());

        if ( horizontalPathLengh > 1 && verticalPathLenght > 1 ) {

            if ( super.isFreePathStraight(targetCell, currentBoard) ) {
                return super.moveTo(targetCell, currentBoard);
            } else {
                throw new WrongMoveException("Queen cannot move: path is not free");
            }

        } else {

            if ( super.isFreePathDiagonal(targetCell, currentBoard) ) {
                return super.moveTo(targetCell, currentBoard);
            } else {
                throw new WrongMoveException("Queen cannot move: path is not free");
            }

        }

    }

}
