package Adapter;

/**
 * Adapter erbt von der Klasse Dienst und implementiert das Interface IZiel
 * Somit kann er die Funktionen von IZiel überschreiben und die Funktionen von Dienst verwenden
 */
public class Adapter extends Dienst implements IZiel{


    @Override
    public void machAnderes() {
        System.out.println("Ich mach etwas anders!");
        machEtwas();
    }
}
