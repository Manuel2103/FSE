package Decorator;

/**
 * Reis ist eine konkrete Beilage und erbt von dem Dekorator Beilage
 */
public class Reis extends Beilage{
    public Reis(IGericht gericht) {
        super(gericht);
    }
    @Override
    public double getPreis() {
        return getGericht().getPreis() + 3.50;
    }

    @Override
    public String getBeschreibung() {
        return getGericht().getBeschreibung() + ", Reis";
    }
}
