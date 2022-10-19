package TemplateMethod;

/**
 * CharakterA verwendet die Schablone Charakter und implementiert einige Methode die von der abstrakten Klassen nur vorgegeben werden.
 */
public class CharakterA extends Charakter{

    @Override
    public void spezialAngriff() {
        System.out.println("SpezialAngriff A");
    }

    @Override
    public void kochen() {
        System.out.println("Rezept von A");
    }
}
