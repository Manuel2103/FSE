public class Main {
    public static void main(String[] args) {

        //Standartverhalten einer Chain of Responsibility
        //Start der Chain
        WR wr = new EURO2Dollar();
        //Hinzufügen von Umrechnungsarten
        wr.addNextChainElem(new EURO2YEN());
        Double betrag;

        //Anprechen der Kette
        try {
            betrag = wr.umrechnen("EURO2Dollar", 5);
            System.out.println(betrag);
        } catch (ENoElementinChain e) {
            System.out.println(e.getMessage());
        }

        //Löschen von einem Chain Element
        wr.removeNextChainElem();
        try {
            betrag = wr.umrechnen("EURO2YEN", 5);
            System.out.println(betrag);
        } catch (ENoElementinChain e) {
            System.out.println(e.getMessage());
        }

        wr.addNextChainElem(new EURO2YEN());

        //Dekorierer
        //Zwei verschiedene konkrete Decorators (Rechnen mit 0.5 Prozent Abzug oder 5€ Fixbetrag)
        DecoWR rechneMitProzent = new DecoProzent(wr);
        DecoWR rechneFix = new DecoFix(wr);
        try {
            System.out.println(rechneMitProzent.umrechnen("EURO2Dollar", 5));
            System.out.println(rechneFix.umrechnen("EURO2Dollar", 5));
        } catch (ENoElementinChain e) {
            throw new RuntimeException(e);
        }

        


    }
}
