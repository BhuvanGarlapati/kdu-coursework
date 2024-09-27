package dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Data will get all setter and getter
 * @AllArgsConstructor will produce all constructor with all type of parameter
 */
@Data
@AllArgsConstructor
public class ErrorDTO {
    String message;
    int statusCode;
}
