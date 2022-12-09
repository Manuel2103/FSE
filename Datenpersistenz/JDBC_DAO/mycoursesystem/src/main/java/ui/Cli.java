package ui;

import dataaccess.DatabaseException;
import dataaccess.MyCourseRepository;
import dataaccess.MySqlCourseRepository;
import domain.Course;
import domain.CourseType;
import domain.InvalidValueException;

import java.sql.SQLOutput;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Cli {
    private Scanner scan;
    private MyCourseRepository repo;

    public Cli(MyCourseRepository repo) {
        this.repo = repo;
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

    /**
     * Der Benutzer wird gefragt, welchen Kurs er updaten will.
     * Nach einer Prüfung, ob der Kurs vorhanden ist, können die Daten eingegeben werden.
     */
    private void updateCourseDetails() {
        System.out.println("Für welche Course ID möchten Sie die CourseDetails ändern?");
        Long courseID = Long.parseLong(scan.nextLine());
        try {
            Optional<Course> courseOptional = repo.getById(courseID);
            if(courseOptional.isEmpty()){
                System.out.println("Kurs mit der ID nicht vorhanden!");
            }else{
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

                Optional<Course> optionalCourseUpdated = repo.update(
                        new Course(
                                course.getId(),
                                //Kurzschreibweise eines ifelse
                                name.equals("") ? course.getName() : name,
                                description.equals("") ? course.getDescription():description,
                                hours.equals("") ? course.getHours(): Integer.parseInt(hours),
                                dateFrom.equals("") ? course.getBeginDate(): Date.valueOf(dateFrom),
                                dateTo.equals("") ? course.getEndDate(): Date.valueOf(dateTo),
                                courseType.equals("") ? course.getCourseType() : CourseType.valueOf(courseType)
                        )
                );
                //Funktionale Funktion eines Optionals
                optionalCourseUpdated.ifPresentOrElse(
                        (c)-> System.out.println("kurs aktualisiert: " + c),
                        ()-> System.out.println("Kurs konnte nicht aktualisiert werden!")
                );
            }

        }catch (Exception exception){
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
            System.out.println("Startdatum (YYYY-MM-DD): ");
            dateTo = Date.valueOf(scan.nextLine());
            System.out.println("Kurstyp: (ZA/BD/FF/OE): ");
            courseType = CourseType.valueOf(scan.nextLine());
            //Verwendet die insert Methode des repos, um einen Kurs zu erstellen.
            Optional<Course> optionalCourse = repo.insert(
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
            Optional<Course> courseOptional = repo.getById(courseId);
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
            list = repo.getAll();
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
        System.out.println("(1) Kurs eingeben \t (2) Alle Kurse anzeigen \t (3) Kursdetails anzeigen \t (4) Kursdetails ändern \t");
        System.out.println("(x) Ende");
    }

    private void inputError() {
        System.out.println("Bitte nur die Zahlen der Auswahl eingeben!");
    }
}
