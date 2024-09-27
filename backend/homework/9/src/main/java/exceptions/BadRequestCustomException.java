package exceptions;

public class BadRequestCustomException extends Exception {
    public BadRequestCustomException(String message)
    {
        super(message);
    }
}
