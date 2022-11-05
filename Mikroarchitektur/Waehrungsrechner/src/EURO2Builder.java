public class EURO2Builder extends WR {

    private Double faktor;
    private String variante;

    /**
     * Builder Klasse für Umrechnungen
     */
    public static class WRBuilder {
        private Double faktor;
        private WR nextChainElem;
        private String variante;

        //Setzen der einzelnen Datenfelder
        public WRBuilder faktor(Double faktor) {
            this.faktor = faktor;
            return this;
        }

        public WRBuilder nextChainElem(WR nextChainElem) {
            this.nextChainElem = nextChainElem;
            return this;
        }

        public WRBuilder variante(String variante) {
            this.variante = variante;
            return this;
        }

        //Zusammenfügen der Datenfelder zu einem Währungsrechner
        public WR build() {
            EURO2Builder wr = new EURO2Builder();
            wr.variante = this.variante;
            wr.faktor = this.faktor;
            wr.setNextChainElem(this.nextChainElem);
            return wr;
        }

    }


    //Privater Konstrucktur damit ein Objekt erzeugt werden kann und damit der Builder verwendet wird
    private EURO2Builder() {

    }

    @Override
    public double getFaktor() {
        return this.faktor;
    }

    @Override
    public boolean zustaendig(String variante) {
        if (this.variante.equals(variante)) {
            return true;
        } else {
            return false;
        }
    }


}
