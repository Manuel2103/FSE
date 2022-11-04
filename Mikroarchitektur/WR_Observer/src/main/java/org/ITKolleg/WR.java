package org.ITKolleg;

import javax.naming.InvalidNameException;
import java.util.Observable;
import java.util.Observer;

public abstract class WR extends Observable implements IUmrechnen {

    @Override
    public double umrechnen(String variante, double betrag) throws InvalidNameException {

        if(zustaendig(variante)){
            double ergebnis = betrag*getFaktor();
            String[] split = variante.split("2");
            String umrechnungsDaten = "Umrechnung von " + betrag + " " +split[0] + " in " + ergebnis + " " + split[1] + ".";
            //Observer auf Changed setzen, damit die Observer wissen das sich etwas geändert hat
            setChanged();
            //die Observer informieren
            notifyObservers(umrechnungsDaten);
            clearChanged();
            return ergebnis;
        }else {
            throw new InvalidNameException();
        }
    }

}
