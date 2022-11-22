package it.ag.whitehat.entities.piece;

import it.ag.whitehat.entities.board.Board;
import it.ag.whitehat.entities.board.Cell;
import it.ag.whitehat.entities.utils.WrongMoveException;

public interface IPiece {

    /**
     * Move the piece
     * @param cell
     * @param currentBoard
     * @return
     * @throws WrongMoveException
     */
    Board moveTo(Cell cell, Board currentBoard) throws WrongMoveException;

}
