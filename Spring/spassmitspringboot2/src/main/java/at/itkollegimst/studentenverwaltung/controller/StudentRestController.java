package at.itkollegimst.studentenverwaltung.controller;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.FormValidierungExceptionDTO;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import at.itkollegimst.studentenverwaltung.exceptions.StudentValidierungFehlgeschlagen;
import at.itkollegimst.studentenverwaltung.services.StudentenService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Rest API für Studenten
 */
@RestController //Gibt an, dass es sich um eine Rest API handelt
@RequestMapping("/api/v1/studenten") //Gibt die URL wie diese API aufgerufen werden kann
@CrossOrigin(origins = "http://127.0.0.1:5500") //Gibt die API auch für andere Ports(Server) frei
public class StudentRestController {

    private StudentenService studentenService;

    public StudentRestController(StudentenService studentenService) {
        this.studentenService = studentenService;
    }

    @GetMapping
      public ResponseEntity<List<Student>> gibAlleStudenten() {
        return ResponseEntity.ok(this.studentenService.alleStudenten());
    }

    @PostMapping
     public ResponseEntity<Student> studentEinfuegen(@Valid @RequestBody Student student, BindingResult bindingResult) throws StudentValidierungFehlgeschlagen {
        //    String errors = "";
        FormValidierungExceptionDTO formValidationErrors = new FormValidierungExceptionDTO("9000");

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                formValidationErrors.addFormValidationError(((FieldError) error).getField(), error.getDefaultMessage());
            }
            throw new StudentValidierungFehlgeschlagen(formValidationErrors);
        } else {
            System.out.println("NAME: " + student.getName());
            return ResponseEntity.ok(this.studentenService.studentEinfuegen(student));
        }
    }

    @PutMapping
   public ResponseEntity<Student> studentUpdaten(@Valid @RequestBody Student student, BindingResult bindingResult) throws StudentValidierungFehlgeschlagen, StudentNichtGefunden {
        //    String errors = "";
        FormValidierungExceptionDTO formValidationErrors = new FormValidierungExceptionDTO("9000");

        if (student.getId() == null)
            throw new StudentNichtGefunden("Studenten-Update mit Studenten ohne ID nicht möglich!");

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                formValidationErrors.addFormValidationError(((FieldError) error).getField(), error.getDefaultMessage());
            }
            throw new StudentValidierungFehlgeschlagen(formValidationErrors);
        } else {
            return ResponseEntity.ok(this.studentenService.studentUpdaten(student));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> studentLoeschen(@PathVariable Long id) throws StudentNichtGefunden {
        return ResponseEntity.ok(this.studentenService.studentLoeschenMitId(id));
    }

    @GetMapping("/mitplz/{plz}")
    public ResponseEntity<List<Student>> alleStudentenMitPlz(@PathVariable String plz) {
        return ResponseEntity.ok(this.studentenService.alleStudentenMitPlz(plz));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> studentMitId(@PathVariable Long id) throws StudentNichtGefunden {
        return ResponseEntity.ok(this.studentenService.studentMitId(id));
    }

}
