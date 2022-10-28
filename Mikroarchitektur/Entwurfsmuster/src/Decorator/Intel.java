package Decorator;

/**
 * Erbt von dem Decorator und fügt ein weiteres Datenfeld hinzu
 */
public class Intel extends CPU{

    private String spezialFeature;

    public Intel(String bezeichnung, String produktNummer, String geschwindigkeit, String spezialFeature) {
        super(bezeichnung, produktNummer, geschwindigkeit);
        this.spezialFeature = spezialFeature;
    }

    public String getSpezialFeature() {
        return spezialFeature;
    }

    @Override
    public String getEigenschaften() {
        return getProduktNummer() + ", " +  getBezeichnung() + ", " +  getGeschwindigkeit() + ", " + getSpezialFeature();
    }
}
