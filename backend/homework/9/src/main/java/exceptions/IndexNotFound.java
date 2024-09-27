package exceptions;

public class IndexNotFound extends IndexOutOfBoundsException{
    public IndexNotFound(String message){
        super(message);
    }
}
