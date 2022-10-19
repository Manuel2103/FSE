package TemplateMethod;

/**
 * Charakter ist eine abstrakte Klasse und dient als Schablone. Es werden verschiedene Methoden bereitgestellt.
 */
public abstract class Charakter {
    public void kaempfen(int schaden){
        System.out.println("Angriff: " + schaden);
    }
    public abstract void spezialAngriff();

    public void heilen(int heilung){
        System.out.println("Heilen: " + heilung);
    }

    public void schlafen(){
        System.out.println("Schlafen");
    }
    public abstract void kochen();
}
