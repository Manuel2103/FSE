package ui;

import dataaccess.DatabaseException;
import dataaccess.MyCourseRepository;
import dataaccess.MySqlCourseRepository;
import domain.Course;
import domain.CourseType;

import java.sql.SQLOutput;
import java.util.List;
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
                    System.out.println("Kurseingabe");
                    break;
                case "2":
                    showAllCourses();
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
        System.out.println("(1) Kurs eingeben \t (2) Alle Kurse anzeigen \t");
        System.out.println("(x) Ende");
    }
    private void inputError(){
        System.out.println("Bitte nur die Zahlen der Auswahl eingeben!");
    }
}
