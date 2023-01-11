package at.itkollegimst.studentenverwaltung.controller;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import at.itkollegimst.studentenverwaltung.exceptions.StudentValidierungFehlgeschlagen;
import at.itkollegimst.studentenverwaltung.services.StudentenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController ermöglicht es eine Rest-API zu realisieren.
@RestController //RestController ermöglicht es eine Rest-API zu realisieren.
@RequestMapping("api/v1/studenten") //Pfad von API
public class StudentRestController {
    //ServiceLayer Zugriff
    private StudentenService studentenService;

    public StudentRestController(StudentenService studentenService) {
        this.studentenService = studentenService;
    }
    @GetMapping
    public ResponseEntity<List<Student>> giballeStudenten(){
        //ResponseEntity erstellt aus den Studentobjekten JSON
        return ResponseEntity.ok(this.studentenService.alleStudenten());
    }
    @PostMapping
    public ResponseEntity<Student> studentEinfuegen(@Valid @RequestBody Student student, BindingResult bindingResult) throws StudentValidierungFehlgeschlagen { //@RequestBody erstellt von dem mitgegebenen Daten von POST ein Student Objekt.

        String errors="";
        if(bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                errors+="\nValidierungsfehler für Objekt" + error.getObjectName() +
                        " im Feld " + ((FieldError)error).getField() + " mit folgendem Problem" +
                        error.getDefaultMessage();
            }
            throw new StudentValidierungFehlgeschlagen(errors);
        }

        return ResponseEntity.ok(this.studentenService.studentEinfuegen(student));

    }
    @DeleteMapping("/{id}")
    public String studentLoeschen(@PathVariable Long id)//PathVariable dient dazu die mitgegebenen Werte zu verwenden
    {
        this.studentenService.studentLoeschenMitId(id);
        return "Student gelöscht";
    }
    @GetMapping("/mitplz/{plz}")
    public ResponseEntity<List<Student>> alleStudentenMitPlz(@PathVariable String plz){
        return ResponseEntity.ok(this.studentenService.alleStudentenMitPlz(plz));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> studentMitId(@PathVariable Long id) throws StudentNichtGefunden {
        return ResponseEntity.ok(this.studentenService.studentMitId(id));

    }


}
