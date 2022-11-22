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
public class King extends Piece {

    public King(String owner, char label, Cell initialPosition) {
        super(owner, label, initialPosition);
    }

    @Override
    public Board moveTo(Cell targetCell, Board currentBoard) throws WrongMoveException {

        // Check if it is a valid move [inside boundaries]
        if ( !super.isValidMove(targetCell) ) {
            throw new WrongMoveException("King cannot move outside the board");
        }

        // Check if the piece walks properly
        int distanceVertical = 0;
        int distanceHorizontal = 0;

        if ( super.verticalDirectionOfMove(super.currentPosition, targetCell) == 1 ) {
            distanceVertical = targetCell.getRow() - super.currentPosition.getRow();
        } else {
            distanceVertical = super.currentPosition.getRow() - targetCell.getRow();
        }

        if ( super.horizontalDirectionOfMove(super.currentPosition, targetCell) == 1) {
            distanceHorizontal = targetCell.getColumn() - super.currentPosition.getColumn();
        } else {
            distanceHorizontal = super.currentPosition.getColumn() - targetCell.getColumn();
        }

        if ( distanceVertical > 1 || distanceHorizontal > 1 ) {
            throw new WrongMoveException("King cannot move longer than 1");
        }

        // Move and / or capture piece
        if (currentBoard.isOwned(targetCell, owner)) {
            throw new WrongMoveException("King cannot capture one of his pieces!!!!!");
        } else {
            return super.moveTo(targetCell, currentBoard);
        }

    }

}
