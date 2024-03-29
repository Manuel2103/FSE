package at.itkollegimst.studentenverwaltung;

import at.itkollegimst.studentenverwaltung.repositories.DbZugriffStudenten;
import at.itkollegimst.studentenverwaltung.repositories.StudentJPARepo;
import at.itkollegimst.studentenverwaltung.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentenverwaltungApplication implements ApplicationRunner { //Durch die Implementierung von ApplicationRunner kann in der Funktion run z.B. Dummy Daten erstellt werden.
	//Durch Autowired wird automatisch eine Rep von Typ StudentJPARepo verwendet.
	//Bei uns SimpleJPARepository
	@Autowired
	DbZugriffStudenten dbZugriffStudenten;
	public static void main(String[] args) {

		SpringApplication.run(StudentenverwaltungApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//Erstellen von Dummy Daten
		this.dbZugriffStudenten.studentSpeichern(new Student("Manuel Foidl" , "6370"));
		this.dbZugriffStudenten.studentSpeichern(new Student("Max Muster" , "3322"));
		this.dbZugriffStudenten.studentSpeichern(new Student("Maxine Musterfrau" , "7070"));
	}
}
