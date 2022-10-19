package ChainofResponsibility;

/**
 * Interface der verschiedenen Rechnungsarten
 */
public interface IGrundrechnungsarten {
    double rechnen(double a, double b, String zeichen) throws NoCalculationFound;

}
