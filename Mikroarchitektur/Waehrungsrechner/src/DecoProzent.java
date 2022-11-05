public class DecoProzent extends DecoWR {


    public DecoProzent(WR wr) {
        super(wr);
    }

    /**
     * Gibt den verminderten Wert zurück
     *
     * @param variante Wie soll umgerechnet werden
     * @param betrag   Wie viel soll umgerechnet werden
     * @return Ergebnis - Verminderung
     * @throws ENoElementinChain
     */
    @Override
    public double umrechnen(String variante, double betrag) throws ENoElementinChain {
        return super.umrechnen(variante, betrag) - (super.umrechnen(variante, betrag) * 0.005);
    }

}
