# FSE

Dokumentation und Mitschrift für fortgeschrittene Software Entwicklung.

Manuel Foidl

# Inhaltsverzeichnis

- [FSE](#fse)
- [Inhaltsverzeichnis](#inhaltsverzeichnis)
- [Spring Boot](#spring-boot)
  - [SpassMitSpringBoot Intro](#spassmitspringboot-intro)
  - [SpassMitSpringBoot Domain und Repo](#spassmitspringboot-domain-und-repo)
  - [SpassMitSpringBoot Datenlayer](#spassmitspringboot-datenlayer)
  - [SpassMitSpringBoot ServiceLayer](#spassmitspringboot-servicelayer)
  - [SpassMitSpringBoot ControllerLayer](#spassmitspringboot-controllerlayer)
  - [SpassMitSpringBoot Exceptions und Validierung](#spassmitspringboot-exceptions-und-validierung)
  - [Java Script Frontend: API kennen lernen](#java-script-frontend-api-kennen-lernen)
  - [Java Script Frontend: Alle Student:innen anzeigen](#java-script-frontend-alle-studentinnen-anzeigen)
  - [Java Script Frontend: Student:innen per id löschen](#java-script-frontend-studentinnen-per-id-löschen)
  - [Java Script Frontend: Student:innen hinzufügen](#java-script-frontend-studentinnen-hinzufügen)
  - [Java Script Frontend: Student:innen aktualisieren](#java-script-frontend-studentinnen-aktualisieren)
  - [Thymeleaf Frontend: Thymeleaf Controller](#thymeleaf-frontend-thymeleaf-controller)
  - [Thymeleaf Frontend: Alle Student:innen anzeigen löschen](#thymeleaf-frontend-alle-studentinnen-anzeigen-löschen)
  - [Thymeleaf Frontend: Student:innen einfügen](#thymeleaf-frontend-studentinnen-einfügen)
  - [Thymeleaf Frontend: Student:innen aktualisieren](#thymeleaf-frontend-studentinnen-aktualisieren)

# Spring Boot

Spring Boot dient zur Entwicklung von Full-Stack Anwendungen, die in eine Datei (.jar)  umgewandelt werden und funktionieren.

## SpassMitSpringBoot Intro

Für die Initialisierung des Projekts wird Spring Initializr verwendet (https://start.spring.io/)

Als Builttool wird Maven verwendet und es wurden folgende Dependencies hinzugefügt:
 * Lombok (Java annotation library which helps to reduce boilerplate code.)
 * Spring Web (Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.)
 * Spring Data JPA (Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.)
 * H2 Database (Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.)
 * Validation (Bean Validation with Hibernate validator.)

Nachdem, das Projekt in IntelliJ geöffnet wurde und alle Dependencies geladen sind, wird unter resources -> application.properties der Datenbankzugriff konfiguriert.
```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
## SpassMitSpringBoot Domain und Repo

In diesem Abschnitt wird eine Domänen Klasse erstellt und ein Repository für Student.
Spring Boot und die Dependencies arbeiten vorwiegend mit Annotationen.

Klasse Student:
```java
@Entity //Gibt an, dass es sich um eine Entität handelt.
@AllArgsConstructor //Konstruktor mit allen Datenfelder
@NoArgsConstructor //Konstruktor mit keine Datenfelder
@Getter
@Setter
public class Student {

    @Id //Gibt an, dass dieses Datenfeld der Primärschlüssel ist
    @GeneratedValue(strategy= GenerationType.SEQUENCE) //Es wird angewiesen, dass es sich um Autoinkrement
    private Long id;
    @Size(min=2) //Automatische Validierung
    private String name;
    @Size(min=4, max=6) //Automatische Validierung
    private String plz;

    //Konstruktor ohne ID für INSERT
    public Student(String name, String plz){
        this.name = name;
        this.plz = plz;
    }
}
```
Interface StudentJPARepo:
```java
/**
 * Das Interface erbt von JpaRepository, dass als Baserepository fungiert.
 * Es bietet auch ein Repo, dass einige Funktion implementiert hat z.B. SimpleJPARepository
 */
@Repository 
public interface StudentJPARepo extends JpaRepository<Student, Long> {
    List<Student> findAllByPlz(String plz);
}
```
StudentenverwaltungApplication:
```java
@SpringBootApplication
public class StudentenverwaltungApplication implements ApplicationRunner { //Durch die Implementierung von ApplicationRunner kann in der Funktion run z.B. Dummy Daten erstellt werden.
	//Durch Autowired wird automatisch eine Rep von Typ StudentJPARepo verwendet.
	//Bei uns SimpleJPARepository
	@Autowired
	StudentJPARepo studentJPARepo;
	public static void main(String[] args) {
		SpringApplication.run(StudentenverwaltungApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//Erstellen von Dummy Daten
		this.studentJPARepo.save(new Student("Manuel Foidl" , "6370"));
		this.studentJPARepo.save(new Student("Max Muster" , "3322"));
		this.studentJPARepo.save(new Student("Maxine Musterfrau" , "7070"));
	}
}
```
## SpassMitSpringBoot Datenlayer
Im Datenlayer wird er Datenbankzugriff für den Studenten geregelt. 
Dazu wurde eine neue neues Interface erstellt und eine Klasse.

Interface DbZugriffStudenten: 
```java
//Interface mit verschiedenen Funktionen
public interface DbZugriffStudenten {

    Student studentSpeichern(Student student);
    List<Student> alleStudenten();
    List<Student> alleStudentenAusDemOrt(String plz);
    Student studentMitId(Long id) throws StudentNichtGefunden;
    void studentLoeschenMitId(Long id);
}
```
Klasse DbZugriffStudentenJPA:
```java
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
```
## SpassMitSpringBoot ServiceLayer

Der ServiceLayer bietet den verschiedenen Layer außerhalb eine Möglichkeit mit den anderen Layern zu kommunizieren. 
Zum Beispiel Controller mit dem Repo. 

Dazu wird ein Interface erstellt, dass verschiedene verschiedene Funktionen deklariert.

Darauf folgt eine Klasse, die diese Funktionen implementiert. Diese Klasse besitzt ein Datenfeld von DbZugriffStudenten, um dort auf die Funktionen zuzugreifen. Durch Dependency Injection ist aber nicht bekannt welche Technologie dahinter steckt, da nur das Interface als Deklaration verwendet wird.

Klasse StudentenServiceImpl: 
```java
@Service //@Service verweist darauf das StudentenServiceImpl eine Componente ist und bei @Autowiring in Frage kommt.
public class StudentenServiceImpl implements StudentenService{
    //Technologieneutraler Zugriff auf die Studenten durch Dependency Injection
    private DbZugriffStudenten dbZugriffStudenten;

    public StudentenServiceImpl(DbZugriffStudenten dbZugriffStudenten) {
        this.dbZugriffStudenten = dbZugriffStudenten;
    }
    //Die folgenden Methoden werden mithilfe der bereits vorhandenen Methoden in DbZugriffStudentenJPA implementiert.
    @Override
    public List<Student> alleStudenten() {
        return this.dbZugriffStudenten.alleStudenten();
    }
    @Override
    public Student studentEinfuegen(Student student) {
        return this.dbZugriffStudenten.studentSpeichern(student);
    }
    @Override
    public Student studentMitId(Long id) throws StudentNichtGefunden {
        return this.dbZugriffStudenten.studentMitId(id);
    }
    @Override
    public List<Student> alleStudentenMitPlz(String plz) {
        return this.dbZugriffStudenten.alleStudentenAusDemOrt(plz);
    }
    @Override
    public void studentLoeschenMitId(Long id) {
        this.dbZugriffStudenten.studentLoeschenMitId(id);
    }
}
```

## SpassMitSpringBoot ControllerLayer

Der ControllerLayer stellt eine REST-API zur Verfügung, die verschiedene Funktion erfüllt. 

Klasse StudentRestController:
```java
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
```
## SpassMitSpringBoot Exceptions und Validierung

In diesem Kapitel werden die Exceptions optimiert, mithilfe eines ExceptionsControllers

ExceptionDTO:

```java
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
```
ExceptionController:
```java
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
```
Exception handling der Validierung in StudentRestController:
```java
@PostMapping
public ResponseEntity<Student> studentEinfuegen(@Valid @RequestBody Student student, BindingResult bindingResult) throws StudentValidierungFehlgeschlagen {
    FormValidierungExceptionDTO formValidationErrors = new FormValidierungExceptionDTO("9000");
    //BindungResult beinhaltet die Fehler die aufgetreten worden sind. 
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
```




## Java Script Frontend: API kennen lernen

In diesem Abschnitt wurde die API genauer untersucht mit der Hilfe von verschiedenen Tools wie zum Beispiel Insomnia und SpringDoc.

## Java Script Frontend: Alle Student:innen anzeigen

Als erstes wurde eine einfache HTML Seite erstellt die als Basis dient. Die Funktionen des Backends werden mit JavaScript angesprochen. 

```javascript
    //Funktion die alle Studenten zurückliefert
    async function getAllData() {
        try {
            //Mithilfe von der Funktion fetch kann eine API aufgerufen werden. Dazu wird die URL benötigt und weitere Parameter
            const response = await fetch('http://localhost:8080/api/v1/studenten',
                {
                    method: 'GET',
                    cache: 'no-cache',
                    headers: {
                        "Accept": "application/json"
                    }
                })
            //Rückgabe als JSON umwandeln    
            const data = await response.json()

            const table = document.getElementById('studentTable')
            while (table.rows[0]) {
                table.deleteRow(0)
            }
            var row = table.insertRow()
            var id = row.insertCell(0)
            var name = row.insertCell(1)
            var plz = row.insertCell(2)
            var action = row.insertCell(3)
            id.innerHTML = 'ID'
            name.innerHTML = 'Name'
            plz.innerHTML = 'PLZ'
            action.innerHTML = 'Aktion'
            //Daten auslesen und in die Tabelle schreiben
            data.forEach((student) => {
                var row = table.insertRow()
                var id = row.insertCell(0)
                var name = row.insertCell(1)
                var plz = row.insertCell(2)
                var action = row.insertCell(3)
                id.innerHTML = student.id
                name.innerHTML = student.name
                plz.innerHTML = student.plz
                //Bearbeiten und Löschen Button rufen die jeweilige Funktion auf.
                action.innerHTML = `<a href="updateStudent.html?id=${student.id}&name=${student.plz}" class="btn btn-info" role="button">bearbeiten</a> <button type="button" class="btn btn-warning" onclick="deleteStudent(${student.id})">löschen </button>`
            })
            console.log(data)
        }
        catch (exception) {
            const table = document.getElementById('studentTable')
            table.innerHTML = "Studentendaten konnten nicht geladen werden"
        }
    }
```

## Java Script Frontend: Student:innen per id löschen

Funktion deleteStudent:
```javascript
    async function deleteStudent(id) {
        try{
        const response = await fetch('http://localhost:8080/api/v1/studenten/'+id,
            {
                method: 'DELETE',
                cache: 'no-cache',
                headers: {
                    "Accept": "application/json"
                }
            })
            const data = await response.json()
            getAllData()
        } catch(exception){
            alert("Fehler beim Löschen")
        }
        
    }
```

## Java Script Frontend: Student:innen hinzufügen

Für das Einfügen der Studenten wird eine eigene Seite erstellt, mit dementsprechenden Formular.
```javascript
    //Funktion zum einfügen von Studenten
    async function sendData(){
        //Daten aus dem Formular auslesen
        const name = $('input[name=name]').val()
        const plz = $('input[name=plz]').val()

        try {
            //POST Call auf die API
            const response = await fetch('http://localhost:8080/api/v1/studenten',
                {
                    method: 'POST',
                    cache: 'no-cache',
                    headers: {
                        "Content-Type": "application/json",
                        "Accept": "application/json"
                    },
                    body: JSON.stringify({"name": name, "plz":plz}) 
                })
                const data = await response.json()
                //Zwei Felder für Fehlermeldungen freihalten
                $('#nameError').html('')
                $('#plzError').html('')
                //Prüfen, ob Fehler entstanden sind
                if(data.code && data.code == 9000 && data.formValidationErrors){
                    if(data.formValidationErrors.name){
                        //Felder im Falle befüllen
                        $('#nameError').html(data.formValidationErrors.name)
                    }
                    if(data.formValidationErrors.plz){
                        $('#plzError').html(data.formValidationErrors.plz)
                    }
                }else{
                    $('#name').val('')
                    $('#plz').val('')
                    alert("Student eingefügt")
                }
   
        } catch (exception) { //siehe fetch()-API Dokumentation
            alert("Student konnte nicht eingefügt werden")
        }
    }
```

## Java Script Frontend: Student:innen aktualisieren

Auch das Aktualisieren der Studenten wird in einer eigenen Datei implementiert und mit einer Form realisiert.

```javascript
loadUrlDataToForm()

    //Mitgegeben Werte auslesen
    function loadUrlDataToForm() {
        const id = getURLParameter('id')
        const name = getURLParameter('name')
        const plz = getURLParameter('plz')
        console.log(id)

        $('#id').val(id)
        $('#name').val(name)
        $('#plz').val(plz)
    }
    function getURLParameter(name) {
        return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exe(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
    }

    async function sendData() {

        const id = $('input[name=id]').val()
        const name = $('input[name=name]').val()
        const plz = $('input[name=plz]').val()

        try {
            const response = await fetch('http://localhost:8080/api/v1/studenten',
                {
                    method: 'PUT',
                    cache: 'no-cache',
                    headers: {
                        "Content-Type": "application/json",
                        "Accept": "application/json"
                    },
                    body: JSON.stringify({ "id": id, "name": name, "plz": plz })
                })

            const data = await response.json()

            $('#nameError').html('')
            $('#plzError').html('')

            if (data.code) {
                if (data.code == 9000 && data.formValidationErrors) {
                    if (data.formValidationErrors.name) {
                        $('#nameError').html(data.formValidationErrors.name)
                    }
                    if (data.formValidationErrors.plz) {
                        $('#plzError').html(data.formValidationErrors.plz)

                    }
                } else if (data.code == 1000 && data.message)//Student für die Aktualisierung ist nicht bekannt
                {
                    alert("Student konnte nicht aktualisiert werden" + data.message)
                }
            } else {

                alert("Student aktualisiert")
            }

        } catch (exception) { //siehe fetch()-API Dokumentation
            alert("Student konnte nicht aktualisiert werden")
        }
    }
```
## Thymeleaf Frontend: Thymeleaf Controller
Für das Thymeleaf Frontend wird ein Thymeleaf Controller benötigt, der Funktionen bereitstellt und von den Thymeleaf Elemente im Fronten verwendet wird.

```java
@Controller
@RequestMapping("/web/v1/studenten")
public class StudentThymeleafController {
    //Verwendet den StudentenService, um dessen Funktioen zu verwenden.
    private StudentenService studentService;
    public StudentThymeleafController(StudentenService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public String gibAlleStudenten(Model model){
        model.addAttribute("allStudents", this.studentService.alleStudenten());
        return "allestudenten";
    }
    @GetMapping("/insert")
    public String studentenEinfuegenFormular(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "studenteneinfuegen";
    }
    @PostMapping("/insert")
    public String studentEinfuegen(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "studenteneinfuegen";
        }else{
            this.studentService.studentEinfuegen(student);
            return "redirect:/web/v1/studenten";
        }
    }
    @GetMapping("/update/{id}")
    public String studentUpdatenFormular(@PathVariable Long id, Model model){
        try{
            Student student = this.studentService.studentMitId(id);
            model.addAttribute("student", student);
            return "studentenupdaten";
        }catch (StudentNichtGefunden studentNichtGefunden){
            return "redirect:web/v1/studenten";
        }
    }
    @PostMapping("/update")
    public String stuentUpdaten(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "studentenupdaten";
        }else{
            try{
                this.studentService.studentUpdaten(student);
                return "redirect:/web/v1/studenten";
            }catch (StudentNichtGefunden studentNichtGefunden){
                return "redirect:/web/v1/studenten";
            }
        }
    }
    @GetMapping("/delete/{id}")
    public String studentLoeschen(@PathVariable Long id){
        try{
            this.studentService.studentLoeschenMitId(id);
            return "redirect:/web/v1/studenten";
        }catch (StudentNichtGefunden studentNichtGefunden){
            return "redirect:/web/v1/studenten";
        }
    }
}
```
## Thymeleaf Frontend: Alle Student:innen anzeigen löschen

Nun werden die gleichen Funktionen mithilfe von Thymeleaf realisiert.

Wichtige Imports:

```html
        <html
        xmlns="http://www.w3.org/1999/xhtml"
        xmlns:th="http://www.tyhmeleaf.org"
        lang="de">
```

Studenten:innen anzeigen:
```html
<!-- Tabelle -->
<table class="table" id="studentTable">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>PLZ</th>
        <th>Aktion</th>
    </tr>
    </thead>
    <tbody>
    <!--Mit th wird Thymeleaf angesprochen-->
    <!--th:each ist eine foreach Schleife-->
    <tr th:each="student: ${allStudents}">
        <td th:text="${student.id}"></td>
        <td th:text="${student.name}"></td>
        <td th:text="${student.plz}"></td>
        <td>
            <a th:href="@{/web/v1/studenten/update/{id}(id=${student.id})}" class="btn btn-info" role="button">bearbeiten </a>
            <!--Student löschen-->
            <a th:href="@{/web/v1/studenten/delete/{id}(id=${student.id})}" class="btn btn-warning" role="button">löschen </a>
        </td>
    </tr>
    </tbody>
</table>
```

## Thymeleaf Frontend: Student:innen einfügen

```html
<table class="table" id="studentTable">
    <form th:object="${student}" th:action=@{/web/v1/studenten/insert} method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" th:field="*{name}">
            <!--Kontrolle ob ein Fehler vorliegt und diesen ausgeben-->
            <div class="form-text" th:if="${#fields.hasErrors('name')}" th:errorclass="error" th:errors="*{name}"></div>
        </div>
        <div class="mb-3">
            <label for="plz" class="form-label">plz</label>
            <input type="text" class="form-control" id="plz" name="plz" th:field="*{plz}">
            <!--Kontrolle ob ein Fehler vorliegt und diesen ausgeben-->
            <div class="form-text" th:if="${#fields.hasErrors('plz')}" th:errorclass="error" th:errors="*{plz}"></div>
        </div>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Speichern</button>
    </form>
</table>
```

## Thymeleaf Frontend: Student:innen aktualisieren

```html
<table class="table" id="studentTable">
    <form th:object="${student}" th:action=@{/web/v1/studenten/update} method="post">
        <div class="mb-3">
            <label for="id" class="form-label">ID</label>
            <input type="text" class="form-control" id="id" name="id" th:field="*{id}" readonly>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" th:field="*{name}">
            <div class="form-text" th:if="${#fields.hasErrors('name')}" th:errorclass="error" th:errors="*{name}"></div>
        </div>
        <div class="mb-3">
            <label for="plz" class="form-label">plz</label>
            <input type="text" class="form-control" id="plz" name="plz" th:field="*{plz}">
            <div class="form-text" th:if="${#fields.hasErrors('plz')}" th:errorclass="error" th:errors="*{plz}"></div>
        </div>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Aktualisieren</button>
    </form>
</table>
```


































