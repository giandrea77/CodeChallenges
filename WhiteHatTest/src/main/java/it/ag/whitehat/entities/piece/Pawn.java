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
public class Pawn extends Piece {

    private int directionOfMove = 0;

    public Pawn(String owner, char label, Cell currentPosition) {
        super(owner, label, currentPosition);

    }

    @Override
    public Board moveTo(Cell targetCell, Board currentBoard) throws WrongMoveException {

        // Check if it is a valid move [inside boundaries]
        if ( !super.isValidMove(targetCell) ) {
            return null;
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

        if ( distanceHorizontal > 1 ) {
            throw new WrongMoveException("Pawn cannot move longer than 1");
        }

        boolean firstMove = true;
        if ( super.getOwner().equals("Player1") ) {
            firstMove = currentBoard.isFirstMovePlayer1();
            currentBoard.setFirstMovePlayer1(false);
        } else {
            firstMove = currentBoard.isFirstMovePlayer2();
            currentBoard.setFirstMovePlayer2(false);
        }

        if ( firstMove == false && distanceVertical > 1 ) {
            throw new WrongMoveException("Pawn cannot move longer than 1");
        } else if ( firstMove == true && distanceVertical > 2 ) {
            throw new WrongMoveException("Pawn cannot move longer than 1");
        }

        // Move and / or capture piece
        if (currentBoard.isOwned(targetCell, owner)) {
            throw new WrongMoveException("Pawn cannot capture one of his pieces!!!!!");
        } else {
            return super.moveTo(targetCell, currentBoard);
        }

    }

}
