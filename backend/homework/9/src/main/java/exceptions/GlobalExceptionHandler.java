package exceptions;

import dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Custom exception class used
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {IndexNotFound.class})
    public ResponseEntity<ErrorDTO> handleCustomException(IndexNotFound exception){
        ErrorDTO error = new ErrorDTO(exception.getMessage().concat(" [IndexNotFound]"), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return  new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /**
     * handles global exception
     * @param exception
     * @return
     */
    @ExceptionHandler(value =  {Exception.class})
    public ResponseEntity<ErrorDTO> allKindOfExceptions(Exception exception){
        ErrorDTO error = new ErrorDTO(exception.getMessage().concat(" [Parent Exception]"), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return  new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}