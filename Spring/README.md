# FSE

Dokumentation und Mitschrift für fortgeschrittene Software Entwicklung.

Manuel Foidl

# Inhaltsverzeichnis

- [FSE](#fse)
- [Inhaltsverzeichnis](#inhaltsverzeichnis)
- [Spring Boot](#spring-boot)
  - [SpassMitSpringBoot Intro](#spassmitspringboot-intro)
  - [SpassMitSpringBoot Domain und Repo](#spassmitspringboot-domain-und-repo)

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






















