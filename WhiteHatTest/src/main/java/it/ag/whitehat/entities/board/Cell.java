package it.ag.whitehat.entities.board;

public class Cell {

    private int row;

    private int column;

    /**
     * class constructor
     */
    public Cell() {}

    /**
     * class constructor
     * @param row
     * @param column
     */
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * The input comes in format e2 and every moves must be translated to Matrix coordinates
     */
    public void ConvertFromInput() {
        this.row = 7 - (this.row - 1);
        this.column = 7 - (this.column - 1);
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    

}
