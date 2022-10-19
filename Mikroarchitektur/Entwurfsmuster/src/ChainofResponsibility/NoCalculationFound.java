package ChainofResponsibility;

/**
 * Exception für das Ende der Kette wenn keine Rechnungsart passte.
 */
public class NoCalculationFound extends Exception{

    public NoCalculationFound(){
        super("Keine Rechnungsart gefunden");
    }
}
