package Decorator;
/**
 * Erbt von dem Decorator und fügt ein weiteres Datenfeld hinzu
 */
public class AMD extends CPU{

    private String bezeichnungRGBLuefter;

    public AMD(String bezeichnung, String produktNummer, String geschwindigkeit, String bezeichnungRGBLuefter) {
        super(bezeichnung, produktNummer, geschwindigkeit);
        this.bezeichnungRGBLuefter = bezeichnungRGBLuefter;
    }

    public String getBezeichnungRGBLuefter() {
        return bezeichnungRGBLuefter;
    }
    @Override
    public String getEigenschaften() {
        return getProduktNummer() + ", " +  getBezeichnung() + ", " +  getGeschwindigkeit() + ", " + getBezeichnungRGBLuefter();
    }
}
