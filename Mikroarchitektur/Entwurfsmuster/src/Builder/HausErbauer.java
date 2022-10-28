package Builder;

/**
 * Die Klasse HausErbauer ist ein konkreter Erbauer der zuständig ist eine Haus zu bauen dazu verwendet er die Klasse Haus
 */
public class HausErbauer extends Erbauer{

    Haus haus;
    public HausErbauer() {
        haus = new Haus("500000", "50", "2022");
    }

    @Override
    public String buildPart() {
        return haus.getHausinfo();
    }
}
