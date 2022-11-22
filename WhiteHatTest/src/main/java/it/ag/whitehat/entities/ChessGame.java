package it.ag.whitehat.entities;

import it.ag.whitehat.entities.board.Board;
import it.ag.whitehat.entities.board.Cell;
import it.ag.whitehat.entities.piece.Bishop;
import it.ag.whitehat.entities.piece.King;
import it.ag.whitehat.entities.piece.Knight;
import it.ag.whitehat.entities.piece.Pawn;
import it.ag.whitehat.entities.piece.Queen;
import it.ag.whitehat.entities.piece.Rock;

/**
 * Initialize the board
 * @author andrea
 */
public class ChessGame {

    private Board board;

    public ChessGame() {
        board = new Board();
    }

    public void initialize(String player1, String player2) {

        {
            // Player 1
            board.setPiece(new King(player1, 'K', new Cell(0, 3)));
            board.setPiece(new Queen(player1, 'Q', new Cell(0, 4)));
            board.setPiece(new Bishop(player1, 'B', new Cell(0, 2)));
            board.setPiece(new Bishop(player1, 'B', new Cell(0, 5)));
            board.setPiece(new Knight(player1, 'N', new Cell(0, 1)));
            board.setPiece(new Knight(player1, 'N', new Cell(0, 6)));
            board.setPiece(new Rock(player1, 'R', new Cell(0, 0)));
            board.setPiece(new Rock(player1, 'R', new Cell(0, 7)));

            board.setPiece(new Pawn(player1, 'P', new Cell(1, 0)));
            board.setPiece(new Pawn(player1, 'P', new Cell(1, 1)));
            board.setPiece(new Pawn(player1, 'P', new Cell(1, 2)));
            board.setPiece(new Pawn(player1, 'P', new Cell(1, 3)));
            board.setPiece(new Pawn(player1, 'P', new Cell(1, 4)));
            board.setPiece(new Pawn(player1, 'P', new Cell(1, 5)));
            board.setPiece(new Pawn(player1, 'P', new Cell(1, 6)));
            board.setPiece(new Pawn(player1, 'P', new Cell(1, 7)));

        }

        {
            // Player 2
            board.setPiece(new King(player2, 'k', new Cell(7, 4)));
            board.setPiece(new Queen(player2, 'q', new Cell(7, 3)));
            board.setPiece(new Bishop(player2, 'b', new Cell(7, 2)));
            board.setPiece(new Bishop(player2, 'b', new Cell(7, 5)));
            board.setPiece(new Knight(player2, 'n', new Cell(7, 1)));
            board.setPiece(new Knight(player2, 'n', new Cell(7, 6)));
            board.setPiece(new Rock(player2, 'r', new Cell(7, 0)));
            board.setPiece(new Rock(player2, 'r', new Cell(7, 7)));

            board.setPiece(new Pawn(player2, 'p', new Cell(6, 0)));
            board.setPiece(new Pawn(player2, 'p', new Cell(6, 1)));
            board.setPiece(new Pawn(player2, 'p', new Cell(6, 2)));
            board.setPiece(new Pawn(player2, 'p', new Cell(6, 3)));
            board.setPiece(new Pawn(player2, 'p', new Cell(6, 4)));
            board.setPiece(new Pawn(player2, 'p', new Cell(6, 5)));
            board.setPiece(new Pawn(player2, 'p', new Cell(6, 6)));
            board.setPiece(new Pawn(player2, 'p', new Cell(6, 7)));
        }

    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }
}
