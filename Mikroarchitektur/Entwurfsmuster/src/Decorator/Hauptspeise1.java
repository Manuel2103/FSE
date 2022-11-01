package Decorator;

/**
 * Die Klasse Hauptspeise1 ist implementiert das Interface IGericht und besitzt zwei Funktionen.
 * Die Klasse dient als Beispiel für ein Gericht, dass den Beilagen übergeben werden kann
 */
public class Hauptspeise1 implements IGericht{
    @Override
    public double getPreis() {
        return 12.50;
    }

    @Override
    public String getBeschreibung() {
        return "Schnitzel";
    }
}
