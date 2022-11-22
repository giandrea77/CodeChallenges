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
public class Bishop extends Piece {

    public Bishop(String owner, char label, Cell currentPosition) {
        super(owner, label, currentPosition);
    }

    @Override
    public Board moveTo(Cell targetCell, Board currentBoard) throws WrongMoveException {

        // Check if it is a valid move [inside boundaries]
        if ( !super.isValidMove(targetCell) ) {
            throw new WrongMoveException("King cannot move outside the board");
        }

        int pathLenght = Math.abs(targetCell.getRow() - super.getCurrentPosition().getRow());

        // if two points are diagonally aligned I can move bishop
        if ( pathLenght == Math.abs(targetCell.getColumn() - super.getCurrentPosition().getColumn()) ) {

            if ( super.isFreePathDiagonal(targetCell, currentBoard) ) {
                return super.moveTo(targetCell, currentBoard);
            } else {
                throw new WrongMoveException("Bishop cannot move: path is not free");
            }

        } else {
            throw new WrongMoveException("Bishop cannot move: incorrect path");
        }

    }
}
