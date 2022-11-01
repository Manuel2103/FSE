package Decorator;

public class Main {
    public static void main(String[] args) {

        //Es wird ein neues Gericht erstellt mit zwei Beilagen
        //Dabei werden die dekorierten Beilagen verschachtelt und zum Schluss wird eine neue Hauptspeise übergeben.
        //Somit summiert sich der Preis und die Zeichenkette erweitert sich.
        IGericht gericht = new Pommes(new Reis(new Hauptspeise1()));
        System.out.println(gericht.getBeschreibung());
        System.out.println(gericht.getPreis());



    }
}
