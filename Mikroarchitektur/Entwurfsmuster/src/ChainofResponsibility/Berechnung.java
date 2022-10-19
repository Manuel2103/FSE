package ChainofResponsibility;

/**
 * Die Klasse Berechnung dient als Ansprechklasse der Kette. Die Kette beginnt mit Addieren.
 * Weiters wird die Exception behandelt, wenn das Ende der Kette erreicht wird
 */
public class Berechnung {
    private iGrundrechnungsarten berechnung;

    public Berechnung() {
        this.berechnung = new Addieren();
    }

    /**
     * Startet die Chain of Responsibility und behandelt die mögliche Exception
     * @param a erste Zahl
     * @param b zweite Zahl
     * @param zeichen Rechnungsart
     * @return Ergebnis
     */
    public double starteBerechnung(double a, double b, String zeichen){

        try {
            return berechnung.rechnen(a, b, zeichen);
        } catch (NoCalculationFound e) {
            throw new RuntimeException(e);
        }

    }
}
