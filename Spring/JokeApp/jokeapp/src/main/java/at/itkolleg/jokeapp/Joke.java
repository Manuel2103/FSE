package at.itkolleg.jokeapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Joke {

    @Id
    @GeneratedValue
    private Long id;
    private String jokeText;
    private String genre;
    private int usk;

}
