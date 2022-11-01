package Decorator;

/**
 * Pommes ist eine konkrete Beilage und erbt von dem Dekorator Beilage
 */
public class Pommes extends Beilage{

    public Pommes(IGericht gericht) {
        super(gericht);
    }
    @Override
    public double getPreis() {
        return getGericht().getPreis() + 4.50;
    }

    @Override
    public String getBeschreibung() {
        return getGericht().getBeschreibung() + ", Pommes";
    }


}
