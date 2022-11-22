package it.ag.whitehat.entities.board;

import it.ag.whitehat.entities.piece.Piece;

public class Board {

    private boolean firstMovePlayer1 = true;

    private boolean firstMovePlayer2 = true;

    private Piece[][] gameBoard;

    public Board() {
        gameBoard = new Piece[8][8];
    }

    /**
     * Check if a cell is free
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isFreeAt(int x, int y) {
        return gameBoard[x][y] == null;
    }

    /**
     * Remove a piece from position
     * @param cell
     */
    public void removePieceAt(Cell cell) {
        gameBoard[cell.getRow()][cell.getColumn()] = null;
    }

    /**
     * Check if the piece in the @Cell position has correct owner
     * @param cell
     * @param owner
     * @return
     */
    public boolean isOwned(Cell cell, String owner) {

        if ( getPieceAt(cell) != null && getPieceAt(cell).getOwner().equals(owner) ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param cell
     * @return
     */
    public Piece getPieceAt(Cell cell) {

        if ( gameBoard[cell.getRow()][cell.getColumn()] == null ) {
            return null;
        }

        Piece piece = gameBoard[cell.getRow()][cell.getColumn()];
        return piece;
    }

    public void setPiece(Piece piece) {
        gameBoard[piece.getCurrentPosition().getRow()][piece.getCurrentPosition().getColumn()] = piece;
    }

    /**
     * Set a piece into a new cell
     *
     * @param piece
     * @param cell
     */
    public void setPieceAt(Piece piece, Cell cell) {
        gameBoard[cell.getRow()][cell.getColumn()] = piece;
    }

    public boolean isFirstMovePlayer1() {
        return firstMovePlayer1;
    }

    public void setFirstMovePlayer1(boolean firstMovePlayer1) {
        this.firstMovePlayer1 = firstMovePlayer1;
    }

    public boolean isFirstMovePlayer2() {
        return firstMovePlayer2;
    }

    public void setFirstMovePlayer2(boolean firstMovePlayer2) {
        this.firstMovePlayer2 = firstMovePlayer2;
    }

    @Override
    public String toString() {
        String s = "  a b c d e f g h\n";
        for (int row = 0; row < 8; row++) {
            s += row;
            for (int col = 0; col < 8; col++) {
                if (gameBoard[row][col] != null) {
                    s += " " + gameBoard[row][col].getLabel();
                } else {
                    s += " -";
                }
            }
            s += "\n";
        }
        return s;
    }

}
