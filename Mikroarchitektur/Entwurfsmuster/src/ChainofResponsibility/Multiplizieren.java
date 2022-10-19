package ChainofResponsibility;
/**
 * Siehe Addieren
 */
public class Multiplizieren implements IGrundrechnungsarten {

    private IGrundrechnungsarten grundrechnungsart;

    public Multiplizieren() {
        this.grundrechnungsart = new Dividieren();
    }

    @Override
    public double rechnen(double a, double b, String zeichen) throws NoCalculationFound {
        if(zeichen.equals("*")){
            return a*b;
        }else if (grundrechnungsart != null){

            return grundrechnungsart.rechnen(a, b, zeichen);
        }else{
            throw new NoCalculationFound();
        }
    }
}
