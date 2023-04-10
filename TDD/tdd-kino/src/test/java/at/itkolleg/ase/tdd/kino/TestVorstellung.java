package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestVorstellung {
    private Vorstellung vorstellung;
    private KinoSaal ks;
    //private Ticket ticket;

    @BeforeEach
    void setup(){
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',10);
        map.put('C',15);
        map.put('D',12);
        ks = new KinoSaal("Saal 5",map);
        vorstellung = new Vorstellung(ks, Zeitfenster.ABEND, LocalDate.of(2023,3,29), "Avengers 10", 8);
        //ticket = new Ticket(ks.getName(), Zeitfenster.ABEND, LocalDate.of(2023,3,29),'A',10);
    }

    @Test
    void testGetterVorstellung(){
        assertEquals(ks, vorstellung.getSaal());
        assertEquals(LocalDate.of(2023,3,29),vorstellung.getDatum());
        assertEquals(Zeitfenster.ABEND,vorstellung.getZeitfenster());
        assertEquals("Avengers 10",vorstellung.getFilm());
    }
    @Test
    void testKaufeTicket(){
        //assertTrue(vorstellung.kaufeTicket('A',10,10).equals());
        Ticket ticket1 = vorstellung.kaufeTicket('A',10,10);
        assertEquals('A', ticket1.getReihe());
        assertEquals(10,ticket1.getPlatz());
        assertEquals(LocalDate.of(2023,3,29),ticket1.getDatum());
        assertEquals(Zeitfenster.ABEND,ticket1.getZeitfenster());
        assertEquals("Saal 5",ticket1.getSaal());
    }
}
