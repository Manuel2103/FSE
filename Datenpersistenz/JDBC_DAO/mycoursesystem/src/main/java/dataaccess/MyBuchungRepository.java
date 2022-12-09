package dataaccess;

import domain.Buchung;

import java.util.List;

public interface MyBuchungRepository extends BaseRepository<Buchung, Long> {
    List<Buchung> getAllStudentsForBuchungById(Long id);
}
