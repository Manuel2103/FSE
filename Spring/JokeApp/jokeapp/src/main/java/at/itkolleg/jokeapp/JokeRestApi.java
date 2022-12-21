package at.itkolleg.jokeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jokes")
public class JokeRestApi {

    @Autowired
    JokesRepository jokesRepository;

    @PostMapping
    public ResponseEntity<Joke> insertJoke(@RequestBody Joke joke){
        joke.setId(null);
        Joke jokeInserted=this.jokesRepository.save(joke);
        return ResponseEntity.ok(jokeInserted);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joke> getJokeById(@PathVariable Long id){
        Optional<Joke> optionalJoke =  jokesRepository.findById(id);
        if (optionalJoke.isPresent()){
            return ResponseEntity.ok(optionalJoke.get());
        }else {
            throw new JokeNotFoundException("This Joke is not in our Database");
        }
    }
    @GetMapping
    public ResponseEntity<List<Joke>> getAllJokes(){
        return ResponseEntity.ok(jokesRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Joke> deleteJokeById(Long id){

        Optional<Joke> optionalJoke =  jokesRepository.findById(id);
        if (optionalJoke.isPresent()){
            jokesRepository.deleteById(id);
            return ResponseEntity.ok(optionalJoke.get());
        }else {
            throw new JokeNotFoundException("This Joke is not in our Database");
        }
    }

}
