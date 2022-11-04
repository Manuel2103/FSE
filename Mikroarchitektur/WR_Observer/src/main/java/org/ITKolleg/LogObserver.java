package org.ITKolleg;

import org.jdom2.output.LineSeparator;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class LogObserver implements Observer {

    private FileWriter myWriter;

    public LogObserver() {
        try {
            myWriter = new FileWriter("./src/main/java/org/ITKolleg/log.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Wird der Observer informiert wird eine Log.txt erstelle/erweitert
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {

        try {
            myWriter.write(new Date() +" " + (String) arg);
            myWriter.write(System.getProperty("line.separator"));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Log Datei konnte nicht erstellt werden");
            e.printStackTrace();
        }
    }
}
