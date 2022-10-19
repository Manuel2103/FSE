package TemplateMethod;

/**
 * CharakterB verwendet die Schablone Charakter und implementiert einige Methode die von der abstrakten Klassen nur vorgegeben werden.
 */
public class CharakterB extends Charakter{

    @Override
    public void spezialAngriff() {
        System.out.println("Spezial Angriff B");
    }

    @Override
    public void kochen() {
        System.out.println("Rezept von B");

    }
}
