package ChainofResponsibility;

public class Main {
    public static void main(String[] args) {

        Berechnung berechnung = new Berechnung();
        System.out.println("Berechnung mit der Kette: " + berechnung.starteBerechnung(5, 2, "+"));
    }
}