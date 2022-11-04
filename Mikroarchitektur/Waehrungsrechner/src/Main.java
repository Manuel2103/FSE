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

        //Builder
        //Mithilfe des Builder zwei neue Umrechnugnsmöglichkeiten erstellen.
        //Die Beiden bilden eine neue Kette
        WR euro2Dollar2 = new EURO2Builder.WRBuilder()
                .variante("EURO2Dollar2")
                .nextChainElem(null)
                .faktor(0.988)
                .build();

        WR euro2KRONEN = new EURO2Builder.WRBuilder()
                .variante("EURO2KRONEN")
                .nextChainElem(euro2Dollar2)
                .faktor(24.43)
                .build();

        //Möglichkeit sie in die bereits vorhandene Kette einzupflegen
        //wr.addNextChainElem(buildNewWR);

        try {
            System.out.println(euro2KRONEN.umrechnen("EURO2KRONEN", 5));
            System.out.println(euro2KRONEN.umrechnen("EURO2Dollar2", 5));
        } catch (ENoElementinChain e) {
            throw new RuntimeException(e);
        }


    }
}
