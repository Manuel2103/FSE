package dataaccess;

import java.util.List;
import java.util.Optional;

/**
 * Das Interface BaseRepository verwendet generische Typen und beinhaltet nur die CRUD Methodenköpfe.
 * @param <T> Entität
 * @param <I> ID der Entität
 */
public interface BaseRepository<T,I> {
    Optional<T> insert(T entity);
    Optional<T> getById(I id);
    List<T> getAll();
    Optional<T> update(T entity);
    void deleteById(I id);

}
