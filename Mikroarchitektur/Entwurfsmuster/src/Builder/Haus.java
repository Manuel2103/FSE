package Builder;

/**
 * Die Klasse Haus dient als Beispiel Produkt und wird von der HausErbauer verwendet um ein Haus zu bauen
 */
public class Haus {
    private String kosten;
    private String hausnummer;
    private String jahr;

    public Haus(String kosten, String hausnummer, String jahr) {
        this.kosten = kosten;
        this.hausnummer = hausnummer;
        this.jahr = jahr;
    }

    public String getKosten() {
        return kosten;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public String getJahr() {
        return jahr;
    }

    public String getHausinfo(){
        return getHausnummer() + ", " + getKosten() + ", " + getJahr();
    }
}
