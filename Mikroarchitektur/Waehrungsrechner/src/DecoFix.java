public class DecoFix extends DecoWR{
    public DecoFix(WR wr) {
        super(wr);
    }

    /**
     * Gibt den verminderten Wert zurück
     * @param variante Wie soll umgerechnet werden
     * @param betrag Wie viel soll umgerechnet werden
     * @return Ergebnis - Verminderung
     * @throws ENoElementinChain
     */
    public double umrechnen(String variante, double betrag) throws ENoElementinChain {
        if (betrag>5){
            return super.umrechnen(variante, betrag - 5);
        }else{
            System.out.println("Bitte Betrag größer 5 eingeben");
            return 0;
        }

    }


}
