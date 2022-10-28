package Builder;

/**
 * Die Klasse Direktor ist für die Verwaltung der verschiedenen Erbauer zuständig.
 */
public class Direktor {
    public static void main(String[] args) {
        construct();
    }

    /**
     * In der Funktion construct werden die Erbauer geschaffen und das Ergebnis ausgegeben.
     */
    public static void construct(){
        Erbauer erbauer = new HausErbauer();
        System.out.println(erbauer.buildPart());

    }
}
