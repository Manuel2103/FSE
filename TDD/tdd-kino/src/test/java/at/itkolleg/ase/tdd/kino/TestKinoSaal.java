package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestKinoSaal {

    @Mock
    private KinoSaal kinosaalMock;

    @Test
    void testKinosaalNameMock(){
        //wenn vom Stub die getName aufgerufen wird, soll KS1 zurückkommen
        Mockito.when(kinosaalMock.getName()).thenReturn("KS1");
        //Schauen ob der Wert korrekt gemockt wurde
        assertEquals("KS1", kinosaalMock.getName());
        //Verifizieren ob getName() aufgerufen worden ist
        Mockito.verify(kinosaalMock).getName();
    }

    @Test
    void testKinosallPruefePlatzMock(){

        Mockito.when(kinosaalMock.pruefePlatz('D', 12)).thenReturn(true);
        Mockito.when(kinosaalMock.pruefePlatz('A', 13)).thenReturn(false);

        assertEquals(true, kinosaalMock.pruefePlatz('D', 12));
        assertEquals(false, kinosaalMock.pruefePlatz('A', 13));

        Mockito.verify(kinosaalMock).pruefePlatz('D',12);
        Mockito.verify(kinosaalMock).pruefePlatz('A',13);
    }

}
