package org.ITKolleg;

import com.rometools.rome.feed.atom.Content;
import com.rometools.rome.feed.atom.Entry;
import com.rometools.rome.feed.atom.Feed;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class AtomFeedObserver implements Observer {
    private ArrayList<Entry> entries = new ArrayList<>();
    private ArrayList<Content> contents = new ArrayList<>();
    private Feed feed = new Feed("Log");

    /**
     * Wird der Observer informiert wird ein Atom-Feed erzeugt.
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {

        //Erzeugen des Atom-Feeds
        //Entry
        Entry entry = new Entry();
        entry.setCreated(new Date());
        entry.setTitle("LOG vom Waehrungsrechner");
        entry.setCreated(new Date());

        //Content
        Content content = new Content();
        content.setValue((String) arg + "\n");
        content.setType("LOG");
        contents.add(content);

        //Feed erstellen
        entry.setContents(contents);
        entries.add(entry);
        feed.setEntries(entries);

        System.out.println(feed);

    }
}
