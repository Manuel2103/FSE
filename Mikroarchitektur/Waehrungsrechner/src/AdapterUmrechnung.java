public class AdapterUmrechnung implements ISammelumrechnung{

    //Es wird eine Chain für das Umrechnen verwendet
    WR wr;
    //Rechnungsart wird übergeben
    public AdapterUmrechnung(WR wr) {
        this.wr = wr;
    }

    /**
     * Durchläuft das Array und berechnet das Ergebnis
     * @param betraege Betreage
     * @param variante Variante der Umrechnung
     * @return Summe der umgewandelten Betraege
     */
    @Override
    public double sammelumrechnen(double[] betraege, String variante) {
        double ergebnis = 0;
        for (int i = 0; i < betraege.length; i++) {
            try {
                ergebnis = ergebnis + wr.umrechnen(variante, betraege[i]);
            } catch (ENoElementinChain e) {
                e.getMessage();
            }
        }
        return ergebnis;
    }

}
