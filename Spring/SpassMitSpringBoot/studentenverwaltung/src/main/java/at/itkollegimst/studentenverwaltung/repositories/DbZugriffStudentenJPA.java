package at.itkollegimst.studentenverwaltung.repositories;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//Dient als konkreter Datenbankzugriff mit einer Technologie.
//Die Funktionen werden mithilfe der SimpleJPARepository implementiert.
@Component //Component dient dazu, dass das Autowiring diese Klasse verwendet
public class DbZugriffStudentenJPA implements DbZugriffStudenten{
    private StudentJPARepo studentJPARepo;

    //Wenn ein Konstruktor so aufgebaut ist verwendet Spring Boot automatisch Autowired
    public DbZugriffStudentenJPA(StudentJPARepo studentJPARepo) {
        this.studentJPARepo = studentJPARepo;
    }
    @Override
    public Student studentSpeichern(Student student) {
        return this.studentJPARepo.save(student);
    }
    @Override
    public List<Student> alleStudenten() {
        return this.studentJPARepo.findAll();
    }
    @Override
    public List<Student> alleStudentenAusDemOrt(String plz) {
        return this.studentJPARepo.findAllByPlz(plz);
    }
    @Override
    public Student studentMitId(Long id) throws StudentNichtGefunden {
        Optional<Student> optionalStudent = this.studentJPARepo.findById(id);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }else{
            throw new StudentNichtGefunden("Student mit der Id" + id + " nicht gefunden!");
        }

    }
    @Override
    public void studentLoeschenMitId(Long id) {
        this.studentJPARepo.deleteById(id);

    }
}
