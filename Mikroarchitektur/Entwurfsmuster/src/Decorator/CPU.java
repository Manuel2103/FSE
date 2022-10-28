package Decorator;

/**
 * CPU ist eine Decorator Klasse die einige Funktionen und Datenfelder hinzufügt
 */
public class CPU implements IKomponente{

    private String bezeichnung;
    private String produktNummer;
    private String geschwindigkeit;

    public CPU(String bezeichnung, String produktNummer, String geschwindigkeit) {
        this.bezeichnung = bezeichnung;
        this.produktNummer = produktNummer;
        this.geschwindigkeit = geschwindigkeit;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public String getProduktNummer() {
        return produktNummer;
    }

    public String getGeschwindigkeit() {
        return geschwindigkeit;
    }

    @Override
    public String getEigenschaften() {
        return "Das ist eine CPU.";
    }
}
