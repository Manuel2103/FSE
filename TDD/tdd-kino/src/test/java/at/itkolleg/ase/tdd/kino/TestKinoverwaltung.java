package at.itkolleg.ase.tdd.kino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
public class TestKinoverwaltung {

    KinoVerwaltung kinoVerwaltung;
    List<Vorstellung> vorstellungen;
    private Vorstellung vorstellung;
    private KinoSaal ks;

    @BeforeEach
    void setup(){
        kinoVerwaltung = new KinoVerwaltung();
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',10);
        map.put('C',15);
        map.put('D',12);
        ks = new KinoSaal("Saal 5",map);
        vorstellung = new Vorstellung(ks, Zeitfenster.ABEND, LocalDate.of(2023,3,29), "Avengers 10", 8);
    }
    @Test
    void testeinplanenVorstellung(){
        kinoVerwaltung.einplanenVorstellung(vorstellung);
        //Prüfen die Vorstellung in die Liste aufgenommen worden ist
        assertTrue(kinoVerwaltung.getVorstellungen().contains(vorstellung));
        //Testen, ob die Exception geworfen worden wird, wenn die Vorstellung schon in der Liste vorhanden ist.
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            kinoVerwaltung.einplanenVorstellung(vorstellung);
        });
        assertTrue(exception.getMessage().contains("Die Vorstellung ist bereits eingeplant"));
    }
    @Test
    void testkaufeTicket(){
        Ticket ticket = new Ticket(ks.getName(), Zeitfenster.ABEND, LocalDate.of(2023, 3, 29), 'A', 10);
        Ticket ticketfunc = kinoVerwaltung.kaufeTicket(vorstellung, 'A', 10, 10);
        assertEquals(ticket.getPlatz(),ticketfunc.getPlatz());
        assertEquals(ticket.getReihe(),ticketfunc.getReihe());
        assertEquals(ticket.getSaal(),ticketfunc.getSaal());
        assertEquals(ticket.getZeitfenster(),ticketfunc.getZeitfenster());

        //Testen, ob der Platz schon belegt ist.
        Exception exception = assertThrows(IllegalStateException.class, ()->{
            kinoVerwaltung.kaufeTicket(vorstellung, 'A', 10, 10);
        });
        assertTrue(exception.getMessage().contains("Der Platz " + ticket.getReihe() + ticket.getPlatz() + " ist bereits belegt."));
    }
}
