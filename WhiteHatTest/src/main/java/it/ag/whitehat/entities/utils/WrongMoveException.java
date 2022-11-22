package it.ag.whitehat.entities.utils;

public class WrongMoveException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public WrongMoveException(String errorMessage) {
        super(errorMessage);
    }

}
