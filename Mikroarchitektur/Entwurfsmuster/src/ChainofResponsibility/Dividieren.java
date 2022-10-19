package ChainofResponsibility;
/**
 * Siehe Addieren
 */
public class Dividieren implements IGrundrechnungsarten {

    private IGrundrechnungsarten grundrechnungsart;
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
