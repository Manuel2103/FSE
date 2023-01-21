package at.itkollegimst.studentenverwaltung.exceptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Diese Klasse definiert wie die Exceptions aufgebaut sein soll.
 * Standard ist ein Code und eine Message dazu.
 */
@AllArgsConstructor
@Getter
@Setter
public class ExceptionDTO {

    private String code;
    private String message;

}
