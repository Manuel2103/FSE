package Observer;

import java.util.ArrayList;

/**
 * Die Klasse Erzaehler dient registriert, löscht, benachrichtigt die Observer
 */
public class Erzaehler {

    String geschichte;

    public Erzaehler() {
        this.geschichte = "Es war einmal";
    }

    ArrayList<Zuhoerer> zuhoerer;
    public void registrieren(Zuhoerer z){
        this.zuhoerer.add(z);
    }

    public void entfernen(Zuhoerer z){
        this.zuhoerer.remove(z);
    }

    public void benachrichtigen(Zuhoerer z){
        z.aktualisieren(getGeschichte(), this);
    }

    public void setGeschichte(String text){
        this.geschichte = geschichte + text;
    }

    public String getGeschichte() {
        return geschichte;
    }
}
