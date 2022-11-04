package org.ITKolleg;

import com.rometools.rome.feed.atom.Feed;

import javax.naming.InvalidNameException;


public class App 
{
    public static void main( String[] args )
    {
        WR wr = new EURO2Dollar();

        //Observer zum Währungsrechner hinzufügen
        wr.addObserver(new LogObserver());
        wr.addObserver(new AtomFeedObserver());

        try {
            wr.umrechnen("EURO2Dollar" , 5);
        } catch (InvalidNameException e) {
            throw new RuntimeException(e);
        }


    }
}
