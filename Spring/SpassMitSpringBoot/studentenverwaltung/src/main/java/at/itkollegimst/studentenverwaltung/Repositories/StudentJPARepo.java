package at.itkollegimst.studentenverwaltung.Repositories;

import at.itkollegimst.studentenverwaltung.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Das Interface erbt von JpaRepository, dass als Baserepository fungiert.
 * Es bietet auch ein Repo, dass einige Funktion implementiert hat z.B. SimpleJPARepository
 */
@Repository
public interface StudentJPARepo extends JpaRepository<Student, Long> {
    List<Student> findAllByPlz(String plz);
}
