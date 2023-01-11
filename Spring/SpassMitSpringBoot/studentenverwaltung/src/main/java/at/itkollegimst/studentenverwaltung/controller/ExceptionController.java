package at.itkollegimst.studentenverwaltung.controller;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.ExceptionDTO;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import at.itkollegimst.studentenverwaltung.exceptions.StudentValidierungFehlgeschlagen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //Macht diese Klase zu einem ExceptionCOntroller
public class ExceptionController {

    @ExceptionHandler(StudentNichtGefunden.class) //gibt an, welche Exception behandelt wird
    public ResponseEntity<ExceptionDTO> studentNichtGefunden(StudentNichtGefunden studentNichtGefunden){
        return new ResponseEntity<>(new ExceptionDTO("1000", studentNichtGefunden.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentValidierungFehlgeschlagen.class)
    public ResponseEntity<ExceptionDTO> studentValFehlgeschlagen(StudentValidierungFehlgeschlagen validierungFehlgeschlagen){
        return new ResponseEntity<>(new ExceptionDTO("9000", validierungFehlgeschlagen.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
