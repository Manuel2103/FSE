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
    public Cli(MyCourseRepository repo){
        this.repo = repo;
        this.scan = new Scanner(System.in);
    }

    public void start()
    {
        String input = "-";
        while (!input.equals("x")){
            showMenue();
            input = scan.nextLine();
            switch (input){
                case "1":
                    addCourse();
                    break;
                case "2":
                    showAllCourses();
                    break;
                case "3":
                    showCourseDetails();
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

    private void addCourse() {

        String name, description;
        int hours;
        Date dateFrom, dateTo;
        CourseType courseType;

        try{
            System.out.println("Bitte alle Kursdaten angeben: ");
            System.out.println("Name: ");
            name = scan.nextLine();
            if(name.equals("")) throw new IllegalArgumentException("Eingabe darf nicht leer sein!");
            System.out.println("Beschreibung: ");
            description = scan.nextLine();
            if(description.equals("")) throw new IllegalArgumentException("Eingabe darf nicht leer sein!");
            System.out.println("Stundenanzahl: ");
            hours = Integer.parseInt(scan.nextLine());
            System.out.println("Startdatum (YYYY-MM-DD): ");
            dateFrom = Date.valueOf(scan.nextLine());
            System.out.println("Startdatum (YYYY-MM-DD): ");
            dateTo = Date.valueOf(scan.nextLine());
            System.out.println("Kurstyp: (ZA/BD/FF/OE): ");
            courseType = CourseType.valueOf(scan.nextLine());

            Optional<Course> optionalCourse = repo.insert(
                    new Course(name, description, hours, dateFrom, dateTo, courseType)
            );
            if (optionalCourse.isPresent()){
                System.out.println("Kurs angelegt: " + optionalCourse.get());
            }else {
                System.out.println("Kurs konnte nicht angelegt werden.");
            }


        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println("Eingabefehler: " + illegalArgumentException.getMessage());


        }catch (InvalidValueException invalidValueException){
            System.out.println("Kursdaten nicht korrekt angegeben: " + invalidValueException.getMessage());

        }catch (DatabaseException databaseException){
            System.out.println("Datenbankfehler beim Einfügen: " + databaseException.getMessage());

        }catch (Exception exception){
            System.out.println("unbekannter Fehler: " + exception.getMessage());
        }

    }

    /**
     * Zeigt einen Kurs an mit einer bestimmten ID.
     */
    private void showCourseDetails(){
        System.out.println("Für welchen Kurs möchten Sie die Kursdetails anzeigen?");
        Long courseId = Long.parseLong(scan.nextLine());
        try {
            //Aufruf der Funktion getByID
            Optional<Course> courseOptional = repo.getById(courseId);
            //Prüfen, ob ein Course zurückgegeben worden ist.
            if(courseOptional.isPresent()){
                System.out.println(courseOptional.get());
            }else{
                System.out.println("Kurs mit der ID " + courseId + " nicht gefunden!");
            }

        }catch (DatabaseException databaseException){
            System.out.println("Datenbankfehler bei Kursanzeige: " + databaseException.getMessage());
        }catch (Exception e){
            System.out.println("Unbekannter Fehler: " + e.getMessage());
        }
    }
    private void showAllCourses(){

        List<Course> list = null;
        try {
            list = repo.getAll();
            if (list.size()>0){
                for (Course course:list){
                    System.out.println(course);
                }
            }else{
                System.out.println("Liste ist leer.");
            }

        }catch (DatabaseException databaseException){
            System.out.println("Datenbankfehler bei Anzeige: " + databaseException.getMessage());

        }catch (Exception e){
            System.out.println("Unbekannter Fehler: " + e.getMessage());
        }


    }
    private void showMenue(){
        System.out.println("--------- Kursmanagment ---------");
        System.out.println("(1) Kurs eingeben \t (2) Alle Kurse anzeigen \t (3) Kursdetails anzeigen \t");
        System.out.println("(x) Ende");
    }
    private void inputError(){
        System.out.println("Bitte nur die Zahlen der Auswahl eingeben!");
    }
}
