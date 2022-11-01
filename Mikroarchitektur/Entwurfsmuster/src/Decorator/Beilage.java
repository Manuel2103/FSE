package Decorator;

/**
 * Die Klasse Beilage dient als Dekorator der konkreten Beilagen.
 * Dazu kommt ein Datenfeld vom Typ IGericht, damit wir den Preis und die Beschreiben dementsprechend erweitern können.
 */
public class Beilage implements IGericht{

    private IGericht gericht;

    public Beilage(IGericht gericht){
        this.gericht = gericht;
    }

    public IGericht getGericht() {
        return gericht;
    }

    @Override
    public double getPreis() {
        return 0;
    }

    @Override
    public String getBeschreibung() {
        return null;
    }
}
