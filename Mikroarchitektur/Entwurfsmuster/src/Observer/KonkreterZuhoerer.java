package Observer;

public class KonkreterZuhoerer extends Zuhoerer{

    @Override
    public void aktualisieren(String text, Erzaehler erzaehler) {
        System.out.println("Geschichte hat sich verändert: ");
        System.out.println(erzaehler.getGeschichte());
    }
}
