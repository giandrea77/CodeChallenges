package it.ag.whitehat.entities.piece;

import it.ag.whitehat.entities.board.Board;
import it.ag.whitehat.entities.board.Cell;
import it.ag.whitehat.entities.utils.WrongMoveException;

public abstract class Piece implements IPiece {

    protected String owner;

    protected char label;

    protected Cell currentPosition;

    public Piece(String owner, char label, Cell currentPosition) {
        this.currentPosition = currentPosition;
        this.owner = owner;
        this.label = label;
    }


    /**
     * // Actual move - all checks are stored on specific piece move
     */
    @Override
    public Board moveTo(Cell targetCell, Board currentBoard) throws WrongMoveException {
        currentBoard.removePieceAt(currentPosition);  
        currentBoard.setPieceAt(this, targetCell);
        currentPosition = targetCell;
        return currentBoard;       
    }

    public boolean isValidMove(Cell cell) {
        return cell.getRow() >= 0 && cell.getRow() < 8 && cell.getColumn() >= 0 && cell.getColumn() < 8;
    }

    /**
     * Calculate the direction of the vertical move
     *
     * @param currentPosition
     * @param targetPosition
     * @return
     */
    public int verticalDirectionOfMove(Cell currentPosition, Cell targetPosition) {

        if ( currentPosition.getRow() > targetPosition.getRow() ) {
            // From north to south
            return -1;
        } else {
            // From south to north
            return 1;
        }

    }

    /**
     * Calculate the direction of the horizontal move
     *
     * @param currentPosition
     * @param targetPosition
     * @return
     */
    public int horizontalDirectionOfMove(Cell currentPosition, Cell targetPosition) {

        if ( currentPosition.getColumn() > targetPosition.getColumn() ) {
            // From east to west
            return -1;
        } else {
            // From west to east
            return 1;
        }


    }

    /**
     * Check if diagonal path to final position does not have any piece in the middle
     * @param cell
     * @param currentBoard
     * @return
     */
    protected boolean isFreePathDiagonal(Cell cell, Board currentBoard) {

        boolean canEat = false;

        // If my target position is busy and the object is not my I could eat (of course if the path is free)
        if ( !currentBoard.isFreeAt(cell.getRow(),cell.getColumn()) && !this.getOwner().equals(currentBoard.getPieceAt(cell).owner)) {
            canEat = true;
        }

        int verticalDirection = cell.getRow() - this.currentPosition.getRow();
        int orizontalDirection = cell.getColumn() - this.currentPosition.getColumn();

        int x = this.currentPosition.getRow();
        int y = this.currentPosition.getColumn();

        do {

            x = (verticalDirection < 0 ? x - 1 : x + 1);
            y = (orizontalDirection < 0 ? y - 1 : y + 1);

            if ( currentBoard.isFreeAt(x,y) ) {
                continue;
            } else {

                // If I can eat and final destination is occupied, I can replace the piece
                if ( x == cell.getRow() && y == cell.getColumn() && canEat ) {
                    return true;
                }

                return false;
            }

        } while (x != cell.getRow() && y != cell.getColumn());

        return true;

    }

    /**
     * Check if Queen (diagonal only) path to final position does not have
     * @param cell
     * @param currentBoard
     * @return
     */
    protected boolean isFreePathStraight(Cell cell, Board currentBoard) {

        boolean canEat = false;

        // If my target position is busy and the object is not my I could eat (of course if the path is free)
        if ( !currentBoard.isFreeAt(cell.getRow(),cell.getColumn()) && !this.owner.equals(currentBoard.getPieceAt(cell).owner)) {
            canEat = true;
        }

        int verticalDirection = cell.getRow() - this.getCurrentPosition().getRow();
        int orizontalDirection = cell.getColumn() - this.getCurrentPosition().getColumn();

        int x = this.currentPosition.getRow();
        int y = this.currentPosition.getColumn();

        do {

            x = (verticalDirection < 0 ? x - 1 : x + 1);
            y = (orizontalDirection < 0 ? y - 1 : y + 1);

            if ( currentBoard.isFreeAt(x,y) ) {
                continue;
            } else {

                // If I can eat and final destination is occupied, I can replace the piece
                if ( x == cell.getRow() && y == cell.getColumn() && canEat ) {
                    return true;
                }

                return false;
            }


        } while (x != cell.getRow() && y != cell.getColumn());

        return true;

    }



    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the label
     */
    public char getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(char label) {
        this.label = label;
    }

    /**
     * @return the currentPosition
     */
    public Cell getCurrentPosition() {
        return currentPosition;
    }

    /**
     * @param currentPosition the currentPosition to set
     */
    public void setCurrentPosition(Cell currentPosition) {
        this.currentPosition = currentPosition;
    }

}
