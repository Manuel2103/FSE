package ui;

import dataaccess.DatabaseException;
import dataaccess.MyBuchungRepository;
import dataaccess.MyCourseRepository;
import dataaccess.MyStudentRepository;
import domain.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Cli {
    private Scanner scan;
    private MyCourseRepository courseRepo;
    private MyStudentRepository studentRepo;
    private MyBuchungRepository buchungRepo;

    public Cli(MyCourseRepository repo, MyStudentRepository studentRepo, MyBuchungRepository buchungRepo) {
        this.courseRepo = repo;
        this.studentRepo = studentRepo;
        this.buchungRepo = buchungRepo;
        this.scan = new Scanner(System.in);
    }

    public void start() {
        String input = "-";
        while (!input.equals("x")) {
            showMenue();
            input = scan.nextLine();
            switch (input) {
                case "1":
                    addCourse();
                    break;
                case "2":
                    showAllCourses();
                    break;
                case "3":
                    showCourseDetails();
                    break;
                case "4":
                    updateCourseDetails();
                    break;
                case "5":
                    deleteCourse();
                    break;
                case "6":
                    courseSearch();
                    break;
                case "7":
                    runningCourses();
                    break;
                case "8":
                    showAllStudents();
                    break;
                case "9":
                    showAllStudents();
                    break;
                case "10":
                    showAllBuchungen();
                    break;
                case "x":
                    System.out.println("Auf Wiedersehen");
                    break;
                default:
                    inputError();
                    break;
            }
        }
        scan.close();
    }

    private void showAllBuchungen() {
        List<Buchung> buchungList;

        try {
            buchungList = buchungRepo.getAll();
            for(Buchung buchung : buchungList){
                System.out.println(buchung);
            }

        }catch (DatabaseException databaseException){
            System.out.println("Datenbankfehler: " + databaseException);
        }catch (Exception e){
            System.out.println("Unbekannter Fehler: " + e.getMessage());
        }

    }

    private void showAllStudents() {
        List<Student> studentList = null;
        try {
            studentList = studentRepo.getAll();
            if(studentList==null){
                System.out.println("Keine Studenten vorhanden!");
            }else{
                for (Student student : studentList){
                    System.out.println(student.toString());
                }
            }
        }catch (DatabaseException databaseException){
            System.out.println("Datenbankfehler: " + databaseException);
        }catch (Exception e){
            System.out.println("Unbekannter Fehelr" + e.getMessage());
        }


    }

    /**
     * In dieser UI Methode werden die laufenden Kurse ausgegebenen.
     */
    private void runningCourses() {
        System.out.println("Aktuell laufende Kurse: ");
        List<Course> list;
        try {
            list = courseRepo.findAllRunningCourses();
            if (list == null) {
                System.out.println("Keine laufenden Kurse");
            } else {
                for (Course course : list) {
                    System.out.println(course);
                }
            }
        } catch (DatabaseException databaseException) {
            System.out.println("Datenbankfehler bei laufende Kurse: " + databaseException.getMessage());
        } catch (Exception exception) {
            System.out.println("Unbekannter Fehler: " + exception.getMessage());
        }
    }

    /**
     * UI Methode für die Suche eines Kurses der eine bestimmte Zeichenkette in der Beschreibung oder Namen besitzt.
     */
    private void courseSearch() {
        System.out.println("Geben Sie einen Suchbegriff an!");
        String searchString = scan.nextLine();
        List<Course> coursesList;
        try {
            coursesList = courseRepo.findAllCoursesByDescriptionOrName(searchString);
            for (Course course : coursesList) {
                System.out.println(course);
            }

        } catch (DatabaseException databaseException) {
            System.out.println("Datenbankfehler bei der Suche: " + databaseException.getMessage());

        } catch (Exception e) {
            System.out.println("Unbekannter Fehler bei der Kursuche: " + e.getMessage());
        }
    }

    /**
     * UI Methode für das Löschen eines Kurses
     */
    private void deleteCourse() {
        System.out.println("Welchen Course möchten sie löschen? Bitte ID eingeben: ");
        Long courseIdToDelete = Long.parseLong(scan.nextLine());
        try {
            courseRepo.deleteById(courseIdToDelete);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Eingabefehler: " + illegalArgumentException.getMessage());
        } catch (DatabaseException databaseException) {
            System.out.println("Datenbankfehler beim Einfügen: " + databaseException.getMessage());
        } catch (Exception exception) {
            System.out.println("unbekannter Fehler: " + exception.getMessage());
        }
    }

    /**
     * Der Benutzer wird gefragt, welchen Kurs er updaten will.
     * Nach einer Prüfung, ob der Kurs vorhanden ist, können die Daten eingegeben werden.
     */
    private void updateCourseDetails() {
        System.out.println("Für welche Course ID möchten Sie die CourseDetails ändern?");
        Long courseID = Long.parseLong(scan.nextLine());
        try {
            Optional<Course> courseOptional = courseRepo.getById(courseID);
            if (courseOptional.isEmpty()) {
                System.out.println("Kurs mit der ID nicht vorhanden!");
            } else {
                Course course = courseOptional.get();
                System.out.println("Änderungen für folgenden Kurs: ");
                System.out.println(course);
                String name, description, hours, dateFrom, dateTo, courseType;
                System.out.println("Bitte neue Kursdaten angeben (Enter, falls keine Änderung gewünscht ist):");
                System.out.println("Name: ");
                name = scan.nextLine();
                System.out.println("Beschreibung: ");
                description = scan.nextLine();
                System.out.println("Hours: ");
                hours = scan.nextLine();
                System.out.println("Startdatum (YYYY-MM-DD): ");
                dateFrom = scan.nextLine();
                System.out.println("Endatum (YYYY-MM-DD): ");
                dateTo = scan.nextLine();
                System.out.println("Kurstyp (ZA/BF/FF/OE): ");
                courseType = scan.nextLine();

                Optional<Course> optionalCourseUpdated = courseRepo.update(
                        new Course(
                                course.getId(),
                                //Kurzschreibweise eines ifelse
                                name.equals("") ? course.getName() : name,
                                description.equals("") ? course.getDescription() : description,
                                hours.equals("") ? course.getHours() : Integer.parseInt(hours),
                                dateFrom.equals("") ? course.getBeginDate() : Date.valueOf(dateFrom),
                                dateTo.equals("") ? course.getEndDate() : Date.valueOf(dateTo),
                                courseType.equals("") ? course.getCourseType() : CourseType.valueOf(courseType)
                        )
                );
                //Funktionale Funktion eines Optionals
                optionalCourseUpdated.ifPresentOrElse(
                        (c) -> System.out.println("kurs aktualisiert: " + c),
                        () -> System.out.println("Kurs konnte nicht aktualisiert werden!")
                );
            }

        } catch (Exception exception) {
            System.out.println("Unbekannter Fehler bei Kursupdate: " + exception.getMessage());
        }
    }

    /**
     * UI Methode die den User durch das Hinzufügen führt
     */
    private void addCourse() {
        //Temporäre Datenfelder
        String name, description;
        int hours;
        Date dateFrom, dateTo;
        CourseType courseType;
        try {
            //Kursdaten eingeben und validieren
            System.out.println("Bitte alle Kursdaten angeben: ");
            System.out.println("Name: ");
            name = scan.nextLine();
            if (name.equals("")) throw new IllegalArgumentException("Eingabe darf nicht leer sein!");
            System.out.println("Beschreibung: ");
            description = scan.nextLine();
            if (description.equals("")) throw new IllegalArgumentException("Eingabe darf nicht leer sein!");
            System.out.println("Stundenanzahl: ");
            hours = Integer.parseInt(scan.nextLine());
            System.out.println("Startdatum (YYYY-MM-DD): ");
            dateFrom = Date.valueOf(scan.nextLine());
            System.out.println("Enddatum (YYYY-MM-DD): ");
            dateTo = Date.valueOf(scan.nextLine());
            System.out.println("Kurstyp: (ZA/BD/FF/OE): ");
            courseType = CourseType.valueOf(scan.nextLine());
            //Verwendet die insert Methode des repos, um einen Kurs zu erstellen.
            Optional<Course> optionalCourse = courseRepo.insert(
                    new Course(name, description, hours, dateFrom, dateTo, courseType)
            );
            if (optionalCourse.isPresent()) {
                System.out.println("Kurs angelegt: " + optionalCourse.get());
            } else {
                System.out.println("Kurs konnte nicht angelegt werden.");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Eingabefehler: " + illegalArgumentException.getMessage());
        } catch (InvalidValueException invalidValueException) {
            System.out.println("Kursdaten nicht korrekt angegeben: " + invalidValueException.getMessage());
        } catch (DatabaseException databaseException) {
            System.out.println("Datenbankfehler beim Einfügen: " + databaseException.getMessage());
        } catch (Exception exception) {
            System.out.println("unbekannter Fehler: " + exception.getMessage());
        }
    }

    /**
     * Zeigt einen Kurs an mit einer bestimmten ID.
     */
    private void showCourseDetails() {
        System.out.println("Für welchen Kurs möchten Sie die Kursdetails anzeigen?");
        Long courseId = Long.parseLong(scan.nextLine());
        try {
            //Aufruf der Funktion getByID
            Optional<Course> courseOptional = courseRepo.getById(courseId);
            //Prüfen, ob ein Course zurückgegeben worden ist.
            if (courseOptional.isPresent()) {
                System.out.println(courseOptional.get());
            } else {
                System.out.println("Kurs mit der ID " + courseId + " nicht gefunden!");
            }

        } catch (DatabaseException databaseException) {
            System.out.println("Datenbankfehler bei Kursanzeige: " + databaseException.getMessage());
        } catch (Exception e) {
            System.out.println("Unbekannter Fehler: " + e.getMessage());
        }
    }

    private void showAllCourses() {

        List<Course> list = null;
        try {
            list = courseRepo.getAll();
            if (list.size() > 0) {
                for (Course course : list) {
                    System.out.println(course);
                }
            } else {
                System.out.println("Liste ist leer.");
            }

        } catch (DatabaseException databaseException) {
            System.out.println("Datenbankfehler bei Anzeige: " + databaseException.getMessage());

        } catch (Exception e) {
            System.out.println("Unbekannter Fehler: " + e.getMessage());
        }


    }

    private void showMenue() {
        System.out.println("--------- Kursmanagment ---------");
        System.out.println("(1) Kurs eingeben \t (2) Alle Kurse anzeigen \t (3) Kursdetails anzeigen \t (4) Kursdetails ändern \t (5) Kursdetails anzeigen \t (6) Kursuche \t (7) Kursuche \t");
        System.out.println("--------- Studentenmanagment ---------");
        System.out.println("(8) Alle Studenten anzeigen");
        System.out.println("--------- Buchungsmanagment ---------");
        System.out.println("(9) Buchung erstellen \t (10) Alle Buchungen ausgeben");
        System.out.println("(x) Ende");
    }

    private void inputError() {
        System.out.println("Bitte nur die Zahlen der Auswahl eingeben!");
    }
}
