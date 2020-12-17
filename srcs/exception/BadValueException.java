package exception;

public class BadValueException extends Exception{
    public BadValueException(String errorMessage){
        super(errorMessage);
    }
}