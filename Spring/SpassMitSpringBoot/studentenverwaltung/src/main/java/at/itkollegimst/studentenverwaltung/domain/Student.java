package at.itkollegimst.studentenverwaltung.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Gibt an, dass es sich um eine Entität handelt.
@AllArgsConstructor //Konstruktor mit allen Datenfelder
@NoArgsConstructor //Konstruktor mit keine Datenfelder
@Getter
@Setter
public class Student {

    @Id //Gibt an, dass dieses Datenfeld der Primärschlüssel ist
    @GeneratedValue(strategy= GenerationType.SEQUENCE) //Es wird angewiesen, dass es sich um Autoinkrement
    private Long id;
    @Size(min=2) //Automatische Validierung
    private String name;
    @Size(min=4, max=6) //Automatische Validierung
    private String plz;

    //Konstruktor ohne ID für INSERT
    public Student(String name, String plz){
        this.name = name;
        this.plz = plz;
    }
}
