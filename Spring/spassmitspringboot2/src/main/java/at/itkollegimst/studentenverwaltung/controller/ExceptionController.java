package at.itkollegimst.studentenverwaltung.controller;

import at.itkollegimst.studentenverwaltung.exceptions.ExceptionDTO;
import at.itkollegimst.studentenverwaltung.exceptions.FormValidierungExceptionDTO;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import at.itkollegimst.studentenverwaltung.exceptions.StudentValidierungFehlgeschlagen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //Gibt an, dass diese Klasse ein ExceptionController ist. Springt ein, wenn eine Exception auftritt.
public class ExceptionController {

    @ExceptionHandler(StudentNichtGefunden.class) //Gibt an, für welche Exception der folgende Code zuständig ist. In diesem Fall StudentNichtGefunden Exception
    public ResponseEntity<ExceptionDTO> studentNichtGefunden(StudentNichtGefunden studentNichtGefunden)
    {
        //Neues ResponseEntity vom Typ ExceptionDTO erstellen mit code und message.
        return new ResponseEntity<>(new ExceptionDTO("1000",studentNichtGefunden.getMessage()), HttpStatus.NOT_FOUND);
    }
    //Exception sollte die Validierung fehlschlagen.
    @ExceptionHandler(StudentValidierungFehlgeschlagen.class)
    public ResponseEntity<FormValidierungExceptionDTO> studentValidierungFehlgeschlagen(StudentValidierungFehlgeschlagen studentValidierungFehlgeschlagen)
    {
        return new ResponseEntity<>(studentValidierungFehlgeschlagen.getErrorMap(), HttpStatus.BAD_REQUEST);
    }
}
