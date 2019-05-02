package app;

/**
 * DataFitException
 */

public class DataFitException extends Exception {

    public enum ExceptionType {
        LARGER, SMALLER
    }
    
    ExceptionType type;

    DataFitException(ExceptionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        switch (type) {
        case LARGER:
            return this.getClass().getName()+" : Data size will not fit in grid becasue it is LARGER";

        default:
            return this.getClass().getName()+" : Data size will not fit in grid becasue it is SMALLER";
        }

    }

}