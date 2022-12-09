package domain;

import java.sql.Date;

public class Student extends BaseEntity{
    private String sName;
    private Klasse sKlasse;
    private Date sGeburtsdatum;

    public Student(Long id, String sName, Klasse sKlasse, Date sGeburtsdatum) {
        super(id);
        this.sName = sName;
        this.sKlasse = sKlasse;
        this.sGeburtsdatum = sGeburtsdatum;
    }

    public Student(String sName, Klasse sKlasse, Date sGeburtsdatum) {
        super(null);
        this.sName = sName;
        this.sKlasse = sKlasse;
        this.sGeburtsdatum = sGeburtsdatum;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Klasse getsKlasse() {
        return sKlasse;
    }

    public void setsKlasse(Klasse sKlasse) {
        this.sKlasse = sKlasse;
    }

    public Date getsGeburtsdatum() {
        return sGeburtsdatum;
    }

    public void setsGeburtsdatum(Date sGeburtsdatum) {
        this.sGeburtsdatum = sGeburtsdatum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getId() + '\'' +
                "sName='" + sName + '\'' +
                ", sKlasse=" + sKlasse +
                ", sGeburtsdatum=" + sGeburtsdatum +
                '}';
    }
}
