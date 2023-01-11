package at.itkollegimst.studentenverwaltung.controller;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import at.itkollegimst.studentenverwaltung.services.StudentenService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Student> studentEinfuegen(@RequestBody Student student){ //@RequestBody erstellt von dem mitgegebenen Daten von POST ein Student Objekt.
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
