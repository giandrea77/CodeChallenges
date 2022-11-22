package it.ag.whitehat.entities.piece;

import it.ag.whitehat.entities.board.Board;
import it.ag.whitehat.entities.board.Cell;
import it.ag.whitehat.entities.utils.WrongMoveException;

/**
 * @author andrea
 *
 * Code completition:
 *  [ ] Can move properly
 *  [ ] Can eath
 */
public class Knight extends Piece {

    private int directionOfMove = 0;

    public Knight(String owner, char label, Cell currentPosition) {
        super(owner, label, currentPosition);
    }

    @Override
    public Board moveTo(Cell targetCell, Board currentBoard) throws WrongMoveException {
        // TODO Auto-generated method stub
        return super.moveTo(targetCell, currentBoard);
    }

    
}
