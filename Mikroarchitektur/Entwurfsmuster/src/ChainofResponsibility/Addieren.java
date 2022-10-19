package ChainofResponsibility;

/**
 * Die Klasse Addieren ist ein Teil der Kette. Sie prüft, ob mit Hilfe eines Strings ob sie die gewünschte Berechnung druchführen kann oder nicht.
 * Wenn nicht wird an das nächste Objekt in der Kette weitergegeben. Am Ende der Kette wird eine Exception geworfen.
 */

public class Addieren implements iGrundrechnungsarten{


    private iGrundrechnungsarten grundrechnungsart;

    /**
     * Im Konstruktor wird die nächste Grundrechnungsart in der Kette festgelegt.
     */
    public Addieren() {

        grundrechnungsart = new Subtrahieren();

    }

    /**
     * Es wird geprüft ob addieren für diese Berechnung zuständig ist, wenn ja dann wird addiert ansonsten wird die rechnen Methode
     * des nächsten Objekts in der Kette aufgerufen.
     * @param a erste Zahl
     * @param b zweite Zahl
     * @param zeichen gewünschte Berechnung
     * @return Ergebnis der Berechnung
     * @throws NoCalculationFound
     */
    @Override
    public double rechnen(double a, double b, String zeichen) throws NoCalculationFound {
        if(zeichen.equals("+")){
            return a+b;
        }else if (grundrechnungsart != null){

            return grundrechnungsart.rechnen(a, b, zeichen);
        }else{
            throw new NoCalculationFound();
        }

    }



}
