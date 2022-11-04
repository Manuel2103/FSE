package ChainofResponsibility;

import java.util.ArrayList;

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
            betrag = wr.umrechnen("EURO2YEN", 5);
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




    }
}
