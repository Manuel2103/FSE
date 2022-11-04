package org.ITKolleg;

import javax.naming.InvalidNameException;

public interface IUmrechnen {
    double umrechnen(String variante, double betrag) throws InvalidNameException;
    double getFaktor();
    boolean zustaendig(String variante);
}
