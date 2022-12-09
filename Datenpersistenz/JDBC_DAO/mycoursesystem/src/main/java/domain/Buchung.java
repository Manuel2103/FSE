package domain;

public class Buchung extends BaseEntity{
    private Course course;
    private Student student;
    private boolean bestaetigt;

    public Buchung(Long id, Course course, Student student, boolean bestaetigt) {
        super(id);
        this.course = course;
        this.student = student;
        this.bestaetigt = bestaetigt;
    }

    public Buchung(Course course, Student student, boolean bestaetigt) {
        super(null);
        this.course = course;
        this.student = student;
        this.bestaetigt = bestaetigt;
    }

    @Override
    public String toString() {
        return "Buchung{" +
                "id=" + getId() +
                "course=" + course +
                ", student=" + student +
                ", bestaetigt=" + bestaetigt +
                '}';
    }
}
