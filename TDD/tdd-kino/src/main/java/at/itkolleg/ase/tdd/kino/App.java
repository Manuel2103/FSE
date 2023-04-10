package at.itkolleg.ase.tdd.kino;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Dieses Beispiel stammt aus https://training.cherriz.de/cherriz-training/1.0.0/testen/junit5.html
 */
public class App 
{
    public static void main( String[] args )
    {
        //Saal anlegen
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',10);
        map.put('C',15);
        map.put('D',12);
        KinoSaal ks = new KinoSaal("LadyX",map);

        //Platz prüfen
        System.out.println(ks.pruefePlatz('A',11));
        System.out.println(ks.pruefePlatz('A',10));
        System.out.println(ks.pruefePlatz('B',10));
        System.out.println(ks.pruefePlatz('C',14));

        //Vorstellung erstellen
        Vorstellung vorstellung = new Vorstellung(ks,Zeitfenster.ABEND, LocalDate.of(2023,3,29), "Der gestiefelte Kater", 10);
        //KinoVerwaltung erstellen und Vorstellung einplanen
        KinoVerwaltung kinoVerwaltung = new KinoVerwaltung();
        kinoVerwaltung.einplanenVorstellung(vorstellung);
        //Ticket bei der Kinoverwaltung kaufen
        kinoVerwaltung.kaufeTicket(vorstellung, 'D', 12, 21);
    }
}
