package ChainofResponsibility;

/**
 * Interface der verschiedenen Rechnungsarten
 */
public interface iGrundrechnungsarten {
    double rechnen(double a, double b, String zeichen) throws NoCalculationFound;

}
