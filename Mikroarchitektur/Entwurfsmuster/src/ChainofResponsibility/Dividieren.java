package ChainofResponsibility;
/**
 * Siehe Addieren
 */
public class Dividieren implements iGrundrechnungsarten{

    private iGrundrechnungsarten grundrechnungsart;
    public Dividieren() {
        grundrechnungsart = null;
    }

    @Override
    public double rechnen(double a, double b, String zeichen) throws NoCalculationFound {
        if(zeichen.equals("/")){
            return a/b;
        }else if (grundrechnungsart != null){

            return grundrechnungsart.rechnen(a, b, zeichen);
        }else{
            throw new NoCalculationFound();
        }
    }
}
