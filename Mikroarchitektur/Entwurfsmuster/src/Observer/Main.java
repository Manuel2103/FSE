package Observer;

//Erstellen eines konkreten Subjekts und eines konkreten Beobachter
public class Main {
    public static void main(String[] args) {
        Zuhoerer zuhoerer = new KonkreterZuhoerer();
        Erzaehler erzaehler = new KonkreterErzaehler();
        erzaehler.setGeschichte(" ein Prinz");
        erzaehler.benachrichtigen(zuhoerer);
    }
}
