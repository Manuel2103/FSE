package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.Named.named;


public class TestVorstellung {
    private Vorstellung vorstellung;
    private KinoSaal ks;

    @BeforeEach
    void setup(){
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',10);
        map.put('C',15);
        map.put('D',12);
        map.put('A',12);
        map.put('A',15);
        ks = new KinoSaal("Saal 5",map);
        vorstellung = new Vorstellung(ks, Zeitfenster.ABEND, LocalDate.of(2023,3,29), "Avengers 10", 8);
    }

    @Test
    void testGetterVorstellung(){
        assertEquals(ks, vorstellung.getSaal());
        assertEquals(LocalDate.of(2023,3,29),vorstellung.getDatum());
        assertEquals(Zeitfenster.ABEND,vorstellung.getZeitfenster());
        assertEquals("Avengers 10",vorstellung.getFilm());
    }

    private static Stream<Arguments> provideParametersForKaufeTicket() {
        return Stream.of(
                Arguments.of('A', 10, 9.50f),
                Arguments.of('C', 15, 10f),
                Arguments.of('B', 10, 11.40f)
        );
    }
    @ParameterizedTest
    @MethodSource ("provideParametersForKaufeTicket")
    void testKaufeTicket(char reihe, int platz, float geld){
        Ticket ticket1 =  vorstellung.kaufeTicket(reihe, platz, geld);
        assertEquals(reihe, ticket1.getReihe());
        assertEquals(platz, ticket1.getPlatz());
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamFactoryMethodKaufeTicketReihe() {

        //Stream mit den Testwerten
        Stream<Named<Character>> inputStream = Stream.of(
                named("Test Reihe A", 'A'),
                named("Test Reihe B", 'B'),
                named("Test Reihe D", 'F'),
                named("Test Reihe C", 'C')

        );
        // Returns a stream of dynamic tests die prüfen, ob die Reihe richtig angelegt worden ist.
        return DynamicTest.stream(inputStream,
                reihe -> assertTrue(vorstellung.kaufeTicket(reihe, 10, 10).getReihe()==reihe));
    }
    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamFactoryMethodKaufeTicketPlatz() {

        //Stream mit den Testwerten
        Stream<Named<Integer>> inputStream = Stream.of(
                named("Test Platz 10", 10),
                named("Test Platz 15", 15),
                named("Test Platz 12", 12),
                named("Test Platz 17", 7),
                named("Test Platz 10", 10)
        );
        // Returns a stream of dynamic tests die prüfen, ob der Platz richtig angelegt worden ist.
        return DynamicTest.stream(inputStream,
                platz -> assertTrue(vorstellung.kaufeTicket('A', platz, 10).getPlatz()==platz));
    }
    @Test
    void testErstellungVorstellung(){
        Vorstellung vorstellung1 = new Vorstellung(ks, Zeitfenster.NACHMITTAG, LocalDate.of(2023,10,10), "Iron Man", 10);
        assertEquals(ks, vorstellung1.getSaal(), "Saal konnte nicht zugewiesen werden");
        assertEquals(LocalDate.of(2023,10,10),vorstellung1.getDatum(), "Datum ist inkorrekt");
        assertEquals(Zeitfenster.NACHMITTAG,vorstellung1.getZeitfenster(), "Zeitfenster nicht korrekt");
        assertEquals("Iron Man",vorstellung1.getFilm(), "Film nicht richtig zugewiesen");

    }



}
